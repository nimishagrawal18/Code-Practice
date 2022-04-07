package Leet;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class GoodNodes {
    public static int goodNodes(TreeNode root) {
        int c = 0;
        c = goodNodes(root, root.val);
        return c;
    }
    public static int goodNodes(TreeNode root, int prevMax) {
        
        if (root==null) return 0;
        int ctr = 0;
        if (root.val>=prevMax) {
            ctr++;
            prevMax = root.val;
        }
        ctr += goodNodes(root.left, prevMax);
        ctr += goodNodes(root.right, prevMax);
        return ctr;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = null;
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}