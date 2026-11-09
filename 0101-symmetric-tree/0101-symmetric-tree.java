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
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode[]> queue = new LinkedList<>();

        queue.offer(new TreeNode[]{root.left, root.right});

        while (!queue.isEmpty()) {

            TreeNode[] pair = queue.poll();

            TreeNode left = pair[0];
            TreeNode right = pair[1];

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.offer(new TreeNode[]{left.left, right.right});
            queue.offer(new TreeNode[]{left.right, right.left});
        }

        return true;
    }
}