/**
 * The queue package contains our Queue, QueueTest, QueueNode and QueueTest 
 * classes.
 * 
 * @author Scott McDonald and Jon Cronin
 */
package queue;

/**
 * Queue implements the basic Queue ADT, with the functions enque() and deque().
 * Users of this queue class can set the maximum capacity or accept the default
 * of 10.
 * @author Scott McDonald and Jon Cronin
 */
public class Queue {
    private QueueNode head;
    private QueueNode tail;
    private int capacity;
    private int size;
    
    // Define the return values the Queue class methods may use
    public static final int Q_SUCCESS = 0;
    public static final int Q_ERR_NULL = -1;
    public static final int Q_ERR_FULL = -2;
    
    /**
     * Default constructor. Sets head and tail to null, max capacity to 10 and
     * current size to 0.
     */
    public Queue() {
        head = null;
        tail = null;
        capacity = 10;
        size = 0;
    }
    
    /**
     * Alternate constructor that allows caller to set the maximum capacity.
     * If capacity is set to a negative value then we will simply let the queue
     * grow until the system is out of heap.
     * @param capacity 
     */
    public Queue(int capacity) {
        this();
        this.capacity = capacity;
    }
    
    /**
     * Returns a new node at the tail of the queue as long as their is space
     * and the node passed to us wasn't null.
     * @param node new node to enque at the tail of the queue
     * @return QueueError enum SUCCESS or one of the enumerated error values. 
     */
    public int enque(QueueNode node) {
        if (node == null) {
            return Q_ERR_NULL;
        }
        
        // if capacity is less then 0 then we don't check the size, we let
        // the queue grow as big as needed, or until limited by the heap.
        if ((capacity > 0) && (size == capacity)) {
            return Q_ERR_FULL;
        }
        
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
        return Q_SUCCESS;
    }
    
    /**
     * Returns the node at the head of the queue. THe node that was entered
     * most recently. 
     * @return QueueNode
     */
    public QueueNode deque() {
        if (head == null) {
            return null;
        } 
        
        QueueNode target = head;
        if (size > 1) {
            head = head.getNextNode();
        } else {
            head = null;
        }
        
        size--;
        return target;
    }
    
    /**
     * Returns the capacity of the queue. Negative values represent unlimited
     * capacity. In other words the queue is only limited by the size of the 
     * heap.
     * @return int capacity 
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * Returns the current size of the queue; aka the number of elements in the
     * queue.
     * @return int size
     */
    public int getSize() {
        return size;
    }
    
}
