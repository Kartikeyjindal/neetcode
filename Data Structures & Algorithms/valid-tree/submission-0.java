class Solution 
{
    public boolean validTree(int n, int[][] edges) 
    {
        if (edges.length != n - 1) 
        {
            return false;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int []e:edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();

        queue.add(0);
        visited.add(0);

        while(!queue.isEmpty())
        {
            int cur=queue.poll();

            for(int neighbor:adj.get(cur))
            {
                if(!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        } 
        return visited.size()==n;
    }
}
