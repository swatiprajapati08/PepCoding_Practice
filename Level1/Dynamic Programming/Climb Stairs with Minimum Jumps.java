import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
   System.out.println(PathTab(n, arr));
   // System.out.println(PathVar(n-1, arr, dp, 0));
  }


  static int PathVar(int n, int arr[], int dp[], int curr)
  {
    if (curr > n) //-ive base case  (5 to 4   no way so =>  +infinity)
      return Integer.MAX_VALUE-1; // otherwisse it will be out of bound bcz in last we have added 1
    if (curr == n)
      return 0;

    if (dp[curr] != -1)
      return dp[curr];

    int val = Integer.MAX_VALUE-1;
    for (int jumps = 1; jumps <= arr[curr]; jumps++)
    {
      int ans = PathVar(n, arr, dp, curr + jumps);
      val = Math.min(val, ans + 1);
    }

    dp[curr] = val;
    return val;
  }


  static int PathTab(int n, int arr[])
  {
    int dp[] = new int[n + 1];

    dp[n] = 0;
    for (int dpIndex = n - 1; dpIndex >= 0; dpIndex--) //each dp box call
    {
      int min = Integer.MAX_VALUE-1;
      for (int jumps = 1; jumps <= arr[dpIndex] && dpIndex + jumps < dp.length; jumps++)
      {
        min = Math.min(dp[dpIndex + jumps], min);
      }
      dp[dpIndex] += min + 1;
    }
    return dp[0];
  }
}
