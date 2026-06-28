class Solution 
{
    public double myPow(double x, int n) 
    {
        double ans=x;

        if(n==0)
        {
            return (double)1;
        }
        if(n>=1)
        {
            for(int i=0;i<n-1;i++)
            {
                ans*=x;
            }
        }
        else
        {
            ans=1;
            for(int i=0;i<Math.abs(n);i++)
            {
                ans=ans/x;
            }
        }
        return ans;
    }
}