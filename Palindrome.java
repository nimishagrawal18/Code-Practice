import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check Palindrome");
        int n = sc.nextInt();
        int rev=0,bkp=n;
        while (n!=0) {
            int d= n%10;
            rev=(rev*10)+d;
            n/=10;
        }

        sc.close();
        if(rev==bkp)
        System.out.println("Yes");
        else 
        System.out.println("No");
    }

}
