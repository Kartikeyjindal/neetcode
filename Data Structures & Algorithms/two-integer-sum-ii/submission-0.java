class Solution 
{
    public int[] twoSum(int[] num, int target) 
    {
        int sum=0;
        int n=num.length;
        int l=0;
        int r=n-1;

        while(l<r)
        {
            sum=num[l]+num[r];
            if(sum==target)
            {
                return new int[]{l+1,r+1};
            }
            if(sum<target)
            {
                l++;
            }
            else 
            {
                r--;
            }
        }
        return new int[0];
    }
}
