package Blind75;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
        for (int i : countBits(15)) {
            System.out.println(i);
        }
    }
    public static int hammingWeight(int n) {
        int c=0;
        while (n!=0) {
            c+=n&1;
            n>>>=1;
        }
        return c;
    }

    public static int[] countBits(int n) { // To count bits in all numbers 0 to n
        int out[] = new int[n+1];

        int offset = 1;

        for (int i = 1; i < out.length; i++) {
            int tOff= (offset<<1);
            if((tOff&i)!=0) {
                offset=tOff;
            }
            out[i]=1+out[i-offset];
        }

        return out;
    }

}
