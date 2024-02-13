import java.util.ArrayList;

/**
 * Starter class for implementing a ComboList.
 *   @author Dave Reed (modified by YOUR_NAME)
 *   @author 2/9/24
 */
public class ComboList<T> {
    private Node<ArrayList<T>> front;
    private Node<ArrayList<T>> back;
    private int nodeCapacity;
    
    /**
     * Constructs an empty list.
     *   @param capacity maximum number of values that can be stored in a node
     */
    public ComboList(int capacity) {
        this.nodeCapacity = capacity;
        this.front = new Node<ArrayList<T>>(new ArrayList<T>(), null);
        this.back = this.front;
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

    public int size(T item) {

        int size = 0;

        for (Node i = this.front; i.getNext() != null; i = i.getNext()) {
            
        }

    }
}