/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.the.project.mine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Write a function that identifies the restaurants getting the most orders in each city.
 * The function 'getTopPerformers' should return a list of restaurants, each of
 * which must have a number of orders higher than the average order-count-per-restaurant
 * in the same city. A supporting interface and definition for RestaurantInfo are
 * provided as a starting point.
 *
 * @author Nakul Shah
 */
public class RestaurantFinder
{
    /**
     * For example, given the following inputs:
        RestaurantInfo(1, 100, 1)
        RestaurantInfo(2, 200, 1)
        RestaurantInfo(3, 100, 1)
        RestaurantInfo(4, 400, 2)
        RestaurantInfo(5, 200, 2)
        RestaurantInfo(6, 400, 2)
     * The getTopPerformers should return
     * RestaurantInfo objects for restaurant ID's 2, 4, and 6.
     * Restaurant 2 has more orders than the average in city 1 (133.3),
     * restaurants 4&6 have more orders than the average in city 2 (333.3).
     *
     * @param restaurants = list of restaurants
     * @return only the above average (top) performers
     * 
     * ASSUMPTION: 
     * 1)Two restaurants in different cities could have the same restaurant id
     * 2)The problem statement states that we want restaurants performing more orders
     * than average. In that case, if there is only one restaurant in a city, then
     * its performance will be equal to the average, hence this restaurant will not
     * be listed
     * @throws java.lang.Exception
     */
    public List getTopPerformers(List restaurants) throws Exception
    {
        try
        {
            List<RestaurantInfo> topPerformers = new ArrayList<RestaurantInfo>();

            Map<Integer, CityInfo> cityAverage = getCityAverages(restaurants);

            for (Map.Entry entry : cityAverage.entrySet()) 
            {     
                CityInfo cityInfo = (CityInfo)entry.getValue();

                topPerformers.addAll(cityInfo.getHighPerformanceRestaurants());
            }

            return topPerformers;
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    private Map getCityAverages(List restaurants) throws Exception
    {
        try
        {
            HashMap<Integer, CityInfo> cityAverage = new HashMap<Integer, CityInfo>();

            CityInfo cityInfo = null;

            for (Object obj : restaurants)
            {
                RestaurantInfo restaurantInfo = (RestaurantInfo)obj;

                if(null != restaurantInfo)
                {
                    cityInfo = cityAverage.get(restaurantInfo.getCityId());

                    if(null == cityInfo)
                    {
                        cityInfo = new CityInfo(restaurantInfo.getCityId(), restaurantInfo);
                        cityAverage.put(restaurantInfo.getCityId(), cityInfo);
                    }
                    else
                    {
                        cityInfo.addRestaurant(restaurantInfo);
                        cityAverage.put(restaurantInfo.getCityId(), cityInfo);
                    }
                }
            }

            return cityAverage;
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

}
