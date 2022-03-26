package Leet;

import java.util.ArrayList;
// import java.util.List;

public class TEST2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode ptr = new ListNode(2);
        l1.next=ptr;
        ptr.next=new ListNode(4);
        /*ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);*/

        ListNode l2 = new ListNode(1);
        ptr = new ListNode(3);
        l2.next=ptr;
        ptr.next=new ListNode(4);
        ptr=ptr.next;
        ptr.next=new ListNode(9);

        ListNode ans= mergeTwoLists(l1,l2);
        while (ans!=null) {
            System.out.println(ans.val);
            ans=ans.next;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList <ListNode> llist = new ArrayList<ListNode>(30);
        ListNode curr = head;
        while (curr!=null) {
            llist.add(curr);
            curr=curr.next;
        }
        int delInd = llist.size()-n;
        llist.get(delInd-1).next=llist.get(delInd+1);
        return head;
    }


   static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1p=list1;
        ListNode l2p=list2;
        ListNode out,outp;
        if (l1p.val< l2p.val) {
            out= new ListNode(l1p.val);
            l1p=l1p.next;
        } else {
            out= new ListNode(l2p.val);
            l2p=l2p.next;
        }
        outp=out;
        while (l1p!=null || l2p!=null) {
            if (l1p==null) {
                outp.next= new ListNode(l2p.val);
                l2p=l2p.next;
                outp=outp.next;
            } else if (l2p==null) {
                outp.next= new ListNode(l1p.val);
                l1p=l1p.next;
                outp=outp.next;
            }
            else if (l1p.val< l2p.val) {
                outp.next= new ListNode(l1p.val);
                l1p=l1p.next;
                outp=outp.next;
            } else {
                outp.next= new ListNode(l2p.val);
                l2p=l2p.next;
                outp=outp.next;
            }
        }
        return out;
    }
}
