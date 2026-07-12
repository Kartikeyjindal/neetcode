class Solution 
{
    int n; 
    int []dp;
    public int rob(int[] nums) 
    {
        n=nums.length;
        if(n==1)
        {
            return nums[0];
        }
        dp=new int[n];
        

        int []n1=new int[n-1];
        int []n2=new int[n-1];

        for(int i=0;i<n-1;i++)
        {
            n1[i]=nums[i];
        }
        for(int i=1;i<n;i++)
        {
            n2[i-1]=nums[i];
        }
        Arrays.fill(dp,-1);
        int s1=solve(0,n1);
        Arrays.fill(dp,-1);
        int s2=solve(0,n2);
        return Math.max(s1,s2);
    }
    public int solve(int curr,int []nums)
    {
        if(curr>=nums.length)
        {
            return 0;
        }
        if(dp[curr]!=-1)
        {
            return dp[curr];
        }

        int take=nums[curr]+solve(curr+2,nums);
        int skip=solve(curr+1,nums);

        return dp[curr]=Math.max(take,skip);
    }
}
