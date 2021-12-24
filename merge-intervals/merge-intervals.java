class Solution {
    public int[][] merge(int[][] intervals) {
      
        Arrays.sort(intervals,(a,b) -> {return a[0] - b[0];});
       
        Stack<Integer[]> stack = new Stack<>();
        
        
        for(int i = 0; i < intervals.length;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(stack.isEmpty())
                stack.push(new Integer[]{start,end});
            else
            {
                Integer[] top = stack.pop();
                
                if(top[1] >= start)
                {
                    top[1] = Math.max(end,top[1]);
                    stack.push(top);
                }
                else{
                   stack.push(top);
                   stack.push(new Integer[]{start,end});
                }
            }
        }
        // stack stored intervals in reverse order
        Stack<Integer[]> res = new Stack<>();
        while(!stack.isEmpty())
            res.push(stack.pop());
        
        int ans[][] = new int[res.size()][2];
        int i = 0;
        
        
        while(!res.isEmpty())
        {
            Integer[] top = res.pop();
            ans[i][0] = top[0];
            ans[i][1] = top[1];
            
            i++;
        }
        
            
        return ans;
        
    }

}