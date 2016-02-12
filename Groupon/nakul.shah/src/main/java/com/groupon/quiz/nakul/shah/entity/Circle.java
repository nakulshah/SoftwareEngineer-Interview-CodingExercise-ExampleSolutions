/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.entity;

/**
 *
 * @author lucky7user
 */
public class Circle extends Shape
{
    Point center;
    Radius radius;

    public Circle(Point center, Radius radius) 
    {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() 
    {
        return center;
    }

    public Radius getRadius() 
    {
        return radius;
    }

    @Override
    public String toString() 
    {
        return "Circle{" + "center=" + center + ", radius=" + radius + '}';
    }
    
    
}