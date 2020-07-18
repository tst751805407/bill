package HUAWEI_work;


import java.util.*;

public class 深度优先和广度优先 {

    public  static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode() {

        }
        public TreeNode(int d) {
            data=d;
        }

        public TreeNode(TreeNode left,TreeNode right,int d) {
            left=left;
            right=right;
            data=d;
        }
    }
    // 前序遍历的非递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            lists.add(temp.data);
            // 这里注意，要先压入右子节点，再压入左节点
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return lists;
    }
    // 二叉树非递归的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, temp = null;
        List<Integer> lists = new ArrayList<>();

        // 判断条件：所有栈为空，且节点指向为空，即所有节点已经完成遍历
        while (!stack.isEmpty() || node != null) {
            // 向左搜索，寻找最左的节点，即中序遍历的第一个节点
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            // 对每一个节点进行判断
            if (!stack.empty()) {
                // 获取当前节点
                temp = stack.pop();
                // 遍历该节点
                lists.add(temp.data);
                // 如果该节点为内部节点，则按中序遍历的顺序，遍历其右子节点
                node = temp.right;
            }
        }
        return lists;
    }
    //后序非递归
    public List<Integer> postorderTraversal_(TreeNode root) {
        LinkedList<Integer> lists = new LinkedList<>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            lists.addFirst(temp.data);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return lists;
    }
    // 前序遍历
    public static void preorder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.data + " ");
        preorder(treeNode.left);
        preorder(treeNode.right);
    }


    // 中序遍历
    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) return;
        inorder(treeNode.left);
        System.out.print(treeNode.data + " ");
        inorder(treeNode.right);
    }
    // 后序遍历
    public static void postorder(TreeNode treeNode) {
        if (treeNode == null) return;
        postorder(treeNode.left);
        postorder(treeNode.right);
        System.out.print(treeNode.data + " ");
    }


    //广度优先
    public void BroadFirstSearch(TreeNode nodeHead){
        if (nodeHead==null)
            return;
        Queue<TreeNode>myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while (!myQueue.isEmpty()){
            TreeNode treeNode=myQueue.poll();
            System.out.print(treeNode.data+" ");
            if (treeNode.left!=null){
                myQueue.add(treeNode.left);
            }
            if (treeNode.right!=null){
                myQueue.add(treeNode.right);
            }
        }
    }



    //深度优先，先进后出，先右边
    public void depthFirstSearch(TreeNode nodeHead){
        if (nodeHead==null)
            return;
        Stack<TreeNode>myStack=new Stack<>();
        myStack.add(nodeHead);
        while (!myStack.isEmpty()){
            TreeNode node=myStack.pop();
            System.out.print(node.data+" ");
            if (node.right!=null){
                myStack.push(node.right);
            }
            if (null!=node.left){
                myStack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);

        head.right=three;
        head.left=second;
        second.right=five;
        second.left=four;
        three.right=seven;
        three.left=six;
        System.out.print("广度优先遍历结果：");
        new 深度优先和广度优先().BroadFirstSearch(head);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new 深度优先和广度优先().depthFirstSearch(head);
        System.out.println();
        System.out.print("前序遍历结果：");
        preorder(head);
        System.out.println();
        System.out.print("前序遍历结果：");
        inorder(head);
        System.out.println();
        System.out.print("前序遍历结果：");
        postorder(head);


    }

}
