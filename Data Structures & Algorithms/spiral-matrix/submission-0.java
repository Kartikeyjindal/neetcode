class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int m=matrix.length;
        int n=matrix[0].length;

        List<Integer> ans=new ArrayList<>();
        //dir will be 0 rightside
                    //1 down 
                    //2 leftside
                    //3 upside
        int k=0;

        int dir=0;
        int l=0;
        int r=n-1;
        int u=0;
        int d=m-1;

        while(u<=d && l<=r)
        {
            if(dir==0)
            {
                for(int i=l;i<=r;i++)
                {
                    ans.add(matrix[u][i]);
                }
                u++;
                dir=1;
            }
            else if(dir==1)
            {
                for(int i=u;i<=d;i++)
                {
                    ans.add(matrix[i][r]);
                }
                r--;
                dir=2;
            }
            else if(dir==2)
            {
                for(int i=r;i>=l;i--)
                {
                    ans.add(matrix[d][i]);
                }
                d--;
                dir=3;
            }
            else if(dir==3)
            {
                for(int i=d;i>=u;i--)
                {
                    ans.add(matrix[i][l]);
                }
                l++;
                dir=0;
            }
        }
        return ans;
    }
}
