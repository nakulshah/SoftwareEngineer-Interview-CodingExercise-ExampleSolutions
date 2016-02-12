/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.entity;

import com.groupon.quiz.nakul.shah.common.Constants;

/**
 *
 * @author lucky7user
 */
public class Radius 
{
    float length;

    public Radius(float length) throws Exception 
    {
        if(0 < length)
            this.length = length;
        else 
            throw new Exception(Constants.NO_NEGATIVE_OR_ZERO_RADIUS);
    }

    public float getLength() 
    {
        return length;
    }

    public void setLength(float length) 
    {
        this.length = length;
    }

    @Override
    public String toString() 
    {
        return "Radius{" + "length=" + length + '}';
    }
    
    
}
