import java.util.*;

public class RecursiveAlgorithm {
    //private ConcreteAbstraction List = new ConcreteAbstraction();
    public RecursiveAlgorithm(String itemName, double capacity, int numItems, double itemWeight, double itemValue, Map<String, Item> items) {
        Scanner scanner = new Scanner(System.in);

        String[] itemNames = items.keySet().toArray(new String[0]);

        List<String> selectedItems = knapsackRecursive(items, itemNames, numItems, capacity);

        // Output the results
        System.out.println("Selected items:");
        for (String name : selectedItems) {
            System.out.println(name);
        }
    }

    public List<String> knapsackRecursive(Map<String, Item> items, String[] itemNames, int n, double capacity) {
        if (n == 0 || capacity == 0) {
            return new ArrayList<>();
        }

        Item currentItem = items.get(itemNames[ (n - 1)]);

        if (currentItem.getWeight() > capacity) {
            return knapsackRecursive(items, itemNames, n - 1, capacity);
        }

        List<String> withoutCurrentItem = knapsackRecursive(items, itemNames, n - 1, capacity);
        List<String> withCurrentItem = knapsackRecursive(items, itemNames, n - 1, capacity - currentItem.getWeight());
        withCurrentItem.add(itemNames[n - 1]);

        int valueWithout = calculateTotalValue(items, withoutCurrentItem);
        int valueWith = calculateTotalValue(items, withCurrentItem);

        if (valueWith > valueWithout) {
            return withCurrentItem;
        } else {
            return withoutCurrentItem;
        }
    }

    public int calculateTotalValue(Map<String, Item> items, List<String> selectedItems) {
        int totalValue = 0;
        for (String itemName : selectedItems) {
            totalValue += items.get(itemName).getValue();
        }
        return totalValue;
    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}

