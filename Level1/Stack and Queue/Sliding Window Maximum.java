import java.io.*;
import java.util.*;

public class Main {

//find next Greater element
  public static int[] solve(int[] arr) {
    int ans[] = new int[arr.length];
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = arr.length - 1; i >= 0; i--)
    {
      //pop
      while(stack.size() > 0 && arr[stack.peek()]<=arr[i])
      stack.pop();
      
      // make ans
      if(stack.size() == 0)
      ans[i] = arr.length;
      else 
      ans[i] = stack.peek();
      
      //push
      stack.push(i);
    }
    return ans;
  }



  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

   int nextGreater[] = solve(arr);
   int j=0;
   for(int i = 0; i <= n - k;i++)
   {
       //enter the loop to get maximum
       if(j < i)
       j = i;
       
       //jump till we get the max inside the window
       while(nextGreater[j] < i + k)
       j = nextGreater[j]; 
       
       System.out.println(arr[j]);
   }
  }
}
