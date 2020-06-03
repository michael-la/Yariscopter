import java.util.ArrayList;

public class BoundQueue<T> {
    private ArrayList<T> data;
    private int size;

    public BoundQueue() {
        data = new ArrayList<T>();
    }

    public T remove() {
        size--;
        return data.remove(size);
    }

    public void add(T t) {
        data.add(t);
        size++;
    }

    //write the method peak witch returns last but doesnt remove it
    public T peek() {
        return data.get(size);
    }

    public int size() {  //following arraylist size naming
        return size;
    }


    // override so that stack objects can be printed
    public String toString() {
        return data.toString();
    }
}
