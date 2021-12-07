import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int prev0 = 1, prev1 = 1;
    for (int i = 2; i <= n; i++)
    {
      int curr0 = prev1;
      int curr1 = prev0 + prev1;
      
      prev0 = curr0;
      prev1 = curr1;
    }
    System.out.println(prev1 + prev0);
  }

}

 <-------------------------------OR----------------------------->
   import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   System.out.println(CBS(n));
 }
 
 static int CBS(int n)
 {
    int dp[][]=new int[n+1][2];
    dp[1][0]=1;
    dp[1][1]=1;
    for(int i=2;i<=n;i++)
    {
        dp[i][0]=dp[i-1][1];
        dp[i][1]=dp[i-1][1]+dp[i-1][0];
    }
    return dp[n][0]+dp[n][1];
 }

}
