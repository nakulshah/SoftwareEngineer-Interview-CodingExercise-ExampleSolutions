/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.the.project.mine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nakul Shah
 */
public class CityInfo
{
    private int totalOrders;
    private ArrayList listRestaurants;
    private ArrayList listHighPerformanceRestaurants;
    private ArrayList listLowPerformanceRestaurants;
    private final int cityId;
    private boolean sorted = false;

    private static final int ZERO = 0;


    public CityInfo(int cityId, RestaurantInfo cityRestaurant) throws Exception
    {
        try
        {
            this.cityId = cityId;

            if(null == listRestaurants)
                listRestaurants = new ArrayList();

            listRestaurants.add(cityRestaurant);
            this.totalOrders = cityRestaurant.getOrderCount();
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }


    public void addRestaurant(RestaurantInfo cityRestaurant)
    {
        this.totalOrders = this.totalOrders + cityRestaurant.getOrderCount();
        
        //if(validateNewRestaurant(cityRestaurant)) //decision: performance vs complexity vs accuracy 
            listRestaurants.add(cityRestaurant);

        sorted = false;
    }

    public int getCityId()
    {
        return cityId;
    }

    private int getAverage()
    {
        if(listRestaurants.size() > 0)
            return (totalOrders/listRestaurants.size());
        else
            return ZERO;
    }

    public List getHighPerformanceRestaurants() throws Exception
    {
        if(false == sorted)
            sort();

        return this.listHighPerformanceRestaurants;
    }

    //we can also expand the functionality to get low performance restaurants

    private void sort() throws Exception
    {
        try
        {
            if(listRestaurants.size() > 0)
            {
                int cityAverage = this.getAverage();

                listHighPerformanceRestaurants = new ArrayList();
                listLowPerformanceRestaurants = new ArrayList();

               for (Object obj : listRestaurants)
               {
                   RestaurantInfo cityRestaurant = null;
                   try
                   {
                       cityRestaurant = (RestaurantInfo)obj;
                   }
                   catch(Exception ex)
                   {
                       //just log the ex
                   }

                   if(null != cityRestaurant)
                   {
                       if(cityAverage < cityRestaurant.getOrderCount())
                           listHighPerformanceRestaurants.add(cityRestaurant);
                       else
                           listLowPerformanceRestaurants.add(cityRestaurant);
                   }
               }

               sorted = true;
            }
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    //Assumption: we need to validate the input to disregard any duplicate entries
    //for the same restaurant in the same city
    //it is a tradeoff between performance vs accuracy 
    //or we can use a map if it is required. 
    //The possibilities are endless, I want to make sure I dont over complicate things
    private boolean validateNewRestaurant(RestaurantInfo newRestaurant)
    {
        for (Object obj : listRestaurants)
        {
            RestaurantInfo restaurantInfo = (RestaurantInfo)obj;

            if(newRestaurant.getRestaurantId() == restaurantInfo.getRestaurantId())
            {
                return false;
            }
        }
        
        return true;
    }

}
