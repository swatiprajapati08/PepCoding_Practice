//https://practice.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix/1#

int countZeros(int arr[][], int n)
    {
        int ans = 0;
       for(int i = 0; i< n;i++){
           int tp = TransitionPoint(arr[i],0,n - 1);
           if(tp == -1)
           ans += n;
           else  //tp will help to get the no.of zeros
           ans += tp;
       }
       return ans;
    }
    // first occurance of 1
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
