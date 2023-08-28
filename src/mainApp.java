import java.util.*;

public class mainApp {
    public static void clearScreen() { //clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){
        Abstraction knapsack = new Abstraction() {};
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("==================");
            System.out.println("Knapsack program ");
            System.out.println("==================");
            System.out.println("Choose an option:");
            System.out.println("1. Add Item");
            System.out.println("2. Delete Item");
            System.out.println("3. Search Item");
            System.out.println("4. Print All Items");
            System.out.println("5. Exit");
            System.out.println("6. Enter knapsack program and choose which algorithm to use:");
            System.out.println("Please enter your choice >>");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.print("Please enter how many items you would like to add :");
                    int num_items = scanner.nextInt();
                    scanner.nextLine();

                    for(int i=0; i<num_items; i++){
                        System.out.println("Enter Item Weight: ");
                        double itemWeight = scanner.nextDouble();
                        System.out.println("Enter Item Value: ");
                        double itemValue = scanner.nextDouble();
                        knapsack.addToMap(itemWeight, itemValue);
                        scanner.nextLine();
                    }

                    break;
                case 2:
                    clearScreen();
                    System.out.print("Enter Item Weight you wanted to delete: ");
                    double deleteItemWeight = scanner.nextDouble();
                    System.out.print("Enter Item Value you wanted to delete : ");
                    double deleteItemValue = scanner.nextDouble();
                    knapsack.deleteItem(deleteItemWeight, deleteItemValue);
                    break;
                case 3:
                    clearScreen();
                    System.out.print("Enter Item Weight you wanted to delete: ");
                    double searchItemWeight = scanner.nextDouble();
                    System.out.print("Enter Item Value you wanted to delete : ");
                    double searchItemValue = scanner.nextDouble();
                    knapsack.searchItem(searchItemWeight, searchItemValue);
                    break;
                case 4:
                    clearScreen();
                    knapsack.printItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                case 6:
                    clearScreen();
                    while(true){
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Please choose the algorithm");
                        System.out.println(" 1. Recursive algorithm");
                        System.out.println(" 2. Memoization technique ");
                        System.out.println(" 3. Brute-Force algorithm ");
                        System.out.println(" Selection " );
                        int user_algo_ch = sc.nextInt();
                        switch(user_algo_ch){
                            case 1:
                                System.out.print("Enter Knapsack capacity :");
                                double capacity = scanner.nextInt();
                                int quantityInMap = knapsack.mapSize();                                     // quantity of the items in the map
                                ArrayList<Double> itemWeights = new ArrayList<>(knapsack.items.keySet());   // convert hashmap values into arraylist
                                ArrayList<Double> itemValues = new ArrayList<>(knapsack.items.values());    // convert hashmap values into arraylist
                                RecursiveAlgorithm Recursivealgorithm = new RecursiveAlgorithm();
                    
                                double[] weightsArray = new double[itemWeights.size()];                     //convert to array
                                double[] valuesArray = new double[itemValues.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeights.size(); i++) {
                                    weightsArray[i] = itemWeights.get(i);
                                    valuesArray[i] = itemValues.get(i);
                                }

                                long startTime = System.currentTimeMillis();
                                double result = Recursivealgorithm.RecursiveknapSack(capacity, weightsArray, valuesArray, quantityInMap);
                                long endTime = System.currentTimeMillis();
                                long executionTime = endTime - startTime;
                                System.out.println("Result of Recursive algorithm:  "  + result); 
                                System.out.println("Execution time: " + executionTime + " ms"); 
                                break;
                                
                            case 2:
                                System.out.print("Enter Knapsack capacity :");
                                double capacity2 = scanner.nextInt();
                                int quantityInMap2 = knapsack.mapSize();                                     // quantity of the items in the map
                                ArrayList<Double> itemWeights2 = new ArrayList<>(knapsack.items.keySet());   // convert hashmap values into arraylist
                                ArrayList<Double> itemValues2 = new ArrayList<>(knapsack.items.values());    // convert hashmap values into arraylist
                                Memoization mz = new Memoization();
                    
                                double[] weightsArray2 = new double[itemWeights2.size()];                     //convert to array
                                double[] valuesArray2= new double[itemValues2.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeights2.size(); i++) {
                                    weightsArray2[i] = itemWeights2.get(i);
                                    valuesArray2[i] = itemValues2.get(i);
                                }
                                
                                long startTime2 = System.currentTimeMillis();
                                double result2 = mz.memo(capacity2, weightsArray2, valuesArray2, quantityInMap2);
                                long endTime2 = System.currentTimeMillis();
                                long executionTime2 = endTime2 - startTime2;
                                System.out.println("Result of Memoization algorithm:  "  + result2); 
                                System.out.println("Execution time: " + executionTime2+ " ms"); 
                                break;

                            case 3:
                                System.out.print("Enter Knapsack capacity :");
                                double capacitybt = scanner.nextInt();
                                int quantityInMapbt = knapsack.mapSize();                                     // quantity of the items in the map
                                ArrayList<Double> itemWeightsbt = new ArrayList<>(knapsack.items.keySet());   // convert hashmap values into arraylist
                                ArrayList<Double> itemValuesbt = new ArrayList<>(knapsack.items.values());    // convert hashmap values into arraylist
                                BruteForceAlgorithm bt = new BruteForceAlgorithm();
                    
                                double[] weightsArraybt = new double[itemWeightsbt.size()];                     //convert to array
                                double[] valuesArraybt= new double[itemValuesbt.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeightsbt.size(); i++) {
                                    weightsArraybt[i] = itemWeightsbt.get(i);
                                    valuesArraybt[i] = itemValuesbt.get(i);
                                }
                                
                                long startTimebt = System.currentTimeMillis();
                                double resultbt= bt.BruteForce(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt);
                                long endTimebt = System.currentTimeMillis();
                                long executionTimebt = endTimebt - startTimebt;
                                System.out.println("Result of Brute Force algorithm:  "  + resultbt); 
                                System.out.println("Execution time: " + executionTimebt+ " ms"); 
                                break;

                            default:
                                clearScreen();
                                System.out.println("Wrong Input : Try Again ! ");
                        }
                    }
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    
    }
}
