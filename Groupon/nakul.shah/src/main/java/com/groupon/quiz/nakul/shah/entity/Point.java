/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.entity;

import com.groupon.quiz.nakul.shah.common.Constants;
import java.text.DecimalFormat;

/**
 *
 * @author lucky7user
 */
public class Point 
{
    float x;
    float y;
    DecimalFormat df = new DecimalFormat(Constants.TWO_DIGITS_DECIMAL_FORMAT);

    public Point(float x, float y) 
    {
        this.x = x;
        this.y = y;
    }

    public float getX() 
    {
        return x;
    }

    public void setX(float x) 
    {
        this.x = x;
    }

    public float getY() 
    {
        return y;
    }

    public void setY(float y) 
    {
        this.y = y;
    }

    @Override
    public String toString() 
    {
        return "Point{" + "x=" + df.format(x) + ", y=" + df.format(y) + '}';
    }

    
}
