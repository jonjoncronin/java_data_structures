/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author mcdonasc
 */
public class BinaryTreeTest {
    
   /**
    * Test method for {@link binaryTree.BinaryTree#BinaryTree()}.
    */
   @Test
   public void testBinaryTree()
   {
      BinaryTree testTree = new BinaryTree();
      Object answer;
      int result;
      
      /* test the constructor */
      result = testTree.getSize();
      assertTrue(result == 0);
      answer = testTree.getRoot();
      assertTrue(answer == null);
   }
    
}
