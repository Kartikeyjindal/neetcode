class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n-2;i++)
        {
            int need=0-nums[i];
            Set<Integer> map=new HashSet<>();
            for(int j=i+1;j<n;j++)
            {
                int remaining=need-nums[j];
                if(map.contains(remaining))
                {
                    ans.add(Arrays.asList(nums[i],nums[j],remaining));
                }
                map.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}
