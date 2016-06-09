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
      fail("Not yet implemented");
   }

   /**
    * Test method for {@link linkedList.LinkedList#getLength()}.
    */
   @Test
   public void testGetLength()
   {
      fail("Not yet implemented");
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToHead(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToHead()
   {
      fail("Not yet implemented");
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToTail(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToTail()
   {
      fail("Not yet implemented");
   }

}
