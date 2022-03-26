package Heaps;

// import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {
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
        MinHeap mh=new MinHeap(arr);
        mh.BuildHeap (arr);
    }
    
    int[] arr;
    int size;

    //Constructor
    public MinHeap (int[] in) {
        arr=in;
        size=0;
    } 

    //Core functions
    public int top () {
        return arr[0];
    }
    public int left (int i) {
        return (i*2) + 1;
    }
    public int right (int i) {
        return (i*2) + 2;
    }
    public int parent (int i) {
        return (i-1)/2;
    }
    private void swapIndexes (int x,int y) {
        int t=arr[x];
        arr[x]=arr[y];
        arr[y]=t;
    }
    public void heapify(int i){
        if(size<=1) return;
        while(i>=0) {
            int l=left(i);
            int r=right(i);
            int smallest=i;
            if(l<size && arr[l]<arr[i]) smallest=l;
            if(r<size && arr[r]<arr[smallest]) smallest=r;
            if(smallest!=i) swapIndexes(smallest, i);
            i=smallest;
        }
    }

    // Main actions
    public int extract() {
        if(size==0) return Integer.MAX_VALUE;
        if(size==1) {
            size=0;
            return arr[0];
        }
        swapIndexes(0,size-1);
        size--;
        return arr[size];
    }
    public void insert(int x) {
        if(arr.length==size) return;
        arr[size]=x;
        size++;
        int i=size-1;
        while(i>=0 && arr[parent(i)]>arr[i]) {
            swapIndexes(i,parent(i));
            i=parent(i);
        }
    }
    public void BuildHeap(int[] in)
    {
        heapify(parent(size-1));
    }
    public int deleteIndex(int i)
    {
        swapIndexes(i, size-1);
        heapify(i);
        size--;
        return arr[size];
    }

}