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
public class TreeFun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        BinaryTree bTree = new BinaryTree();
        
        bTree.insert(700);
        bTree.insert(200);
        bTree.insert(400);
        bTree.insert(100);
        bTree.insert(500);
        bTree.insert(300);
        bTree.insert(600);
        
        
        bTree.printTree();
        
        System.out.println("700 lookup = " + bTree.lookup(700));
        System.out.println("800 lookup = " + bTree.lookup(800));
        System.out.println("Size = " + bTree.size());
        System.out.println("Max Depth = " + bTree.maxDepth());
        System.out.println("Min Value = " + bTree.minValue());
        System.out.println("Max Value = " + bTree.maxValue());
        System.out.println("Has Path Sum 1000 = " + bTree.hasPathSum(1000));
        System.out.println("Has Path Sum 9000 = " + bTree.hasPathSum(900));
        System.out.println("Has Path Sum 10000 = " + bTree.hasPathSum(10000));
        
        bTree.printPaths();
        bTree.mirror();
        bTree.doubleTree();
        
        //Q = Construct a tree from its inorder traversal 
        //Q = Draw the graphical representation of a tree
    }
    
}
