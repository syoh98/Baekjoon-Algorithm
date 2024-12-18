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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return valueSum(root, low, high);
    }

    public int valueSum(TreeNode node, int low, int high) {
        if(node == null) {
            return 0;
        }
        int sum = 0;

        if(node.val >= low && node.val <= high) {
            sum += node.val;
        }

        sum += valueSum(node.left, low, high);
        sum += valueSum(node.right, low, high);

        return sum;
    }
}
