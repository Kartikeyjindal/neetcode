class Solution 
{
    public int maxArea(int[] heights) 
    {
        int n=heights.length;
        int ans=Integer.MIN_VALUE;

        int l=0;
        int r=n-1;

        while(l<r)
        {
            ans=Math.max(ans,Math.min(heights[l],heights[r])*(r-l));

            if(heights[l]<heights[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        return ans;
    }
}
