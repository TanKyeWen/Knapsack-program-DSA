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
 
}

