class Solution 
{
    public int maxProfit(int[] prices) 
    {
        Stack<Integer> stack=new Stack<>();
        int n=prices.length;
        int ans=0;
        stack.push(prices[n-1]);
        for(int i=n-2;i>=0;i--)
        {
            if(stack.peek()<prices[i])
            {
                stack.push(prices[i]);
            }
            ans=Math.max(ans,stack.peek()-prices[i]);
        }
        return ans;
    }
}
