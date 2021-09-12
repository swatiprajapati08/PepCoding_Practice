import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int prices[] = new int[n];
    int wgt[] = new int[n];

    for (int i = 0; i < n; i++)
      prices[i] = sc.nextInt();
    for (int i = 0; i < n; i++)
      wgt[i] = sc.nextInt();

    int cap = sc.nextInt();

    // System.out.println(knapSack(cap,wgt,prices,n));

    int dp[][] = new int[n + 1][cap + 1];
    System.out.println(KS(cap, wgt, prices, dp, 1));

  }

  static int KS(int W, int wt[], int val[], int dp[][], int curr)
  {
    if (W < 0)
      return Integer.MIN_VALUE;

    if (curr == dp.length) return 0;

    if (dp[curr][W] != 0)
      return dp[curr][W];

    //faith
    //doesn't include
    int x = KS(W, wt, val, dp, curr + 1);
    //include
    int y = (W - wt[curr - 1] < 0) ? 0 : KS(W - wt[curr - 1], wt, val, dp, curr) + val[curr - 1];
    int max = Math.max(x, y);
    dp[curr][W] = max;
    return max;
  }

  static int knapSack(int W, int wt[], int val[], int n)
  {
    int dp[][] = new int[n + 1][W + 1];
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= W; j++)
      {
        int x = dp[i - 1][j]; //doesn't include
        int y = (j - wt[i - 1] < 0) ? 0 : dp[i][j - wt[i - 1]] + val[i - 1]; //include kr liya
        dp[i][j] = Math.max(x, y);

      }
    }
    return dp[n][W];
  }
}
