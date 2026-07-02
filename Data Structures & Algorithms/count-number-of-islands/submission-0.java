class Solution 
{
    int m;int n;
    public int numIslands(char[][] grid) 
    {
        m=grid.length;
        n=grid[0].length;

        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    ans++;
                    sink(i,j,grid);
                }
            }
        }
        return ans;
    }

    public void sink(int i,int j,char[][]grid)
    {
        if(i>=m ||i<0 || j<0 || j>=n || grid[i][j]=='0')
        {
            return ;
        }
        grid[i][j]='0';

        sink(i+1,j,grid);
        sink(i,j+1,grid);
        sink(i-1,j,grid);
        sink(i,j-1,grid);
    }
}
