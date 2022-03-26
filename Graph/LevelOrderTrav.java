package Graph;

import java.util.ArrayDeque;

public class LevelOrderTrav {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println(getHeight(root));
    }
    public static void levelOrder(Node root)
    {
        // int h = getHeight(root);
        ArrayDeque<Node> Q = new ArrayDeque<>();
        Q.add(root);
        // System.out.println(root.val);
        Node curr;
        while (!Q.isEmpty()) {
            curr = Q.poll();
            if (curr.left!=null) Q.add(curr.left);
            if (curr.right!=null) Q.add(curr.right);
            System.out.println(curr.val);
        }

    }
    private static int getHeight(Node root) {
        if (root==null) return 0;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }
}

class BinaryTree {
    Node root;

    void add(int n) {
        Node curr = root;
        while (curr!=null){
            if (curr.val>=n ) {
                if (curr.left==null) {
                    curr.left = new Node(n);
                    break;
                }
                else curr=curr.left;
            }
            else {
                if (curr.right == null) {
                    curr.right = new Node(n);
                    break;
                }
                else curr=curr.right;
            }
        }
    }


}

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
        left=null;
        right=null;
    }
    
}