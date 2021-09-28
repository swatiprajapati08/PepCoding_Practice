import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

       int n=scn.nextInt();
       
       int space=n/2;
       int star=1,p=1,x=0;
       for(int i=1;i<=n;i++)
       {
           
           for(int j=1;j<=space;j++)
           System.out.print("	");
           x=p;
            for(int k=1;k<=star;k++)
          { 
              
              System.out.print(x+"	");
             if(k<=star/2)
             x++;
             else
             x--;
          }
           
           if(i<=n/2)
           {
               space--;
               star+=2;
               p++;
           }
           else
           {
               space++;
               star-=2;
               p--;
               
           }
           System.out.println();
       }

    }
}
