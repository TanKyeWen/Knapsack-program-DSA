public class BruteForceAlgorithm {
    public double BruteForce(double W, double[] wt, double[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            return BruteForce(W, wt, val, n - 1);
        } else {
            return Math.max(val[n - 1] + BruteForce(W - wt[n - 1], wt, val, n - 1),
                            BruteForce(W, wt, val, n - 1));
        }
    }
    
    // Function to return selected item names
    public String getSelectedItems(double W, double[] wt, double[] val, int n, String[] itemName) {
        if (n == 0 || W == 0) {
            return "";
        }
        if (wt[n - 1] > W) {
            return getSelectedItems(W, wt, val, n - 1, itemName);
        }
        
        double withItem = val[n - 1] + BruteForce(W - wt[n - 1], wt, val, n - 1);
        double withoutItem = BruteForce(W, wt, val, n - 1);
        
        if (withItem > withoutItem) {
            return itemName[n - 1] + " " + getSelectedItems(W - wt[n - 1], wt, val, n - 1, itemName);
        } else {
            return getSelectedItems(W, wt, val, n - 1, itemName);
        }
    }
    
    // Function to return selected item weights
    public String getSelectedWeights(double W, double[] wt, double[] val, int n) {
        if (n == 0 || W == 0) {
            return "";
        }
        if (wt[n - 1] > W) {
            return getSelectedWeights(W, wt, val, n - 1);
        }
        
        double withItem = val[n - 1] + BruteForce(W - wt[n - 1], wt, val, n - 1);
        double withoutItem = BruteForce(W, wt, val, n - 1);
        
        if (withItem > withoutItem) {
            return wt[n - 1] + " " + getSelectedWeights(W - wt[n - 1], wt, val, n - 1);
        } else {
            return getSelectedWeights(W, wt, val, n - 1);
        }
    }
}
