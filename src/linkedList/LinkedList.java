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
      if(someNode == null)
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
      if(someNode == null)
      {
         return -1;
      }
      if(someNode.getNodeNext() != null)
      {
         return -1;
      }
      if(this.length < this.maxSize)
      {
         if(this.tail.setNodeNext(someNode))
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
}
