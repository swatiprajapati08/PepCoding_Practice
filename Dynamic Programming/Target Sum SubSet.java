import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();

    int sum = sc.nextInt();

    boolean dp[] = new boolean[n];

   // System.out.println(TargetSum(0, arr, n, sum, dp));
    System.out.println(TargetSum(arr, sum));

  }


  static boolean TargetSum(int index, int arr[], int n, int target, boolean dp[])
  {
    if (index == n) //check for each case
    {
      if (target == 0)return true;
      return false;
    }

    if (target < 0)
      return false;

    if (dp[index] != false)
      return dp[index];

    boolean x = TargetSum(index + 1, arr, n, target - arr[index], dp);
    boolean y = TargetSum(index + 1, arr, n, target, dp);

    boolean val = x || y;
    dp[index] = val;
    return val;
  }

  public static boolean TargetSum(int[] arr, int target) {
    int n = arr.length;
    boolean dp[][] = new boolean[n + 1][target + 1];

    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= target; j++)
      {
        boolean no = dp[i - 1][j];
        boolean yes = (j - arr[i - 1] < 0) ? false : dp[i - 1][j - arr[i - 1]];
        dp[i][j] = no || yes;
      }
    }
    return dp[n][target];
  }


}
