package binaryTree;

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
public class BinaryTree<E>
{
   /**
    * This private BTreeNode class is a basic node object to be used with the 
    * Binary Tree data structure - this is the node object that makes up this
    * type of tree.
    * @param <E> 
    */
   private static class BTreeNode<E>
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
   
   public int getSize()
   {
      return this.size;
   }
   
   public E getRoot()
   {
      if(this.isEmpty())
      {
         return null;
      }
      return this.root.getData();
   }
   public boolean isEmpty()
   {
      return (this.size == 0);
   }
}
