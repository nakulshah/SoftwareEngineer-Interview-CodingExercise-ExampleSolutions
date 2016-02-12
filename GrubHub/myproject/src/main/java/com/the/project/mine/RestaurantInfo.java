/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.the.project.mine;

/**
 *
 * @author Nakul Shah
 */
public class RestaurantInfo
{
    private final int restaurantId;
    private final int orderCount;
    private final int cityId;

    public RestaurantInfo(int restaurantId, int orderCount, int cityId)
    {
        this.restaurantId = restaurantId;
        this.orderCount = orderCount;
        this.cityId = cityId;
    }
    public int getRestaurantId()
    {
        return restaurantId;
    }
    public int getOrderCount()
    {
        return orderCount;
    }
    public int getCityId()
    {
        return cityId;
    }
}
