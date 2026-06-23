class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int n=nums.length;
        int zero=0;
        long product=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
        }
        if(zero>1)
        {
            int []ans=new int[n];
            Arrays.fill(ans,0);
            return ans;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                product*=nums[i];
            }
        }

        int []ans=new int[n];

        if(zero==1)
        {
            for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    ans[i]=(int)product;
                }
            }
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                ans[i]=(int)product/nums[i];
            }
        }

        return ans;
    }
}  
