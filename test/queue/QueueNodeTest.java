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

/**
 * Test class to verify the QueueNode methods.
 * @author Scott McDonald and Jon Cronin
 */
public class QueueNodeTest extends TestCase {
    
    // Default JUnit constructor created by NetBeans. Leaving for now.
    public QueueNodeTest(String testName) {
        super(testName);
    }

    /**
     * Validates the QueueNode default constructor.
     */
    public void testQueueNode() {
        QueueNode<Integer> myNode = new QueueNode<>(42);
        assertTrue(myNode.getElement() == 42);
        assertTrue(myNode.getNextNode() == null);
    }
    
    /**
     * Validates QueueNode getters and setters.
     */
    public void testQueueNodeSetNextNode() {
        QueueNode<Integer> node1 = new QueueNode<>(4);
        QueueNode<Integer> node2 = new QueueNode<>(7);
        node1.setNextNode(node2);
        assertTrue(node1.getNextNode() == node2);
    }
}
