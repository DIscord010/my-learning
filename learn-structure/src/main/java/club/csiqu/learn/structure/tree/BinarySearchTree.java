package club.csiqu.learn.structure.tree;

/**
 * 二叉搜索树
 *
 * @param <T> 泛型，必须实现 {@link Comparable}接口
 * @author chensiqu
 * @since 2019/4/4 17:54
 */
class BinarySearchTree<T extends Comparable<T>> {

    /** 树根 */
    private Node<T> root;

    /**
     * 添加数据
     *
     * @param data 数据
     */
    private void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node<T> current = root;
        Node<T> parent;
        while (true) {
            if (current.data.compareTo(data) == 0) {
                System.out.println("节点已存在");
                return;
            }
            // 当前节点大于新节点
            if (current.data.compareTo(data) > 0) {
                parent = current;
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            }
            // 当前节点小于新节点
            if (current.data.compareTo(data) < 0) {
                parent = current;
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    private boolean delete(T data) {
        if (root == null) {
            return false;
        }
        // 记录当前节点的父亲节点
        Node<T> parent = null;
        Node<T> current = root;
        // 遍历找到目标元素的位置
        while (current != null) {
            if (data.compareTo(root.data) < 0) {
                parent = current;
                current = current.leftChild;
            } else if (data.compareTo(root.data) > 0) {
                parent = current;
                current = current.rightChild;
            } else {
                break;
            }
        }
        if (current == null) {
            System.out.println("Target dosen't exist!");
            return false;
        }
        // 待删除节点为叶子节点
        if (current.isLeaf()) {
            // 当前节点为树根
            if (parent == null) {
                root = null;
                return true;
            }
            if (parent.leftChild == current) {
                parent.leftChild = null;
                return true;
            } else {
                parent.rightChild = null;
                return true;
            }
        }
        // 待删除节点只有一个右孩子
        else if (current.leftChild == null && current.rightChild != null) {
            // 当前节点为树根
            if (parent == null) {
                root = current.rightChild;
                return true;
            }
            if (parent.leftChild == current) {
                parent.leftChild = current.rightChild;
                return true;
            } else {
                parent.rightChild = current.rightChild;
                return true;
            }
        }
        // 待删除节点只有左孩子
        else if (current.leftChild != null && current.rightChild == null) {
            // 当前节点为树根
            if (parent == null) {
                root = current.leftChild;
                return true;
            }
            if (parent.leftChild == current) {
                parent.leftChild = current.leftChild;
                return true;
            } else {
                parent.rightChild = current.leftChild;
                return true;
            }
        }
        // 待删除节点既有左孩子也有右孩子
        else {


        }
        return false;
    }

    /**
     * 打印整棵二叉搜索树
     */
    private void print() {
        print(root);
    }

    /**
     * 中序遍历
     *
     * @param node 节点
     */
    private void print(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null) {
            print(node.getLeftChild());
        }
        System.out.print("->" + node.getData());
        if (node.getRightChild() != null) {
            print(node.getRightChild());
        }
    }

    /**
     * 二叉搜索树节点
     *
     * @param <T>
     */
    private static class Node<T extends Comparable<T>> {

        /** 节点数据 */
        private T data;

        /** 左孩子 */
        private Node<T> leftChild;

        /** 右孩子 */
        private Node<T> rightChild;

        /** 父亲 */
        private Node<T> parent;

        Node(T data) {
            this.data = data;
        }

        /**
         * 是否为叶子节点
         *
         * @return {@code true} if this is leaf node.
         */
        Boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node<T> getLeftChild() {
            return leftChild;
        }

        void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        Node<T> getRightChild() {
            return rightChild;
        }

        void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
        bsTree.add(8);
        bsTree.add(12);
        bsTree.add(80);
        bsTree.add(11);
        bsTree.print();
    }
}