import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++)
        coins[i]=sc.nextInt();
        int amount=sc.nextInt();
        System.out.println(change(amount,coins));

    }
    public static int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
         dp[i][0]=1;
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                int x=dp[i-1][j]; // doesn't include 
                int y=(j-coins[i-1]<0)? 0 : dp[i][j-coins[i-1]]; //unbounded knapsack and included
                dp[i][j]=x+y;
            }
        }
    return dp[coins.length][amount];
   }
}
