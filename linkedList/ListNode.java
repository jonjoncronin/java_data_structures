package ws_2;
public class ListNode
{
   Object data;
   ListNode next;

   public ListNode()
   {
      this.data = null;
      this.next = null;
   }

   public ListNode(Object data)
   {
      this.data = data;
      this.next = null;
   }

   public ListNode(Object data, ListNode next)
   {
      this.data = data;
      this.next = next;
   }

   public Object getNodeData()
   {
      return this.data;
   }

   public boolean setNodeData(Object data)
   {
      this.data = data;
      return true;
   }

   public ListNode getNodeNext()
   {
      return this.next;
   }

   public boolean setNodeNext(ListNode next)
   {
      if (next == this)
         return false;

      this.next = next;
      return true;
   }

   public boolean equals(ListNode someNode)
   {
      if(someNode.data == null &&
            this.data == null)
      {
         return true;
      }
      else if(someNode.data == null ||
            this.data == null)
      {
         return false;
      }
      else
      {
         return someNode.data.equals(this.data);
      }

   }
}
