class Solution 
{
    public int[] findOrder(int n, int[][] prerequisites) 
    {
        int []ans=new int[n];
        int idx=0;
        int []indegree=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []p: prerequisites)
        {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }

        int course=0;

        while(!queue.isEmpty())
        {
            int cur=queue.poll();
            ans[idx++]=cur;
            course++;

            for(int neighbor:adj.get(cur))
            {
                indegree[neighbor]--;

                if(indegree[neighbor]==0)
                {
                    queue.add(neighbor);
                }
            }
        }

        if(course==n)
        {
            return ans;
        }
        else
        {
            return new int[0];
        }
    }
}
