import java.util.ArrayList;
import java.util.Iterator;
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

    /* 
    public Iterator<T> iterator() {
        return new ComboIterator();
    }
    private class ComboIterator implements Iterator<T> {

        Node<ArrayList<T>> currentNode;
        int currentIndex;

        public ComboIterator() {
            this.currentNode = ComboList.this.front;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null && this.currentIndex < this.currentNode.getData().size();
        }
    
    
        @Override
        public T next() {
            T value = this.currentNode.getData().get(this.currentIndex);
            this.currentIndex++;

            if (this.currentIndex == this.currentNode.getData().size()) { 
                this.currentNode = this.currentNode.getNext();
                this.currentIndex = 0;
            }
            return value;
        }
    }

    */

    public int size() {
        
        return numStored;

    }

    public T get(int index) throws IndexOutOfBoundsException {

    if (index > numStored - 1 || index < 0) {
        System.out.println("You input a number greater than your size or zero, try again with a smaller number :-) ");
        throw(new java.util.NoSuchElementException());
    }

     Node<ArrayList<T>> stepper = this.front;

        while (index >= stepper.getData().size()) {

            index -= stepper.getData().size();
            stepper = stepper.getNext();
            
        }
        return stepper.getData().get(index);
    }

    public boolean add(int index, T value) throws IndexOutOfBoundsException{

        if (index > numStored - 1 || index < 0) {
            System.out.println("You input a number greater than your size or zero, try again with a smaller number :-) ");
            throw(new java.util.NoSuchElementException());
        }

        Node<ArrayList<T>> stepper = this.front;

        while (index >= stepper.getData().size()) {
            index -= stepper.getData().size();
            stepper = stepper.getNext();
        }

        stepper.getData().add(index, value);

            if (stepper.getNext() != null) { //if the stepper next node is not null
                if (stepper.getData().size() > this.nodeCapacity) { // if the size of the stored arraylist is greater than the capacity (put this ontop level)
                    if (stepper.getNext().getData().size() < this.nodeCapacity ) { //checking to see if the net node has room for another node
                        T placeholderValue; //creating a palceholder intger 
                        placeholderValue = stepper.getData().get(stepper.getData().size()-1);  //the palceholder value is given the value of the size of the last list
                        stepper.getNext().getData().add(0, placeholderValue); //should I be using Reed's defined add method here or the ArrayList add
                    }
                }
                else {
                    new Node<ArrayList<T>>(new ArrayList<T>(), stepper.getNext()); //creating a new node at the next available space
                    Integer placeholderValue = 0; //creating a palceholder intger 
                    placeholderValue = stepper.getNext().getData().size() - 1; //the palceholder value is given the value of the size of the last list
                    stepper.getData().add(0, (T) placeholderValue); //should I be using Reed's defined add method here or the ArrayList add
                }
            }
            return true; //what should i be returning instead?
    }

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