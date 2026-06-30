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
    public int diameterOfBinaryTree(TreeNode root)
    {
        int maxdis=0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode curr=queue.poll();
            maxdis=Math.max(maxdis,height(curr.left)+height(curr.right));
            if(curr.left!=null)
            {
                queue.add(curr.left);
            }
            if(curr.right!=null)
            {
                queue.add(curr.right);
            }
        }
        return maxdis;
    }

    public int height(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }

        return Math.max(height(node.left),height(node.right))+1;
    }
}
