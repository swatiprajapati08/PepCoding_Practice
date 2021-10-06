import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> postfix = new Stack<String>();
    Stack<String> infix = new Stack<String>();
    Stack<Integer> value = new Stack<Integer>();
    String a = "", b = "", temp = "";

    for (int i = exp.length() - 1; i >= 0 ; i--)
    {
      char ch = exp.charAt(i);
      if (ch >= '0' && ch <= '9')
      {
        postfix.add(Character.toString(ch));
        infix.add(Character.toString(ch));
        value.add(ch - '0');
      }
      else
      {
        //process the postfix
        a = postfix.pop();
        b = postfix.pop();
        temp = a + b + Character.toString(ch);
        postfix.add(temp);
        //process the infix
        a = infix.pop();
        b = infix.pop();
        temp = "(" + a + Character.toString(ch) + b + ")";
        infix.add(temp);

        //process the value stack
        int x = value.pop();
        int y = value.pop();
        int val = calc(x, y, ch);
        value.add(val);
      }

    }
    System.out.println(value.peek() + " \n" + infix.peek() + "\n" + postfix.peek());

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
