import java.util.ArrayList;
import java.util.List;

/**
 * Starter class for implementing a ComboList.
 *   @author Dave Reed (modified by Owen McGrath)
 *   @author 2/9/24
 */
public class ComboList<T> {
    private Node<ArrayList<T>> front;
    private Node<ArrayList<T>> back;
    private int nodeCapacity;
    private int numStored;
    List<T> outputList = new ArrayList<T>();
    
    /**
     * Constructs an empty list.
     *   @param capacity maximum number of values that can be stored in a node
     */
    public ComboList(int capacity) {
        this.nodeCapacity = capacity;
        this.front = new Node<ArrayList<T>>(new ArrayList<T>(), null);
        this.back = this.front;
        this.numStored = 0;
    }
    
    /**
     * Adds an element to the end of the list.
     *   @param item the item to be added
     */
    public void add(T item) {
        if (this.back.getData().size() == this.nodeCapacity) {
            this.back.setNext(new Node<ArrayList<T>>(new ArrayList<T>(), null));
            this.back = this.back.getNext();
        }
        this.back.getData().add(item);
        this.numStored++;
    }

    /**
     * Displays the contents of the ComboList, node by node, for debugging purposes.
     */
    public void sneakPeek() {
        Node<ArrayList<T>> stepper = this.front;
        int nodeNum = 0;
        while (stepper != null) {
            System.out.println(nodeNum++ + ": " + stepper.getData());
            stepper = stepper.getNext();
        }	
    }

    public int size() {
        
        return numStored;

    }


    public T get(int index) throws IndexOutOfBoundsException {

     Node<ArrayList<T>> stepper = this.front;

        if (index > numStored - 1) {
            System.out.println("You input a number greater than your size, try again with a smaller number :-) ");
            throw(new java.util.NoSuchElementException());
        }

        while (index >= stepper.getData().size()) {

            if (index < stepper.getData().size()) {
                stepper.getData().get(index);
            } else {
                index -= stepper.getData().size();
                stepper = stepper.getNext();
            }
            
        }
        return stepper.getData().get(index);
    }

    public boolean add(int index, T value) throws IndexOutOfBoundsException{

        Node<ArrayList<T>> stepper = this.front;

        if (index > numStored - 1) {
            System.out.println("You input a number greater than your size, try again with a smaller number :-) ");
            throw(new java.util.NoSuchElementException());
        }

        while (index >= stepper.getData().size()) {

            if (index < stepper.getData().size()) {
                this.get(index);
                this.add(value);
            } else {
                index -= stepper.getData().size();
                stepper = stepper.getNext();
            }

        }

        return true;
    }

    public List<T> toList() {

        for (int i = 0; i < numStored; i++) {
            outputList.add(this.get(i));
        }

        return outputList;

    }  

    public String toString() {
        return outputList.toString();
    }
}