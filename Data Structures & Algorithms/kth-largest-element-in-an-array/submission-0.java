class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i:nums)
        {
            pq.add(i);
        }

        while(k!=1)
        {
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}
