/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.common;

import com.groupon.quiz.nakul.shah.helper.Helper;

/**
 *
 * @author lucky7user
 */
public class Enums 
{
    static Helper helper;
    
    public void setHelper(Helper helper) {
        Enums.helper = helper;
    }
    
    public enum Quadrant 
    {
        FIRST, SECOND, THIRD, FOURTH;
    }
    
    public static Quadrant getRandomQuadrant()
    {
        return Quadrant.values()[(int)Math.floor(helper.getRandom(Constants.ZERO, Constants.FOUR))];
    }
}
