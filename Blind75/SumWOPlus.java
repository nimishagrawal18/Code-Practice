package Blind75;

public class SumWOPlus {
    public static void main(String[] args) {
        System.out.println(getSum(5, -8));
    }
    
    public static int getSum(int a, int b) {
        short carry=(short)a;
        int sum=b;
        short t;
        while(carry!=0) {
            t= (short) (carry^sum);
            carry=(short)((sum&carry)<<1);
            sum=t;
        }
        return sum;
    }
}
