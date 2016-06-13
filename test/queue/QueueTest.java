/**
 * The queue package contains our Queue, QueueTest, QueueNode and QueueTest 
 * classes.
 * 
 * @author Scott McDonald and Jon Cronin
 */
package queue;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Integer;

/**
 * Test class used to validate our simple Queue ADT.
 * @author Scott McDonald and Jon Cronin
 */
public class QueueTest extends TestCase {
    
    // Default JUnit constructor created by Netbeans. Leaving for now.
    public QueueTest(String testName) {
        super(testName);
    }

    /**
     * testQueue validates the default Queue constructor.
     */
    public void testQueue() {
        Queue myQ = new Queue();
        Queue myQSize = new Queue(20);
        QueueNode node = myQ.deque();
        int capacity, size;
        
        capacity = myQ.getCapacity();
        size = myQ.getSize();
        assertTrue(node == null);
        assertTrue(capacity == 10);
        assertTrue(size == 0);
        
        node = myQSize.deque();
        capacity = myQSize.getCapacity();
        size = myQSize.getSize();
        assertTrue(node == null);
        assertTrue(capacity == 20);
        assertTrue(size == 0);
        
        
    }
    
    /**
     * testEnqueDeque validates enque() success and error cases. It also 
     * validates that deque() returns the nodes in the correct FIFO order until 
     * the Queue is empty. Finally it validates that there is no max capcity
     * when caller creates a Queue with negative capacity.
     */
    public void testEnqueDeque() {
        Queue myQ = new Queue();
        int enQRetVal;
        
        // Verify that inserting a null object returns Q_ERR_NULL, leaving
        // the Q unmodified
        enQRetVal = myQ.enque(null);
        assertTrue(enQRetVal == Queue.Q_ERR_NULL);
        
        // We have a default Q, so the capacity is 10, validate we can enqueue
        // 10 nodes and that the 11th node will return Q_ERR_FULL
        QueueNode<Integer> node;
        for (int ii=0; ii<11; ii++) {
            node = new QueueNode<>(ii);
            enQRetVal = myQ.enque(node);
            if (ii<10) {
                assertTrue(enQRetVal == Queue.Q_SUCCESS);
            } else {
                assertTrue(enQRetVal == Queue.Q_ERR_FULL);
            }
        }
        
        // Deque all the entries we made and verify they are returned in FIFO
        // order.
        for (int ii=0; ii<11; ii++) {
            node = myQ.deque();
            int element;
            if (ii<10) {
                element = node.getElement();
                assertTrue(element == ii);
            } else {
                assertTrue(node == null);
            }
        }
        
        // Finally create a Queue with a negative capacity. validate it grows
        // well beyond 10; as a negative size means the user wants the queue
        // to have no limit. The only bound in this case is the size of heap
        myQ = new Queue(-10);
        for (int ii=0; ii<30; ii++) {
            node = new QueueNode<>(ii);
            enQRetVal = myQ.enque(node);
            assertTrue(enQRetVal == Queue.Q_SUCCESS);
        }
        
        // Deque all the entries we made and verify they are returned in FIFO
        // order.
        for (int ii=0; ii<31; ii++) {
            node = myQ.deque();
            int element;
            if (ii<30) {
                element = node.getElement();
                assertTrue(element == ii);
            } else {
                assertTrue(node == null);
            }
        }
        
        // Verify that enque rejects nodes that already have a next element
        node = new QueueNode<>(42);
        node.setNextNode(new QueueNode<>(10));
        enQRetVal = myQ.enque(node);
        assertTrue(enQRetVal == Queue.Q_ERR_NEXT_NODE);
    }
    
    
}
