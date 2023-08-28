public class BruteForceAlgorithm {
    public  double BruteForce(double W, double[] wt, double[] val, int n) {
        // initial conditions
        if (n == 0 || W == 0) {
            return 0;
        }
        // If weight is higher than capacity then it is not included
        if (wt[n - 1] > W) {
            return BruteForce(W, wt, val, n - 1);
        }
        // return either nth item being included or not
        else {
            return Math.max(val[n - 1] + BruteForce(W - wt[n - 1], wt, val, n - 1),
                            BruteForce(W, wt, val, n - 1));
        }
    }
}
