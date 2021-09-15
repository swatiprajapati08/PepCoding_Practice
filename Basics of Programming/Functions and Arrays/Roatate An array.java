import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  static void Reverse(int arr[], int start, int end)
  {
    while (start < end)
    {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      end--;
      start++;
    }
  }

  public static void rotate(int[] arr, int k) {
    k = k % arr.length;

    if (k < 0)
      k = k + arr.length;

    Reverse(arr, 0, arr.length - k - 1);
    Reverse(arr, arr.length - k, arr.length - 1);
    Reverse(arr, 0, arr.length - 1);

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
  }

}
