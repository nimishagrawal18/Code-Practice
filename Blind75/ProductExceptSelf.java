package Blind75;

// https://leetcode.com/problems/product-of-array-except-self/submissions/
public class ProductExceptSelf {
    
    public static void main(String[] args) {
        ProductExceptSelf ob = new ProductExceptSelf();
        int[] ar = new int[]{1,2,3,4};
        ar = ob.productExceptSelf(ar);
        for (int i : ar) {
            System.out.println(i);
        }
        
    }
    
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0]=nums[0];
        post[post.length-1]=nums[nums.length-1];
        for (int i = 1; i < post.length; i++) {
            pre[i]=pre[i-1]*nums[i];
        }

        for (int i = post.length-2; i >= 0 ; i--) {
            post[i]=post[i+1]*nums[i];
        }

        out[0] = post[0];
        out[out.length-1]= pre[pre.length-2];
        for (int i = 1; i < post.length-1; i++) {
            out[i] = pre[i-1]*post[i+1];
        }

        return out;
    }
}
