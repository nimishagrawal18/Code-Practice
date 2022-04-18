package AmzPractice;

public class CountNSay {
    public String countAndSay(int n) {
        if (n==1) return "1";
        String in = "1";
        for (int i=2;i<=n;i++) {
            in = countAndSay(in);
        }
        return in;
    }
    public String countAndSay(String in) {
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i<in.length()) {
            char c = in.charAt(i);
            // Now to count the repititons of this digit
            int ctr=1;
            while ((i+ctr<in.length()) && in.charAt(i+ctr)==c){
                ctr++;
            }
            out.append(ctr);
            out.append(c);
            i+=ctr;
        }
        return out.toString();
    }
}
