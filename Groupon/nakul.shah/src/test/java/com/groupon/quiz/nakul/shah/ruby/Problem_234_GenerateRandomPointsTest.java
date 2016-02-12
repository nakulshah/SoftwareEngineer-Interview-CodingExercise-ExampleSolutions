/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.ruby;

import com.groupon.quiz.nakul.shah.BaseTest;
import com.groupon.quiz.nakul.shah.common.Constants;
import com.groupon.quiz.nakul.shah.entity.Circle;
import com.groupon.quiz.nakul.shah.entity.Point;
import com.groupon.quiz.nakul.shah.entity.Radius;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class Problem_234_GenerateRandomPointsTest extends BaseTest
{
    private static final Log LOG = LogFactory.getLog(Problem_234_GenerateRandomPointsTest.class);
    
    public Problem_234_GenerateRandomPointsTest() {
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
    public void generateRandomPointsBoundryTest() 
    {
        try
        {
            Point point = new Point(helper.getRandom(-100, 100),helper.getRandom(-100, 100));
            Radius radius = new Radius(helper.getRandom(100));
            
            
            Circle circle = new Circle(point, radius);

            int MAX = 10000;
            
            boolean withinBounds = true;
            
            for(int i = 0; i < MAX; i++)
            {
                Point randomPoint = randomPointsGenerator.generateRandomPoint(circle);
                
                if(false == checkWithinBounds(circle, randomPoint))
                {
                    LOG.error("Failed Boundry Test: " + circle + randomPoint);
                    withinBounds = false;
                    fail();
                }
            }
            
            if(withinBounds)
            {
                LOG.debug("Boundry Test Passed");
            }
            
            assertTrue(withinBounds);
        }
        catch(Exception ex)
        {
            LOG.error(ex);
            assertTrue(false);
        }
    }
    

    
    @Test
    public void generateRandomPointsQuadrantRandomnessTest() 
    {
        try
        {
            Point point = new Point(Constants.ZERO,Constants.ZERO);
            Radius radius = new Radius(helper.getRandom(100));
            Circle circle = new Circle(point, radius);
            int firstQCount = 0;
            int secondQCount = 0;
            int thirdQCount = 0;
            int fourthQCount = 0;
            int axisCount = 0;

            int MAX = 10000;

            for(int i = 0; i < MAX; i++)
            {
                Point randomPoint = randomPointsGenerator.generateRandomPoint(circle);

                if(randomPoint.getX() > 0)
                {
                    if(randomPoint.getY() > 0)
                    { 
                        firstQCount ++;
                    }
                    else if(randomPoint.getY() < 0)
                    {
                        secondQCount ++;
                    }
                    else
                    {
                        axisCount ++;
                    }
                }
                else if(randomPoint.getX() < 0)
                {
                    if(randomPoint.getY() > 0)
                    {
                        fourthQCount ++;
                    }
                    else if(randomPoint.getY() < 0)
                    {
                        thirdQCount ++;
                    }
                    else
                    {
                        axisCount ++;
                    }
                }
                else
                {
                    axisCount ++;
                }
            }
            
            LOG.debug("firstQCount = " + firstQCount);
            LOG.debug("secondQCount = " + secondQCount);
            LOG.debug("thirdQCount = " + thirdQCount);
            LOG.debug("fourthQCount = " + fourthQCount);
            LOG.debug("axisCount = " + axisCount); //with co-ordinates defined as
            //float, getting a point on axis is rare
            
            assertTrue(firstQCount > MAX/(4*1.25)); //20% wiggle room
            assertTrue(secondQCount > MAX/(4*1.25));
            assertTrue(thirdQCount > MAX/(4*1.25));
            assertTrue(fourthQCount > MAX/(4*1.25));
        }
        catch(Exception ex)
        {
            LOG.error(ex);
            assertTrue(false);
        }
    }
    
    @Test
    public void generateRandomPointsPositionRandomnessTest() 
    {
        try
        {
            Point point = new Point(Constants.ZERO,Constants.ZERO);
            Radius radius = new Radius(Constants.FOUR);
            Circle circle = new Circle(point, radius);
            
            int[][] buckets = new int[Constants.FOUR][Constants.FOUR];
            
            for(int i = 0; i < Constants.FOUR; i++)
            {
                for(int j = 0; j < Constants.FOUR; j++)
                {
                    buckets[i][j] = 0;
                }
            }

            int MAX = 10000;
            int error = 0;

            for(int n = 0; n < MAX; n++)
            {
                Point randomPoint = randomPointsGenerator.generateRandomPoint(circle);

                int i = ((int)Math.floor(Math.abs(randomPoint.getX())));                
                int j = ((int)Math.floor(Math.abs(randomPoint.getY())));

                if((i < Constants.FOUR) && (j < Constants.FOUR))
                    buckets[i][j] ++;
                else
                {
                    error ++;
                    LOG.error("Error Point = " + randomPoint);
                }
            }
            
            for(int i = 0; i < Constants.FOUR; i++)
            {
                for(int j = 0; j < Constants.FOUR; j++)
                {
                    if(((i+j)<Constants.FOUR) || ((i == j) & (i == 2)))
                        assertTrue(buckets[i][j] > MAX/(15));
                    else if((i+j) == Constants.FOUR)
                        assertTrue(buckets[i][j] > MAX/(20));
                    else if((i+j) == Constants.FIVE)
                        assertTrue(buckets[i][j] > MAX/(100));
                    else if((i+j) > Constants.FIVE)
                        assertTrue(buckets[i][j] == Constants.ZERO);
                        
                        
                    LOG.debug("i = " + i + ", j = " + j + " bucket count = " + buckets[i][j]);
                }
            }
            
            assertFalse(error > 0);
        }
        catch(Exception ex)
        {
            LOG.error(ex);
            assertTrue(false);
        }
    }
    
    private boolean checkWithinBounds(Circle circle, Point point)
    {
        boolean withinBounds = false;
        
        float radSq = helper.getSquare(circle.getRadius().getLength());
        float hypSq = helper.getSquare(point.getX() - circle.getCenter().getX())
                + helper.getSquare(point.getY() - circle.getCenter().getY());
        
        //LOG.debug("radSq = " + radSq + " hypSq = " + hypSq);
        
        if(hypSq <= radSq)
            withinBounds = true;
        
        return withinBounds;
    }
}
