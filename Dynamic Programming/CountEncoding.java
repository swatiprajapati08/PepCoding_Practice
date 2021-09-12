import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int dp[] = new int[str.length()];
    Arrays.fill(dp, -1);
   // System.out.println(countEncoding(str, 0, dp));
      System.out.println(countEncodingTab(str));
  }

  static int countEncoding(String str, int index, int dp[])
  {
    if (index == str.length())  //empty string ka khud 1 count empty
      return 1;

    if (dp[index] != -1)
      return dp[index];

    int ans = 0;

    int ch1 = str.charAt(index) - '0';
    if (ch1 >= 1 && ch1 <= 9)
      ans += countEncoding(str, index + 1, dp);

    if (index + 1 < str.length())
    {
      int ch2 = (str.charAt(index) - '0') * 10 + str.charAt(index + 1 ) - '0';
      if (ch2 >= 10 && ch2 <= 26)
        ans += countEncoding(str, index + 2, dp);
    }
    dp[index] = ans;
    return ans;
  }

  static int countEncodingTab(String str)
  {
    int dp[] = new int[str.length() + 1];
    dp[str.length()] = 1; //empty string ka khud 1 count empty

    for (int index = str.length() - 1; index >= 0; index--)
    {

      int ch1 = str.charAt(index) - '0';
      if (ch1 >= 1 && ch1 <= 9)
        dp[index] += dp[index + 1];

      if (index + 1 < str.length())
      {
        int ch2 = (str.charAt(index) - '0') * 10 + str.charAt(index + 1 ) - '0';
        if (ch2 >= 10 && ch2 <= 26)
          dp[index] += dp[index + 2];
      }
    }
    return dp[0];
  }
}
