import java.util.*;
public class countBitsToN {
    //program to count total no of the bits set in all numbers upto N
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number");
        int n= sc.nextInt(); 
        n++;                        // incremented to ignore 0 occurence
        int pow2=2;
        int c=n/2;
        while (pow2<=n) {
            int p=n/pow2;           //No of pairs at the corresponding bit
            c+=(p/2)*pow2;          //no. of pairs/2 = no of pairs of 1 X no of 1 in each pair
            c+=(p%2==1)?(n%pow2):0; // If pairs are odd, add remaining 1's to the count
            pow2<<=1;               // increase to the nex power of 2
        }
        System.out.print(c);
        sc.close();
    }
}
