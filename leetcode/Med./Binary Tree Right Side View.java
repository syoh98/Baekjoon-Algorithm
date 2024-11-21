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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        reSideView(root, result, 0);

        return result;
    }

    public void reSideView(TreeNode node, ArrayList<Integer> result, int depth) {
        if(node == null) {
            return;
        }
        
        if(depth == result.size()) {
            result.add(node.val);
        }

        reSideView(node.right, result, depth+1);
        reSideView(node.left, result, depth+1);
    }
}
