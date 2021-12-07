/*
  des=4 
  curr==des then return 1; it have one path

                         3 4 5   4 5 6     4 5 6
                              2   3    4    3    4   5   4 5 6 
                                1               2          3
                                            0
*/
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(Paths(0, n, dp));

  }

  static int Paths(int curr, int des, int dp[])
  {
    if (curr > des)
      return 0;
    else if (curr == des)
      return 1;
    //memorisation
    if (dp[curr] != -1)
      return dp[curr];


    int x = Paths(curr + 1, des, dp);
    int y = Paths(curr + 2, des, dp);
    int z = Paths(curr + 3, des, dp);

    int total = x + y + z;
    dp[curr] = total;
    return total;
  }

  //Tabulations
  static int PathTab(int n)
  {
    int dp[] = new int[n + 1];
    // dp[0] = 1;
    // dp[1] = 1;
    // dp[2] = 2;
    // dp[3] = 4;
    // for (int i = 4; i <= n; i++)
    //   dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    
    // return dp[n];


    //   or

    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--)
    {
      dp[i] = dp[i + 1];
      if (i + 2 < dp.length)
        dp[i] += dp[i + 2];
      if (i + 3 <  dp.length)
        dp[i] += dp[i + 3];
    }


    return dp[0];
  }
}
