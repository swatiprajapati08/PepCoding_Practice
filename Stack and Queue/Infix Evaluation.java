import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> num = new Stack<Integer>();
    Stack<Character> ops = new Stack<Character>();


    for (int i = 0; i < exp.length(); i++)
    {
      char ch = exp.charAt(i);

      if (ch >= '0' && ch <= '9')
        num.push(ch - '0');

      else if (ch == '(')
        ops.push(ch);

      else if (ch == ')')
      {
        //pop till ( and added the calculated val
        while (ops.peek() != '(')
        {
          int val2 = num.pop();
          int val1 = num.pop();
          char opr = ops.pop();
          int res = calc(val1, val2, opr);
          num.push(res); // push the ans
        }
        ops.pop(); // pop (
      }

      else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' ) // +,-,*,/
      {
        //remove till we get the high precedence
        // as lowest can't sit on highest
        while (ops.size() > 0 && ops.peek() != '(' && precedence(ops.peek()) >= precedence(ch))
        {
          int val2 = num.pop();
          int val1 = num.pop();
          char opr = ops.pop();
          int res = calc(val1, val2, opr);
          num.push(res);
        }
        ops.push(ch);
      }
    }

    // perform operations remaining in stack after traversal

    while (ops.size() > 0)
    {
      int val2 = num.pop();
      int val1 = num.pop();
      char opr = ops.pop();
      int res = calc(val1, val2, opr);
      num.push(res);
    }
    System.out.println(num.peek());

  }

  static int precedence(char op)
  {
    if ( op == '*' || op == '/')
      return 2;
    else if ( op == '+' || op == '-')
      return 1;
    return 0;
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
