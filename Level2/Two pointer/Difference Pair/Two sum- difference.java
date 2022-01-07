/* Two Sum - Difference equals to target
https://www.lintcode.com/problem/610/ */


public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        
        Arrays.sort(nums);
        int i = 0 , j = 1;
        target = Math.abs(target);
        while(i < nums.length && j < nums.length){
            if(i == j){
                if(target < 0)
                i++;
                else
                j++;
                continue;
            }      // if we only increase left++ without check then it will fail this case   0 2 3 10 13   target = 1 
            int diff = nums[j] - nums[i];
            if(diff == target){
                int min = Math.min(nums[i],nums[j]);
                int max = Math.max(nums[i],nums[j]);
                return new int[]{min,max};
            }
            else if(diff < target) j++;
            else{
                i++;
            }
        }
     return new int[2];
    }
}
