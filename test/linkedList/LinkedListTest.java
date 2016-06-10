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
      LinkedList zeroLL = new LinkedList(0);
      LinkedList lessThanTenLL = new LinkedList(5);
      LinkedList overTenLL = new LinkedList(5000);
      int result;
      
      result = maxLL.getMaxSize();
      assertTrue(result == Integer.MAX_VALUE);
      result = zeroLL.getMaxSize();
      assertTrue(zeroLL.maxSize == 10);
      result = lessThanTenLL.getMaxSize();
      assertTrue(result == 5);
      result = overTenLL.getMaxSize();
      assertTrue(result == 5000);
   }

   /**
    * Test method for {@link linkedList.LinkedList#getLength()}.
    */
   @Test
   public void testGetLength()
   {
      LinkedList someList = new LinkedList(3);
      ListNode someNode1 = new ListNode();
      ListNode someNode2 = new ListNode();
      int retVal;
      
      retVal = someList.addEntryToHead(someNode1);
      assertTrue(retVal == 1);
      retVal = someList.getLength();
      assertTrue(retVal == 1);
      
      retVal = someList.addEntryToHead(someNode2);
      assertTrue(retVal == 2);
      retVal = someList.getLength();
      assertTrue(retVal == 2);
      
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToHead(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToHead()
   {
      int result;
      LinkedList testLL = new LinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      ListNode testNode1 = new ListNode(someObject1);
      ListNode testNode2 = new ListNode(someObject2);
      ListNode testNode3 = new ListNode(someObject2);
      assertTrue(testLL.length == 0);
      assertTrue(testLL.getLength() == 0);
      assertTrue(testLL.head == null);
      assertTrue(testLL.tail == null);
      testNode1.setNodeNext(testNode2);
      result = testLL.addEntryToHead(testNode1);
      assertTrue(result == -1);
      testNode1 = new ListNode(someObject1);
      result = testLL.addEntryToHead(testNode1);
      assertTrue(testLL.head == testNode1);
      assertTrue(result == 1);
      result = testLL.addEntryToHead(testNode1);
      assertTrue(result == -1);
      result = testLL.addEntryToHead(testNode2);
      assertTrue(testLL.head == testNode2);
      assertTrue(testLL.head.getNodeNext() == testNode1);
      assertTrue(result == 2);
      result = testLL.addEntryToHead(testNode3);
      assertTrue(result == 0);
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToTail(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToTail()
   {
      int result;
      LinkedList testLL = new LinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      ListNode testNode1 = new ListNode(someObject1);
      ListNode testNode2 = new ListNode(someObject2);
      ListNode testNode3 = new ListNode(someObject2);
      assertTrue(testLL.length == 0);
      assertTrue(testLL.getLength() == 0);
      assertTrue(testLL.head == null);
      assertTrue(testLL.tail == null);
      testNode1.setNodeNext(testNode2);
      result = testLL.addEntryToTail(testNode1);
      assertTrue(result == -1);
      testNode1 = new ListNode(someObject1);
      result = testLL.addEntryToTail(testNode1);
      assertTrue(testLL.head == testNode1);
      assertTrue(testLL.tail == testNode1);
      assertTrue(result == 1);
      result = testLL.addEntryToTail(testNode1);
      assertTrue(result == -1);
      result = testLL.addEntryToTail(testNode2);
      assertTrue(testLL.head == testNode1);
      assertTrue(testLL.tail == testNode2);
      assertTrue(result == 2);
      result = testLL.addEntryToTail(testNode3);
      assertTrue(result == 0);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#toString()}.
    */
   @Test
   public void testToString()
   {
      String expectedOutput = "This list of size 10 contains  \n" +
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
      /* create a list of 10 elements */
      LinkedList someList = new LinkedList();
      Integer[] objectArray = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      ListNode[] nodeArray = new ListNode[10];
      for(int ii = 0; ii < objectArray.length; ii++)
      {
         /* insert Integer Objects into the linked list in order that they are 
          * in the array. This will result in a reverse order for the list. */
         nodeArray[ii] = new ListNode(objectArray[ii]);
         someList.addEntryToHead(nodeArray[ii]);
      }
      result = expectedOutput.compareTo(someList.toString());
      //System.out.println(someList.toString());
      assertTrue(result == 0);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#toString()}
    * on an empty list.
    */
   @Test
   public void testToStringEmptyList()
   {
      String expectedOutput = "This list of size 0 contains  \n" +
                              "nothing\n";
      int result;
      /* create a list of 10 elements */
      LinkedList someList = new LinkedList();
      result = expectedOutput.compareTo(someList.toString());
      //System.out.println(someList.toString());
      assertTrue(result == 0);
   }
}
