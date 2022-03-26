package Leet;


import java.util.Arrays;
import java.util.Comparator;


public class ReordeerLogs {
    
    public String[] reorderLogFiles(String[] logs) {
        
        // TreeMap<String,String> letter = new TreeMap<String,String>();

        Comparator<String> comparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] log1 = o1.split(" ",2);    
                String[] log2 = o2.split(" ",2);
                
                boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(log2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = log1[1].compareTo(log2[1]);
                    if(cmp==0) {
                        return log1[0].compareTo(log2[0]);
                    }
                    return cmp;
                }
                if(isDigit1 && !isDigit2){
                    return -1;
                }     
                if(!isDigit1 && isDigit2) { // if one of them is a digit
                    return 1;
                }
                return 0;
            }
        };

        Arrays.sort(logs,comparator);

        return logs;
    }

}
