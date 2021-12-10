class Solution {
    //treat 2D matrix as 1D and apply binary Search
    public boolean searchMatrix(int[][] matrix, int target) {
       int left = 0, right = (matrix.length * matrix[0].length) - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
             int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return false;
    }
}
