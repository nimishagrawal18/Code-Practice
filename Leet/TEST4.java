package Leet;

// import java.util.Stack;

public class TEST4 {
    public static void main(String[] args) {
        /*
         * TEST4 ob = new TEST4();
         * System.out.println(ob.longestValidParentheses(")((())(())))()"));
         */
        int k = 5;
        if ((k = 2) == 3) {
            k += 5;
        } else {
            k += 7;
        }
        System.out.print(k);
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = i - dp[i] - 1;
            if (j >= 0 && s.charAt(j) == '(' && s.charAt(i) == ')') {
                dp[i + 1] = dp[i] + dp[j] + 2;
                res = Math.max(dp[i + 1], res);
            }
        }

        return res;
    }

    /*
     * Mine ==
     * public int longestValidParentheses(String s) {
     * Stack<Integer> st = new Stack<>();
     * st.push(-1);
     * int maxL=0,l=0;
     * for (int i = 0; i < s.length(); i++) {
     * char c=s.charAt(i);
     * if(c=='(') {
     * st.push(i);
     * }
     * else {
     * if(st.size()>1) {
     * st.pop();
     * l=i-st.peek();
     * maxL=l>maxL?l:maxL;
     * }
     * else st.push(i);
     * }
     * }
     * return maxL;
     * }
     */

}
