package stack;

/**
 * The StackLinkedList class is a very simple Stack implementation that allows 
 * the user to push and pop Objects of any type. This Stack implementation uses
 * a linkedList implementation under the covers allowing for dynamic growing and
 * shrinking of the memory allocations for Stack.
 * 
 * @author Jon Cronin and Scott McDonald
 * @param <E> This Stack supports elements of any Object type
 */
public class StackLinkedList<E>
{
   /**
    * This private node class is a basic node object to be used with the Stack
    * data structure - this is the linked list node object that makes up this
    * type of Stack.
    */
   private static class StackNode<E>
   {
      private E data = null;
      private StackNode<E> next = null;

      /**
       * Overloaded constructor to allow you to specify the data as well as the
       * next StackNode that a StackNode will contain.
       *
       * @param data The element/object you want stored as the data of the
       * StackNode
       * @param next The next ListNode that you want stored as the next of the
       * StackNode
       */
      public StackNode(E data, StackNode<E> next)
      {
         this.data = data;
         this.next = next;
      }

      /**
       * Accessor function to allow you to retrieve the data of a StackNode.
       *
       * @return The Object stored as the data of the StackNode.
       */
      public E getNodeData()
      {
         return this.data;
      }

      /**
       * Accessor function to retrieve the StackNode stored as the next of the
       * StackNode.
       *
       * @return The next StackNode that this StackNode is pointing to.
       */
      public StackNode<E> getNodeNext()
      {
         return this.next;
      }

      /**
       * Overriden function to return a string describing this StackNode.
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
   private StackNode<E> top = null;
   
   /**
    * Basic constructor of a Stack object.
    */
   public StackLinkedList()
   {
      this.length = 0;
      this.maxSize = 10;
      this.top = null;
   }
   
   /**
    * Overloaded constructor to allow you to specify the maxSize of the Stack
    * you want to create.
    * @param maxSize The maxSize of the Stack you want to create. Only supports
    * positive numbers. If you do not specify a maxSize then the maxSize will
    * default to 10 entries.
    */
   public StackLinkedList(int maxSize)
   {
      this.length = 0;
      if (maxSize > 0) {
        this.maxSize = maxSize;
      } else {
          this.maxSize = 10;
      }
      this.top = null;
   }
   
   /**
    * Accessor function to get the max size of the Stack.
    * @return The Integer maxSize of the stack - how many objects could possibly
    * be stored in the Stack.
    */
   public int getMaxSize()
   {
      return this.maxSize;
   }

   /**
    * Accessor function to get the current length of the Stack.
    * 
    * @return The Integer length of the Stack - how many objects are currently 
    * in the Stack.
    */
   public int getLength()
   {
      return this.length;
   }
   
   /**
    * Modifier function to add an Object to the top of the Stack.
    * 
    * @param someData The Object you want to add to the Stack.
    * @return The Integer length of the Stack after adding the Object. 0 if 
    * the Stack is full.
    */
   public int push(E someData)
   {
      if(this.length < this.maxSize)
      {
         this.top = new StackNode<>(someData,this.top);
         this.length++;
         return this.length;   
      }
      else
      {
         return 0;
      }
   }
   
   /**
    * Modifier function to remove an Object from the top of the Stack.
    * @return Object that was at the top of the Stack. Null if the Stack is 
    * empty.
    */
   public E pop()
   {
      E topNodeData;
      if(length == 0)
      {
         return null;
      }
      topNodeData = this.top.getNodeData();
      this.top = this.top.getNodeNext();
      this.length--;
      return topNodeData;
   }
   
   /**
    * Accessor function to retrieve but not remove the Object at the top of the
    * Stack.
    * @return Object that is currently at the top of the Stack. Null if the 
    * Stack is empty.
    */
   public E top()
   {
      if(this.top == null)
         return null;
      else
         return this.top.getNodeData();
   }
   
   /**
    * Informational function to determine if a Stack is empty.
    * @return true if the Stack is empty, otherwise false
    */
   public boolean isEmpty()
   { 
      return !(this.length > 0);   
   }
   
   /**
    * Overriden function to return a string describing this Stack.
    * @return String in the format of "This stack of size [length] contains\n
    * Data: [Object.toString]" 
    */
   @Override
   public String toString()
   {
      StackNode curNode = this.top;
      StringBuilder output = new StringBuilder();
      output.append("This stack of size " + this.length + " contains  \n");
      if (this.top == null)
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
}
