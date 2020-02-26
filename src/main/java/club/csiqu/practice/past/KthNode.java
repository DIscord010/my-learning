package club.csiqu.practice.past;

/**
 * @author chensiqu
 * @since 2019/3/14 16:28
 */
public class KthNode {

    /**
     * 给定一棵二叉搜索树，请找出其中的第 k小的节点。
     * 二叉搜索树中序遍历即为排序结果。
     *
     * @param pRoot 树根
     * @param k     int
     * @return 第 k小的节点
     */
    public TreeNode kthNode(TreeNode pRoot, int k) {
        TreeNode result = new TreeNode(0);
        kthNode(pRoot, k, result);
        if (result.val == 0) {
            return null;
        }
        return result;
    }

    /** 记录第几个 */
    private int index = 1;

    private void kthNode(TreeNode pRoot, Integer k, TreeNode result) {
        if (index > k || pRoot == null) {
            return;
        }
        if (pRoot.left != null) {
            kthNode(pRoot.left, k, result);
        }
        if (index == k) {
            result.val = pRoot.val;
            index++;
            return;
        }
        index++;
        if (pRoot.right != null) {
            kthNode(pRoot.right, k, result);
        }
    }
}