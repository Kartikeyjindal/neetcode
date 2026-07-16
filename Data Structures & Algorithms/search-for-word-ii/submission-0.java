class Solution 
{
    List<String> ans;
    int r,c;
    int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};
    class Trie
    {
        boolean endword;
        Trie[] child;
        String word;

        Trie()
        {
            endword=false;
            child=new Trie[26];
            word="";
        }
    }

    public void insert(Trie root,String s)
    {
        Trie curr=root;

        for(char c:s.toCharArray())
        {
            if(curr.child[c-'a']==null)
            {
                curr.child[c-'a']=new Trie();
            }
            curr=curr.child[c-'a'];
        }
        curr.endword=true;
        curr.word=s;
    }

    public List<String> findWords(char[][] board, String[] words) 
    {
        ans=new ArrayList<>();
        r=board.length;
        c=board[0].length;
        Trie root=new Trie();

        for(int i=0;i<words.length;i++)
        {
            insert(root,words[i]);
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                char ch=board[i][j];
                if(root.child[ch-'a']!=null)
                {
                    dfs(board,i,j,root);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board,int i,int j,Trie root)
    {
        if(i<0 || i>=r || j<0 || j>=c || board[i][j]=='1' || root.child[board[i][j]-'a']==null)
        {
            return ;
        }
        root=root.child[board[i][j]-'a'];

        if(root.endword)
        {
            ans.add(root.word);
            root.endword=false;
        }

        char temp=board[i][j];
        board[i][j] = '1';

        for(int[] p : dir)
        {
            int nr = i + p[0];
            int nc = j + p[1];
            dfs(board, nr, nc, root);
        }
        board[i][j] = temp;

    }
}
