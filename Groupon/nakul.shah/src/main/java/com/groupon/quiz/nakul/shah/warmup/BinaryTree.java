/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.warmup;

/**
 *
 * @author lucky7user
 */
public class BinaryTree 
{
    private Node root; 
    
    /** 
    Creates an empty binary tree -- a null root pointer. 
    */ 
    public void BinaryTree() 
    { 
        root = null; 
    } 

    /** 
    Returns true if the given target is in the binary tree. 
    Uses a recursive helper. 
    */ 
    public boolean lookup(int data) 
    { 
        return lookup(root, data);
    }
    
    private boolean lookup(Node node, int data)
    {
        if(null == node)
        {
            return false;
        }
        else 
        {
            if(node.data == data)
                return true;
            else if(node.data > data)
                return lookup(node.left, data);
            else
                return lookup(node.right, data);
        }
        
    }

    /** 
    Inserts the given data into the binary tree. 
    Uses a recursive helper. 
     * @param data
    */ 
    public void insert(int data) 
    { 
        insert(root, data);
    }
    
    private void insert(Node node, int data)
    {
        if(null != node)
        {
            if(node.data > data)
            {
                if(null != node.left)
                    insert(node.left, data);
                else
                    node.left = new Node(data);
            }
            else
            {
                if(null != node.right)
                    insert(node.right, data);
                else
                    node.right = new Node(data);
            }
        }
        else
        {
            root = new Node(data);
        }
    }

    /** 
    Returns the number of nodes in the tree. 
    Uses a recursive helper that recurs 
    down the tree and counts the nodes. 
    */ 
    public int size() 
    { 
        return size(root);
    }
    
    private int size(Node node)
    {
        if(null != node)
        {
            int sum = 0;
            sum = sum + size(node.left);
            sum = sum + size(node.right);

            return sum + 1;
        }
        return 0;       
    }
    
  
    /** 
    Returns the max root-to-leaf depth of the tree. 
    Uses a recursive helper that recurs down to find 
    the max depth. 
    */ 
    public int maxDepth() 
    { 
        return maxDepth(root);
    }
    
    private int maxDepth(Node node)
    {
        if(null == node)
            return 0;
        else
        {
            int maxRight = maxDepth(node.right) + 1;
            int maxLeft = maxDepth(node.left) + 1;
            
            return(maxLeft>maxRight ? maxLeft : maxRight);
        }
                    
    }
    
    /** 
    Returns the min value in a non-empty binary search tree. 
    Uses a helper method that iterates to the left to find 
    the min value. 
    */ 
    public int minValue() 
    { 
        return minValue(root);
    }
    
    private int minValue(Node node)
    {
        if(null != node.left)
        {
            return minValue(node.left);
        }
        else
            return node.data;
    }
    
    public int maxValue() 
    { 
        return maxValue(root);
    }
    
    private int maxValue(Node node)
    {
        if(null != node.right)
        {
            return maxValue(node.right);
        }
        else
            return node.data;
    }
  
    /** 
    Prints the node values in the "inorder", preorder & postorder order. 
    Uses a recursive helper to do the traversal. 
    */ 
    public void printTree() 
    { 
        System.out.println("<<<<<<<<<<INORDER>>>>>>>>>");
        printInorder(root);
        
        System.out.println("<<<<<<<<<<PREORDER>>>>>>>>>");
        printPreorder(root);
    }
    
    private void printInorder(Node node)
    {
        if(null != node)
        {
            printInorder(node.left);
            System.out.println(node.data);
            printInorder(node.right);
        }
    }
    
