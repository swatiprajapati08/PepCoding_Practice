/*
1.Take an input r, the size of row.
2.Take an input c, the size of column.
2.Take r*c more inputs and store that in an array.


Write a function Spiral print it clock wise and then anti-clock wise
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int arr[][] = new int[r][c];
        for(int i =0; i < r;i++)
        {
            for(int j = 0; j < c; j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        clockwise(arr,r,c);
        System.out.println();
        Anticlockwise(arr,r,c);
        
    }
    
    static void clockwise(int arr[][],int r,int c)
    {
        int counter = 0;
        int frow = 0,fcol = 0 ,lrow = r-1 , lcol = c-1;
        while(counter < r * c)
        {
            for(int i = frow , j = fcol; j <= lcol ;j++)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            frow++;
            for(int i = frow , j = lcol; i <= lrow ;i++)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            lcol--;
            
            for(int i = lrow , j = lcol; j >= fcol ;j--)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            lrow--;
            
            for(int i = lrow , j = fcol; i >= frow ;i--)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                  return;
            }
            
            fcol++;
        }
    }
    
     static void Anticlockwise(int arr[][],int r,int c)
    {
        int counter = 0;
        int frow = 0,fcol = 0 ,lrow = r-1 , lcol = c-1;
        while(counter < r * c)
        {
            for(int i = frow , j = fcol; i <= lrow ;i++)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            fcol++;
            for(int i = lrow , j = fcol; j <= lcol ;j++)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            lrow--;
            
            for(int i = lrow , j = lcol; i >= frow ;i--)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                    return;
            }
            
            lcol--;
            
            for(int i = frow , j = lcol; j >= fcol ;j--)
            {
                System.out.print(arr[i][j]+" ");
                counter++;
                
                if(counter >= r * c)
                  return;
            }
            
            frow++;
        }
    }
}
