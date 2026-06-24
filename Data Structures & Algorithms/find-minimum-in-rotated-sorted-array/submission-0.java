class Solution 
{
    public int findMin(int[] nums) 
    {
        int ans=Integer.MAX_VALUE;

        for(int i:nums)
        {
            ans=Math.min(ans,i);
        }
        return ans;
    }
}
