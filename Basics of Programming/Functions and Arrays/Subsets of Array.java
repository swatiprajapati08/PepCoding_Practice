import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();

    int pow = (int)Math.pow(2, n);

    for (int i = 0; i < pow; i++)
    {
      int binary = generateBinary(i);
     // System.out.println(binary);
      
      int div = (int)Math.pow(10, n - 1);

      for (int j = 0; j < n; j++)
      {
        int  quo = binary / div;
        if (quo % 10 == 0)
          System.out.print("-\t");
        else
          System.out.print(arr[j] + "\t");
        div = div / 10;
      }
      System.out.println();

    }
  }
  
  static int generateBinary(int n)
  {
      int pow=1;
      int val=0;
      while(n>0)
      {
          int dig=n%2;
          n=n/2;
          
          val+=dig*pow;
          pow*=10;
      }
      return val;
  }

}
