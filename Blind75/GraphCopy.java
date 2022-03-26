package Blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class GraphCopy {

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

    public static Node cloneGraph(Node node) {
        if (node==null) return null;
        Node clone=new Node(node.val);
        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap <Node,Node> map =new HashMap <Node,Node>();
        Queue<Node> nodeQueue = new ArrayDeque<Node>();
        visited.add(node.val);
        map.put(node, clone);
        nodeQueue.add(node);
        while(!nodeQueue.isEmpty()) {
            Node n = nodeQueue.poll();
            Node c = map.get(n);
            for (Node x : n.neighbors) {
                if (!visited.contains(x.val)) {
                    visited.add(x.val);
                    Node t = new Node(x.val);
                    map.put(x,t);
                    c.neighbors.add(t);
                    nodeQueue.add(x);
                }
                else if (!c.neighbors.contains(map.get(x))) {
                    c.neighbors.add(map.get(x));
                }
            }
        }
        return clone;
    }
}

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