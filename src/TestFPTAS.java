import java.util.*;

public class TestFPTAS {
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

        // Input: FPTAS parameter
        System.out.print("Enter FPTAS parameter (0 < epsilon < 1): ");
        double epsilon = scanner.nextDouble();

        // Calculate the scaling factor
        int maxValue = items.values().stream().mapToInt(Item::getValue).max().orElse(0);
        double scalingFactor = epsilon * maxValue / numItems;

        String[] itemNames = items.keySet().toArray(new String[0]);

        // Create a 2D array for dynamic programming
        int[][] dp = new int[numItems + 1][capacity + 1];

        // Fill the dp array using dynamic programming
        for (int i = 1; i <= numItems; i++) {
            Item item = items.get(itemNames[i - 1]);
            for (int w = 1; w <= capacity; w++) {
                if (item.getWeight() <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - item.getWeight()] + (int) (item.getValue() / scalingFactor));
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Find the selected items
        List<String> selectedItems = new ArrayList<>();
        int w = capacity;
        for (int i = numItems; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = items.get(itemNames[i - 1]);
                selectedItems.add(itemNames[i - 1]);
                w -= item.getWeight();
            }
        }

        // Output the results
        System.out.println("Selected items:");
        for (String itemName : selectedItems) {
            System.out.println(itemName);
        }
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
