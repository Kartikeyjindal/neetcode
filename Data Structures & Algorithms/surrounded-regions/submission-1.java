class Solution 
{
    int m;
    int n;
    public void solve(char[][] board) 
    {
        m=board.length;
        n=board[0].length;

        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O')
            {
                dfs(0,i,board);
            }
            if(board[m-1][i]=='O')
            {
                dfs(m-1,i,board);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O')
            {
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O')
            {
                dfs(i,n-1,board);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='1')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }


    }

    public void dfs(int r,int c,char[][] board)
    {
        if(r<0 || r>=m || c<0 || c>=n || board[r][c]=='X'||board[r][c]=='1')
        {
            return ;
        }
        board[r][c]='1';
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }
}
