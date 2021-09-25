import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> prefix = new Stack<String>();
    Stack<String> postfix = new Stack<String>();
    Stack<Character> ops = new Stack<Character>();
    for (char ch : exp.toCharArray())
    {
      if (ch >= 'a' && ch <= 'z' || ch >= '1' && ch <= '9' || ch >= 'A' && ch <= 'Z')
      {
        prefix.push(Character.toString(ch));
        postfix.push(Character.toString(ch));
      }
      else if (ch == '(')
        ops.push(ch);

      else if (ch == ')')
      {
        //pop till ( and added the calculated val
        while (ops.peek() != '(')
        {
          Character op = ops.pop();
          String preVal2 = prefix.pop();
          String preVal1 = prefix.pop();
          String res = op + preVal1 + preVal2;
          prefix.push(res);
          String postVal2 = postfix.pop();
          String postVal1 = postfix.pop();
          String res2 = postVal1 + postVal2 + op;
          postfix.push(res2);
        }
        ops.pop(); //'(' pop out from stack
      }

      else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
      {

        //remove till we get the high precedence
        // as lowest can't sit on highest
        while (ops.size() > 0 && ops.peek() != '(' && precedence(ops.peek()) >= precedence(ch))
        {
          Character op = ops.pop();
          String preVal2 = prefix.pop();
          String preVal1 = prefix.pop();
          String res = op + preVal1 + preVal2;
          prefix.push(res);
          String postVal2 = postfix.pop();
          String postVal1 = postfix.pop();
          String res2 = postVal1 + postVal2 + op;
          postfix.push(res2);
        }
        ops.push(ch);
      }
    }
     // perform operations remaining in stack after traversal
    while (ops.size() > 0)
    {
      Character op = ops.pop();
      String preVal2 = prefix.pop();
      String preVal1 = prefix.pop();
      String res = op + preVal1 + preVal2;
      prefix.push(res);
      String postVal2 = postfix.pop();
      String postVal1 = postfix.pop();
      String res2 = postVal1 + postVal2 + op;
      postfix.push(res2);
    }

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
  }

  static int precedence(char op)
  {
    if ( op == '*' || op == '/')
      return 2;
    else if ( op == '+' || op == '-')
      return 1;
    return 0;
  }

}
