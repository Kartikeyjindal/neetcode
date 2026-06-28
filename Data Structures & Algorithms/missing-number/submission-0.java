class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int n=nums.length;

        int expsum=n*(n+1)/2;
        int acusum=0;

        for(int i:nums)
        {
            acusum+=i;
        }

        return expsum-acusum;
        
    }
}
