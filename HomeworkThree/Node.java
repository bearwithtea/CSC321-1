/**
 * Class that defines a Node in a singly-linked list.
 *   @author Dave Reed
 *   @version 2/9/24
 */
public class Node<E> {
    private E data;
    private Node<E> next;
        
    /**
     * Constructs a node.
     * @param data the value to be stored in the node
     * @param next reference to the next node in the list
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
        
    /**
     * Getter method for the data.
     *   @return the data value stored in the node
     */
    public E getData() {
        return this.data;
    }
        
    /**
     * Getter method for next.
     *   @return reference to the next node in the list
     */
    public Node<E> getNext() {
        return this.next;
    }
        
    /**
     * Setter method for the data.
     *   @param newData the value to be stored in the node
     */
    public void setData(E newData) {
        this.data = newData;
    }
        
    /**
     * Setter method for next.
     *   @param newNext the new reference to the next node
     */
    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }
}
