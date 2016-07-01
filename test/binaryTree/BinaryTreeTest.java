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
 * @author Jon Cronin and Scott McDonald
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
   
   /**
    * Test method for {@link binaryTree.BinaryTree#add(Object)}.
    */
   @Test
   public void testAdd()
   {
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      Integer someObject4 = new Integer(3);
      int result;
      
      result = testTree.add(someObject2);
      assertTrue(result == 1);
      result = testTree.add(someObject1);
      assertTrue(result == 2);
      result = testTree.add(someObject3);
      assertTrue(result == 3);
      result = testTree.add(someObject4);
      assertTrue(result == -1);
   }
   
   /**
    * Test method for {@link binaryTree.BinaryTree#getSize()}.
    */
   @Test
   public void testGetSize()
   {
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      Integer someObject4 = new Integer(3);
      int result;
      
      result = testTree.add(someObject1);
      result = testTree.add(someObject2);
      result = testTree.add(someObject3);
      result = testTree.getSize();
      assertTrue(result == 3);
   }
   
   /**
    * Test method for {@link binaryTree.BinaryTree#getRoot()}.
    */
   @Test
   public void testGetRoot()
   {
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      Integer answer;
      
      answer = (Integer)testTree.getRoot();
      assertTrue(answer == null);
      
      testTree.add(someObject1);
      answer = (Integer)testTree.getRoot();
      assertTrue(answer == someObject1);
   }
   
   /**
    * Test method for {@link binaryTree.BinaryTree#isEmpty()}.
    */
   @Test
   public void testIsEmpty()
   {
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      boolean result;
      
      result = testTree.isEmpty();
      assertTrue(result == true);
      
      testTree.add(someObject1);
      result = testTree.isEmpty();
      assertTrue(result == false);
   }
   
   /**
    * Test method for {@link binaryTree.BinaryTree#Contains(Object)}.
    */
   @Test
   public void testContains()
   {
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      Integer someObject4 = new Integer(3);
      Integer someObject5 = new Integer(1);
      Integer someObject6 = new Integer(6);
      boolean result;
      
      testTree.add(someObject2);
      testTree.add(someObject1);
      testTree.add(someObject3);

      result = testTree.contains(someObject4);
      assertTrue(result == true);
      
      result = testTree.contains(someObject5);
      assertTrue(result == true);
      
      result = testTree.contains(someObject6);
      assertTrue(result == false);
   }
   
      /**
    * Test method for {@link binaryTree.BinaryTree#toString()}.
    */
   @Test
   public void testToString()
   {
      String expectedOutput = "This tree of size 3 contains  \n" +
                              "Data: 2\n" +
                              "Data: 1\n" +
                              "Data: 3\n";
      int result;
      /* create a tree of 3 elements */
      BinaryTree testTree = new BinaryTree();
      Integer someObject1 = new Integer(1);
      Integer someObject2 = new Integer(2);
      Integer someObject3 = new Integer(3);
      
      testTree.add(someObject2);
      testTree.add(someObject1);
      testTree.add(someObject3);
      
      result = expectedOutput.compareTo(testTree.toString());
      assertTrue(result == 0);
   }
   
   /**
    * Test method for {@link binaryTree.BinaryTree#toString()}
    * on an empty list.
    */
   @Test
   public void testToStringEmptyList()
   {
      String expectedOutput = "This tree of size 0 contains  \n" +
                              "nothing\n";
      int result;
      /* create a list of 10 elements */
      BinaryTree testTree = new BinaryTree();
      result = expectedOutput.compareTo(testTree.toString());
      assertTrue(result == 0);
   }
}
