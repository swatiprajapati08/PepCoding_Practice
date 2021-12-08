//coin-change Combination-1

import java.io.*;
import java.util.*;

//each level every coins explored from lastidx+1
public class Main {

    public static void coinChange(int idx, int[] coins, int amtsf, int tamt, String asf){
        if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        if(amtsf > tamt)return;
        
        for(int i = idx + 1; i <coins.length;i++){
            coinChange(i,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(-1, coins, 0, amt, "");
    }
}

//coin-change Combination-2 
//Have infinite supply of same coins(we can start from same index)


import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int idx, int[] coins, int amtsf, int tamt, String asf) {
          if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        if(amtsf > tamt)return;
        
        for(int i = idx; i <coins.length;i++){
            coinChange(i,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}


//coins-change Permutation 1
//only 1 coin availabe of each type

import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
      if(amtsf == tamt){
              System.out.println(asf+".");
              return;
          }
      if(amtsf > tamt)return;
      
      for(int i = 0;i<used.length;i++){
          if(used[i] == false){
              used[i] = true;
              coinChange(coins,amtsf + coins[i],tamt,asf+coins[i]+"-",used);
              used[i] = false;
          }
      }
      
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}



//coin-change Permutation-2
//infinte supply of same coins available

import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
       if(amtsf == tamt){
           System.out.println(asf+".");
           return;
       }
       if(amtsf > tamt)return;
       
       for(int i = 0; i< coins.length;i++)
       coinChange(coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
       
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}
