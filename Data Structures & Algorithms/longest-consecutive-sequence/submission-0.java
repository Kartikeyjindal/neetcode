class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        if(nums==null || nums.length==0)
        {
            return 0;
        }

        Set<Integer> set=new HashSet<>();

        for(int n:nums)
        {
            set.add(n);
        }

        int maxlen=0;

        for(int num:set)
        {
            if(!set.contains(num-1))
            {
                int curr=num;
                int currlen=1;

                while(set.contains(curr+1))
                {
                    curr++;
                    currlen++;
                }
                maxlen=Math.max(maxlen,currlen);
            }
        }
        return maxlen;
    }
}
