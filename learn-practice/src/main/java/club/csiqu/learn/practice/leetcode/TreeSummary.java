package club.csiqu.learn.practice.leetcode;

/**
 * 树相关.
 *
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class TreeSummary {

    int depth = 0;

    /**
     * 543.
     * 计算二叉树的直径
     *
     * @param root 树根
     * @return 数的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return depth;
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = depth(treeNode.left);
        int rigthDepth = depth(treeNode.right);
        depth = Math.max(depth, leftDepth + rigthDepth);
        return Math.max(leftDepth, rigthDepth) + 1;
    }

    /**
     * 669.
     * 给定一个二叉搜索树，同时给定最小边界 L和最大边界 R。
     * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中(R>=L)。
     * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     *
     * @param root 树根
     * @param l    最小边界
     * @param r    最大边界
     * @return 修剪后的树根
     */
    public TreeNode trimBst(TreeNode root, int l, int r) {
        return trim(root, l, r);
    }

    private TreeNode trim(TreeNode treeNode, int l, int r) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val > r) {
            return trim(treeNode.left, l, r);
        }
        if (treeNode.val < l) {
            return trim(treeNode.right, l, r);
        }
        treeNode.left = trim(treeNode.left, l, r);
        treeNode.right = trim(treeNode.right, l, r);
        return treeNode;
    }
}