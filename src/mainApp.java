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
            System.out.println("3. Print All Items");
            System.out.println("4. Exit");
            System.out.println("5. Enter knapsack program and choose which algorithm to use:");
            System.out.println("Please enter your choice >>");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            boolean knapsackLoop = true;
            switch (choice) {
                case 1:
                    clearScreen();
                    int num_items;
                    do {
                        System.out.print("Please enter how many items you would like to add: ");
                        if (scanner.hasNextInt()) {
                            num_items = scanner.nextInt();
                            if (num_items > 0) {
                                break; // Exit the loop if a valid positive integer is entered
                            } else {
                                 System.out.println("Wrong input. Please enter a positive integer for the number of items.");
                            }
                        } else {
                            System.out.println("Wrong input. Please enter a valid integer for the number of items.");
                            scanner.next(); // Consume the invalid input
                        }
                    } while (true);
                    scanner.nextLine();

                    for (int i = 0; i < num_items; i++) {
                        System.out.println("Enter Item Name: ");
                        String itemname = scanner.nextLine();
            
                        double itemWeight;
                        do {
                            System.out.println("Enter Item Weight: ");
                            if (scanner.hasNextDouble()) {
                                itemWeight = scanner.nextDouble();
                                break; // Exit the loop if a valid double is entered
                            } else {
                                System.out.println("Wrong input. Please enter a valid number for Item Weight.");
                                scanner.next();
                            }
                        } while (true);
            
                        int itemQuantity;
                        do {
                            System.out.println("Enter Item Quantity: ");
                            if (scanner.hasNextInt()) {
                                itemQuantity = scanner.nextInt();
                                break; // Exit the loop if a valid integer is entered
                            } else {
                                System.out.println("Wrong input. Please enter a valid integer for Item Quantity.");
                                scanner.next(); 
                            }
                        } while (true);
            
                        double itemValue;
                        do {
                            System.out.println("Enter Item Value: ");
                            if (scanner.hasNextDouble()) {
                                itemValue = scanner.nextDouble();
                                break; // Exit the loop if a valid double is entered
                            } else {
                                System.out.println("Wrong input. Please enter a valid number for Item Value.");
                                scanner.next(); 
                            }
                        } while (true);
            
                        System.out.println("");
                        System.out.println("");
                        knapsack.addToMap(itemname,itemWeight, itemQuantity,itemValue);
                        scanner.nextLine();
                    }

                    break;
                case 2:
                    clearScreen();
                    System.out.print("Enter Item Name you want to delete: ");
                    String deleteItemName = scanner.nextLine();
        
                    double deleteItemWeight;
                    do {
                        System.out.print("Enter Item Weight you want to delete: ");
                        if (scanner.hasNextDouble()) {
                            deleteItemWeight = scanner.nextDouble();
                            break; // Exit the loop if a valid double is entered
                        } else {
                            System.out.println("Wrong input. Please enter a valid number for Item Weight.");
                            scanner.next();
                        }
                    } while (true);
        
                    int deleteItemQuantity;
                    do {
                        System.out.print("Enter Item Quantity you want to delete: ");
                        if (scanner.hasNextInt()) {
                            deleteItemQuantity = scanner.nextInt();
                            break; // Exit the loop if a valid integer is entered
                        } else {
                            System.out.println("Wrong input. Please enter a valid integer for Item Quantity.");
                            scanner.next();
                        }
                    } while (true);
        
                    double deleteItemValue;
                    do {
                        System.out.print("Enter Item Value you want to delete: ");
                        if (scanner.hasNextDouble()) {
                            deleteItemValue = scanner.nextDouble();
                            break; // Exit the loop if a valid double is entered
                        } else {
                            System.out.println("Wrong input. Please enter a valid number for Item Value.");
                            scanner.next();
                        }
                    } while (true);
        
                    knapsack.deleteItem(deleteItemName, deleteItemWeight, deleteItemQuantity, deleteItemValue);
        
                    break;
                
                case 3:
                    clearScreen();
                    knapsack.printItems();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                case 5:
                    clearScreen();
                    int mapsize = knapsack.mapSize();

                    if(mapsize == 0){
                        System.out.println("Map is empty > Try Again !");
                        break;
                    }

                    if(mapsize == 1){
                        System.out.println("Must be 2 values for knapsack > Try Again !");
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
                            
                                double capacity;
                                do {
                                    System.out.print("Enter the capacity : ");
                                    if (scanner.hasNextDouble()) {
                                        capacity = scanner.nextDouble();
                                        break; // Exit the loop if a valid double is entered
                                    } else {
                                        System.out.println("Wrong input. Please enter a valid number for capacity.");
                                        scanner.next();
                                    }
                                } while (true);
                
                                int quantityInMap = knapsack.mapSize();              // quantity of the items in the map
                                ArrayList<String> itemNames  =  new ArrayList<>();   // convert hashmap values into arraylist                                   
                                ArrayList<Double> itemWeights = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Integer> itemQuantities = new ArrayList<>(); // convert hashmap values into arraylist
                                ArrayList<Double> itemValues = new ArrayList<>();    // convert hashmap values into arraylist
                                RecursiveAlgorithm Recursivealgorithm = new RecursiveAlgorithm();

                                for (Map.Entry<String, Map<Double, Map<Integer, Double>>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNameString = itemEntry.getKey();
                                    Map<Double, Map<Integer, Double>> itemDetails = itemEntry.getValue();
                                
                                    for (Map.Entry<Double, Map<Integer, Double>> weightEntry : itemDetails.entrySet()) {
                                        double itemWeight = weightEntry.getKey();
                                        Map<Integer, Double> quantityDetails = weightEntry.getValue();
                                
                                        for (Map.Entry<Integer, Double> quantityEntry : quantityDetails.entrySet()) {
                                            int itemQuantity = quantityEntry.getKey();
                                            double itemValue = quantityEntry.getValue();
                                
                                            itemNames.add(itemNameString);
                                            itemWeights.add(itemWeight);
                                            itemQuantities.add(itemQuantity);
                                            itemValues.add(itemValue);
                                        }
                                    }
                                }
                                
                                 
                                String[] namesArray = new String[itemNames.size()];
                                double[] weightsArray = new double[itemWeights.size()];                     //convert to array
                                int[] quantityArray = new int[itemQuantities.size()];
                                double[] valuesArray = new double[itemValues.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeights.size(); i++) {
                                    namesArray[i] = itemNames.get(i);
                                    weightsArray[i] = itemWeights.get(i);
                                    quantityArray[i] = itemQuantities.get(i);
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
                                System.out.println("Capacity of the knapsack                          : "  + capacity); 
                                System.out.println("Result of selected item name                      : "  + Recursivealgorithm.getSelectedItems(capacity, weightsArray, valuesArray, quantityInMap,namesArray)); 
                                System.out.println("Result of selected item weight                    : "  + Recursivealgorithm.getSelectedWeights(capacity, weightsArray, valuesArray, quantityInMap));
                                System.out.println("Result of selected item quantity                  : "  + Recursivealgorithm.getSelectedQuantities(capacity,weightsArray,valuesArray,quantityInMap,namesArray,quantityArray));
                                System.out.println("Execution time: " + executionTime + " ms"); 
                                break;
                                
                            case 2:
                                double capacity2;
                                do {
                                    System.out.print("Enter the capacity : ");
                                    if (scanner.hasNextDouble()) {
                                        capacity2 = scanner.nextDouble();
                                        break; // Exit the loop if a valid double is entered
                                    } else {
                                        System.out.println("Wrong input. Please enter a valid number for capacity.");
                                        scanner.next();
                                    }
                                } while (true);

                                int quantityInMap2 = knapsack.mapSize();  
                                ArrayList<String> itemNamesmz  =  new ArrayList<>();   // convert hashmap values into arraylist                                   
                                ArrayList<Double> itemWeightsmz = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Integer> itemQuantitiesmz = new ArrayList<>(); // convert hashmap values into arraylist
                                ArrayList<Double> itemValuesmz = new ArrayList<>();    // convert hashmap values into arraylist
                                Memoization mz = new Memoization();

                                for (Map.Entry<String, Map<Double, Map<Integer, Double>>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNameStringMZ = itemEntry.getKey();
                                    Map<Double, Map<Integer, Double>> itemDetails = itemEntry.getValue();
                                
                                    for (Map.Entry<Double, Map<Integer, Double>> weightEntry : itemDetails.entrySet()) {
                                        double itemWeightMZ = weightEntry.getKey();
                                        Map<Integer, Double> quantityDetails = weightEntry.getValue();
                                
                                        for (Map.Entry<Integer, Double> quantityEntry : quantityDetails.entrySet()) {
                                            int itemQuantityMZ = quantityEntry.getKey();
                                            double itemValueMZ = quantityEntry.getValue();
                                
                                            itemNamesmz.add(itemNameStringMZ);
                                            itemWeightsmz.add(itemWeightMZ);
                                            itemQuantitiesmz.add(itemQuantityMZ);
                                            itemValuesmz.add(itemValueMZ);
                                        }
                                    }
                                }
                                 
                                String[] namesArraymz = new String[itemNamesmz.size()];
                                double[] weightsArraymz = new double[itemWeightsmz.size()];                     //convert to array
                                int[] quantityArraymz = new int[itemQuantitiesmz.size()];
                                double[] valuesArraymz = new double[itemValuesmz.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeightsmz.size(); i++) {
                                    namesArraymz[i] = itemNamesmz.get(i);
                                    weightsArraymz[i] = itemWeightsmz.get(i);
                                    quantityArraymz[i] = itemQuantitiesmz.get(i);
                                    valuesArraymz[i] = itemValuesmz.get(i);
                                }
                                
                                long startTime2 = System.nanoTime();
                                double result2 = mz.memo(capacity2, weightsArraymz, valuesArraymz, quantityInMap2);
                                long endTime2 = System.nanoTime();
                                long executionTime2 = endTime2 - startTime2;
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("                  Memoization Technique                        ");
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("Max value selected  chosen by Memoization Technique : "  + result2); 
                                System.out.println("Capacity of the knapsack                            : "  + capacity2); 
                                System.out.println("Result of selected item name                        : "  + mz.getSelectedItems(capacity2, weightsArraymz, valuesArraymz, quantityInMap2,namesArraymz)); 
                                System.out.println("Result of selected item weight                      : "  + mz.getSelectedWeights(capacity2, weightsArraymz, valuesArraymz, quantityInMap2));
                                System.out.println("Result of selected item quantity                    : "  + mz.getSelectedQuantities(capacity2,weightsArraymz,valuesArraymz,quantityInMap2,quantityArraymz));
                                System.out.println("Execution time: " + executionTime2 + " ms"); 
                                break;

                            case 3:
                                double capacitybt;
                                do {
                                    System.out.print("Enter the capacity : ");
                                    if (scanner.hasNextDouble()) {
                                        capacitybt = scanner.nextDouble();
                                        break; // Exit the loop if a valid double is entered
                                    } else {
                                        System.out.println("Wrong input. Please enter a valid number for capacity.");
                                        scanner.next();
                                    }
                                } while (true);
                                int quantityInMapbt = knapsack.mapSize();
                                ArrayList<String> itemNamesbt  =  new ArrayList<>();   // convert hashmap values into arraylist                                   
                                ArrayList<Double> itemWeightsbt = new ArrayList<>();   // convert hashmap values into arraylist
                                ArrayList<Integer> itemQuantitiesbt = new ArrayList<>(); // convert hashmap values into arraylist
                                ArrayList<Double> itemValuesbt = new ArrayList<>();    // convert hashmap values into arraylist
                                BruteForceAlgorithm bt= new BruteForceAlgorithm();

                                for (Map.Entry<String, Map<Double, Map<Integer, Double>>> itemEntry : knapsack.items.entrySet()) {
                                    String itemNameStringBT = itemEntry.getKey();
                                    Map<Double, Map<Integer, Double>> itemDetails = itemEntry.getValue();
                                
                                    for (Map.Entry<Double, Map<Integer, Double>> weightEntry : itemDetails.entrySet()) {
                                        double itemWeightBT = weightEntry.getKey();
                                        Map<Integer, Double> quantityDetails = weightEntry.getValue();
                                
                                        for (Map.Entry<Integer, Double> quantityEntry : quantityDetails.entrySet()) {
                                            int itemQuantityBT = quantityEntry.getKey();
                                            double itemValueBT = quantityEntry.getValue();
                                
                                            itemNamesbt.add(itemNameStringBT);
                                            itemWeightsbt.add(itemWeightBT);
                                            itemQuantitiesbt.add(itemQuantityBT);
                                            itemValuesbt.add(itemValueBT);
                                        }
                                    }
                                }
                                 
                                String[] namesArraybt = new String[itemNamesbt.size()];
                                double[] weightsArraybt = new double[itemWeightsbt.size()];                     //convert to array
                                int[] quantityArraybt = new int[itemQuantitiesbt.size()];
                                double[] valuesArraybt = new double[itemValuesbt.size()];                       //convert to array
    
                                for (int i = 0; i < itemWeightsbt.size(); i++) {
                                    namesArraybt[i] = itemNamesbt.get(i);
                                    weightsArraybt[i] = itemWeightsbt.get(i);
                                    quantityArraybt[i] = itemQuantitiesbt.get(i);
                                    valuesArraybt[i] = itemValuesbt.get(i);
                                }
                                
                                long startTimebt = System.nanoTime();
                                double resultbt= bt.BruteForce(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt);
                                long endTimebt = System.nanoTime();
                                long executionTimebt = endTimebt - startTimebt;
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("                  Brute Force Algorithm                        ");
                                System.out.println("---------------------------------------------------------------"); 
                                System.out.println("Max value selected  chosen by Brute Force Algorithm : "  + resultbt); 
                                System.out.println("Capacity of the knapsack                            : "  + capacitybt); 
                                System.out.println("Result of selected item name                        : "  + bt.getSelectedItems(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt,namesArraybt)); 
                                System.out.println("Result of selected item weight                      : "  + bt.getSelectedWeights(capacitybt, weightsArraybt, valuesArraybt, quantityInMapbt));
                                System.out.println("Result of selected item quantity                    : "  + bt.getSelectedQuantities(capacitybt,weightsArraybt,valuesArraybt,quantityInMapbt,quantityArraybt));
                                System.out.println("Execution time: " + executionTimebt + " ms");  
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
