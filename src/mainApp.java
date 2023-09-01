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

            boolean knapsackLoop = true;
            switch (choice) {
                case 1:
                    clearScreen();
                    System.out.print("Please enter how many items you would like to add :");
                    int num_items = scanner.nextInt();
                    scanner.nextLine();

                    for(int i=0; i<num_items; i++){
                        System.out.println("Enter Item Name: ");
                        String itemname = scanner.nextLine();
                        System.out.println("Enter Item Weight: ");
                        double itemWeight = scanner.nextDouble();
                        System.out.println("Enter Item Value: ");
                        double itemValue = scanner.nextDouble();
                        System.out.println("");
                        System.out.println("");
                        knapsack.addToMap(itemname,itemWeight, itemValue);
                        scanner.nextLine();
                    }

                    break;
                case 2:
                    clearScreen();
                    System.out.print("Enter Item Name you wanted to delete: ");
                    String deleteItemName = scanner.nextLine();
                    System.out.print("Enter Item Weight you wanted to delete: ");
                    double deleteItemWeight = scanner.nextDouble();
                    System.out.print("Enter Item Value you wanted to delete : ");
                    double deleteItemValue = scanner.nextDouble();
                    knapsack.deleteItem(deleteItemName,deleteItemWeight, deleteItemValue);
                    break;
                case 3:
                    clearScreen();
                    System.out.print("Enter Item Name you wanted to search: ");
                    String searchItemName = scanner.nextLine();
                    System.out.print("Enter Item Weight you wanted to search: ");
                    double searchItemWeight = scanner.nextDouble();
                    System.out.print("Enter Item Value you wanted to search : ");
                    double searchItemValue = scanner.nextDouble();
                    knapsack.searchItem(searchItemName,searchItemWeight, searchItemValue);
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
                    int mapsize = knapsack.mapSize();

                    if(mapsize == 0){
                        System.out.println("Map is empty > Try Again !");
                        break;
                    }

                    while(knapsackLoop){
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Please choose the algorithm");
                        System.out.println(" 1. Recursive algorithm");
                        System.out.println(" 2. Memoization technique ");
                        System.out.println(" 3. Brute-Force algorithm ");
                        System.out.println(" 4. Quit to main menu ");
                        System.out.println(" Selection  >>" );
                        int user_algo_ch = sc.nextInt();
                        switch(user_algo_ch){
                            case 1:
                                System.out.print("Enter Knapsack capacity :");
                                double capacity = scanner.nextInt();
                                int quantityInMap = knapsack.mapSize();  
                                ArrayList<String> itemNames  =  new ArrayList<>();                                // quantity of the items in the map
                                ArrayList<Double> itemWeights = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Double> itemValues = new ArrayList<>();    // convert hashmap values into arraylist
                                RecursiveAlgorithm Recursivealgorithm = new RecursiveAlgorithm();

                                for (Map.Entry<String, Map<Double, Double>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNamestring = itemEntry.getKey();
                                    Map<Double, Double> itemDetails = itemEntry.getValue();
                                    for (Map.Entry<Double, Double> entry : itemDetails.entrySet()) {
                                        itemNames.add(itemNamestring);
                                        itemWeights.add(entry.getKey());
                                        itemValues.add(entry.getValue());
                                    }
                                }
                                 
                                String[] namesArray = new String[itemNames.size()];
                                double[] weightsArray = new double[itemWeights.size()];                     //convert to array
                                double[] valuesArray = new double[itemValues.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeights.size(); i++) {
                                    namesArray[i] = itemNames.get(i);
                                    weightsArray[i] = itemWeights.get(i);
                                    valuesArray[i] = itemValues.get(i);
                                }

                                long startTime = System.nanoTime();
                                double result = Recursivealgorithm.RecursiveknapSack(capacity, weightsArray, valuesArray, quantityInMap);
                                long endTime = System.nanoTime();
                                long executionTime = endTime - startTime;
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("                  Recursive Algorithm                          ");
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("Max value selected  chosen by Recursive algorithm : "  + result); 
                                System.out.println("Result selected item name   :                       "  + Recursivealgorithm.getSelectedItems(capacity, weightsArray, valuesArray, quantityInMap,namesArray)); 
                                System.out.println("Result selected item weight :                       "  + Recursivealgorithm.getSelectedWeights(capacity, weightsArray, valuesArray, quantityInMap));
                                System.out.println("Execution time: " + executionTime + " ms"); 
                                break;
                                
                            case 2:
                                System.out.print("Enter Knapsack capacity :");
                                double capacity2 = scanner.nextInt();
                                int quantityInMap2 = knapsack.mapSize();  
                                ArrayList<String> itemNames2  =  new ArrayList<>();                                    // quantity of the items in the map
                                ArrayList<Double> itemWeights2 = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Double> itemValues2 = new ArrayList<>();    // convert hashmap values into arraylist
                                Memoization mz = new Memoization();
                                
                                for (Map.Entry<String, Map<Double, Double>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNamestring2 = itemEntry.getKey();
                                    Map<Double, Double> itemDetails = itemEntry.getValue();
                                    for (Map.Entry<Double, Double> entry : itemDetails.entrySet()) {
                                        itemNames2.add(itemNamestring2);
                                        itemWeights2.add(entry.getKey());
                                        itemValues2.add(entry.getValue());
                                    }
                                }
                                String[] namesArray2 = new String[itemNames2.size()];
                                double[] weightsArray2 = new double[itemWeights2.size()];                     //convert to array
                                double[] valuesArray2= new double[itemValues2.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeights2.size(); i++) {
                                    namesArray2[i] = itemNames2.get(i);
                                    weightsArray2[i] = itemWeights2.get(i);
                                    valuesArray2[i] = itemValues2.get(i);
                                }
                                
                                long startTime2 = System.nanoTime();
                                double result2 = mz.memo(capacity2, weightsArray2, valuesArray2, quantityInMap2);
                                long endTime2 = System.nanoTime();
                                long executionTime2 = endTime2 - startTime2;
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("                  Memoization Technique                          ");
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("Max value selected  chosen by Memoization algorithm : "  + result2); 
                                System.out.println("Result selected item name                           : "  + mz.getSelectedItems(capacity2, weightsArray2, valuesArray2, quantityInMap2,namesArray2)); 
                                System.out.println("Result selected item weight                         : "  + mz.getSelectedWeights(capacity2, weightsArray2, valuesArray2, quantityInMap2)); 
                                System.out.println("Execution time: " + executionTime2+ " ms"); 
                                break;

                            case 3:
                                System.out.print("Enter Knapsack capacity :");
                                double capacitybt = scanner.nextInt();
                                int quantityInMapbt = knapsack.mapSize();
                                ArrayList<String> itemNamesbt  =  new ArrayList<>();                                     // quantity of the items in the map
                                ArrayList<Double> itemWeightsbt = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Double> itemValuesbt = new ArrayList<>();    // convert hashmap values into arraylist
                                BruteForceAlgorithm bt = new BruteForceAlgorithm();
                                
                                for (Map.Entry<String, Map<Double, Double>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNamestring3 = itemEntry.getKey();
                                    Map<Double, Double> itemDetails = itemEntry.getValue();
                                    for (Map.Entry<Double, Double> entry : itemDetails.entrySet()) {
                                        itemNamesbt.add(itemNamestring3);
                                        itemWeightsbt.add(entry.getKey());
                                        itemValuesbt.add(entry.getValue());
                                    }
                                }
                                String[] namesArraybt = new String[itemNamesbt.size()];
                                double[] weightsArraybt = new double[itemWeightsbt.size()];                     //convert to array
                                double[] valuesArraybt= new double[itemValuesbt.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeightsbt.size(); i++) {
                                    namesArraybt[i] = itemNamesbt.get(i);
                                    weightsArraybt[i] = itemWeightsbt.get(i);
                                    valuesArraybt[i] = itemValuesbt.get(i);
                                }
                                
                                long startTimebt = System.nanoTime();
                                double resultbt= bt.BruteForce(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt);
                                long endTimebt = System.nanoTime();
                                long executionTimebt = endTimebt - startTimebt;
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("                  Brute - Force Algorithm                      ");
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("Max value selected  chosen by Memoization algorithm : "  + resultbt); 
                                System.out.println("Result selected item name                           : "  + bt.getSelectedItems(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt,namesArraybt)); 
                                System.out.println("Result selected item weight                         : "  + bt.getSelectedWeights(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt)); 
                                System.out.println("Execution time: " + executionTimebt+ " ms");  
                                break;

                            case 4:
                                clearScreen();
                                knapsackLoop = false;
                                break;
                            default:
                                clearScreen();
                                System.out.println("Wrong Input : Try Again ! ");
                            
                        }
                    }
                default:
                    if(knapsackLoop == true){
                        System.out.println("Invalid choice. Please choose a valid option.");
                    }
            }
        }
    
    }
}
