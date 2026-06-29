class Solution 
{
    public boolean isHappy(int n) 
    {
        HashSet<Integer> map=new HashSet<>();

        while(n!=1 && !map.contains(n))
        {
            map.add(n);
            n=solve(n);
        }
        return n==1;
    }

    public int solve(int n)
    {
        int ans=0;
        while(n>0)
        {
            int dig=n%10;
            n=n/10;

            ans+=dig*dig;
        }
        return ans;
    }
}
