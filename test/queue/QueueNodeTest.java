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
        assertTrue(myNode.element == 42);
        assertTrue(myNode.nextNode == null);
    }
}
