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

    /**
     * Returns the size of the list by using the amount of nodes stored.
     * O(1)
     * @return numStored;
     */
    public int size() {
        
        return numStored;

    }

    /**
     * This is a method that, while the index is not a negative number or zero, and the index is greater than the current size of the arraylist, iterates through the nodes, reducing the amount by the size of the arraylist, until it reaches the correct index
     * O(N)
     * @return stepper.getData().get(index); or, in non-brainhurty terms, the current nodes arraylist index
     */
    public T get(int index) throws IndexOutOfBoundsException {

    if (index > numStored - 1 || index < 0) {
        System.out.println("You input a number greater than your specified size or zero, try again with a smaller number. ");
        throw(new IndexOutOfBoundsException());
    }

    Node<ArrayList<T>> stepper = this.front;

        while (index >= stepper.getData().size()) {

            index -= stepper.getData().size();
            stepper = stepper.getNext();
            
        }
        return stepper.getData().get(index);
    }

    /**
     * pain
     * This is a method that took a year off of my lifespan and also checks user input for a non-negative or zero number. If that is provided, then it deals with three cases: adding a number to an arraylist with capacity, adding a number to the next arraylist if the current one is full, and then adding an new node if all others are full.
     * O(N) bc while loop
     * @param index
     * @param value
     * @return true
     * @throws IndexOutOfBoundsException
     */
    public boolean add(int index, T value) throws IndexOutOfBoundsException{

    if (index > numStored - 1 || index < 0) {
        System.out.println("You input a number greater than your specified size or zero, try again with a smaller number. ");
        throw(new IndexOutOfBoundsException());
    }

        Node<ArrayList<T>> stepper = this.front;

        while (index >= stepper.getData().size()) {
            index -= stepper.getData().size();
            stepper = stepper.getNext();
        }

        stepper.getData().add(index, value);

        if (stepper.getData().size() > this.nodeCapacity) { 
            T placeholderValue = stepper.getData().remove(stepper.getData().size()-1);
            if (stepper.getNext() != null && stepper.getNext().getData().size() < this.nodeCapacity) {
                stepper.getNext().getData().add(0, placeholderValue);
            } else { 
                Node<ArrayList<T>> newNode = new Node<>(new ArrayList<>(), stepper.getNext());
                newNode.getData().add(0, placeholderValue);
                stepper.setNext(newNode); 
            }
        }
        return true;
    }

    /**
     * This is a method that, while the stepper is not pointing to a null, iterates through the list and then adds all to a list.
     * O(N) bc while loop :P
     * @return outputList
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

    /**
     * This is a method that converts the list to a string
     * O(N)
     * @return a string version of the list
     */
    public String toString() {
        return this.toList().toString();
    }
}