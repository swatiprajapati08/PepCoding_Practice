/*
Micro just bought a maze, that can be represented as a matrix A of size N×M, 
where rows are numbered from 1 to N and columns are numbered from 1 to M. Each
cell of the matrix can be either 0 or 1. If a cell is 0 that means it cannot 
be visited and if it is 1, then it can be visited. Allowed moves are up, down,
left and right. Help Micro to find out if he can reach from the cell (1,1) to 
the cell (N,M), it is guaranteed that the cells (1,1) and (N,M) have value 1.

input:
3 3
1 0 1
1 0 0
1 1 1

Output
Yes 
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr[][] = new int[n][m];
        int visited[][] = new int[n][m];
        for(int i = 0; i < n ;i++)
        {
            for(int j = 0; j< m; j++)
                arr[i][j] = sc.nextInt();
        }
        
        if(Destination(arr,visited,0,0,n,m))
            System.out.println("Yes");
        else
            System.out.println("No");
        
        
    }
    
    static boolean Destination(int arr[][], int visited[][], int i , int j,int n,int m)
    {
        if(i == arr.length - 1 && j == arr[0].length - 1)
            return true;
        
        if( i >=  0 && j>=0 && j<m && i<n && arr[i][j] == 1 && visited[i][j] == 0)
        {
            visited[i][j] = 1;
            if(Destination(arr,visited,i+1,j,n,m))
                return true;
            if(Destination(arr,visited,i,j+1,n,m))
                return true;
            if(Destination(arr,visited,i-1,j,n,m))
                return true;
            if(Destination(arr,visited,i,j-1,n,m))
                return true;
            
            visited[i][j] = 0;
            return false;
        }
        return false;
    }
}
