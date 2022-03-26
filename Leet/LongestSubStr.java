package Leet;

// import java.util.Arrays;
import java.util.HashSet;

public class LongestSubStr {
    public static void main(String[] args) {
        String s="abcabcbb";
        char[] ar = s.toCharArray();
        HashSet<Character> hs=new HashSet<>();
        int start=0,end=1, max=1;
        hs.add(ar[0]);
        while (end<ar.length) {
            if(hs.contains(ar[end])) {
                hs.remove(ar[start]);
                start++;
            }else {
                hs.add(ar[end]);
                end++;
                max=Math.max(end-start,max);
            }

        }
        System.out.println(max);
    }
}
