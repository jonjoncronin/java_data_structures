package linkedList;

/**
 * The LinkedList class is a very simple LinkedList implementation that utilizes
 * the ListNode class that is also part of the linkedList package.
 *
 * @author Jon Cronin and Scott McDonald
 */
public class LinkedList<E>
{

   /**
    * The ListNode class is a basic node object to be used with Linked Lists or
    * other data structures that may utilize a similar linked list type
    * architecture. The ListNode itself is a public class with public members
    * and public functions due to its simplicity.
    *
    * @author Jon Cronin and Scott McDonald
    */
   private static class ListNode<E>
   {

      private E data = null;
      private ListNode<E> next = null;

      /**
       * Overloaded constructor to allow you to specify the data as well as the
       * next ListNode that a ListNode will contain.
       *
       * @param data The element/object you want stored as the data of the
       * ListNode
       * @param next The next ListNode that you want stored as the next of the
       * ListNode
       */
      public ListNode(E data, ListNode<E> next)
      {
         this.data = data;
         this.next = next;
      }

      /**
       * Accessor function to allow you to retrieve the data of a ListNode.
       *
       * @return The Object stored as the data of the ListNode.
       */
      public E getNodeData()
      {
         return this.data;
      }

      /**
       * Accessor function to retrieve the ListNode stored as the next of the
       * ListNode.
       *
       * @return The next ListNode that this ListNode is pointing to.
       */
      public ListNode<E> getNodeNext()
      {
         return this.next;
      }

      /**
       * Overloaded function to allow you to see if a ListNode is equal to
       * another ListNode. Equality is based on the Object stored as data.
       *
       * @param someNode The other ListNode you want to compare this one with.
       * @return true or false if the data Objects are equal.
       */
      public boolean equals(ListNode<E> someNode)
      {
         return someNode.data.equals(this.data);
      }

      /**
       * Overriden function to return a string describing this ListNode.
       *
       * @return String in the format of "Data: [Object.toString]"
       */
      @Override
      public String toString()
      {
         return ("Data: " + this.data.toString());
      }
   }
   
   private int length = 0;
   private int maxSize = 10;
   private ListNode<E> head = null;
   private ListNode<E> tail = null;

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
      if (maxSize > 0)
      {
         this.maxSize = maxSize;
      } else
      {
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
    * Accessor function to determine if the current list is empty.
    * @return true if the list is empty otherwise false.
    */
   public boolean isEmpty()
   {
      return !(this.length > 0);
   }

   /**
    * Modifier function to add a ListNode to the head of the LinkedList.
    *
    * @param someNode The ListNode you want to add to the LinkedList
    * @return The Integer length of the list after adding the ListNode. 0 if the
    * list is full. -1 if the ListNode.next is not empty.
    */
   public int addEntryToHead(E someData)
   {
      if (this.length < this.maxSize)
      {
         ListNode someNode = new ListNode<>(someData,null);
         if(this.head == null)
         {
            /* we have an empty list */
            this.head = someNode;
            this.tail = someNode;
         }
         else
         {
            someNode.next = this.head;
            this.head = someNode;
         }
         this.length++;
         return this.length;
      } else
      {
         return 0;
      }
   }

   /**
    * Modifier function to add a ListNode to the tail of the LinkedList.
    *
    * @param someNode The ListNode you want to add to the LinkedList
    * @return The Integer length of the list after adding the ListNode. 0 if the
    * list is full. -1 if the ListNode.next is not empty.
    */
   public int addEntryToTail(E someData)
   {

      if (this.length < this.maxSize)
      {
         ListNode someNode = new ListNode<>(someData, null);
         if (this.tail == null)
         {
            /* we have an empty list */
            this.head = someNode;
            this.tail = someNode;
         } else
         {
            this.tail.next = someNode;
            this.tail = someNode;
         }
         this.length++;
         return this.length;
      } else
      {
         return 0;
      }
   }

   /**
    * Accessor function to return the Object being stored at the head of the 
    * list. The Object remains in the list.
    * @return The Object at the head of the list - null if the list is empty.
    */
   public E getFirst()
   {
      if (this.isEmpty())
      {
         return null;
      }
      return this.head.getNodeData();
   }
   
   /**
    * Accessor function to return the Object being stored at the tail of the 
    * list. The Object remains in the list.
    * @return The Object at the tail of the list - null if the list is empty.
    */
   public E getLast()
   {
      if (this.isEmpty())
      {
         return null;
      }
      return this.tail.getNodeData();
   }
   
   /**
    * Modifier function to remove a target entry from the list. This function
    * requires that the caller pass a target object that is comparable to 
    * another instance of that object being stored in the list.
    * @param someTarget A comparable Object that you expect to exist in the 
    * list.
    * @return The Object that has been removed from the list - null if the list
    * is empty or if the target was unmatched.
    */
   public E removeEntry(E someTarget)
   {
      ListNode prevNode;
      E foundTarget = null;

      if (this.isEmpty())
      {
         return null;
      }

      /* check the head first as findTargetPrev will return a false positive 
       * in that case.
       */
      if (someTarget.equals(this.getFirst()))
      {
         foundTarget = (E)this.getFirst();
         this.head = this.head.getNodeNext();
         this.length--;
      }
      else
      {
         prevNode = this.findTargetPrev(someTarget);
         if (prevNode != null)
         {
            foundTarget = (E) prevNode.getNodeNext().getNodeData();
            prevNode.next = prevNode.next.getNodeNext();
            this.length--;
         }   
      }
      return foundTarget;
   }

   /**
    * Accessor function to find the previous Node in the linkedList where the 
    * 1st match of the target is found. If the target matched the entry at the 
    * head of the list this function will return null - making it look like the
    * target was not found. It is the responsibility of the caller to check to 
    * see if the head matches the target.
    * @param someTarget The target we are looking for.
    * @return The prevNode that is pointing to the target Node.
    */
   private ListNode<E> findTargetPrev(E someTarget)
   {
      ListNode curNode = this.head;
      ListNode prevNode = null;
      while (curNode != null)
      {
         if (someTarget.equals(curNode.getNodeData()))
         {
            return prevNode;
         }
         prevNode = curNode;
         curNode = curNode.getNodeNext();
      }
      return null;
   }

   /**
    * Overriden function to return a string describing this LinkedList.
    *
    * @return String in the format of "This list of size [length] contains\n
    * Data: [Object.toString]"
    */
   public String toString()
   {
      ListNode curNode = this.head;
      StringBuilder output = new StringBuilder();
      output.append("This list of size " + this.length + " contains  \n");
      if (this.head == null)
      {
         output.append("nothing\n");
         return output.toString();
      }
      while (curNode != null)
      {
         output.append(curNode.toString() + "\n");
         curNode = curNode.next;
      }
      return output.toString();
   }

   /**
    * Overloaded function to allow you to see if a LinkedList is equal to
    * another LinkedList. Equality is based on the length and max sizes of the
    * lists as well as on the order of ListNode elements and the equality of the
    * Objects stored in the ListNodes.
    *
    * @param someList The list you want to compare this one to.
    * @return true if the lists equal each other.
    */
   public boolean equals(LinkedList<E> someList)
   {
      ListNode thisCurNode = this.head;
      ListNode someCurNode = someList.head;
      if (someList.length == this.length
              && someList.maxSize == this.maxSize)
      {
         while (thisCurNode != null)
         {
            if (!thisCurNode.equals(someCurNode))
            {
               return false;
            }
            thisCurNode = thisCurNode.next;
            someCurNode = someCurNode.next;
         }
      } else
      {
         return false;
      }
      return true;
   }
}
