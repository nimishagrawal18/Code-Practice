public class JobSequencing {
     public static void main(String[] args) {
         Item ob = new Item(5, 12);
         System.out.println(ob.getValue());
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