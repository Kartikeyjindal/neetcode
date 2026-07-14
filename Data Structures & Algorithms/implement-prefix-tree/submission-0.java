class PrefixTree 
{
    boolean endword;
    PrefixTree []child;
    
    public PrefixTree() 
    {
        endword=false;
        child=new PrefixTree[26];
    }

    public void insert(String word) 
    {
        PrefixTree cur=this;

        for(char ch:word.toCharArray())
        {
            if(cur.child[ch-'a']==null)
            {
                cur.child[ch-'a']=new PrefixTree();
            }
            cur=cur.child[ch-'a'];
        }
        cur.endword=true;  
    }

    public boolean search(String word) 
    {
        PrefixTree cur=this;

        for(char ch:word.toCharArray())
        {
            if(cur.child[ch-'a']==null)
            {
                return false;
            }
            cur=cur.child[ch-'a'];
        }
        return cur.endword;
    }

    public boolean startsWith(String prefix) 
    {
        PrefixTree cur=this;

        for(char ch:prefix.toCharArray())
        {
            if(cur.child[ch-'a']==null)
            {
                return false;
            }
            cur=cur.child[ch-'a'];
        }
        return true;
    }
}
