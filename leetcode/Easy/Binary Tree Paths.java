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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();

        if(root != null) {
            findPath(root, "", paths);
        }

        return paths;   
    }

    public static void findPath(TreeNode root, String path, List<String> paths) {
        // leaf일 경우
        if(root.left == null && root.right == null) {
            paths.add(path + root.val);
        }
        if(root.left != null) {
            findPath(root.left, path + root.val + "->", paths);
        }
        if(root.right != null) {
            findPath(root.right, path + root.val + "->", paths);
        }
    }
}
