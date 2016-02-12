/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.groupon.quiz.nakul.shah.redis;

/**
 *
 * @author lucky7user
 */
public interface GrouponRedis 
{
    void Set(Object key, String value);
    String Get(Object key);
    int Delete(Object ... key);
    String[] Keys(String search);
}
