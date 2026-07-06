class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        if(grid==null || grid.length==0)
        {
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;

        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                if(grid[r][c]==2)
                {
                    queue.add(new int[]{r,c});
                }
                else if(grid[r][c]==1)
                {
                    fresh++;
                }
            }
        }

        if(fresh==0)
        {
            return 0;
        }

        int ans=0;
        int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty())
        {
            int size=queue.size();
            boolean rotted=false;

            for(int i=0;i<size;i++)
            {
                int[]curr=queue.poll();
                int r=curr[0];
                int c=curr[1];

                for(int []d:dir)
                {
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        queue.add(new int[]{nr,nc});
                        rotted=true;
                    }
                    
                }
            }
            if(rotted)
            {
                ans++;
            }
        }
        if(fresh==0)
        {
            return ans;
        }
        return -1;
    }
}
