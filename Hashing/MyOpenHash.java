package Hashing;

// Class to implement simple Open address hashing (linear probing)
// -1 means empty, -2 means deleted

public class MyOpenHash {
    int[] arr;
    public MyOpenHash(int b) {
        arr= new int[b];
        for (int i=0;i<arr.length;i++) arr[i]=-1;
    }

    private int calcHash(int i) {
        return i%arr.length;
    }

    public void insert(int x) {
        int i = calcHash(x);
        if (arr[i] <= -1) arr[i]=x;
        else {
            int c=0,o;
            while (c<arr.length) {
                o=(i+c)%arr.length;
                if(arr[o]==x) {
                    System.out.println("Key already present!");
                    return;
                }
                if(arr[o]<=-1) {
                    arr[o]=x;
                    return;
                }
                
                c++;
            }
            if (c==arr.length) System.out.println("Array Full!!");
        }
    }

    public boolean search(int x) {
        int i = calcHash(x); 
        if (arr[i] == x) return true;
        else {
            int c=0,o;
            while (c<arr.length) {
                o=(i+c)%arr.length;
                if(arr[o]==-1)
                    break;
                else if (arr[o]==x) return true;
                c++;
            }
            return false;
        }

    }

    public void delete(int x) {
        int i = calcHash(x);
        if (arr[i] == x) arr[i]=-2;
        else {
            int c=0,o;
            while (c<arr.length) {
                o=(i+c)%arr.length;
                if(arr[o]==-1)
                    break; 
                else if (arr[o]==x) {
                    arr[o]=-2;
                    return;
                }
                c++;
            }
            if (c==arr.length) System.out.println("Not Found");
        }
    }

}
