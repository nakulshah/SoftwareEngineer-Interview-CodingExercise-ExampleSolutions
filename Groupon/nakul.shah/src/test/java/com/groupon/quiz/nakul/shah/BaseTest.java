/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah;

import com.groupon.quiz.nakul.shah.helper.Helper;
import com.groupon.quiz.nakul.shah.helperimpl.HelperImpl;
import com.groupon.quiz.nakul.shah.redis.GrouponRedis;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lucky7user
 */
public class BaseTest 
{
    protected ApplicationContext appContext;
    protected RandomPointsGenerator randomPointsGenerator;
    protected Helper helper;
    protected GrouponRedis grouponRedis;
    
    private static final Log LOG = LogFactory.getLog(BaseTest.class);
    
    public BaseTest() 
    {
        appContext = new ClassPathXmlApplicationContext("spring/beans/AppBeans.xml");
        randomPointsGenerator = (RandomPointsGenerator)appContext.getBean("RandomPointsGenerator");
        helper = (Helper)appContext.getBean("Helper");
        grouponRedis = (GrouponRedis)appContext.getBean("GrouponRedis");
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
     public void springWireUpTest() 
     {
         LOG.debug("Base Test Start");
         assertTrue(null != appContext);
         assertTrue(null != randomPointsGenerator);
         LOG.debug("Base Test End");
     }
}
