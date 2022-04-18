package AmzPractice;

// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class AddLLs{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            // Solution g = new Solution();
            Node res = Solution.addTwoLists(first, second);
            printList(res);
        }
        sc.close();
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node last1 = first;
        Node last2 = second;
        Node prev = null;
        while (last1.next!=null)
        {
            Node t = last1.next;
            last1.next = prev;
            prev = last1;
            last1 = t;
        }
        prev = null;
        while (last2.next!=null)
        {
            Node t = last2.next;
            last2.next = prev;
            prev = last2;
            last1 = t;
        }
        // Linked lists are now reversed
        
        Node ptr1 = last1;
        Node ptr2 = last2;
        Node ans = null,aPtr = null;
        boolean isHead = true;
        int s;
        while (true) {
            
            if (ptr1==null && ptr2==null) break;
            
            s = ptr1==null?0:ptr1.data;
            s += ptr2==null?0:ptr2.data;
            if (s>9) {
                s-=10;
                if (ptr1.next!=null) ptr1.next.data++;
                else if (ptr2.next!=null) ptr2.next.data++;
                else ptr1.next = new Node(s);
            }
            
            if (isHead) {
                ans = new Node(s);
                isHead = false;
                aPtr = ans.next;
            }
            else {
                aPtr = new Node(s);
                aPtr = aPtr.next;
            }
            
            if(ptr1!=null) ptr1 = ptr1.next;
            if(ptr2!=null) ptr2 = ptr2.next;
        }
        
        last1 = ans;
        prev = null;
        while (last1.next!=null)
        {
            Node t = last1.next;
            last1.next = prev;
            prev = last1;
            last1 = t;
        }
        
        return last1;
        
    }
}