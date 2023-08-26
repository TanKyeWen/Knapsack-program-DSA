import java.util.HashMap;
import java.util.Map;

abstract class Abstraction{
    protected Map<Double, Double> items;

    public Abstraction() {
        items = new HashMap<>();
    }

    public String deleteItem(double itemWeight, double itemValue) {
        if (!items.containsKey(itemWeight) && !items.containsValue(itemValue)) {
            return "Item not found";
        }

        items.entrySet().removeIf(entry -> entry.getKey() == itemWeight || entry.getValue() == itemValue);
        return "Item deleted successfully";
    }

    public String searchItem(double itemWeight, double itemValue) {
        if (items.containsKey(itemWeight) && items.get(itemWeight) == itemValue) {
            return "Item found";
        }
        return "Item not found";
    }

    public void addToMap(double itemWeight, double itemValue) {
        if (itemWeight <= 0 || itemValue < 0) {
            System.out.println("Invalid input: weight must be positive, value must be non-negative");
            return;
        }

        items.put(itemWeight, itemValue);
        System.out.println("Item added to the map");
    }

    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }

        System.out.println("Current items in the map:");
        for (Map.Entry<Double, Double> entry : items.entrySet()) {
            System.out.println("Weight: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public int mapSize() {
        return items.size();
    }
}
