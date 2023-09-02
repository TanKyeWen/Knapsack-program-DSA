public class RecursiveAlgorithm {
    public double max(double a, double b) {
        return (a > b) ? a : b;
    }
    
    public double RecursiveknapSack(double W, double wt[], double val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return RecursiveknapSack(W, wt, val, n - 1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return max(val[n - 1] + RecursiveknapSack(W - wt[n - 1], wt, val, n - 1),
                       RecursiveknapSack(W, wt, val, n - 1));
    }
    
    // Function to return selected item names
    public String getSelectedItems(double W, double wt[], double val[], int n, String[] itemName) {
        // Base Case
        if (n == 0 || W == 0)
            return "";

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return getSelectedItems(W, wt, val, n - 1, itemName);

        // Check if including the current item leads to higher value
        if (val[n - 1] + RecursiveknapSack(W - wt[n - 1], wt, val, n - 1) >
            RecursiveknapSack(W, wt, val, n - 1)) {
            return itemName[n - 1] + " " + getSelectedItems(W - wt[n - 1], wt, val, n - 1, itemName);
        } else {
            return getSelectedItems(W, wt, val, n - 1, itemName);
        }
    }
    
    // Function to return selected item weights
    public String getSelectedWeights(double W, double wt[], double val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return "";

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return getSelectedWeights(W, wt, val, n - 1);

        // Check if including the current item leads to higher value
        if (val[n - 1] + RecursiveknapSack(W - wt[n - 1], wt, val, n - 1) >
            RecursiveknapSack(W, wt, val, n - 1)) {
            return wt[n - 1] + " " + getSelectedWeights(W - wt[n - 1], wt, val, n - 1);
        } else {
            return getSelectedWeights(W, wt, val, n - 1);
        }
    }

    public String getSelectedQuantities(double W, double wt[], double val[], int n, String[] itemName, int[] itemQuantities) {
        // Base Case
        if (n == 0 || W == 0)
            return "";

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return getSelectedQuantities(W, wt, val, n - 1, itemName, itemQuantities);

        // Check if including the current item leads to higher value
        if (val[n - 1] + RecursiveknapSack(W - wt[n - 1], wt, val, n - 1) >
            RecursiveknapSack(W, wt, val, n - 1)) {
            return itemQuantities[n - 1] + " " + getSelectedQuantities(W - wt[n - 1], wt, val, n - 1, itemName, itemQuantities);
        } else {
            return getSelectedQuantities(W, wt, val, n - 1, itemName, itemQuantities);
        }
    }
}

