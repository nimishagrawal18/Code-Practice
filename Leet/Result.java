package Leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Result {

    /*
     * Complete the 'getTotalImbalance' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY weight as parameter.
     */

    public static long getTotalImbalance(List<Integer> weight) {
    // Write your code here
        int n = weight.size();
        Stack<Integer> st = new Stack<Integer>();
        
        long ans = 0;
        
        for (int i = 0; i <= n; i++) {
            while(!st.empty() && (i==n || weight.get(st.peek()) < weight.get(i))) {
                int top = st.pop();
                int l = top - (st.isEmpty()?-1:st.peek());
                int r = i-top;
                ans += (long)weight.get(top)*l*r;
                
            }   
            st.push(i);
        }
        st.clear();
        
        for (int i = 0; i <= n; i++) {
            while(!st.empty() && (i==n || weight.get(st.peek()) > weight.get(i))) {
                int top = st.pop();
                int l = top - (st.isEmpty()?-1:st.peek());
                int r = i-top;
                ans -= (long)weight.get(top)*l*r;
                
            }   
            st.push(i);
        }
        
        return ans;
        
    }


    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        //l.add(3);
        l.add(3);
        l.add(2);
        l.add(3);
        System.out.println(getTotalImbalance(l));
    }
}
