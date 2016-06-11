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
    protected E element;
    protected QueueNode nextNode;
    
    public QueueNode(E element) {
        this.element = element;
        nextNode = null;
    }
}
