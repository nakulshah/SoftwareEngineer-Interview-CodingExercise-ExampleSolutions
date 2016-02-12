package com.the.project.mine;

import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     *  RestaurantInfo(1, 100, 1)
        RestaurantInfo(2, 200, 1)
        RestaurantInfo(3, 100, 1)
        RestaurantInfo(4, 400, 2)
        RestaurantInfo(5, 200, 2)
        RestaurantInfo(6, 400, 2)
     */
    public void testGetTopPerformers() throws Exception
    {
        System.out.println("---------testGetTopPerformers------------");
        
        RestaurantFinder rf = new RestaurantFinder();
        ArrayList listRestaurants = new ArrayList();
        
        ArrayList topPerformerRestaurants;
        
        listRestaurants.add(new RestaurantInfo(1, 100, 1));
        listRestaurants.add(new RestaurantInfo(2, 200, 1));
        listRestaurants.add(new RestaurantInfo(3, 100, 1));
        listRestaurants.add(new RestaurantInfo(4, 400, 2));
        listRestaurants.add(new RestaurantInfo(5, 200, 2));
        listRestaurants.add(new RestaurantInfo(6, 400, 2));
        
        topPerformerRestaurants = (ArrayList) rf.getTopPerformers(listRestaurants);
        
        for (Object obj : topPerformerRestaurants)
        {
            RestaurantInfo restaurantInfo = (RestaurantInfo)obj;

            if(null != restaurantInfo)
            {
                System.out.println("---------------------");
                
                System.out.println("restaurantInfo.getRestaurantId()=" + restaurantInfo.getRestaurantId());
                System.out.println("restaurantInfo.getOrderCount()=" + restaurantInfo.getOrderCount());
                System.out.println("restaurantInfo.getCityId()=" + restaurantInfo.getCityId());
                
            }
        }
        
        assertTrue( true );
    }
    
    public void testGetMyTopPerformers() throws Exception
    {
        
        System.out.println("---------testGetMyTopPerformers------------");
        
        RestaurantFinder rf = new RestaurantFinder();
        ArrayList listRestaurants = new ArrayList();
        
        ArrayList topPerformerRestaurants;
        
        listRestaurants.add(new RestaurantInfo(32, 300, 3));
        listRestaurants.add(new RestaurantInfo(31, 100, 2));
        listRestaurants.add(new RestaurantInfo(33, 1000, 2));
        listRestaurants.add(new RestaurantInfo(14, 101, 2));
        listRestaurants.add(new RestaurantInfo(25, 200, 4));
        listRestaurants.add(new RestaurantInfo(34, 0, 3));
        
        topPerformerRestaurants = (ArrayList) rf.getTopPerformers(listRestaurants);
        
        for (Object obj : topPerformerRestaurants)
        {
            RestaurantInfo restaurantInfo = (RestaurantInfo)obj;

            if(null != restaurantInfo)
            {
                System.out.println("---------------------");
                
                System.out.println("restaurantInfo.getRestaurantId()=" + restaurantInfo.getRestaurantId());
                System.out.println("restaurantInfo.getOrderCount()=" + restaurantInfo.getOrderCount());
                System.out.println("restaurantInfo.getCityId()=" + restaurantInfo.getCityId());
                
            }
        }
        
        assertTrue( true );
    }
}
