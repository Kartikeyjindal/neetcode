/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution 
{  
    public boolean isSubtree(TreeNode root, TreeNode subroot) 
    {
        if(root==null)
        {
            return false;
        }
        if(solve(root,subroot))
        {
            return true;
        }
        return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
    }

    public boolean solve(TreeNode root,TreeNode subroot)
    {
        if(root==null && subroot==null)
        {
            return true;
        }
        if(root==null || subroot==null)
        {
            return false;
        }
        if(root.val!=subroot.val)
        {
            return false;
        }

        return solve(root.left,subroot.left) && solve(root.right,subroot.right);
    }
}
