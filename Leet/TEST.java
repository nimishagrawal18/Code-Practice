package Leet;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
        /*Map<String, Integer> hm;
        hm = Map.of("M",1000,"CM",900,"D",500,"CD",400,"C",100,"XC",90,"L",50,"XL",40,"X",10,"IX",9);
        hm.put("V",5);
        hm.put("I",1);
        hm.put("IV",4);
        System.out.println(romanToInt("MLXVII"));*/
        //System.out.println(longestCommonPrefix(new String[]{"floral","flight","floor"}));
        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        ;
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> hm;
        hm = Map.of('M',1000,'D',500,'C',100,'L',50,'X',10,'V',5,'I',1);
        int total=0;
        int last=hm.get(s.charAt(s.length()-1)),val=0;
        total+=last;
        for (int i=s.length()-2;i>=0;i--) {
            val=hm.get(s.charAt(i));
            if (val<last) total-=val;
            else total+=val;
            last=val;
        }
        return total;
    }
    public static String longestCommonPrefix(String[] strs) {
        int i=0;
        boolean f=false;
        StringBuffer lcp=new StringBuffer("");
        while (true) {
            if (strs[0].length()<=i) return lcp.toString();
            char c=strs[0].charAt(i);
            for (String s : strs) {
                if (s.length()<=i || s.charAt(i)!=c) {
                    f=true;
                    break;
                }

            }
            i++;
            if(!f) {
                lcp.append(c);
            }else return lcp.toString();
        }
    }
    public List<String> letterCombinations(String digits) {

        for (int i=0;i<digits.length();i++) {
            int d=(digits.charAt(i)-'0');
            for (char c: getLetters(d)
                 ) {
                    System.out.println(c);
            }
        }
        return null;
    }
    // private static List<String> makeCombos(String digits, int x) {
    //     List<String> li = new ArrayList<String>();
    //     for (int i=x;i<digits.length();i++) {
    //         int d=(digits.charAt(i)-'0');
    //         for (char c: getLetters(d)
    //         ) {
    //             StringBuffer st=new StringBuffer(String.valueOf(c));
    //             st.append(makeCombos(digits,i+1));
    //             li.add(st.toString());
    //         }
    //     }
    //     return li;
    // }
    private static Character[] getLetters(int x) {
        HashMap<Integer,Character[]> map = new HashMap<Integer,Character[]>();
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
        return map.get(x);

    }
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        for (char c:s.toCharArray()
             ) {
            if (c=='(' || c=='{' || c=='[') st.push(c);
            else if (c==')') {
                if (st.isEmpty() || st.pop()!='(') return false;
            }
            else if (c=='}') {
                if (st.isEmpty() || st.pop()!='{') return false;
            }
            else if (c==']') {
                if (st.isEmpty() || st.pop() != '[') return false;
            }
        }
        if (st.isEmpty()) return true;
        return false;
    }

    /*public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out=new ArrayList<List<Integer>>();
        if (nums.length<3) return out;
        //HashMap <Integer,Integer> m1 = new HashMap<Integer,Integer>();
        HashMap <Integer,NumPair> m2 = new HashMap<Integer,NumPair>();
        //for (int i = 0; i < nums.length; i++) {
        //    m1.put(nums[i],i);
        //}
        for (int j = 0; j < nums.length-1; j++) {
            for (int i = j+1; i < nums.length; i++) {
                m2.put(nums[i]+nums[j],new NumPair(i,j));
            }
        }
        int x=0,a=-1,b=-1;

        for (int i = 0; i < nums.length; i++) {
            x=nums[i];

            if (m2.containsKey(-x)) {
                a = m2.get(-x).a;
                b = m2.get(-x).b;
                if (a != b && a != i && b != i) {
                    List<Integer> al = new ArrayList<Integer>();
                    al.add(x);
                    al.add(nums[m2.get(-x).a]);
                    al.add(nums[m2.get(-x).b]);
                    //if (out.)out.add(al);
                }
            }
        }
        return out;
    }*/
    class NumPair {
        int a;
        int b;
        NumPair (int a,int b) {
            this.a=a;
            this.b=b;
        }
        NumPair() {
            a=0;
            b=0;
        }

        public int getA() {    return a;        }
        public int getB() {    return b;        }
        public void setA(int a) {   this.a = a;        }
        public void setB(int b) {   this.b = b;        }
    }




}
