package AmzPractice;

//https://www.geeksforgeeks.org/replace-0-5-input-integer/
public class Repl0w5 {
    public static void main(String[] args) {
        System.out.println(replace(1020));
    }
    static int replace (int n) {
        int mod,ans=0,mul=1,t=n;
        while (t!=0) {
            mod=t%10;
            if(mod==0) ans+=5*mul;
            else ans+=mod*mul;
            mul*=10;
            t/=10;
        }
        return ans;
    }
}
