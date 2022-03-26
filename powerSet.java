
import java.util.Scanner;

public class powerSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String in= sc.nextLine();
        int l= in.length();
        int alen= 1<<l;
        String ar[]=new String[alen];
        for (int i=0;i<alen;i++) {
            String tstr="";
            for (int j=0;j<in.length();j++) {
                if ((i&(1<<j))!=0)
                tstr+= in.charAt(j);
            }
            ar[i]=tstr;
        }
        for (String o : ar) {
            System.out.println(o);
        }
        sc.close();
    }
}
 