import java.util.ArrayList;
import java.util.List;

public class BoundQueue<Bound> {
    private List<Bound> data;
    private int size;

    public BoundQueue() {

        data = new ArrayList<Bound>();
    }

    public Bound remove() {
        size--;
        return data.remove(0);
    }

    public void add(Bound bound) {
        data.add(bound);
        size++;
    }

    //write the method peak witch returns first but doesnt remove it
    public Bound peek() {
        return data.get(0);
    }

    public Bound peekLast(){
        return data.get(size-1);
    }

    public Bound get(int index){
        return data.get(index);
    }

    public int size() {  //following arraylist size naming
        return size;
    }


    // override so that stack objects can be printed
    public String toString() {
        return data.toString();
    }
}
