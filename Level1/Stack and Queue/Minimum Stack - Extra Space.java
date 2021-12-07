import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;

    public MinStack() {
      st = new Stack<>();
      minst = new Stack<>();
    }


    int size() {
      return st.size();
    }

    void push(int val) {
      st.push(val);
      if (minst.size() == 0 || minst.peek() >= val)
        minst.push(val);
    }

    int pop() {
      if (st.size() == 0)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      int val = st.pop();
      if (minst.peek() == val)
        minst.pop();
      return val;
    }

    int top() {
      if (st.size() > 0)
        return st.peek();
      System.out.println("Stack underflow");
      return -1;
    }

    int min() {
      if (minst.size() > 0)
        return minst.peek();
      System.out.println("Stack underflow");
      return -1;
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
