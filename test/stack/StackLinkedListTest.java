/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import linkedList.*; // reusing the ListNode class
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author joncronin
 */
public class StackLinkedListTest
{
   /**
    * Test method for {@link stack.StackLinkedList#StackLinkedList()}.
    */
   @Test
   public void testStackLinkedList()
   {
      StackLinkedList testStack = new StackLinkedList();
      assertTrue(testStack.length == 0);
      assertTrue(testStack.maxSize == 10);
      assertTrue(testStack.top == null);
   }
   
   /**
    * Test method for {@link stack.StackLinkedList#StackLinkedList(Int)}.
    */
   @Test
   public void testStackLinkedListInt()
   {
      StackLinkedList negStack = new StackLinkedList(-100);
      StackLinkedList goodStack = new StackLinkedList(100);
      assertTrue(negStack.maxSize == 10);
      assertTrue(negStack.top == null);
      assertTrue(negStack.length == 0);
      assertTrue(goodStack.maxSize == 100);
      assertTrue(goodStack.top == null);
      assertTrue(goodStack.length == 0);
   }
   /**
    * Test method for {@link stack.StackLinkedList#getMaxSize()}.
    */
   @Test
   public void testGetMaxSize()
   {
      StackLinkedList maxStack = new StackLinkedList(Integer.MAX_VALUE);
      StackLinkedList minStack = new StackLinkedList(Integer.MIN_VALUE);
      StackLinkedList zeroStack = new StackLinkedList(0);
      StackLinkedList lessThanTenStack = new StackLinkedList(5);
      StackLinkedList overTenStack = new StackLinkedList(5000);
      int result;
      
      result = maxStack.getMaxSize();
      assertTrue(result == Integer.MAX_VALUE);
      result = minStack.getMaxSize();
      assertTrue(result == 10);
      result = zeroStack.getMaxSize();
      assertTrue(result == 10);
      result = lessThanTenStack.getMaxSize();
      assertTrue(result == 5);
      result = overTenStack.getMaxSize();
      assertTrue(result == 5000);
   }
   /**
    * Test method for {@link stack.StackLinkedList#getLength()}.
    */
   @Test
   public void testGetLength()
   {
      StackLinkedList someStack = new StackLinkedList(3);
      ListNode someNode1 = new ListNode();
      ListNode someNode2 = new ListNode();
      int retVal;
      
      retVal = someStack.push(someNode1);
      assertTrue(retVal == 1);
      retVal = someStack.getLength();
      assertTrue(retVal == 1);
      
      retVal = someStack.push(someNode2);
      assertTrue(retVal == 2);
      retVal = someStack.getLength();
      assertTrue(retVal == 2);
   }
   /**
    * Test method for {@link stack.StackLinkedList#push(linkedList.ListNode)}.
    */
   @Test
   public void testPush()
   {
      int result;
      StackLinkedList testStack = new StackLinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      ListNode testNode1 = new ListNode(someObject1);
      ListNode testNode2 = new ListNode(someObject2);
      ListNode testNode3 = new ListNode(someObject2);
      assertTrue(testStack.length == 0);
      assertTrue(testStack.getLength() == 0);
      assertTrue(testStack.top == null);
      testNode1.setNodeNext(testNode2);
      result = testStack.push(testNode1);
      assertTrue(result == -1);
      testNode1 = new ListNode(someObject1);
      result = testStack.push(testNode1);
      assertTrue(testStack.top == testNode1);
      assertTrue(result == 1);
      result = testStack.push(testNode1);
      assertTrue(result == -1);
      result = testStack.push(testNode2);
      assertTrue(testStack.top == testNode2);
      assertTrue(testStack.top.getNodeNext() == testNode1);
      assertTrue(result == 2);
      result = testStack.push(testNode3);
      assertTrue(result == 0);
   }
   /**
    * Test method for {@link stack.StackLinkedList#pop()}.
    */
   @Test
   public void testPop()
   {
      int result;
      ListNode poppedNode;
      
      StackLinkedList testStack = new StackLinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      ListNode testNode1 = new ListNode(someObject1);
      ListNode testNode2 = new ListNode(someObject2);
      testNode1 = new ListNode(someObject1);
      result = testStack.push(testNode1);
      assertTrue(testStack.top == testNode1);
      assertTrue(result == 1);

      result = testStack.push(testNode2);
      assertTrue(testStack.top == testNode2);
      assertTrue(testStack.top.getNodeNext() == testNode1);
      assertTrue(result == 2);
      
      poppedNode = testStack.pop();
      assertTrue(poppedNode == testNode2);
      assertTrue(testStack.length == 1);
      poppedNode = testStack.pop();
      assertTrue(poppedNode == testNode1);
      assertTrue(testStack.length == 0);
      poppedNode = testStack.pop();
      assertTrue(poppedNode == null);
   }
   /**
    * Test method for {@link stack.StackLinkedList#toString()}.
    */
   @Test
   public void testToString()
   {
      String expectedOutput = "This stack of size 10 contains  \n" + 
                              "Data: 109\n" +
                              "Data: 108\n" +
                              "Data: 107\n" +
                              "Data: 106\n" +
                              "Data: 105\n" +
                              "Data: 104\n" +
                              "Data: 103\n" +
                              "Data: 102\n" +
                              "Data: 101\n" +
                              "Data: 100\n";
      int result;
      /* create a stack of 10 elements */
      StackLinkedList someStack = new StackLinkedList();
      Integer[] objectArray =
      {
         100, 101, 102,
         103, 104, 105,
         106, 107, 108,
         109
      };
      ListNode[] nodeArray = new ListNode[10];
      for (int ii = 0; ii < objectArray.length; ii++)
      {
         /* insert Integer Objects into the stack in order that they are 
           * in the array. This will result in a reverse order for the list. */
         nodeArray[ii] = new ListNode(objectArray[ii]);
         someStack.push(nodeArray[ii]);
      }
      result = expectedOutput.compareTo(someStack.toString());
      assertTrue(result == 0);
   }
   /**
    * Test method for {@link stack.StackLinkedList#toString()}
    * for an empty stack.
    */
   @Test
   public void testToStringEmptyStack()
   {
      String expectedOutput = "This stack of size 0 contains  \n"
                              + "nothing\n";
      int result;
      /* create a stack of 0 elements */
      StackLinkedList someStack = new StackLinkedList();
      result = expectedOutput.compareTo(someStack.toString());
      assertTrue(result == 0);
   }
   
}
