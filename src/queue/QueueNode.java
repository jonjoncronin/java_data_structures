/**
 * The queue package contains our Queue, QueueTest, QueueNode and QueueTest 
 * classes.
 * 
 * @author 
 */
package queue;

/**
 * The QueueNode class is used to represent each element in a Queue.
 * 
 * @author Scott McDonald
 */
public class QueueNode<E> {
    private E element;
    private QueueNode nextNode;
    
    public QueueNode(E element) {
        this.element = element;
        nextNode = null;
    }
    
    public E getElement() {
        return element;
    }
    
    public QueueNode getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(QueueNode next) {
        this.nextNode = next;
    }
}
