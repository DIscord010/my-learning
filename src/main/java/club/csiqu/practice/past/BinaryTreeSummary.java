package club.csiqu.practice.past;

import java.util.*;

@SuppressWarnings("unused")
public class BinaryTreeSummary {

    /**
     * 根据前序和中序遍历数组重构二叉树
     *
     * @param pre 前序遍历数组
     * @param in  中序遍历数组
     * @return 根节点
     */
    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = -1;
        for (int i = 0; i < in.length; i++) {
            if (root.getVal() == in[i]) {
                index = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(pre, 1, index + 1);
        int[] leftIn = Arrays.copyOfRange(in, 0, index);
        int[] rightPre = Arrays.copyOfRange(pre, index + 1, pre.length);
        int[] rightIn = Arrays.copyOfRange(in, index + 1, in.length);
        // 分别对左右子树进行递归
        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);
        return root;
    }

    /**
     * 先序遍历二叉树
     *
     * @param root 树根
     */
    private static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("->" + root.getVal());
        printPreorder(root.left);
        printPreorder(root.right);
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 树根
     */
    private void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print("->" + root.getVal());
        printInorder(root.right);
    }

    /**
     * 给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并且返回。
     *
     * @param pNode 节点
     * @return 节点的中序下一个节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果右子树不空 则为右子树的最左孩子
        if (pNode.right != null) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        // 如果右子树为空，而父亲不为空 则向上寻找
        else if (pNode.next != null) {
            TreeLinkNode temp = pNode;
            // 父亲的左孩子是我 则父亲是中序下个节点，不是则继续向上
            while (temp.next != null && temp.next.left != temp) {
                temp = temp.next;
            }
            return temp.next;
        }
        return null;
    }


    /**
     * 中序遍历二叉树判断是否含有某一节点。
     *
     * @param root1 二叉树树根
     * @param root2 二叉树节点
     * @return 二叉树节点
     */
    private TreeNode hasTreeNode(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return null;
        }
        if (root1.getVal() == root2.getVal()) {
            return root1;
        }
        hasTreeNode(root1.left, root2);
        // System.out.print("->" + root.val);
        hasTreeNode(root1.right, root2);
        return null;
    }

    /**
     * 判断 root2是否为 root1相同树根的子树，
     * 入参之时保证 root2非空。
     *
     * @param root1 二叉树
     * @param root2 二叉树
     * @return 是否为子树
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.getVal() == root2.getVal()) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    /**
     * 判断二叉树 root2是否为 root1的子结构，
     * 默认空树不是任何一个树的子结构。
     *
     * @param root1 二叉树树根
     * @param root2 二叉树树根
     * @return 是否为子结构
     */
    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1, root2) || hasSubtree(root1.left, root2)
                || hasSubtree(root1.right, root2);
    }

    /**
     * 层次遍历二叉树，使用一个队列来实现迭代。
     *
     * @param root 二叉树树根
     * @return 结果集
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            arrayList.add(node.getVal());
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return arrayList;
    }

    /**
     * 按照之字形打印二叉树
     *
     * @param pRoot 二叉树树根
     * @return 之字形打印结果
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (pRoot == null) {
            return new ArrayList<>();
        }
        queue.offer(pRoot);
        queue.offer(new TreeNode(-1));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != -1) {
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else if (!queue.isEmpty()) {
                result.add(temp);
                temp = new ArrayList<>();
                queue.offer(new TreeNode(-1));
            } else {
                // 将最后一行放入结果集
                result.add(temp);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     *
     * @param sequence 待判断数组
     * @return 是否为某二叉搜索树的后序遍历的结果
     */
    private static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int node = sequence[sequence.length - 1];
        int i = 0;
        for (; i < sequence.length - 1; i++) {
            if (node < sequence[i]) {
                break;
            }
        }
        for (int j = i; j < sequence.length - 1; j++) {
            if (node > sequence[j]) {
                return false;
            }
        }
        boolean leftFlag = true;
        if (i > 0) {
            leftFlag = verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        boolean rightFlag = true;
        if (i < sequence.length - 1) {
            rightFlag = verifySquenceOfBST(Arrays.copyOfRange(sequence, i,
                    sequence.length - 1));
        }
        return leftFlag && rightFlag;
    }

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
     * 进行先序遍历，用一个集合存放节点值，每次递归集合添加节点值 target=target-节点值。
     * 判断节点值是否与 target相等，且节点没有左右孩子，是的话将集合添加进结果集。
     * 需要移除尾巴节点(回退到父节点)。
     *
     * @param root   根节点
     * @param target 整数
     * @return 路径集合
     */
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root, target, arrayLists, path);
        return arrayLists;
    }

    private void findPath(TreeNode root, int target,
                          ArrayList<ArrayList<Integer>> arrayLists,
                          ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            arrayLists.add(new ArrayList<>(path));
        }
        if (root.val <= target && root.left != null) {
            findPath(root.left, target - root.val, arrayLists, path);
        }
        if (root.val <= target && root.right != null) {
            findPath(root.right, target - root.val, arrayLists, path);
        }
        // 回退到父节点
        path.remove(path.size() - 1);
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * @param pRootOfTree 二叉搜索树树根
     * @return 链表
     */
    private static TreeNode convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        List<TreeNode> list = new ArrayList<>();
        convertToList(pRootOfTree, list);
        for (int i = 0; i < list.size(); i++) {
            //System.out.print(list.get(i).val);
            if (i == 0) {
                list.get(i).left = null;
                list.get(i).right = list.get(i + 1);
                //System.out.println("text");
            } else if (i == list.size() - 1) {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = null;
                //System.out.println("text");
            } else {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(i + 1);
                //System.out.println("text");
            }
        }
        return list.get(0);
    }

    private static void convertToList(TreeNode pRootOfTree,
                                      List<TreeNode> list) {
        if (pRootOfTree == null) {
            return;
        }
        convertToList(pRootOfTree.left, list);
        list.add(pRootOfTree);
        convertToList(pRootOfTree.right, list);
    }

    /**
     * 判断一颗二叉树是不是对称的
     *
     * @param pRoot 树根
     * @return {@code true}如果此二叉树对称
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        // 左右节点相等 且子树也为镜像
        return left.val == right.val
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }

    /**
     * 求树的镜像
     *
     * @param root 树根
     */
    private void mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 二叉树的深度
     *
     * @param root 树根
     * @return 深度
     */
    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    /**
     * 判断树是不是平衡二叉树
     *
     * @param root 树根
     * @return {@code true}如果是平衡二叉树
     */
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 序列化二叉树
     *
     * @param root 树根
     * @return {@link String}
     */
    private static String serialize(TreeNode root) {

        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            return null;
        }
        serialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 序列化二叉树
     *
     * @param root   树根
     * @param string {@link StringBuilder}
     */
    private static void serialize(TreeNode root, StringBuilder string) {

        if (root == null) {
            string.append("#,");
            return;
        }
        string.append(root.val).append(",");
        serialize(root.left, string);
        serialize(root.right, string);
    }

    /** 序列化的字符串索引 */
    private static int index = -1;

    /**
     * 反序列化二叉树
     *
     * @param str 序列化的二叉树
     * @return {@code root}树根
     */
    private static TreeNode deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] strings = str.split(",");
        index++;
        TreeNode root = null;
        if (!"#".equals(strings[index])) {
            root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = deserialize(str);
            root.right = deserialize(str);
        }
        return root;
    }

    /**
     * 拥有父节点引用的二叉树
     */
    private static class TreeLinkNode {

        int val;

        /** 左孩子 */
        TreeLinkNode left;

        /** 右孩子 */
        TreeLinkNode right;

        /** 父亲 */
        TreeLinkNode next;

        TreeLinkNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        r.right.left = new TreeNode(6);
        r.right.right = new TreeNode(7);
        String s = serialize(r);
        System.out.println(s);
        assert s != null;
        TreeNode node = deserialize(s);
        printPreorder(node);
    }
}