public class MaxProdSubArr {
    public static void main(String[] args) {
        MaxProdSubArr ob = new MaxProdSubArr();
        int[] ar = new int[] {-2,0,-1 };
        System.out.println(ob.maxProduct(ar));
        // for (int i : ar) {
        // System.out.println(i);
        // }
    }

    public int maxProduct(int[] nums) {
        if (nums.length==1) return nums[0];
        int max = 1, min = 1, ans=0;
        //int prod[] = new int[nums.length];
        //prod[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {

            if (nums[i]==0) {
                min=1;
                max=1;
                continue;
            }
            int t=max*nums[i];
            max = Math.max(nums[i], Math.max(t, nums[i]*min));
            min = Math.min(nums[i], Math.min(t, nums[i]*min));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
