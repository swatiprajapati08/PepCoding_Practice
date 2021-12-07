import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(PathTab(n,arr));
    //System.out.println(PathVar(n, arr, dp, 0));
  }


  static int PathVar(int n, int arr[], int dp[], int curr)
  {
    if (curr > n)
      return 0;
    if (curr == n)
      return 1;

    if (dp[curr] != -1)
      return dp[curr];

    int validMoves = arr[curr];
    int val = 0;
    for (int i = 1; i <= validMoves; i++)
      val += PathVar(n, arr, dp, curr + i);

    dp[curr] = val;
    return val;


  }


  static int PathTab(int n, int arr[])
  {
    int dp[] = new int[n + 1];

    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--)
    {
      for (int j = 0; j <= arr[i] && i + j < dp.length; j++)
      {
        dp[i] += dp[i + j];
      }
    }
    return dp[0];
  }
}
