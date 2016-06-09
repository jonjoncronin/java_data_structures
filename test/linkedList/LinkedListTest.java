/**
 * 
 */
package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author joncronin
 *
 */
public class LinkedListTest
{

   /**
    * Test method for {@link linkedList.LinkedList#LinkedList()}.
    */
   @Test
   public void testLinkedList()
   {
      LinkedList testLL = new LinkedList();
      assertTrue(testLL.length == 0);
      assertTrue(testLL.maxSize == 10);
      assertTrue(testLL.head == null);
      assertTrue(testLL.tail == null);
   }

   /**
    * Test method for {@link linkedList.LinkedList#LinkedList(int)}.
    */
   @Test
   public void testLinkedListInt()
   {
      LinkedList negativeLL = new LinkedList(-100);
      LinkedList goodLL = new LinkedList(100);
      assertTrue(negativeLL.maxSize == 10);
      assertTrue(negativeLL.head == null);
      assertTrue(negativeLL.tail == null);
      assertTrue(negativeLL.length == 0);
      assertTrue(goodLL.maxSize == 100);
      assertTrue(goodLL.head == null);
      assertTrue(goodLL.tail == null);
      assertTrue(goodLL.length == 0);
   }

   /**
    * Test method for {@link linkedList.LinkedList#getMaxSize()}.
    */
   @Test
   public void testGetMaxSize()
   {
      LinkedList maxLL = new LinkedList(Integer.MAX_VALUE);
      LinkedList minLL = new LinkedList(Integer.MIN_VALUE);
      LinkedList zeroLL = new LinkedList(0);
      LinkedList lessThanTenLL = new LinkedList(5);
      LinkedList overTenLL = new LinkedList(5000);
      
      assertTrue(maxLL.maxSize == Integer.MAX_VALUE);
      assertTrue(minLL.maxSize == 10);
      assertTrue(zeroLL.maxSize == 10);
      assertTrue(lessThanTenLL.maxSize == 5);
      assertTrue(overTenLL.maxSize == 5000);
   }

   /**
    * Test method for {@link linkedList.LinkedList#getLength()}.
    */
   @Test
   public void testGetLength()
   {
      LinkedList testHeadLL = new LinkedList(3);
      LinkedList testTailLL = new LinkedList(4);
      ListNode testNode = null;
      int retVal;
      
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == -1);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == -1);
      
      testNode = new ListNode(5);
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == 1);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == 1);
      assertTrue(testHeadLL.length == 1);
      assertTrue(testTailLL.length == 1);
      
      testNode = new ListNode(3);
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == 2);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == 2);
      assertTrue(testHeadLL.length == 2);
      assertTrue(testTailLL.length == 2);
      
      testNode = new ListNode(7);
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == 3);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == 3);
      assertTrue(testHeadLL.length == 3);
      assertTrue(testTailLL.length == 3);
      
      testNode = new ListNode(8);
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == 0);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == 4);
      assertTrue(testHeadLL.length == 3);
      assertTrue(testTailLL.length== 4);
      
      testNode = new ListNode(10);
      retVal = testHeadLL.addEntryToHead(testNode);
      assertTrue(retVal == 0);
      retVal = testTailLL.addEntryToTail(testNode);
      assertTrue(retVal == 0);
      assertTrue(testHeadLL.length == 3);
      assertTrue(testTailLL.length == 4);
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToHead(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToHead()
   {
      //fail("Not yet implemented");
      //tested along with testGetLength(). Leaving test case here but passing
      // in case it turns into something later.
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToTail(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToTail()
   {
      //fail("Not yet implemented");
      //tested along with testGetLength(). Leaving test case here but passing
      // in case it turns into something later.
   }

}
