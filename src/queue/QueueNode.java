/**
 * The queue package contains our Queue, QueueTest, QueueNode and QueueTest 
 * classes.
 * 
 * @author Scott McDonald and Jon Cronin
 */
package queue;

/**
 * The QueueNode class is used to represent each element in a Queue.
 * 
 * @author Scott McDonald and Jon Cronin
 */
public class QueueNode<E> {
    private E element;
    private QueueNode nextNode;
    
    /**
     * Constructs new QueueNode with element passed in, and sets nextNode to 
     * null.
     * @param E element generic element this node will hold
     */
    public QueueNode(E element) {
        this.element = element;
        nextNode = null;
    }
    
    /**
     * Returns the generic element this node is holding
     * @return E element
     */
    public E getElement() {
        return element;
    }
    
    /**
     * Returns the next node this node is pointing to
     * @return QueueNode nextNode
     */
    public QueueNode getNextNode() {
        return nextNode;
    }
    
    /**
     * Sets the next node this node will point to
     * @param next nextNode
     */
    public void setNextNode(QueueNode next) {
        this.nextNode = next;
    }
}
