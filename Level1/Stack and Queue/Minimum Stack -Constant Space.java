import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
      min = Integer.MAX_VALUE;
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      
        if (val >= min)
          data.push(val);
        else
        {
          data.push(val + val - min); //fake value added so we can detect
          min = val; //store original min
        }
    }

    int pop() {
      if (data.size() == 0)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      else
      {
        if (data.peek() >= min)
          return data.pop();
        else
        {
          int fakeVal = data.pop(); //inside the stack
          int originalMin = min;
          //retieve the original val from fake
          min = 2 * min - fakeVal;
          return originalMin;
        }
      }
    }

    int top() {
      if (data.size() == 0)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      else
      {
        if (data.peek() >= min) //actual val
          return data.peek();
        else
          return min;
      }
    }

    int min() {
      if (data.size() == 0)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
