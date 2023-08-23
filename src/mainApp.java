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

            // Input: Item data (name, quantity, weight, value)
            ConcreteAbstraction items = new ConcreteAbstraction();
            for (int i = 0; i < numItems; i++) {
                System.out.print("Enter item name: ");
                String itemName = sc.next();
                System.out.print("Enter item quantity: ");
                int itemQuantity = sc.nextInt();
                System.out.print("Enter item weight: ");
                int itemWeight = sc.nextInt();
                System.out.print("Enter item value: ");
                int itemValue = sc.nextInt();
                items.put(itemName, itemQuantity, itemWeight, itemValue);
            }

            System.out.println("Knapsack Problem Solver ");
            System.out.println("Current available knapsack algorithm " );
            System.out.println(" 1. Recursive");
            System.out.println(" 2. Memoization algorithm " );
            System.out.println("Please select which algorithm you want to use to solve the knapsack problem : ");
            String user_algo_selection  = sc.nextLine(); 

            switch(user_algo_selection){
                case "1":
                    RecursiveAlgorithm recursive = new RecursiveAlgorithm(itemName, itemQuantity, itemWeight, itemValue, items);
            }
        }

        
        
        







    }

    public static void clearScreen(){
            for(int i = 0; i < 20; i++){
                System.out.println();
            }
        }
}