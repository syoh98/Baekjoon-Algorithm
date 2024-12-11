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
class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getEdgeCnt(root);

        return diameter;
    }

    public int getEdgeCnt(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftVal = getEdgeCnt(node.left);
        int rightVal = getEdgeCnt(node.right);

        diameter = Math.max(diameter, leftVal + rightVal);

        return Math.max(leftVal, rightVal) + 1;
    }
}
