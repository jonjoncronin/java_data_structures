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
      Object answer;
      int result;
      
      /* test the constructor */
      result = testLL.getLength();
      assertTrue(result == 0);
      result = testLL.getMaxSize();
      assertTrue(result == 10);
      answer = testLL.getFirst();
      assertTrue(answer == null);
   }

   /**
    * Test method for {@link linkedList.LinkedList#LinkedList(int)}.
    */
   @Test
   public void testLinkedListInt()
   {
      LinkedList negLL = new LinkedList(-100);
      LinkedList goodLL = new LinkedList(100);
      
      int result;
      Object answer;
      
      /* check the constructor with a negative maxLength */
      result = negLL.getMaxSize();
      assertTrue(result == 10);
      result = negLL.getLength();
      assertTrue(result == 0);
      answer = negLL.getFirst();
      assertTrue(answer == null);
      
      /* check the constructor with a positive maxLength */
      result = goodLL.getMaxSize();
      assertTrue(result == 100);
      result = goodLL.getLength();
      assertTrue(result == 0);
      answer = goodLL.getFirst();
      assertTrue(answer == null);
   }

   /**
    * Test method for {@link linkedList.LinkedList#isEmpty()}.
    */
   @Test
   public void testIsEmpty()
   {
      LinkedList testLL = new LinkedList();
      Integer someObject1 = new Integer(1);
      boolean result;
      
      /* test an empty list */
      result = testLL.isEmpty();
      assertTrue(result == true);
      /* add an entry - test again */
      testLL.addEntryToHead(someObject1);
      result = testLL.isEmpty();
      assertTrue(result == false);
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
      int result;
      
      /* check getting the maxLength */
      result = maxLL.getMaxSize();
      assertTrue(result == Integer.MAX_VALUE);
      result = minLL.getMaxSize();
      assertTrue(result == 10);
      result = zeroLL.getMaxSize();
      assertTrue(result == 10);
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
      LinkedList someLL = new LinkedList(3);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      int retVal;
      
      retVal = someLL.addEntryToHead(someObject1);
      assertTrue(retVal == 1);
      retVal = someLL.getLength();
      assertTrue(retVal == 1);
      
      retVal = someLL.addEntryToHead(someObject2);
      assertTrue(retVal == 2);
      retVal = someLL.getLength();
      assertTrue(retVal == 2);
   }

   /**
    * Test method for {@link linkedList.LinkedList#getFirst()}.
    */
   @Test
   public void testGetFirst()
   {
      LinkedList testLL = new LinkedList();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Object answer;
      
      /* test an empty list */
      answer = testLL.getFirst();
      assertTrue(answer == null);
      /* add 2 entries - test again */
      testLL.addEntryToHead(someObject1);
      testLL.addEntryToHead(someObject2);
      answer = testLL.getFirst();
      assertTrue(answer == someObject2);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#getLast()}.
    */
   @Test
   public void testGetLast()
   {
      LinkedList testLL = new LinkedList();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Object answer;
      
      /* test an empty list */
      answer = testLL.getLast();
      assertTrue(answer == null);
      /* add 2 entries - test again */
      testLL.addEntryToHead(someObject1);
      testLL.addEntryToHead(someObject2);
      answer = testLL.getLast();
      assertTrue(answer == someObject1);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#addEntryToHead(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToHead()
   {
      int result;
      Integer answer;
      LinkedList testLL = new LinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      
      result = testLL.addEntryToHead(someObject1);
      answer = (Integer)(testLL.getFirst());
      assertTrue(answer == someObject1);
      assertTrue(result == 1);
       
      result = testLL.addEntryToHead(someObject2);
      answer = (Integer)(testLL.getFirst());
      assertTrue(answer == someObject2);
      assertTrue(result == 2);
      
      result = testLL.addEntryToHead(someObject3);
      assertTrue(result == 0);
   }

   /**
    * Test method for {@link linkedList.LinkedList#addEntryToTail(linkedList.ListNode)}.
    */
   @Test
   public void testAddEntryToTail()
   {
      int result;
      Integer answer;
      LinkedList testLL = new LinkedList(2);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      
      result = testLL.addEntryToTail(someObject1);
      answer = (Integer)(testLL.getLast());
      assertTrue(answer == someObject1);
      assertTrue(result == 1);
       
      result = testLL.addEntryToTail(someObject2);
      answer = (Integer)(testLL.getLast());
      assertTrue(answer == someObject2);
      assertTrue(result == 2);
      
      result = testLL.addEntryToTail(someObject3);
      assertTrue(result == 0);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#removeEntry(Object)}.
    */
   @Test
   public void testRemoveEntry()
   {
      int result;
      Integer answer;
      LinkedList testLL = new LinkedList(5);
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      Integer someObject4 = new Integer(4);
      
      /* start with an emptry list */
      answer = (Integer)testLL.removeEntry(someObject1);
      assertTrue(answer == null);
      
      /* fill in the table */
      result = testLL.addEntryToHead(someObject1);
      result = testLL.addEntryToHead(someObject2);
      result = testLL.addEntryToHead(someObject3);
      assertTrue(result == 3);
      
      /* try to remove an object that isn't in the list */
      answer = (Integer)testLL.removeEntry(someObject4);
      assertTrue(answer == null);
      
      /* remove the middle object */
      answer = (Integer)testLL.removeEntry(someObject2);
      assertTrue(answer == someObject2);
      
      /* remove the tail object */
      answer = (Integer)testLL.removeEntry(someObject3);
      assertTrue(answer == someObject3);
      
      /* remove the head object */
      answer = (Integer)testLL.removeEntry(someObject1);
      assertTrue(answer == someObject1);
      
      /* check the length */
      result = testLL.getLength();
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
      for(int ii = 0; ii < objectArray.length; ii++)
      {
         /* insert Integer Objects into the linked list in order that they are 
          * in the array. This will result in a reverse order for the list. */
         someList.addEntryToHead(objectArray[ii]);
      }
      result = expectedOutput.compareTo(someList.toString());
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
      assertTrue(result == 0);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#equals(linkedList.LinkedList)}
    * testing that 2 lists equal each other.
    */
   @Test
   public void testEqualsTrue()
   {
      boolean result;
      /* create a list of 10 elements */
      LinkedList someList = new LinkedList();
      LinkedList otherList = new LinkedList();
      Integer[] objectArray1 = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      Integer[] objectArray2 = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      for(int ii = 0; ii < objectArray1.length; ii++)
      {
         /* insert Integer Objects into the linked list in order that they are 
          * in the array. This will result in a reverse order for the list. 
          * We need 2 separate arrays of ListNodes because the LinkedList class
          * expects that ListNodes being inserted into a LinkedList are not 
          * part of another list - that their listNode.next parameter is null.
          */
         someList.addEntryToHead(objectArray1[ii]);
         otherList.addEntryToHead(objectArray2[ii]);
      }
      
      result = someList.equals(otherList);
      assertTrue(result == true);
   }
   
   /**
    * Test method for {@link linkedList.LinkedList#equals(linkedList.LinkedList)}
    * testing that 2 lists do not equal each other.
    */
   @Test
   public void testEqualsFalse()
   {
      boolean result;
      /* create a list of 10 elements */
      LinkedList someList = new LinkedList();
      LinkedList otherList = new LinkedList();
      LinkedList bigList = new LinkedList(20);
      LinkedList emptyList = new LinkedList();
      Integer[] objectArray1 = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      Integer[] objectArray2 = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      Integer[] objectArray3 = {100, 101, 102, 
                               103, 104, 105, 
                               106, 107, 108, 
                               109};
      for(int ii = 0; ii < objectArray1.length; ii++)
      {
         /* insert Integer Objects into the linked list in order that they are 
          * in the array. This will result in a reverse order for the list.
          * for the other list add them into the list from the tail side - 
          * resulting in order that we see it defined above.
          * We need 2 separate arrays of ListNodes because the LinkedList class
          * expects that ListNodes being inserted into a LinkedList are not 
          * part of another list - that their listNode.next parameter is null.
          */
         someList.addEntryToHead(objectArray1[ii]);
         otherList.addEntryToTail(objectArray2[ii]);
         bigList.addEntryToHead(objectArray3[ii]);
      }
      
      result = someList.equals(otherList);
      assertTrue(result == false);
      result = someList.equals(bigList);
      assertTrue(result == false);
      result = someList.equals(emptyList);
      assertTrue(result == false);
   }
}
