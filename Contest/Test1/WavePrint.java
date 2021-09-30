/*
1.Take an input r, the size of row.
2.Take an input c, the size of column.
2.Take r*c more inputs and store that in an array.


Write a function Wave print it row-wise and then column wise.

Example(To be used only for expected output):
Input:
3 3
1 2 3
4 5 6
7 8 9
Output:
1 2 3 6 5 4 7 8 9
1 4 7 8 5 2 3 6 9
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for(int i = 0;i < n; i++)
        {
            for(int j = 0; j < m; j++ )
                arr[i][j]=sc.nextInt();
        }
        printRowWise(arr,n,m);
        System.out.println();
        printColWise(arr,n,m);
    }
    static void printRowWise(int arr[][],int n,int m)
    {
        for(int i = 0  ;i < n; i++)
        {
            if(i % 2 == 0)
            {
                for(int j = 0;j < m; j++)
                    System.out.print(arr[i][j]+" ");
            }
            else
            {
                for(int j = m-1;j >= 0; j--)
                    System.out.print(arr[i][j]+" ");
            }
        }
    }
    static void printColWise(int arr[][],int n,int m)
    {
        for(int j = 0  ;j < m; j++)
        {
            if(j % 2 == 0)
            {
                for(int i = 0;i < n; i++)
                    System.out.print(arr[i][j]+" ");
            }
            else
            {
                for(int i = n-1;i >= 0; i--)
                    System.out.print(arr[i][j]+" ");
            }
        }
    }
}
