class WordDictionary 
{
    class Trie
    {
        Trie[] child=new Trie[26];
        boolean endword=false;
    }
    Trie root;
    public WordDictionary() 
    {
        root=new Trie();
    }

    public void addWord(String word) 
    {
        Trie curr=root;

        for(char c:word.toCharArray())
        {
            int idx=c-'a';
            if(curr.child[idx]==null)
            {
                curr.child[idx]=new Trie();
            }
            curr=curr.child[idx];
        }
        curr.endword=true;
    }

    public boolean search(String word) 
    {
        return solve(word,0,root);
    }

    public boolean solve(String word,int i,Trie curr)
    {
        if(word.length()==i)
        {
            return curr.endword;
        }

        char c=word.charAt(i);

        if(c=='.')
        {
            for(int j=0;j<26;j++)
            {
                if(curr.child[j]!=null && solve(word,i+1,curr.child[j]))
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            int idx=c-'a';
            if(curr.child[idx]==null)
            {
                return false;
            }
            return solve(word,i+1,curr.child[idx]);
        }
    }
}
