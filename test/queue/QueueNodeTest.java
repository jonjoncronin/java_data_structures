/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author mcdonasc
 */
public class QueueNodeTest extends TestCase {
    
    public QueueNodeTest(String testName) {
        super(testName);
    }

    public void testQueueNode() {
        QueueNode<Integer> myNode = new QueueNode<>(42);
        assertTrue(myNode.getElement() == 42);
        assertTrue(myNode.getNextNode() == null);
    }
    
    public void testQueueNodeSetNextNode() {
        QueueNode<Integer> node1 = new QueueNode<>(4);
        QueueNode<Integer> node2 = new QueueNode<>(7);
        node1.setNextNode(node2);
        assertTrue(node1.getNextNode() == node2);
    }
}
