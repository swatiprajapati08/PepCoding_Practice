import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        
        Arrays.sort(arr,(a,b)-> {return a[0] - b[0];});
        
        Stack<Integer[]> stack = new Stack<>();
        
        for(int i =0;i<arr.length;i++)
        {
            int start = arr[i][0];
            int end = arr[i][1];
            
            if(stack.isEmpty())
            stack.add(new Integer[]{start,end});
            else
            {
                Integer[] prevInterval = stack.pop();
                
                //if less then merge in previous interval
                if(start <= prevInterval[1])
                {
                    prevInterval[1] = Math.max(end,prevInterval[1]);
                    stack.push(prevInterval);
                }
                else
                {
                    stack.push(prevInterval);
                    stack.add(new Integer[]{start,end});
                }
                
            }
        }
        
        // Stack Elements are in reverse order.
        Stack<Integer[]> res = new Stack<>();
        while(!stack.isEmpty())
            res.push(stack.pop());
        
        while(!res.isEmpty())
        {
            Integer[] curr = res.pop();
            System.out.println(curr[0] + " " + curr[1]);
        }
        
    }

}
