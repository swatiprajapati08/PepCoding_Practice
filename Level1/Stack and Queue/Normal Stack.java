import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int top;

    public CustomStack(int cap) {
      data = new int[cap];
      top = -1;
    }

    int size() {
      return top + 1;
    }

    void display() {
      for (int i = top; i >= 0 ; i--)
        System.out.print(data[i] + " ");
        System.out.println();
    }

    void push(int val) {
      if (top == data.length - 1)
      {
        System.out.println("Stack overflow");
        return;
      }
      data[++top] = val;

    }

    int pop() {
      if (top ==  - 1)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      int val = data[top];
      top--;
      return val;
    }

    int top() {
      if (top ==  - 1)
      {
        System.out.println("Stack underflow");
        return -1;
      }
      return data[top];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

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
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = br.readLine();
    }
  }
}
