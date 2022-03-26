public class MSQ1 {
    public static String solution(String S) {
        int[] DC = new int[10];
        for (int i = 0; i < S.length(); i++) {
            DC[(S.charAt(i))-'0']++;
        }
        StringBuffer sb= new StringBuffer();
        
        for (int i = 9; i >= 0;) {
            if(DC[i]>=2) {
                sb.insert(sb.length()/2, (i*11));
                DC[i]-=2;
            }else{
                i--;
            }    
        }
        for (int i = 9; i >= 0;i--) {
            if(DC[i]>0){
                sb.insert(sb.length()/2, i);
                break;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("12345"));
    }
}
