import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructStr {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("purp");
        list.add("p");
        list.add("ur");
        list.add("le");
        list.add("purpl");
        String str = "purplepurple";
        HashMap<String,Integer> memo = new HashMap<String,Integer>();
        ConstructStr ob = new ConstructStr();
        System.out.println(ob.howConstruct(str,list,memo));
    }
    public int howConstruct(String str, List<String> list, HashMap<String,Integer> memo) {
        if (memo.containsKey(str)) return memo.get(str);
        if (str.equals("")) return 1;
        // if (str==null) return 0;
        int total=0;
        for (String subS:
             list) {
            if (str.startsWith(subS)) {
                total+=howConstruct(str.substring(subS.length()),list,memo);
            }
        }
        memo.put(str,total);
        return total;
    }
    // For finding All combinations - we need to return a 2D string array
    // Then when in base case, add a new subArray then go up the stack while collecting whatever strings were used in the list
    // If 2 combinations are returning, simply add them as separate arrays in the main array
    // Also, while returning, need to add own substring to all the sub arrays
    // -  Reading this later is not gonna make any sense I guess :)
}