class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int n=temperatures.length;

        int []ans=new int [n];
        Stack<int []> stack=new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty())
            {
                int []curr=stack.peek();
                int temp=curr[0];
                int idx=curr[1];
                if(temp<=temperatures[i])
                {
                    stack.pop();
                }
                else
                {
                    break;
                }
            }
            if(stack.isEmpty())
            {
                ans[i]=0;
            }
            else
            {
                int []curr=stack.peek();
                int temp=curr[0];
                int idx=curr[1];
                ans[i]=idx-i;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}
