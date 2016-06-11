package linkedList;

public class LinkedList
{
   int length;
   int maxSize;
   ListNode head;
   ListNode tail;

   public LinkedList()
   {
      this.length = 0;
      this.maxSize = 10;
      this.head = null;
      this.tail = null;
   }

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

   public int getMaxSize()
   {
      return this.maxSize;
   }

   public int getLength()
   {
      return this.length;
   }

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
