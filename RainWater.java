import java.util.Scanner;

// To solve the rainwater collection problem. 
/* 
Example -

1
1xxx1
11xx11
11x111
111111

1 are the walls and x are the blocks full of water. The heights of each column are given as an array

*/
public class RainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements now");
        for (int x=0;x<arr.length;x++) {
            arr[x]=sc.nextInt();
        }
        sc.close();
        int[] lmax=new int[n],rmax=new int[n];
        
        lmax[0]=arr[0];
        for (int i=1;i<n;i++) {
            lmax[i]=Math.max(arr[i],lmax[i-1]);
        }
        rmax[n-1]=arr[n-1];
        for (int i=n-2;i>=0;i--) {
            rmax[i]=Math.max(arr[i],rmax[i+1]);
        }
        int ans=0;
        for (int i=0;i<n;i++){
            ans+=Math.min(lmax[i],rmax[i])-arr[i];
        }
        System.out.println(ans);
    }
}
