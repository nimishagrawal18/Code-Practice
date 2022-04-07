
public class MS2Q1 {
    // Matching paranthesis
    public int solution(String S) {
        int out = 0, balance = 0;
        char c;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (c=='(') {
                balance++;
            }else if (c==')') {
                balance--;
            }
            else continue;
            
            if(balance<0) {
                out++;
                balance++;
            }
        }
        out += balance;
        return out;
    }
}
