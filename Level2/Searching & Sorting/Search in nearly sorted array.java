https://www.pepcoding.com/resources/online-java-foundation/leetcode/search-in-nearly-sorted-array/ojquestion#!
// If mid found the search mid + 1, mid, mid - 1



import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solve(num, k));
  }

  public static int solve(int[] arr, int target) {
      int low = 0, high = arr.length - 1;
      
      while(low <= high){
          
          int mid = low + (high - low)/2;
          
          int lval = mid - 1 >= 0 ? arr[mid - 1] : Integer.MIN_VALUE;
          
          int rval = mid + 1 >= 0 ? arr[mid + 1] : Integer.MIN_VALUE;
          
          if(arr[mid] == target) return mid;
          else if(lval == target) return mid - 1;
          else if(rval == target) return mid + 1;
          else if(arr[mid] > target) high = mid - 2;
          else low = mid + 2;
      }
      return -1;

  }
}
