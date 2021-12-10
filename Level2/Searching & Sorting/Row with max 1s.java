//https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
       int left = 0,right = m - 1,index = -1,noOfOnes = 0;
       
       for(int i = 0; i < n;i++){
         
      //always put a loop by updating the next tp - 1 
     // if it is giving more no of 1's then only update.
         
           int tp = TransitionPoint(arr[i],0,right);
           if(tp != -1 &&  m - tp > noOfOnes)
           {right = tp - 1;
           noOfOnes = m - tp;
           index = i;}
           
       }
       return index;
    }
  //finding 1's index of getting one
    static int TransitionPoint(int arr[], int left , int right){
        
           int ans = -1;
        while(left <= right){
         
            int mid = left + (right - left)/2;
            if(arr[mid]==1){
                ans = mid;
                right = mid - 1;
            }
            else
            left = mid + 1;
        }
        return ans;
    }
}
