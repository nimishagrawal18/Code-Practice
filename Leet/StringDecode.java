package Leet;

// https://leetcode.com/problems/decode-string/

public class StringDecode {
    public static void main(String[] args) {
        StringDecode ob = new StringDecode();
        System.out.println(ob.decodeString("a2[ab3[c]]3[cd]ef"));
    }
    
    public String decodeString(String s) {
        return decodeString(s,0,s.length()-1,1);
    }
    public String decodeString(String s,int start, int end, int count) {
        // Need to rework this logic with a fresh mind :) - cannot iron out the issues at the moment.
        
        
        
        
        
        
        int i =start;
        String out = "", op="";
        while (i<=s.length()) {
            char ch = s.charAt(i);
            if(ch>='0'&&ch<='9') {
                s = decodeString(s,i+2,s.indexOf(']')-1,ch-'0');
                op+= s.substring(i,s.indexOf(']')-1);
                //i=s.;

            }
            else if (ch==']') {
                for (int j = 0; j < count; j++) {
                    out+=op;
                }
                op="";
                return s.substring(0,start-2)+out+s.substring(i+1);
            }
            else {
                op+=ch;
                i++;
            }

        }
        return out;
    }
}
