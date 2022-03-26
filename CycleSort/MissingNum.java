package CycleSort;

public class MissingNum {
    public static void main(String[] args) {
        int[] arr={6,3,1,2,5}; //4 is missing
        sort(arr);
        for(int x=0;x<arr.length;x++){
            if(arr[x]!=x+1) {
                System.out.println(x+1);
                return;
            }
        } 
    }
    private static void sort(int[] arr) {
        int i=0;
        while (i<arr.length) {
            int place=arr[i]-1;
            if(arr[i]!=(i+1)) {
                int t = arr[place];
                arr[place]=arr[i];
                arr[i]=t;
            }
            else i++;
        }
    }
    
}
