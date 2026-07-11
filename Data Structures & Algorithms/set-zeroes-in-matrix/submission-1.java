class Solution 
{
    public void setZeroes(int[][] matrix) 
    {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    solve(matrix,i,j);
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==-1000000007)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }

    public void solve(int[][] matrix ,int r,int c)
    {
        int m=matrix.length;
        int n=matrix[0].length;

        for(int i=0;i<n;i++)
        {
            if(matrix[r][i] != 0) matrix[r][i]=-1000000007;
        }
        for(int i=0;i<m;i++)
        {
            if(matrix[i][c] != 0) matrix[i][c]=-1000000007;
        }
    }
}
