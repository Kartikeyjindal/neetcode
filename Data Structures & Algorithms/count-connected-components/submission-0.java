class Solution 
{
    int []parent;
    int []rank;
    public int countComponents(int n, int[][] edges) 
    {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        Arrays.fill(rank,-1);

        for(int[]e:edges)
        {
            union(e[0],e[1]);
        } 

        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            set.add(find(i));
        }
        return set.size();

    }

    public void union(int a,int b)
    {
        int pa=find(a);
        int pb=find(b);

        if(pa==pb)
        {
            return;
        }
        else if(rank[pa]>rank[pb])
        {
            parent[pb]=pa;
        }
        else if(rank[pa]<rank[pb])
        {
            parent[pa]=pb;
        }
        else
        {
            parent[pa]=pb;
            rank[pb]++;
        }
    }

    public int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]=find(parent[x]);
    }
}
