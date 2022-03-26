package LeetDS;

// import java.util.Arrays;
import java.util.HashSet;

public class checkDuplicate {

    public static void main(String[] args) {
        checkDuplicate ob = new checkDuplicate();
        int[] x = {1,2,3,4,4};
        System.out.println(ob.containsDuplicate(x));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        /*for (Integer integer : nums) {
            hs.add(integer);
        }*/
        
        System.out.println(nums);
        return hs.size()==nums.length;
    }
}