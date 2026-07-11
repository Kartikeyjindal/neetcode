class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n=edges.length;

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int []e:edges)
        {
            boolean []visited=new boolean[n+1];
            if(dfs(adj,e[0],e[1],visited))
            {
                return e;
            }
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return new int[0];

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int u,int v,boolean []visited)
    {
        visited[u]=true;

        if(u==v)
        {
            return true;
        }

        for(int neighbor:adj.get(u))
        {
            if(visited[neighbor])
            {
                continue;
            }
            if(dfs(adj,neighbor,v,visited))
            {
                return true;
            }
        }
        return false;
    }
}
