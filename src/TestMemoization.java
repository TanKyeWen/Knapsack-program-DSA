import java.util.*;

public class TestMemoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Capacity of the knapsack
        System.out.print("Enter the knapsack capacity: ");
        int capacity = scanner.nextInt();

        // Input: Number of items
        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();

        // Input: Item data (name, weight, value)
        Map<String, Item> items = new HashMap<>();
        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter item name: ");
            String itemName = scanner.next();
            System.out.print("Enter item weight: ");
            int itemWeight = scanner.nextInt();
            System.out.print("Enter item value: ");
            int itemValue = scanner.nextInt();
            items.put(itemName, new Item(itemWeight, itemValue));
        }

        String[] itemNames = items.keySet().toArray(new String[0]);
        Map<String, List<String>> memo = new HashMap<>();

        List<String> selectedItems = knapsackMemoized(items, itemNames, numItems, capacity, memo);

        // Output the results
        System.out.println("Selected items:");
        for (String itemName : selectedItems) {
            System.out.println(itemName);
        }
    }

    public static List<String> knapsackMemoized(
            Map<String, Item> items,
            String[] itemNames,
            int n,
            int capacity,
            Map<String, List<String>> memo) {
        if (n == 0 || capacity == 0) {
            return new ArrayList<>();
        }

        String memoKey = n + "-" + capacity;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        Item currentItem = items.get(itemNames[n - 1]);

        if (currentItem.getWeight() > capacity) {
            List<String> result = knapsackMemoized(items, itemNames, n - 1, capacity, memo);
            memo.put(memoKey, result);
            return result;
        }

        List<String> withoutCurrentItem = knapsackMemoized(items, itemNames, n - 1, capacity, memo);
        List<String> withCurrentItem = knapsackMemoized(items, itemNames, n - 1, capacity - currentItem.getWeight(), memo);
        withCurrentItem = new ArrayList<>(withCurrentItem);
        withCurrentItem.add(itemNames[n - 1]);

        int valueWithout = calculateTotalValue(items, withoutCurrentItem);
        int valueWith = calculateTotalValue(items, withCurrentItem);

        List<String> result;
        if (valueWith > valueWithout) {
            result = withCurrentItem;
        } else {
            result = withoutCurrentItem;
        }

        memo.put(memoKey, result);
        return result;
    }

    public static int calculateTotalValue(Map<String, Item> items, List<String> selectedItems) {
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
