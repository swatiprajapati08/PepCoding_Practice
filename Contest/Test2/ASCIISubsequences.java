/*
Take as input str, a string. We are concerned with all the possible
ascii-subsequences of str. E.g. “ab” has following ascii-subsequences “”, “b”,
“98”, “a”, “ab”, “a98”, “97”, “97b”, “9798”

Example(To be used only for expected output):
Input:
ab
output

9
[, b, 98, a, ab, a98, 97, 97b, 9798]

b
98
a
ab
a98
97
97b
9798

*/


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> result = new ArrayList<>();
        Subsequence(str,"",result);
         System.out.println(result.size());
            System.out.println(result);
        for(String s:result)
            System.out.println(s);
    }
    
    static void Subsequence(String str, String out, ArrayList<String> result)
    {
        if(str.length() == 0)
        {
            result.add(out);
            return;
        }
        Subsequence(str.substring(1),out ,result);
        Subsequence(str.substring(1),out + str.charAt(0),result);
        Subsequence(str.substring(1),out + (int)(str.charAt(0)),result);
       
       
        return;
    }
}
