import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int space = 0;
    for (int i = 1; i <= n; i++)
    {
      for (int j = 1; j <= space; j++)
        System.out.print("	");
      for (int j = 1; j <= n - space * 2; j++)
      {
        if (i != 1 && i <= n / 2)
        {
          if (j == 1 || j == n - space * 2)
            System.out.print("*	");
          else
            System.out.print("	");

        }
        else
          System.out.print("*	");
      }

      if (i <= n / 2)
        space++;
      else
        space--;
      System.out.println();
    }


  }
}
