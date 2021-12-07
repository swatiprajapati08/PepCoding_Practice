import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int coins[] = new int[n];
    for (int i = 0; i < n; i++)
      coins[i] = sc.nextInt();
    int amount = sc.nextInt();
    System.out.println(change(coins, amount));
  }

  public static int change(int[] coins, int amount) {
    int dp[] = new int[amount + 1];
    dp[0] = 1;

    for (int i = 1; i <= amount; i++)
    {
      for (int j = 0; j < coins.length; j++)
      {
        dp[i] += (i - coins[j] < 0) ? 0 : dp[i - coins[j]];
      }
    }
    return dp[amount];
  }
}
