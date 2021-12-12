//https://www.interviewbit.com/problems/woodcutting-made-easy/


public class Solution {
    public int solve(int[] A, int B) {
        long low = 0,high =0;

        for(int i: A)
        high = Math.max(high,i);

        int ans = -1; 
        while(low <= high){
            int mid = (int)(low +(high - low)/2);
            if(canCut(A,mid,B)==true){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
  
    boolean canCut(int arr[], int currH,int b){
        long dis = 0;
        for(int i: arr){
            if(i > currH)
            dis += i - currH;
        }

        if(dis < b) return false;

        return true;
    }
}
