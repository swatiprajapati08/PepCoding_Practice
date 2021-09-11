import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int arr[][] = new int[n][m];
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < m; j++)
        arr[i][j] = sc.nextInt();
    }
    int dp[][] = new int[n][m];
    System.out.println(PrintMinTab(n, m, arr));
//   System.out.println(PrintMinCost(0, 0, n - 1, m - 1, arr, dp));
  }

  static int PrintMinCost(int sr, int sc, int dr, int dc, int arr[][], int dp[][])
  {
    if (sr > dr || sc > dc)
      return Integer.MAX_VALUE;

    if (sr == dr && sc == dc)
      return arr[sr][sc];

    if (dp[sr][sc] != 0)
      return dp[sr][sc];

    int x = PrintMinCost(sr + 1, sc, dr, dc, arr, dp);
    int y = PrintMinCost(sr, sc + 1, dr, dc, arr, dp);

    int val = arr[sr][sc] + Math.min(x, y);
    dp[sr][sc] = val;
    return val;
  }


  static int PrintMinTab(int n, int m, int arr[][])
  {
    int dp[][] = new int[n][m];


    for (int i = n - 1; i >= 0; i--)
    {
      for (int j = m - 1; j >= 0; j--)
      {
        dp[i][j] = arr[i][j];
        if (i + 1 < n && j + 1 < m)
          dp[i][j] += Math.min(dp[i + 1][j], dp[i][j + 1]);
        else if (i == n - 1 && j == m - 1)
          dp[i][j] = arr[i][j];
        else if (i + 1 < n || j + 1 == m)
          dp[i][j] += dp[i + 1][j];
        else if (j + 1 < m || i + 1 == n)
          dp[i][j] += dp[i][j + 1];
      }
    }

    return dp[0][0];
  }


}
