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
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, (long) targetSum);
    }

    public int dfs(TreeNode node, long targetSum) {
        if(node == null) {
            return 0;
        }

        int count = getPathCount(node, targetSum);

        count += dfs(node.left, targetSum);
        count += dfs(node.right, targetSum);

        return count;
    }

    public int getPathCount(TreeNode node, long targetSum) {
        if(node == null) {
            return 0;
        }

        int count = 0;

        if(node.val == targetSum) {
            count++;
        }

        count += getPathCount(node.left, targetSum - node.val);
        count += getPathCount(node.right, targetSum - node.val);

        return count;
    }
}
