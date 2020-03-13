package club.csiqu.practice.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Siqu Chen 2020/3/10
 * @since 1.0.0
 */
class TreeSummaryTest {

    TreeSummary treeSummary = new TreeSummary();

    @Test
    void trimBst() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        Assertions.assertNull(treeSummary.trimBst(root, 1, 2).left);
    }
}