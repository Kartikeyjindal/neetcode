class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int len=0;

        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);

            if(map.containsKey(c))
            {
                start=Math.max(start,map.get(c)+1);
            }
            map.put(c,i);
            len=Math.max(len,i-start+1);
        }
        return len;
    }
}
