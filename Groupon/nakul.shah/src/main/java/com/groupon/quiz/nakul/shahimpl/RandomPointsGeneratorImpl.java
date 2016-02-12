/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shahimpl;

import com.groupon.quiz.nakul.shah.RandomPointsGenerator;
import com.groupon.quiz.nakul.shah.common.Enums;
import com.groupon.quiz.nakul.shah.entity.Circle;
import com.groupon.quiz.nakul.shah.entity.Point;
import com.groupon.quiz.nakul.shah.helper.Helper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author lucky7user
 */
public class RandomPointsGeneratorImpl implements RandomPointsGenerator
{
    private static final Log LOG = LogFactory.getLog(RandomPointsGeneratorImpl.class);
    Helper helper;

    public void setHelper(Helper helper) {
        this.helper = helper;
    }
    
    
    @Override
    public Point generateRandomPoint(Circle circle) 
    {
        Point randomPoint = null;
        
        try
        {
            float randomX = 0;
            float randomY = 0;
            
            /*
            *The below approaches did not work becasue the point generation 
            *is heavier towards the center
            * The test com.groupon.quiz.nakul.shah.ruby.Problem_234_GenerateRandomPointsTest.
            * generateRandomPointsPositionRandomnessTest failed.
            
            *The code should be taken out of Production code base, but I am including it to
            *suggest that these pitfall/gotcha should be avoided 
            
             * Pitfall Approach 1--> 
            switch((int)Math.floor(helper.getRandom(Constants.TWO)))
            {
                case Constants.ZERO:
                    randomX = helper.getRandom(circle.getRadius().getLength());
                    randomY = helper.getRandom(helper.getRightTriangleSide(circle.getRadius().getLength(), randomX));
                    break;
                case Constants.ONE:
                    randomY = helper.getRandom(circle.getRadius().getLength());
                    randomX = helper.getRandom(helper.getRightTriangleSide(circle.getRadius().getLength(), randomY));
                    break;
                default:
                    break;
            }
             * Why Approach 1 does not work?
             * Because if you consider a circle, then length of X and Y have more chances 
             * of being n then being n+1 
            
             * Pitfall Approach 2--> 
            float randomTheta = helper.getRandom(Constants.NINETY);
            float randomRadius = helper.getRandom(circle.getRadius().getLength());
            
            randomX = helper.getRightTriangleAdjacentSide(randomRadius, randomTheta);
            randomY = helper.getRightTriangleOppositeSide(randomRadius, randomTheta);
            
             * Why Approach 2 does not work?
             * Because the appraoch tries to fit same number of points in every
             * internal-perimeter/internal-circumfrence. 
             * For a circle with radius M, where M > n+1
             * This causes pointsOnInternalCircumfrence(n) = pointsOnInternalCircumfrence(n+1)
             * even though areaOfInternalCircle(n) < areaOfInternalCircle(n + 1)
             
             * 
             */
            
            
            do
            {
                randomX = helper.getRandom(circle.getRadius().getLength());
                randomY = helper.getRandom(circle.getRadius().getLength());
            }
            while(!isWithinCircleBoundary(circle, randomX, randomY));
            
            
            randomPoint = new Point(randomX, randomY);
            
            randomPoint = this.assignRandomQuadrant(randomPoint);
            
            randomPoint = this.formatRandomPointPosition(circle.getCenter(), randomPoint);
        }
        catch(Exception ex)
        {
            LOG.error("Error generating random point");
            helper.PrintExceptionStack(ex);
        }
        
        return randomPoint;
    }
    
    private boolean isWithinCircleBoundary(Circle circle, float randomX, float randomY)
    {
        try
        {
            if(helper.getRightTriangleHypotenuse(randomX, randomY) <=
                    circle.getRadius().getLength())
                return true;
            else
                return false;
        }
        catch(Exception ex)
        {
            LOG.error("Error checking if the point is within the circle boundary");
            helper.PrintExceptionStack(ex);
            return false;
        }
    }
    
    private Point assignRandomQuadrant(Point randomPoint)
    {
        try
        {   
            switch(Enums.getRandomQuadrant())
            {
                case FIRST:
                    break;
                case SECOND:
                    randomPoint.setY(randomPoint.getY() * (-1));
                    break;
                case THIRD:
                    randomPoint.setX(randomPoint.getX() * (-1));
                    randomPoint.setY(randomPoint.getY() * (-1));
                    break;
                case FOURTH:
                    randomPoint.setX(randomPoint.getX() * (-1));
                    break;
                default:
                    break;
            }   
        }
        catch(Exception ex)
        {
            LOG.error("Error assigning random quadrant");
            helper.PrintExceptionStack(ex);
        }
        
        return randomPoint;
    }
    
    private Point formatRandomPointPosition(Point circleCenter, Point randomPoint)
    {
        try
        {
            randomPoint.setX(randomPoint.getX() + circleCenter.getX());
            randomPoint.setY(randomPoint.getY() + circleCenter.getY());
        }
        catch(Exception ex)
        {
            LOG.error("Error formatting random position");
            helper.PrintExceptionStack(ex);
        }
        
        return randomPoint;
    }

}
