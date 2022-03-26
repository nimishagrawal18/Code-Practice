import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FracKnapsack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(10,60));
        //items.add(new Item(40,40));
        items.add(new Item(20,100));
        //items.add(new Item(30,120));
        FracKnapsack ob = new FracKnapsack();
        System.out.println(ob.FractionalKS(items, 50));
    }
    public int FractionalKS(List<Item> items, int capacity) {
        Collections.sort(items);
        int sum=0,remain=capacity,i=0;
        while (remain>0) {
            if (items.size()==i) break;
            Item x = items.get(i);
            if (x.getWeight()<remain) {
                remain-=x.getWeight();
                sum+=x.getValue();
            }
            else {
                sum+=remain*x.getwByV();
                remain=0;
            }
            i++;
        }
        return sum;
    }
    
}
class Item implements Comparable<Item>{
    private int weight;
    private int value;
    private double wByV;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.wByV = value/(double)weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getwByV() {
        return (int)wByV;
    }
    @Override
    public int compareTo(Item i) {
        
        return (int)(i.getwByV()-this.wByV);
    }
    
}