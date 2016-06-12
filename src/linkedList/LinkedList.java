package linkedList;

/**
 * The LinkedList class is a very simple LinkedList implementation that utilizes
 * the ListNode class that is also part of the linkedList package.
 * 
 * @author Jon Cronin and Scott McDonald
 */
public class LinkedList
{
   int length;
   int maxSize;
   ListNode head;
   ListNode tail;

   /**
    * Basic constructor of a LinkedList object
    */
   public LinkedList()
   {
      this.length = 0;
      this.maxSize = 10;
      this.head = null;
      this.tail = null;
   }

   /**
    * Overloaded constructor to allow you to specify the maxSize of the 
    * LinkedList you want to create.
    * 
    * @param maxSize The maxSize of the list you want to create. Only supports 
    * positive numbers. If you maxSize specified then the max list size is 10.
    */
   public LinkedList(int maxSize)
   {
      this.length = 0;
      if (maxSize > 0) {
        this.maxSize = maxSize;
      } else {
          this.maxSize = 10;
      }
      this.head = null;
      this.tail = null;
   }

   /**
    * Accessor function to get the max size of the LinkedList.
    * 
    * @return The Integer maxSize of the list - how many ListNodes could 
    * possibly be stored in the LinkedList.
    */
   public int getMaxSize()
   {
      return this.maxSize;
   }

   /**
    * Accessor function to get the current length of the list.
    * 
    * @return The Integer length of the list - how many ListNodes are currently 
    * in the LinkedList.
    */
   public int getLength()
   {
      return this.length;
   }

   /**
    * Modifier function to add a ListNode to the head of the LinkedList.
    * 
    * @param someNode The ListNode you want to add to the LinkedList
    * @return The Integer length of the list after adding the ListNode. 0 if 
    * the list is full. -1 if the ListNode.next is not empty.
    */
   public int addEntryToHead(ListNode someNode)
   {
      if(someNode.getNodeNext() != null)
      {
         return -1;
      }
      if(this.length < this.maxSize)
      {
         if(someNode.setNodeNext(this.head))
         {
            this.head = someNode;
            this.length++;
            return this.length;   
         }
         else
         {
            return -1;
         }
      }
      else
      {
         return 0;
      }
   }
   
   /**
    * Modifier function to add a ListNode to the tail of the LinkedList.
    * 
    * @param someNode The ListNode you want to add to the LinkedList
    * @return The Integer length of the list after adding the ListNode. 0 if 
    * the list is full. -1 if the ListNode.next is not empty.
    */
   public int addEntryToTail(ListNode someNode)
   {
      if(someNode.getNodeNext() != null)
      {
         return -1;
      }
      if(this.length < this.maxSize)
      {
         if(this.tail == null)
         {
            /* we have an empty list */
            this.head = someNode;
            this.tail = someNode;
            this.head = someNode;
            this.length++;
            return this.length;
         }
         else if(this.tail.setNodeNext(someNode))
         {
            this.tail = someNode;
            this.length++;
            return this.length;
         }
         else
         {
            return -1;
         }
      }
      else
      {
         return 0;
      }
   }
   /**
    * Overriden function to return a string describing this LinkedList.
    * @return String in the format of "This list of size [length] contains\n
    * Data: [Object.toString]" 
    */
   public String toString()
   {
      ListNode curNode = this.head;
      StringBuilder output = new StringBuilder();
      output.append("This list of size " + this.length + " contains  \n");
      if(this.head == null)
      {
         output.append("nothing\n");
         return output.toString();
      }
      while(curNode != null)
      {
         output.append(curNode.toString() + "\n");
         curNode = curNode.next;
      }
      return output.toString();
   }
   
   /*
    * equals checks to make sure that the 2 lists are exactly the same - 
    * same length, same maxSize and same order of elements
    */
   /**
    * Overloaded function to allow you to see if a LinkedList is equal to 
    * another LinkedList. Equality is based on the length and max sizes of the 
    * lists as well as on the order of ListNode elements and the equality of the
    * Objects stored in the ListNodes.
    * @param someList The list you want to compare this one to.
    * @return true if the lists equal each other.
    */
   public boolean equals(LinkedList someList)
   {
      ListNode thisCurNode = this.head;
      ListNode someCurNode = someList.head;
      if(someList.length == this.length &&
         someList.maxSize == this.maxSize)
      {
         while(thisCurNode != null)
         {
            if(!thisCurNode.equals(someCurNode))
            {
               return false;
            }
            thisCurNode = thisCurNode.next;
            someCurNode = someCurNode.next;
         }
      }
      else
      {
         return false;
      }
      return true;
   }
//   public int removeEntry(ListNode someNode)
//   {
//      ListNode prevNode;
//      prevNode = this.findPreviousNode(someNode);
//      if(prevNode != null)
//      {
//         prevNode.setNodeNext(someNode.getNodeNext());
//         someNode.next = null;
//         someNode.data = 0;
//         return 1;
//      }
//      return -1;
//   }
//   
//   private ListNode findPreviousNode(ListNode someNode)
//   {
//      ListNode curNode = this.head;
//      ListNode prevNode = this.head;
//      while(curNode != null)
//      {
//         if(someNode == curNode)
//         {
//            return prevNode;
//         }
//         prevNode = curNode;
//         curNode = curNode.getNodeNext();
//      }
//      return null;
//   }
}
