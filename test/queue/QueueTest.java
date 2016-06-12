/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Integer;

/**
 *
 * @author mcdonasc
 */
public class QueueTest extends TestCase {
    
    public QueueTest(String testName) {
        super(testName);
    }

    public void testQueue() {
        Queue myQ = new Queue();
        //assertTrue(myQ.getHead() == null);
        //assertTrue(myQ.getTail() == null);
        assertTrue(myQ.deque() == null);
        assertTrue(myQ.getCapacity() == 10);
        assertTrue(myQ.getSize() == 0);
    }
    
    public void testEnqueDeque() {
        Queue myQ = new Queue();
        QueueNode<Integer> node1 = new QueueNode<>(42);
        QueueNode<Integer> node2 = new QueueNode<>(-5);
        myQ.enque(node1);
        myQ.enque(node2);
        assertTrue((Integer)myQ.deque().getElement() == 42);
        assertTrue((Integer)myQ.deque().getElement() == -5);
    }
    
    
}
