package binaryTree;
import java.util.*;


/**
 * 
 * 
 * @author Jon Cronin and Scott McDonald
 */

/**
 * The BinaryTree class is a Generic Class and a simplistic implementation of a 
 * ordered binary tree data structure.
 * 
 * @author Jon Cronin and Scott McDonald
 * @param <E> This BinaryTree Class supports elements of any Object type.
 */
public class BinaryTree<E extends Comparable> 
{
   /**
    * This private BTreeNode class is a basic node object to be used with the 
    * Binary Tree data structure - this is the node object that makes up this
    * type of tree.
    * @param <E> 
    */
   private class BTreeNode<E extends Comparable>
   {
      private E data;
      private BTreeNode<E> parent;
      private BTreeNode<E> leftChild;
      private BTreeNode<E> rightChild;
      
      /**
       * Overloaded constructor to allow you to specify the data as well as the
       * parent and children of a tree node.
       * 
       * @param someData the data you want stored in the tree
       * @param up the parent node of this new node
       * @param left the left child node of this new node
       * @param right the right child node of this new node
       */
      public BTreeNode(E someData, BTreeNode<E> up, BTreeNode<E> left, BTreeNode<E> right)
      {
         this.data = someData;
         this.parent = up;
         this.leftChild = left;
         this.rightChild = right;
      }
      
      /**
       * Accessor function to get the Object data being stored at this node.
       * 
       * @return Object data 
       */
      public E getData()
      {
         return this.data;
      }
      
      /**
       * Accessor function to get the parent node of this node in the tree.
       * 
       * @return BTreeNode parent of this node.
       */
      public BTreeNode<E> getParent()
      {
         return this.parent;
      }
      
      /**
       * Accessor function to get the right child node of this node in the tree.
       * 
       * @return BTreeNode right child of this node.
       */
      public BTreeNode<E> getRightChild()
      {
         return this.rightChild;
      }
      
      /**
       * Accessor function to get the left child node of this node in the tree.
       * 
       * @return BTreeNode left child of this node.
       */
      public BTreeNode<E> getLeftChild()
      {
         return this.leftChild;
      }
      
      /**
       * Modifier function to set the data being stored in this node.
       * 
       * @param someData the Object to be stored
       */
      public void setData(E someData)
      {
         this.data = someData;
      }
      
      /**
       * Modifier function to set the parent node of this node.
       * 
       * @param someNode the desired parent node 
       */
      public void setParent(BTreeNode<E> someNode)
      {
         this.parent = someNode;
      }
      
      /**
       * Modifier function to set the left child node of this node.
       * 
       * @param someNode the desired left child node
       */
      public void setLeftChild(BTreeNode<E> someNode)
      {
         this.leftChild = someNode;
      }
      
      /**
       * Modifier function to set the right child node of this node.
       * 
       * @param someNode the desired right child node 
       */
      public void setRightChild(BTreeNode<E> someNode)
      {
         this.rightChild = someNode;
      }
      
      /**
       * Overriden function to return a string describing this node.
       *
       * @return String in the format of "Data: [Object.toString]"
       */
      @Override
      public String toString()
      {
         return ("Data: " + this.data.toString());
      }
   }
   
   private BTreeNode<E> root = null;
   private int size = 0;
   
   /**
    * Basic constructor of a BinaryTree object.
    */
   public BinaryTree()
   {
      this.root = null;
      this.size = 0;
   }
   
   /**
    * 
    * @return 
    */
   public int getSize()
   {
      return this.size;
   }
   
   /**
    * 
    * @return 
    */
   public E getRoot()
   {
      if(this.isEmpty())
      {
         return null;
      }
      return this.root.getData();
   }
   
   /**
    * 
    * @return 
    */
   public boolean isEmpty()
   {
      return (this.size == 0);
   }
   
   /**
    * 
    * @param someData
    * @return 
    */
   public int add(E someData)
   {
      int treeSize = this.size;
      this.root = insertInSubtree(someData, this.root);
      if(treeSize < this.size)
         return this.size;
      else
         return -1;
   }
   
   /**
    * 
    * @param someData
    * @param subRoot
    * @return 
    */
   private BTreeNode<E> insertInSubtree(E someData, BTreeNode<E> subRoot)
   {
      int compareResult;
      if(subRoot == null)
      {
         this.size++;
         return new BTreeNode<>(someData, null, null, null);
      }
      
      compareResult = someData.compareTo(subRoot.getData());
      
      switch(compareResult)
      {
         case -1:
            subRoot.setLeftChild(insertInSubtree(someData, subRoot.leftChild));
            break;
         case 1:
            subRoot.setRightChild(insertInSubtree(someData, subRoot.rightChild));
            break;
         default:
            // someData is already in the tree.
            break;
      }
      return subRoot;
   }
   
   /**
    * 
    * @param someData
    * @return 
    */
   public boolean contains(E someData)
   {
      return isInSubtree(someData, this.root);
   }
   
   /**
    * 
    * @param someData
    * @param subRoot
    * @return 
    */
   private boolean isInSubtree(E someData, BTreeNode<E> subRoot)
   {
      int compareResult;
      boolean result;
      if(subRoot == null)
         return false;
      
      compareResult = someData.compareTo(subRoot.getData());
      
      switch(compareResult)
      {
         case -1:
            result = isInSubtree(someData, subRoot.leftChild);
            break;
         case 1:
            result = isInSubtree(someData, subRoot.rightChild);
            break;
         case 0:
         default:
            result = true;
            break;
      }
      return result;
   }
   
   /**
    * Overriden function to return a string describing this BinaryTree.
    *
    * @return String in the format of "This tree of size [length] contains\n
    * Data: [Object.toString]". Output of the tree is down with a breadth-first
    * traversal giving the output from the root on up/down the tree by level.
    */
   @Override
   public String toString()
   {
      LinkedList childQueue = new LinkedList();
      BTreeNode<E> node;
      StringBuilder output = new StringBuilder();
      
      output.append("This tree of size " + this.size + " contains  \n");
      if(this.isEmpty())
      {
         output.append("nothing\n");
      }
      else
      {
         childQueue.addFirst(this.root);
         while(!childQueue.isEmpty())
         {
            node = (BTreeNode)childQueue.removeLast();
            output.append(node.toString() + "\n");
            if(node.leftChild != null)
               childQueue.addFirst(node.leftChild);
            if(node.rightChild != null)
               childQueue.addFirst(node.rightChild);
         }
      }
      
      return output.toString();
   }
}
