package HUAWEI_work;

import java.util.Scanner;

public class C {
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

    // 前序遍历
    public static void preorder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.data + " ");
        preorder(treeNode.left);
        preorder(treeNode.right);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        char[]c=new char[100];

        c=s.nextLine().toCharArray();

        int n=0;

        for (int i = 0; i <c.length ; i++) {
            if (c[i]=='0'){
                n++;
            }
        }
        System.out.println(n-2);

    }
}
