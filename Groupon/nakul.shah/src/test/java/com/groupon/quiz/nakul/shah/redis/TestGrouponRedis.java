/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.redis;

import com.groupon.quiz.nakul.shah.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucky7user
 */
public class TestGrouponRedis extends BaseTest
{
    
    String myKey = "GrouponAddress";
    String myValue = "600W";
    
    public TestGrouponRedis() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testSet() 
     {
         this.grouponRedis.Set(myKey, myValue);
     }
     
     @Test
     public void testGet() 
     {
         String string1 = "Hello World";
         String string2 = "Hello World";
         
         this.grouponRedis.Set("GrouponAddress", myValue);
         
         System.out.println(this.grouponRedis.Get("GrouponAddress"));
         
         assertEquals(myValue, this.grouponRedis.Get("GrouponAddress"));
     }
     
     @Test
     public void testDelete() 
     {
         this.grouponRedis.Set("GrouponAddress", myValue);
         this.grouponRedis.Set("GrouponPAAddress", "Paulo Alto");
         this.grouponRedis.Set("GrouponSTAddress", "Stattle");
         
         this.grouponRedis.Delete("GrouponPAAddress", "GrouponSTAddress", "GrouponNPAddress");
         
         assertEquals(myValue, this.grouponRedis.Get("GrouponAddress"));
         assertNull(this.grouponRedis.Get("GrouponSTAddress"));
     }
}
