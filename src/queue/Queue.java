/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author mcdonasc
 */
public class Queue {
    protected QueueNode head;
    protected QueueNode tail;
    protected int capacity;
    protected int size;
    
    public Queue() {
        head = null;
        tail = null;
        capacity = 10;
        size = 0;
    }
    
    public void enque(QueueNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }
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
    
    public int getCapacity() {
        return capacity;
    }
    
    public int getSize() {
        return size;
    }
    
}
