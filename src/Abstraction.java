import java.util.HashMap;
import java.util.Map;

abstract class Abstraction {
    protected Map<String, Map<Double, Map<Integer, Double>>> items;

    public Abstraction() {
        items = new HashMap<>();
    }

    public String deleteItem(String itemName, double itemWeight, int itemQuantity, double itemValue) {
        if (!items.containsKey(itemName)) {
            return "Item not found";
        }

        Map<Double, Map<Integer, Double>> itemDetails = items.get(itemName);
        if (!itemDetails.containsKey(itemWeight)) {
            return "Item not found";
        }

        Map<Integer, Double> quantityDetails = itemDetails.get(itemWeight);
        if (!quantityDetails.containsKey(itemQuantity) || quantityDetails.get(itemQuantity) != itemValue) {
            return "Item not found";
        }

        quantityDetails.remove(itemQuantity);
        if (quantityDetails.isEmpty()) {
            itemDetails.remove(itemWeight);
        }

        if (itemDetails.isEmpty()) {
            items.remove(itemName);
        }

        return "Item deleted successfully";
    }

    public String searchItem(String itemName, double itemWeight, int itemQuantity, double itemValue) {
        System.out.println("Searching for: " + itemName + ", " + itemWeight + ", " + itemQuantity + ", " + itemValue);
    
        if (items.containsKey(itemName)) {
            Map<Double, Map<Integer, Double>> itemDetails = items.get(itemName);
            if (itemDetails.containsKey(itemWeight)) {
                Map<Integer, Double> quantityDetails = itemDetails.get(itemWeight);
                if (quantityDetails.containsKey(itemQuantity) && quantityDetails.get(itemQuantity) == itemValue) {
                    return "Item found !";
                }
            }
        }
    
        System.out.println("Item not found");
        return "Item not found";
    }
    
    

    public void addToMap(String itemName, double itemWeight, int itemQuantity, double itemValue) {
        if (itemWeight <= 0 || itemQuantity <= 0 || itemValue < 0) {
            System.out.println("Invalid input: weight must be positive, quantity must be positive, value must be non-negative");
            return;
        }

        items
            .computeIfAbsent(itemName, k -> new HashMap<>())
            .computeIfAbsent(itemWeight, k -> new HashMap<>())
            .put(itemQuantity, itemValue);
        System.out.println("Item added to the map");
    }

    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }

        System.out.println("Current items in the map:");
        for (Map.Entry<String, Map<Double, Map<Integer, Double>>> itemEntry : items.entrySet()) {
            String itemName = itemEntry.getKey();
            Map<Double, Map<Integer, Double>> itemDetails = itemEntry.getValue();
            for (Map.Entry<Double, Map<Integer, Double>> weightEntry : itemDetails.entrySet()) {
                double itemWeight = weightEntry.getKey();
                Map<Integer, Double> quantityDetails = weightEntry.getValue();
                for (Map.Entry<Integer, Double> quantityEntry : quantityDetails.entrySet()) {
                    int itemQuantity = quantityEntry.getKey();
                    double itemValue = quantityEntry.getValue();
                    System.out.println("Item: " + itemName + ", Weight: " + itemWeight + ", Quantity: " + itemQuantity + ", Value: " + itemValue);
                }
            }
        }
    }

    public int mapSize() {
        return items.size();
    }

}
