class Solution 
{
    public void islandsAndTreasure(int[][] grid) 
    {
        if(grid==null ||grid.length==0)
        {
            return ;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty())
        {
            int[]curr=queue.poll();
            int r=curr[0];
            int c=curr[1];

            for(int []d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];

                if(nc<0 || nc>=n || nr<0 || nr>=m || grid[nr][nc]!=Integer.MAX_VALUE)
                {
                    continue;
                }
                grid[nr][nc]=grid[r][c]+1;

                queue.offer(new int[]{nr,nc});
            }
        }
    }
}
