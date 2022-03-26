package Leet;

import java.util.ArrayList;
import java.util.List;

public class TEST3 {
    public static void main(String[] args) {
        TEST3 ob = new TEST3();
        /*List <String> outL = ob.generateParenthesis(6);
        for (String x:outL) {
            System.out.println(x);*/

        /*int ar[]={1,1,1,2,2,2,4,5,5,6,7,8,8};
        int k=ob.removeDuplicates(ar);
        for (int i = 0; i < k; i++) {
            System.out.println(ar[i]);
        }*/

        /*int ar[]={3,2,2,3};
        int k=ob.removeElement(ar,3);
        for (int i = 0; i < k; i++) {
            System.out.println(ar[i]);
        }*/

        //System.out.println(ob.strStr("nimish","ti"));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(ob.divide(Integer.MAX_VALUE,1));

    }
    
    public List<String> generateParenthesis(int n) {
        List <String> outL=new ArrayList<>();
        generate("",n,0,0,outL);
        return outL;
    }
    private void generate(String str,int n, int ob, int cb, List <String> L) {
        if (str.length()==(n*2)) {
            L.add(str);
            return;
        }
        if(ob<n) generate(str+"(",n,ob+1,cb,L);
        if (cb<ob) generate(str+")",n,ob,cb+1,L);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode out = null , outptr =null;
        int min=Integer.MIN_VALUE,minI=-1;
        boolean allNull=false;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null) {
                allNull = false;
                if (lists[i].val < min) {
                    min = lists[i].val;
                    minI = i;
                }
            }
        }
        out= new ListNode(lists[minI].val);
        lists[minI]=lists[minI].next;
        outptr = out;
        while (!allNull) {
            allNull=true;
            min=Integer.MIN_VALUE;
            minI=-1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i]!=null) {
                    allNull = false;
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minI = i;
                    }
                }
            }
            if (allNull) return out;
            outptr.next=new ListNode(lists[minI].val);
            outptr=outptr.next;
            lists[minI]=lists[minI].next;
        }
        return out;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length<=1) return nums.length;
        int c=0,last=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=last) c++;
            nums[c]=nums[i];
            last=nums[i];
        }
        return c+1;
    }
    public int removeElement(int[] nums, int val) {
        int shift=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==val) shift++;
            else nums[i-shift]=nums[i];
        }
        return nums.length-shift;
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        //if (needle.equals(haystack)) return 0;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.charAt(i)==needle.charAt(0)){
                boolean isValid=true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j)!=needle.charAt(j)) {
                        isValid=false;
                        break;
                    }
                }
                if(isValid) return i;
            }
        }
        return -1;
    }

    public int divide(int dividend, int divisor) {
        if(dividend<divisor) return 0;
        if(dividend==divisor) return 1;
        boolean isNeg=false,over=false;
        if(divisor<0) {
            isNeg=true;
            divisor= -divisor;
        }
        int q=0;
        while (dividend>divisor) {
            dividend-=divisor;
            if (!(-q>Integer.MIN_VALUE )) {
                over = true;
                break;
            }
            else q++;
        }
        if(!over) {
            if (isNeg) return -q;
            return q;
        }
        if (isNeg) return Integer.MIN_VALUE;
        return Integer.MAX_VALUE;
    }
}
