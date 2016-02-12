/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.helper;

/**
 *
 * @author lucky7user
 */
public interface Helper 
{
    float getRandom(float maxValue);
    float getRandom(float start, float end);
    float getSquare(float number);
    float getSquareRoot(float number);
    float getRightTriangleSide(float hypotenuse, float side);
    float getRightTriangleHypotenuse(float side1, float side2);
    float getRightTriangleOppositeSide(float hypotenuse, float theta);
    float getRightTriangleAdjacentSide(float hypotenuse, float theta);
    public void PrintExceptionStack(Exception ex);
    public void PrintExceptionStack2(Exception ex);
    
    /*
     *Some of the functions were added for approaches which did not work
     *Such could be taken out of Production code base, but I am including it 
     *because those generic helper functions can be used to build other solutions 
     * 
     */
}
