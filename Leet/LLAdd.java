package Leet;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LLAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2;
        int t=p1.val+p2.val,s=0;
        boolean carry=t>9;
        ListNode ans;
        if(carry) ans=new ListNode(t-10);
        else ans=new ListNode(t);
        ListNode p3=ans;
        p1=p1.next;
        p2=p2.next;
        //p3=p3.next;

        while(p1!=null || p2!=null) {
            if(p1==null) {
                s=p2.val+(carry?1:0);
                carry = (s==10)||(s/10==1);
                p3.next=new ListNode(s%10);
                carry = (s==10)||(s/10==1);;
                p2=p2.next;
                p3=p3.next;
            }
            else if(p2==null) {
                s=p1.val+(carry?1:0);
                carry = (s==10)||(s/10==1);
                p3.next=new ListNode(s%10);
                carry = (s==10)||(s/10==1);
                p1=p1.next;
                p3=p3.next;
            }
            else {
                s=p1.val+p2.val+(carry?1:0);
                carry = (s==10)||(s/10==1);
                p3.next=new ListNode(s%10);
                p1=p1.next;
                p2=p2.next;
                p3=p3.next;
            }
        }
        if (carry) p3.next=new ListNode(1);
        return ans;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode ptr = new ListNode(9);
        l1.next=ptr;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);

        ListNode l2 = new ListNode(9);
        ptr = new ListNode(9);
        l2.next=ptr;
        ptr.next=new ListNode(9);
        ptr=ptr.next;
        ptr.next=new ListNode(9);

        ListNode ans= addTwoNumbers(l1,l2);
        while (ans!=null) {
            System.out.println(ans.val);
            ans=ans.next;
        }

    }
}
