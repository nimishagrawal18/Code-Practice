package Blind75;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(3));
    }
    public static int reverseBits(int n) {
        int out = 0;
        // for (int i =0;i<32;i++) {
        while(n<Integer.MAX_VALUE) {
            out<<=1;
            out+=n&1;
            n>>=1;
        }
        return out;
    }
}
