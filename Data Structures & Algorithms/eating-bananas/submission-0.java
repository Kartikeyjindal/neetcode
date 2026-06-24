class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int l=1;
        int r=0;
        for(int pile :piles) 
        {
            r = Math.max(r,pile);
        }
        while(l<=r)
        {
            int mid=l+(r-l)/2;

            long t=solve(piles,mid);

            if(t<=h)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }

    public long solve(int[] piles,int mid)
    {
        long t=0;

        for(int i:piles)
        {
            if(i%mid==0)
            {
                t+=i/mid;
            }
            else
            {
                t+=i/mid+1;
            }
        }
        return t;
    }
}