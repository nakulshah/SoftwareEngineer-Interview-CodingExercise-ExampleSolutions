/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.helperimpl;

import com.groupon.quiz.nakul.shah.common.Constants;
import com.groupon.quiz.nakul.shah.helper.Helper;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author lucky7user
 */
public class HelperImpl implements Helper
{
    
    private static final Log LOG = LogFactory.getLog(HelperImpl.class);
    Random random = new Random();
    
    /*
     *Some of the code was added for approaches which did not work
     *Such could be taken out of Production code base, but I am including it 
     *because those generic helper functions can be used to build other solutions 
     * 
     */

    @Override
    public float getRandom(float maxValue) 
    {
        return this.getRandom(Constants.ZERO, maxValue);
    }

    @Override
    public float getRandom(float start, float end) 
    {
        return ((random.nextFloat() * (end - start)) + start);
    }

    @Override
    public float getSquare(float number) 
    {
        return (number * number);
    }

    @Override
    public float getSquareRoot(float number) 
    {
        return ((float) (Math.sqrt(number)));
    }

    @Override
    public float getRightTriangleSide(float hypotenuse, float side) 
    {
        //http://en.wikipedia.org/wiki/Pythagorean_theorem
        
        return (this.getSquareRoot((this.getSquare(hypotenuse) - this.getSquare(side))));
    }

    @Override
    public float getRightTriangleOppositeSide(float hypotenuse, float theta) 
    {
        //opposite = sin(theta)*hypotenuse
        float oppositeSide = ((float) (Math.sin(Math.toRadians(theta))*hypotenuse));
        //LOG.debug("hypotenuse = " + hypotenuse + " theta = " + theta + " oppositeSide = " + oppositeSide);
        
        return oppositeSide;
    }

    @Override
    public float getRightTriangleAdjacentSide(float hypotenuse, float theta) 
    {
        //adjacent = cos(theta)*hypotenuse
        float adjacentSide = ((float) (Math.cos(Math.toRadians(theta))*hypotenuse));
        //LOG.debug("hypotenuse = " + hypotenuse + " theta = " + theta + " adjacentSide = " + adjacentSide);
        
        return adjacentSide;
    }

    @Override
    public float getRightTriangleHypotenuse(float side1, float side2) 
    {
        return (this.getSquareRoot((this.getSquare(side1) + this.getSquare(side2))));
    }
    
    @Override
    public void PrintExceptionStack(Exception ex)
    {
        LOG.error(ex.getMessage());
        
        String error = "EXCEPTION: " + ex.getMessage();
        StackTraceElement [] stackElements = ex.getStackTrace();
        for (StackTraceElement stackElement : stackElements) 
        {
            error += System.getProperty("line.separator") + stackElement;
        }
        error += System.getProperty("line.separator");
        
        LOG.error(error);
    }

    @Override
    public void PrintExceptionStack2(Exception ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
