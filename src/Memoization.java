import java.io.*;

public class Memoization {

    // A utility function that returns
    // maximum of two doubles
    public double max(double a, double b) { 
        return (a > b) ? a : b; 
    }

    // Returns the value of maximum profit
    public double memoRec(int W, double wt[], double val[],
                        int n, double[][] dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W]
                = memoRec(W, wt, val, n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W]
                = max((val[n - 1]
                    + memoRec(W - (int)wt[n - 1], wt, val,
                                    n - 1, dp)),
                    memoRec(W, wt, val, n - 1, dp));
    }

    public double memo(double W, double wt[], double val[], int N)
    {

        // Declare the table dynamically
        double dp[][] = new double[N + 1][(int)W + 1];

        // Loop to initially filled the
        // table with -1
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return memoRec((int)W, wt, val, N, dp);
    }
}
