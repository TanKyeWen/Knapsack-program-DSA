import java.io.*;

public class Memoization {

    public double max(double a, double b) {
        return (a > b) ? a : b;
    }

    public double memoRec(int W, double wt[], double val[],
                          int n, double[][] dp) {
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)
            return dp[n][W] = memoRec(W, wt, val, n - 1, dp);
        else
            return dp[n][W] = max((val[n - 1] +
                                   memoRec(W - (int) wt[n - 1], wt, val, n - 1, dp)),
                                  memoRec(W, wt, val, n - 1, dp));
    }

    public double memo(double W, double wt[], double val[], int N) {
        double dp[][] = new double[N + 1][(int) W + 1];
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return memoRec((int) W, wt, val, N, dp);
    }

    // Function to return selected item names
    public String getSelectedItems(double W, double wt[], double val[], int n, String[] itemName) {
        double dp[][] = new double[n + 1][(int) W + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        memoRec((int) W, wt, val, n, dp); // Call memoRec to populate dp array

        if (n == 0 || W == 0)
            return "";

        if (wt[n - 1] > W)
            return getSelectedItems(W, wt, val, n - 1, itemName);

        if (val[n - 1] + dp[n - 1][(int) W - (int) wt[n - 1]] > dp[n - 1][(int) W]) {
            return itemName[n - 1] + " " + getSelectedItems(W - wt[n - 1], wt, val, n - 1, itemName);
        } else {
            return getSelectedItems(W, wt, val, n - 1, itemName);
        }
    }

    // Function to return selected item weights
    public String getSelectedWeights(double W, double wt[], double val[], int n) {
        double dp[][] = new double[n + 1][(int) W + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        memoRec((int) W, wt, val, n, dp); // Call memoRec to populate dp array

        if (n == 0 || W == 0)
            return "";

        if (wt[n - 1] > W)
            return getSelectedWeights(W, wt, val, n - 1);

        if (val[n - 1] + dp[n - 1][(int) W - (int) wt[n - 1]] > dp[n - 1][(int) W]) {
            return wt[n - 1] + " " + getSelectedWeights(W - wt[n - 1], wt, val, n - 1);
        } else {
            return getSelectedWeights(W, wt, val, n - 1);
        }
    }
}
