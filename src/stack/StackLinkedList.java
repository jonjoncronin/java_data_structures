/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;
import linkedList.*; // reusing the ListNode class

/**
 *
 * @author joncronin
 */
public class StackLinkedList 
{
   int length;
   int maxSize;
   ListNode top;
   
   public StackLinkedList()
   {
      this.length = 0;
      this.maxSize = 10;
      this.top = null;
   }
   
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
   
   public int getMaxSize()
   {
      return this.maxSize;
   }

   public int getLength()
   {
      return this.length;
   }
   
   public int push(ListNode someNode)
   {
      if(someNode.getNodeNext() != null)
      {
         return -1;
      }
      if(this.length < this.maxSize)
      {
         if(someNode.setNodeNext(this.top))
         {
            this.top = someNode;
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
   
   public ListNode pop()
   {
      ListNode topNode;
      if(length == 0)
      {
         return null;
      }
      topNode = this.top;
      this.top = topNode.getNodeNext();
      topNode.next = null;
      this.length--;
      return topNode;
   }
   
   public String toString()
   {
      ListNode curNode = this.top;
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
