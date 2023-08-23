import java.util.*;

public class mainApp {
    public static void main(String[] args){
        boolean user_loop = true;
        while(user_loop){
            Scanner sc = new Scanner(System.in);
            
            // Input: Capacity of the knapsack
            System.out.print("Enter the knapsack capacity: ");
            int capacity = sc.nextInt();

            // Input: Number of items
            System.out.print("Enter the number of items: ");
            int numItems = sc.nextInt();
            double itemQuantity = 0.0, itemValue = 0.0, itemWeight = 0.0;
            String itemName = null;

            // Input: Item data (name, quantity, weight, value)
            ConcreteAbstraction items = new ConcreteAbstraction();
            for (int i = 0; i < numItems; i++) {
                System.out.print("Enter item name: ");
                itemName = sc.next();
                System.out.print("Enter item quantity: ");
                itemQuantity = sc.nextDouble();
                System.out.print("Enter item weight: ");
                itemWeight = sc.nextDouble();
                System.out.print("Enter item value: ");
                itemValue = sc.nextDouble();
                items.put(itemName, itemValue, itemValue, itemValue);
            }

            System.out.println("Knapsack Problem Solver ");
            System.out.println("Current available knapsack algorithm " );
            System.out.println(" 1. Recursive");
            System.out.println(" 2. Memoization algorithm " );
            System.out.println("Please select which algorithm you want to use to solve the knapsack problem : ");
            String user_algo_selection  = sc.nextLine(); 

            switch(user_algo_selection){
                case "1":
                RecursiveAlgorithm recursive;
                String[] itemNames = items.keySet().toArray(new String[0]);

                List<String> selectedItems = recursive.knapsackRecursive();

                // Output the results
                System.out.println("Selected items:");
                for (String name : selectedItems) {
                    System.out.println(name);
                }
            }
        }

        
        
        







    }

    public static void clearScreen(){
            for(int i = 0; i < 20; i++){
                System.out.println();
            }
        }
}

class ConcreteAbstraction extends Abstraction {
    // You can add additional methods or fields specific to this subclass if needed
    
    public void put(String key, double value1, double value2,double value3) {
        map.put(key, new TripleValues(value1, value2,value3));
    }

    public void deleteLine(String key) {    //delete the value in the map
        map.remove(key);
    }
}