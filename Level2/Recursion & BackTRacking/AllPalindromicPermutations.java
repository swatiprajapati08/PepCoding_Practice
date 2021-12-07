import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int idx, int total, HashMap<Character, Integer> fmap, Character oddc, Character[] ch, boolean flag) {
		
		if(idx == total/2){
		    
		    //even digit
		    if(flag == false)
		        ch[idx] = oddc;
		   for(int i = 0; i<ch.length;i++)
		   System.out.print(ch[i]);
		   
		   System.out.println();
		    return;
		}
		
		int lastIdx = total - idx - 1;
		
		for(char c : fmap.keySet()){
		    int val = fmap.get(c);
		    
		    if(val != 1 && val > 0){
		        ch[idx] = c;
		        ch[lastIdx] = c;
		        fmap.put(c, val - 2);
		        generatepw(idx+1,total,fmap,oddc,ch,flag);
		        ch[idx] = '.';
		        ch[lastIdx] = '.';
		        fmap.put(c, val);
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		int oddN = 0;
		char oddC='.';
		for(char i:fmap.keySet()){
		    if(fmap.get(i) % 2 != 0){
		         oddC = i;
		         oddN++;
		    }
		}
		
		if(oddN > 1){
		    System.out.println("-1");
		    return;
		}
		
		boolean flag = str.length() % 2 == 0 ? true : false;
		Character ch[] = new Character[str.length()];
		Arrays.fill(ch,'.');
		
		
		generatepw(0,str.length(),fmap,oddC,ch,flag);
	
	}
	
}