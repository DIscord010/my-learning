package club.csiqu.practice.past;

public class MinimumOfBinaryTree {

    private int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return 1 + minDepth(node.right);
        }
        if (node.right == null) {
            return 1 + minDepth(node.left);
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    public int run(TreeNode root) {
        return minDepth(root);
    }
}