/*
1.Take an input N, the size of array.
2.Take N more inputs and store that in an array.

Write a function which returns true if the second array is inverse of first and
false otherwise. Print the value returned.

Example(To be used only for expected output):
Input:
4
1 2 3 0
3 0 1 2
Output:
true

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        int brr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
         for(int i=0;i<n;i++)
            brr[i]=sc.nextInt();
        System.out.println(CheckInv(arr,brr,n));
    }
    static boolean CheckInv(int arr[], int brr[], int n)
    {
        //generate inverse
        for(int i = 0;i<n;i++)
        {
            if(brr[arr[i]] != i)
                return false;
        }
        return true;
    }
}
