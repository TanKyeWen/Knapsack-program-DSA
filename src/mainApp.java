import java.util.*;

public class mainApp {
    public static void clearScreen() { //clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int maxRecursion(int a, int b) {
        return  (a >b) ? a : b;
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
                    System.out.print("Enter Knapsack capacity :");
                    int capacity = scanner.nextInt();
                    int quantityInMap = knapsack.mapSize();
                    System.out.print("size : " + quantityInMap );
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    
    }
}
