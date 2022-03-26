package Leet;

public class Reverse {
    public static void main(String[] args) {
        String s ="11111 nias";
        System.out.println(Long.parseLong("-91283472332"));
        int out=0,i=0,l=s.length();
        boolean isNeg=false;
        //s=s.trim();
        char c=s.charAt(0);
        while (i<l && (c<48||c>57)) {
            c=s.charAt(i);
            System.out.println(c);
            if (c=='-') isNeg=true;
            else if (c==' '||c=='+');
            else if (Character.isDigit(c)) break;
            else return;
            i++;
        }
        while (c>=48&&c<=57) {

            if (out*10 > Integer.MAX_VALUE) System.out.println(isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE);
            out *= 10;
            if (out+c-48 > Integer.MAX_VALUE) System.out.println(isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE);
            out += (c - 48);
            i++;
            if (i<l) c=s.charAt(i);
            else break;
        }
        //return isNeg?-out:out;
        System.out.println(isNeg?-out:out);
    }

    public int parse (String s) {
        int out=0,i=0,l=s.length();
        boolean isNeg=false;
        char c=s.charAt(i);
        while (i<l && (c<48||c>57)) {
            c=s.charAt(i);
            if (c=='-') isNeg=true;
            else if (c==' '||c=='+');
            else if (Character.isDigit(c)) break;
            else return 0;
            i++;
        }
        while (c>=48 && c<=57) {
            if (isNeg && (-(out)<Integer.MIN_VALUE/10)) return Integer.MIN_VALUE;
            else if (out > Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
            out *= 10;
            if (isNeg && (-(out)<Integer.MIN_VALUE+(c-48))) return Integer.MIN_VALUE;
            else if (out > Integer.MAX_VALUE-(c+48)) return Integer.MAX_VALUE;
            out += (c - 48);
            i++;
            if (i<l) c=s.charAt(i);
            else break;
        }
        return isNeg?-out:out;
    }
}
