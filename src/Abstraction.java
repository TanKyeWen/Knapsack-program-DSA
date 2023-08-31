import java.util.HashMap;
import java.util.Map;

abstract class Abstraction{
    protected Map<String, Map<Double, Double>> items;

    public Abstraction() {
        items = new HashMap<>();
    }

    public String deleteItem(String itemName, double itemWeight, double itemValue) {
        if (!items.containsKey(itemName)) {
            return "Item not found";
        }

        Map<Double, Double> itemDetails = items.get(itemName);
        if (!itemDetails.containsKey(itemWeight) || itemDetails.get(itemWeight) != itemValue) {
            return "Item not found";
        }

        itemDetails.remove(itemWeight);
        if (itemDetails.isEmpty()) {
            items.remove(itemName);
        }

        return "Item deleted successfully";
    }

    public String searchItem(String itemName, double itemWeight, double itemValue) {
        if (items.containsKey(itemName)) {
            Map<Double, Double> itemDetails = items.get(itemName);
            if (itemDetails.containsKey(itemWeight) && itemDetails.get(itemWeight) == itemValue) {
                return "Item found";
            }
        }
        return "Item not found";
    }

    public void addToMap(String itemName, double itemWeight, double itemValue) {
        if (itemWeight <= 0 || itemValue < 0) {
            System.out.println("Invalid input: weight must be positive, value must be non-negative");
            return;
        }

        items.computeIfAbsent(itemName, k -> new HashMap<>()).put(itemWeight, itemValue);
        System.out.println("Item added to the map");
    }

    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }

        System.out.println("Current items in the map:");
        for (Map.Entry<String, Map<Double, Double>> itemEntry : items.entrySet()) {
            String itemName = itemEntry.getKey();
            Map<Double, Double> itemDetails = itemEntry.getValue();
            for (Map.Entry<Double, Double> entry : itemDetails.entrySet()) {
                System.out.println("Item: " + itemName + ", Weight: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }

    public int mapSize() {
        return items.size();
    }
}