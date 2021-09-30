import java.io.*;
import java.util.*;

public class Solution {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
       
        
        int n = sc.nextInt();
        int arr[] = generateArray(n);
        int brr[] = generateArray(n);
        int crr[] = generateArray(n);
        PrintArray(arr);
        for(int i = n-1; i>=0;i--)
              System.out.print(brr[i]+" ");
        System.out.println();
        PrintArray(crr);
    
        
    }
    
    static void PrintArray(int arr[])
    {
        for(int i = 0;i < arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    static int[] generateArray(int n){
        int arr[] = new int[n];
        for(int i =0 ;i < n;i++)
            arr[i]= sc.nextInt();
       
        //sorting the arr
        
        for(int i =0 ;i<n-1;i++)
        {
            for(int j =0; j< n-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
