import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> potentialCeleb = new Stack<Integer>();

        for(int i=0; i<arr.length;i++)
        potentialCeleb.push(i);
        
        while(potentialCeleb.size() > 1)
        {
            int val2 = potentialCeleb.pop();
            int val1 = potentialCeleb.pop();
            //System.out.println(val2+" "+val1);
            if(arr[val1][val2] == 1)
            potentialCeleb.push(val2);
            else
            potentialCeleb.push(val1);
            
        }
        if(checkValid(arr,potentialCeleb.peek()))
        System.out.println(potentialCeleb.peek());
        else
        System.out.println("none");
    }
    
    static boolean checkValid(int arr[][],int index)
    {
        //check row it must have zer0(celebrity doesn't know anyone)
        for(int i = 0; i < arr.length; i++)
        {
            if( index != i && arr[index][i] == 1)
            return false;
        }
        //check column it must have one (everybody know celebrity)
        for(int i = 0; i < arr.length; i++)
        {
            if( index != i && arr[i][index] == 0)
            return false;
        }
        return true;
    }

}
