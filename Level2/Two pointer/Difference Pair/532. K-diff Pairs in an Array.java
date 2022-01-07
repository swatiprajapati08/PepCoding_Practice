https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/

class Solution {
    public int findPairs(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0 , j = 1;
       
        int count = 0;
        while(i < nums.length && j < nums.length){
            
            //skip duplicate
            if(i > 0 && nums[i-1] == nums[i]){i++; continue;}
            //if(j > 0 && nums[j-1] == nums[j]){j++; continue;}
            
            if(i == j){
                if(target < 0)
                    i++;
                else 
                    j++;
                continue;
            }
            
            int diff = nums[j] - nums[i];
            if(diff == target){
                count++;
                i++;
                j++;
            }
            else if(diff < target) j++;
            else
                i++;

        }
     return count;
    }
}
  
