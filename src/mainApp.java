import java.util.*;

public class mainApp {
    private ConcreteAbstraction itemMap;

    public mainApp(){
        itemMap = new ConcreteAbstraction();
    }

    public void addItem(String itemName, double itemWeight, double itemValue) {
        itemMap.put(itemName, itemWeight, itemValue);
        System.out.println("Item added successfully.");
    }

    public void updateItem(String itemName, double newItemWeight, double newItemValue) {
        itemMap.updateValues(itemName, newItemWeight, newItemValue);
    }

    public void deleteItem(String itemName) {
        itemMap.deleteLine(itemName);
    }

    public void searchItem(String itemName) {
        double itemWeight = itemMap.getValue1(itemName);
        double itemValue = itemMap.getValue2(itemName);
        System.out.println("Item: " + itemName);
        System.out.println("Weight: " + itemWeight);
        System.out.println("Value: " + itemValue);
    }

    public void printAllItems() {
        itemMap.printMapValues();
    }

    public static void main(String[] args){
        mainApp manager = new mainApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Search Item");
            System.out.println("5. Print All Items");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Item Weight: ");
                    double itemWeight = scanner.nextDouble();
                    System.out.print("Enter Item Value: ");
                    double itemValue = scanner.nextDouble();
                    manager.addItem(itemName, itemWeight, itemValue);
                    break;
                case 2:
                    System.out.print("Enter Item Name to Update: ");
                    String updateItemName = scanner.nextLine();
                    System.out.print("Enter New Item Weight: ");
                    double newItemWeight = scanner.nextDouble();
                    System.out.print("Enter New Item Value: ");
                    double newItemValue = scanner.nextDouble();
                    manager.updateItem(updateItemName, newItemWeight, newItemValue);
                    break;
                case 3:
                    System.out.print("Enter Item Name to Delete: ");
                    String deleteItemName = scanner.nextLine();
                    manager.deleteItem(deleteItemName);
                    break;
                case 4:
                    System.out.print("Enter Item Name to Search: ");
                    String searchItemName = scanner.nextLine();
                    manager.searchItem(searchItemName);
                    break;
                case 5:
                    manager.printAllItems();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    
    }
}