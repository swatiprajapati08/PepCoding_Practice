import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> prefix = new Stack<String>();
    Stack<String> infix = new Stack<String>();
    Stack<Integer> value = new Stack<Integer>();
    String a = "", b = "", temp = "";

    for (int i = 0; i < exp.length(); i++)
    {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9')
      {
        prefix.add(Character.toString(ch));
        infix.add(Character.toString(ch));
        value.add(ch - '0');
      }
      else
      {
        //process the postfix
        b = prefix.pop();
        a = prefix.pop();
        temp = Character.toString(ch) + a + b ;
        prefix.add(temp);
        //process the infix
        b = infix.pop();
        a = infix.pop();
        temp = "(" + a + Character.toString(ch) + b + ")";
        infix.add(temp);

        //process the value stack
        int x = value.pop();
        int y = value.pop();
        int val = calc(y, x, ch);
        value.add(val);
      }

    }
    System.out.println(value.peek() + " \n" + infix.peek() + "\n" + prefix.peek());

  }
  static int calc(int val1, int val2, char op)
  {
    int res = 0;
    switch (op) {
      case '+':
        res = val1 + val2;
        break;

      case '-':
        res = val1 - val2;
        break;

      case '/':
        res = val1 / val2;
        break;

      case '*':
        res = val1 * val2;
        break;
      default:
    }
    return res;
  }
}
