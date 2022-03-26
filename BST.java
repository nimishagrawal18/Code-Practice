

class BST {
    Node root;
    public BST() {
        root = new Node();
        
    }
    public void insert(int n) {
        if (root.val==1) {
            ;
        }
    }
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(5);;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    public void setVal(int val){
        this.val=val;
    }


}