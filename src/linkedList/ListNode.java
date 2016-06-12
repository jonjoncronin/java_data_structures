package linkedList;

/**
 * The ListNode class is a basic node object to be used with Linked Lists or 
 * other data structures that may utilize a similar linked list type 
 * architecture. The ListNode itself is a public class with public members 
 * and public functions due to its simplicity.
 * 
 * @author Jon Cronin and Scott McDonald
 */
public class ListNode
{
   public Object data;
   public ListNode next;

   /**
    * Basic constructor of a ListNode object
    */
   public ListNode()
   {
      this.data = null;
      this.next = null;
   }

   /**
    * Overloaded constructor to allow you to specify the data of a ListNode
    * 
    * @param data The Object you want stored as the data of the ListNode 
    */
   public ListNode(Object data)
   {
      this.data = data;
      this.next = null;
   }

   /**
    * Overloaded constructor to allow you to specify the data as well as the
    * next ListNode that a ListNode will contain.
    * 
    * @param data The Object you want stored as the data of the ListNode
    * @param next The next ListNode that you want stored as the next of the ListNode
    */
   public ListNode(Object data, ListNode next)
   {
      this.data = data;
      this.next = next;
   }

   /**
    * Accessor function to allow you to retrieve the data of a ListNode. 
    * 
    * @return The Object stored as the data of the ListNode. 
    */
   public Object getNodeData()
   {
      return this.data;
   }

   /**
    * Modifier function to allow you to set the data of a ListNode.
    * 
    * @param data The object that you want stored as the data of the ListNode
    * @return true or false that the object was stored.
    */
   public boolean setNodeData(Object data)
   {
      this.data = data;
      return true;
   }

   /**
    * Accessor function to retrieve the ListNode stored as the next of the 
    * ListNode.
    * 
    * @return The next ListNode that this ListNode is pointing to. 
    */
   public ListNode getNodeNext()
   {
      return this.next;
   }

   /**
    * Modifier function to allow you to set the next ListNode that this ListNode
    * points at.
    * @param next The ListNode that you want stored as the next ListNode that
    * this ListNode is pointing to.
    * @return true or false that the next ListNode was stored. Will be false if
    * the ListNode you are trying to point to is the same as this ListNode - 
    * don't point a ListNode at itself.
    */
   public boolean setNodeNext(ListNode next)
   {
      if (next == this)
         return false;

      this.next = next;
      return true;
   }

   /**
    * Overloaded function to allow you to see if a ListNode is equal to
    * another ListNode. Equality is based on the Object stored as data.
    * @param someNode The other ListNode you want to compare this one with.
    * @return true or false if the data Objects are equal.
    */
   public boolean equals(ListNode someNode)
   {
      if(this.data == null)
      {
         return false;
      }
      else
      {
         return someNode.data.equals(this.data);
      }
   }
   
   /**
    * Overriden function to return a string describing this ListNode.
    * @return String in the format of "Data: [Object.toString]"
    */
   @Override
   public String toString()
   {
      return ("Data: " + this.data.toString());
   }
   
   public String toString()
   {
      return ("Data: " + this.data.toString());
   }		     
}
