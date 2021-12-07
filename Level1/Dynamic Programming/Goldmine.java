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
    //   int ans=0;
    //   int dp[][]=new int[n][m];
    //   for(int i=0;i<n;i++)
    //   ans=Math.max(ans,GoldMine(i,0,arr,dp));
    //   System.out.println(ans);
    System.out.println(GDtab(n, m, arr));
  }
  static int GoldMine(int i, int j, int arr[][], int dp[][])
  {
    if (i < 0 || j < 0 || j >= arr[0].length || i >= arr.length)
      return 0;
    if (j == arr[0].length - 1)
      return arr[i][j];


    if (dp[i][j] != 0)
      return dp[i][j];

    //faith
    int x = GoldMine(i - 1, j + 1, arr, dp);
    int y = GoldMine(i, j + 1, arr, dp);
    int z = GoldMine(i + 1, j + 1, arr, dp);

    int val = arr[i][j];
    val += Math.max(x, Math.max(y, z));
    dp[i][j] = val;
    return val;
  }

  static int GDtab(int n, int m, int arr[][])
  {
    int dp[][] = new int[n][m];

    //last row already filled
    for (int i = 0; i < n; i++)
      dp[i][m - 1] = arr[i][m - 1];

    for (int j = m - 1 ; j >= 0 ; j--)
    {
      for (int i = 0; i < n ; i++)
      {
        if (j == m - 1)
          dp[i][j] = arr[i][j];
        else {
          int up = (i - 1 > 0) ? dp[i - 1][j + 1] : 0;
          int right = dp[i][j + 1];
          int down = (i + 1 < n) ? dp[i + 1][j + 1] : 0;

          dp[i][j] = arr[i][j] + Math.max(up, Math.max(right, down));
        }
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++)
      max = Math.max(dp[i][0], max);

    return max;

  }


}
