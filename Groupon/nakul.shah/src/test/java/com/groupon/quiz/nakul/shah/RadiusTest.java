/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupon.quiz.nakul.shah;

import com.groupon.quiz.nakul.shah.common.Constants;
import com.groupon.quiz.nakul.shah.entity.Radius;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nakul Shah
 */
public class RadiusTest extends BaseTest
{
    
    public RadiusTest() {
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
    public void NegativeRadiusInitTest() 
    {
        try
        {
            Radius rad = new Radius(-9);
        }
        catch(Exception ex)
        {
            assertTrue(ex.getMessage().equals(Constants.NO_NEGATIVE_OR_ZERO_RADIUS));
        }
    }
}
