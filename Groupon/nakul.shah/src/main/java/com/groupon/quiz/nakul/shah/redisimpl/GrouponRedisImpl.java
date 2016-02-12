/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.redisimpl;

import com.groupon.quiz.nakul.shah.redis.GrouponRedis;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucky7user
 */
public class GrouponRedisImpl implements GrouponRedis
{
    Map<String, String> redisMap = new HashMap<String, String>();
    
    String convertObjectToString(Object obj)
    {
        String toReturn;
        
        toReturn = obj.toString();
        
        return toReturn;
    }
    
    @Override
    public void Set(Object key, String value) 
    {
        redisMap.put(convertObjectToString(key), value);
    }

    @Override
    public String Get(Object key) 
    {
        return redisMap.get(convertObjectToString(key));
    }

    @Override
    public int Delete(Object... keys) 
    {
        int count = 0; 
        
        for(Object key : keys)
        {
            if(true == redisMap.containsKey(convertObjectToString(key)))
                redisMap.remove(convertObjectToString(key));
        }
        
        return count;
    }

    @Override
    public String[] Keys(String search) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
