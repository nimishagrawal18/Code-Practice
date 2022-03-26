import java.util.Scanner;

public class FactRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number for Factorial");
        int n=sc.nextInt();
        System.out.println(factorial(n));
        sc.close();
    }
    public static long factorial(long a) {
        if(a!=0) {
            return a*factorial(a-1);
        }
        return 1;
    }

}
