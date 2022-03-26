public class MSQ2 {
    public int solution(String S) {
        // write your code in Java SE 8
        int l= S.length();
        int[] arX = new int[l];
        int[] arY = new int[l];
        arX[0]= (S.charAt(0)=='x')?1:0;
        arY[0]= (S.charAt(0)=='y')?1:0;
        for (int i = 1; i < arY.length; i++) {
            arX[i]= arX[i-1] + ((S.charAt(i)=='x')?1:0);
            arY[i]= arY[i-1] + ((S.charAt(i)=='y')?1:0);
        }

        for (int i = 1; i < S.length()-1; i++) {
                        
        }
        return 0;
    }
    int countX (String s) {
        int ctr = 0;
        while (s.indexOf('x')>=0) {
            s.substring(s.indexOf('x'));
            ctr++;
        }
        return ctr;
    }
    int countY (String s) {
        int ctr = 0;
        while (s.indexOf('y')>=0) {
            s.substring(s.indexOf('y'));
            ctr++;
        }
        return ctr;
    }
}
