/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

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
      Object answer;
      int result;
      
      /* test the constructor */
      result = testStack.getLength();
      assertTrue(result == 0);
      result = testStack.getMaxSize();
      assertTrue(result == 10);
      answer = testStack.top();
      assertTrue(answer == null);
   }
   
   /**
    * Test method for {@link stack.StackLinkedList#StackLinkedList(Int)}.
    */
   @Test
   public void testStackLinkedListInt()
   {
      StackLinkedList negStack = new StackLinkedList(-100);
      StackLinkedList goodStack = new StackLinkedList(100);
      int result;
      Object answer;
      
      /* check the constructor with a negative maxLength */
      result = negStack.getMaxSize();
      assertTrue(result == 10);
      result = negStack.getLength();
      assertTrue(result == 0);
      answer = negStack.top();
      assertTrue(answer == null);
      
      /* check the constructor with a positive maxLength */
      result = goodStack.getMaxSize();
      assertTrue(result == 100);
      result = goodStack.getLength();
      assertTrue(result == 0);
      answer = goodStack.top();
      assertTrue(answer == null);
   }
   
   /**
    * Test method for {@link stack.StackLinkedList#isEmpty()}.
    */
   @Test
   public void testIsEmpty()
   {
      StackLinkedList testStack = new StackLinkedList();
      Integer someObject1 = new Integer(1);
      boolean answer;
      int result;
      
      result = testStack.getLength();
      assertTrue(result == 0);
      answer = testStack.isEmpty();
      assertTrue(answer == true);
      
      testStack.push(someObject1);
      result = testStack.getLength();
      assertTrue(result == 1);
      answer = testStack.isEmpty();
      assertTrue(answer == false);
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
      
      /* check getting the maxLength */
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
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      int retVal;
      
      retVal = someStack.push(someObject1);
      assertTrue(retVal == 1);
      retVal = someStack.getLength();
      assertTrue(retVal == 1);
      
      retVal = someStack.push(someObject2);
      assertTrue(retVal == 2);
      retVal = someStack.getLength();
      assertTrue(retVal == 2);
   }
   
   /**
    * Test method for {@link stack.StackLinkedList#top(Obecjt)}.
    */
   @Test
   public void testTop()
   {
      StackLinkedList testStack = new StackLinkedList();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer answer;
      
      /* check that top is empty */
      answer = (Integer)(testStack.top());
      assertTrue(answer == null);
      
      /* push the first object and check top */
      testStack.push(someObject1);
      answer = (Integer)(testStack.top());
      assertTrue(answer == someObject1);
      
      /* push another object and check top again */
      testStack.push(someObject2);
      answer = (Integer)(testStack.top());
      assertTrue(answer == someObject2);
   }
   
   /**
    * Test method for {@link stack.StackLinkedList#push(linkedList.ListNode)}.
    */
   @Test
   public void testPush()
   {
      int result;
      Integer answer;
      StackLinkedList testStack = new StackLinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);

      result = testStack.getLength();
      assertTrue(result == 0);
      answer = (Integer)(testStack.top());
      assertTrue(answer == null);
      
      result = testStack.push(someObject1);
      answer = (Integer)(testStack.top());
      assertTrue(answer == someObject1);
      assertTrue(result == 1);
       
      result = testStack.push(someObject2);
      answer = (Integer)(testStack.top());
      assertTrue(answer == someObject2);
      assertTrue(result == 2);
      
      result = testStack.push(someObject3);
      assertTrue(result == 0);
   }
   /**
    * Test method for {@link stack.StackLinkedList#pop()}.
    */
   @Test
   public void testPop()
   {
      int result;
      Integer answer;
      
      StackLinkedList testStack = new StackLinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);

      /* Add the first object */
      result = testStack.push(someObject1);
      assertTrue(result == 1);

      /* Add the second object */
      result = testStack.push(someObject2);
      assertTrue(result == 2);
      
      answer = (Integer)(testStack.pop());
      assertTrue(answer == someObject2);
      result = testStack.getLength(); 
      assertTrue(result == 1);
      
      answer = (Integer)(testStack.pop());
      assertTrue(answer == someObject1);
      result = testStack.getLength();
      assertTrue(result == 0);
      
      answer = (Integer)(testStack.pop());
      assertTrue(answer == null);
      
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
      
      for (int ii = 0; ii < objectArray.length; ii++)
      {
         /* insert Integer Objects into the stack in order that they are 
           * in the array. This will result in a reverse order for the list. */
         someStack.push(objectArray[ii]);
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
