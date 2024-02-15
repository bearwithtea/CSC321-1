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

            index -= stepper.getData().size();
            stepper = stepper.getNext();
            
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
            index -= stepper.getData().size();
            stepper = stepper.getNext();
        }

        stepper.getData().add(index, value);

        /*
        * if (stepper.getNext != null)
        * if (stepper.getData.size() > this.capacity)
         * if (stepper.getNext.getSize < this.capacity ())
         * placementvalue = 0;
         * placementvalue = get arraylist.size - 1
         * stepper.getData().add(0, placementvalue)
         * else {
         * (new Node<ArrayList<T>>(new ArrayList<T>(), stepper.getNext));
         * stepper.setNext();
         * add to the next node
         * }
         */

        if (stepper.getNext() != null) { //if the stepper next node is not null
            Integer placeholderValue = 0;
            if (stepper.getData().size() > this.nodeCapacity) { // if the size of the stored arraylist is greater than the capacity

                if (stepper.getNext().getData().size() < this.nodeCapacity ) { //checking to see if the net node has room for another node
                    
                    placeholderValue = stepper.getNext().getData().size() - 1;
                    stepper.getData().add(0, (T) placeholderValue);
                }
            }
            else {

                new Node<ArrayList<T>>(new ArrayList<T>(), stepper.getNext());
                stepper.setNext(placeholderValue);

            }
        }
        return true;
    }

    public List<T> toList() {

        List<T> outputList = new ArrayList<T>();
        Node<ArrayList<T>> stepper = this.front;

        while (stepper != null) {
            outputList.addAll(stepper.getData());
            stepper = stepper.getNext();
        }

        return outputList;

    }  

    public String toString() {
        return this.toList().toString();
    }
}