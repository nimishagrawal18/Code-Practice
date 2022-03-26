package Leet;

import java.util.*;

public class GraphCopy {

    public static Node cloneGraph(Node node) {
        if (node==null) return null;
        Node clone=new Node(node.val);
        boolean visited[]=new boolean[101];
        HashMap <Node,Node> map =new HashMap <Node,Node>();
        Queue<Node> nodeQueue = new ArrayDeque<Node>();
        visited[node.val]=true;
        map.put(node,clone);
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            Node node1=nodeQueue.poll();
            Node iter1= map.get(node1);
            for (Node x:node1.neighbors
                 ) {
                if (!visited[x.val]) {
                    visited[x.val]=true;
                    Node created = new Node(x.val);
                    nodeQueue.add(x);
                    iter1.neighbors.add(created);
                    created.neighbors.add(iter1);
                    map.put(x,created);
                }
                else {
                    if(!iter1.neighbors.contains(map.get(x)));
                    {
                        iter1.neighbors.add(map.get(x));
                        map.get(x).neighbors.add(iter1);
                    }
                }
            }
        }
        return clone;
    }

    public static void main(String[] args) {
        // ArrayList<Node> nl=new ArrayList<Node>();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        cloneGraph(n1);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
