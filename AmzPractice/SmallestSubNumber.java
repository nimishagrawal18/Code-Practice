package AmzPractice;

// https://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
public class SmallestSubNumber {
    public static void main(String[] args) {
        String s= "4325043";
        System.out.println(removeDigits(s, 3));
        
    }
    static String removeDigits(String s,int k) {
        StringBuffer remStr=new StringBuffer(s);
        while (k!=0) {
            int endIndex=remStr.length()-k+1;
            int smallest= findLargestDig(remStr.subSequence(0, endIndex));
            remStr.deleteCharAt(smallest);
            k--;
        }

        return remStr.toString();
    }
    static int findLargestDig(CharSequence s) {
        int max=-1,maxI=-1;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c>=max){
                max=c;
                maxI=i;
            }
        }
        return maxI;
    }
}
