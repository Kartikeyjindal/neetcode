class Solution
{
    public boolean isPalindrome(String str) 
    {
        StringBuilder s=new StringBuilder();
        for (char ch : str.toCharArray()) 
        {
            if (Character.isLetterOrDigit(ch)) 
            {
                s.append(Character.toLowerCase(ch));
            }
        }
        int l=0;
        int r=s.length()-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
