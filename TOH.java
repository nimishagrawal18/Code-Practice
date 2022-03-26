import java.util.Scanner;
public class TOH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number for Factorial");
        int n=sc.nextInt();
        TOHanoi(n, 'A', 'B', 'C');
        sc.close();

    }
    public static void TOHanoi (int n,char A, char B, char C) {
        if (n==1) {
            System.out.println("Move 1 from "+A+" to "+C);
            return;
        }
        TOHanoi(n-1, A, C, B);
        System.out.println("Move "+n+" from "+A+" to "+C);
        TOHanoi(n-1, B, A, C);
    }
}