    private void printPreorder(Node node)
    {
        if(null != node)
        {
            System.out.println(node.data);
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }
    
    /** 
    Given a tree and a sum, returns true if there is a path from the root 
    down to a leaf, such that adding up all the values along the path 
    equals the given sum.
    Strategy: subtract the node value from the sum when recurring down, 
    and check to see if the sum is 0 when you run out of tree. 
    */ 
    public boolean hasPathSum(int sum) 
    { 
        return hasPathSum(root, sum);
    }
    
    private boolean hasPathSum(Node node, int sum)
    {
        if(null != node)
        {
            if((node.data == sum) && (null == node.right) && (null == node.left))
            {
                return true;
            }
            else
            {
                boolean presentLeft = hasPathSum(node.left, sum - node.data);
                boolean presentRight = hasPathSum(node.right, sum - node.data);

                return (presentLeft || presentRight);
            }
        }
        else
            return false;
    }
    
    /** 
 Given a binary tree, prints out all of its root-to-leaf 
 paths, one per line. Uses a recursive helper to do the work. 
*/ 
public void printPaths() { 
  int[] path = new int[1000]; 
  printPaths(root, path, 0); 
}
/** 
 Recursive printPaths helper -- given a node, and an array containing 
 the path from the root node up to but not including this node, 
 prints out all the root-leaf paths. 
*/ 
private void printPaths(Node node, int[] path, int pathLen) { 
  if (node==null) return;

  // append this node to the path array 
  path[pathLen] = node.data; 
  pathLen++;

  // it's a leaf, so print the path that led to here 
  if (node.left==null && node.right==null) { 
    printArray(path, pathLen); 
  } 
  else { 
  // otherwise try both subtrees 
    printPaths(node.left, path, pathLen); 
    printPaths(node.right, path, pathLen); 
  } 
}

/** 
 Utility that prints ints from an array on one line. 
*/ 
private void printArray(int[] ints, int len) { 
  int i; 
  for (i=0; i<len; i++) { 
   System.out.print(ints[i] + " "); 
  } 
  System.out.println(); 
} 
    
//    /** 
//    Given a binary tree, prints out all of its root-to-leaf 
//    paths, one per line. Uses a recursive helper to do the work. 
//    */ 
//    public void printPaths() 
//    { 
//        int min = 0;
//        int max = this.maxValue(root);
//        while((min < max) && (min != -1))
//        {
//            min = printPaths(root, min);
//            System.out.println("***" + min + "***");
//        }
//    }
//    
//    int printPaths(Node node, int minSoFar)
//    {
//        if(node == null)
//        {
//            return -1;
//        }
//        else
//        {
//            System.out.print(node.data + " ");
//            
////            if((node.left == null) && (node.right == null))
////            {
////                return node.data;
////            }
////            else 
//                if(((node.left != null) && (node.data > minSoFar)) || 
//                        ((node.left != null) && (node.right == null)))
//            {
//                return printPaths(node.left, minSoFar);
//            }
//            else if(node.right != null)
//            {
//                return printPaths(node.right, minSoFar);
//            }
//            else
//            {
//                return node.data;
//            }
//            
//        }
//    }
    
    
    /** 
    Changes the tree into its mirror image.

    So the tree... 
       4 
      / \ 
     2   5 
    / \ 
    1   3

    is changed to... 
       4 
      / \ 
     5   2 
        / \ 
       3   1

    Uses a recursive helper that recurs over the tree, 
    swapping the left/right pointers. 
    */ 
    public void mirror() 
    { 
        this.printTree();
        interchange(root);
        this.printTree();
    }
    
    void interchange(Node node)
    {
        if(null != node)
        {
            interchange(node.left);
            interchange(node.right);
            
            Node tempLeft = node.left;
            node.left = node.right;
            node.right = tempLeft;
        }
    }
    
    /** 
    Changes the tree by inserting a duplicate node 
    on each nodes's .left. 


    So the tree... 
       2 
      / \ 
     1   3

    Is changed to... 
          2 
         / \ 
        2   3 
       /   / 
      1   3 
     / 
    1

    Uses a recursive helper to recur over the tree 
    and insert the duplicates. 
    */ 
    public void doubleTree() 
    { 
        this.printTree();
        doubleTree(root);
        this.printTree();
    }
    
    void doubleTree(Node node)
    {
        if(null != node)
        {
            doubleTree(node.left);
            doubleTree(node.right);
            
            if(node.left != null)
            {
                Node tempLeft = node.left;
                
                node.left = new Node(node.left.data);
                
                node.left.left = tempLeft;
            }

            if(node.right != null)
            {
                Node tempRight = node.right;
                
                node.right = new Node(node.right.data);
                
                node.right.right = tempRight;
            }

        }
    }
            
    /* 
    Compares the receiver to another tree to 
    see if they are structurally identical. 
    */ 
    public boolean sameTree(BinaryTree other) 
    { 
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /** 
    For the key values 1...numKeys, how many structurally unique 
    binary search trees are possible that store those keys?
    Strategy: consider that each value could be the root. 
    Recursively find the size of the left and right subtrees. 
    */ 
    public static int countTrees(int numKeys)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /** 
    Tests if a tree meets the conditions to be a 
    binary search tree (BST). 
    */ 
    public boolean isBST() 
    { 
         throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /** 
    Tests if a tree meets the conditions to be a 
    binary search tree (BST). Uses the efficient 
    recursive helper. 
    */ 
    public boolean isBST2() 
    { 
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
