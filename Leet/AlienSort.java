package Leet;

import java.util.Comparator;

//https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/
public class AlienSort {
    public static boolean isAlienSorted(String[] words, String order) {
        Comparator<String> cmp = new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
                int minL = Math.min(o1.length(), o2.length());
                int i = 0;
                for (; i < minL ; i++) {
                    char ch = o1.charAt(i);
                    char ch2 = o2.charAt(i);
                    int diff =  order.indexOf(ch)-order.indexOf(ch2);
                    if (diff!=0) return diff;
                }
                return o1.length()-o2.length();
                
            }
            
        };
        for (int i = 0; i < words.length-1; i++) {
            if(cmp.compare(words[i],words[i+1])>0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
    }
}