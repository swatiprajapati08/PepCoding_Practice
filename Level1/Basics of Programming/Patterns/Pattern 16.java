import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n=scn.nextInt();
    int space=2*n-3;
    for(int i=1;i<=n;i++)
    {
        for(int k=1;k<=i;k++)
        System.out.print(k+"	");
        for(int k=1;k<=space;k++)
        System.out.print("	");
        if(i!=n){
        for(int k=i;k>=1;k--)
        System.out.print(k+"	");
        }
        else
        {
            for(int k=i-1;k>=1;k--)
        System.out.print(k+"	");
        }
        
        space-=2;
        System.out.println();
    }
    

 }
}
