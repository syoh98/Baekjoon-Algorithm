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
        if(root == null) {
            return 0;
        }

        // 1. 노드의 값이 범위 내에 있는 경우 -> 추가
        if(root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if(root.val < low) { // 2. 노드의 값이 범위보다 작은 경우 -> right 탐색
            return rangeSumBST(root.right, low, high);
        } else { // 3. 노드의 값이 범위보다 큰 경우 -> left 탐색
            return rangeSumBST(root.left, low, high);
        }
    }
}
