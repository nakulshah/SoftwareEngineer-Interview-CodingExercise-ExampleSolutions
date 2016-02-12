/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3.helperimpl;

import shah.nakul.com.schrodinger.quiz.s3.common.Enums;
import shah.nakul.com.schrodinger.quiz.s3.helper.Helper;
import shah.nakul.com.schrodinger.quiz.s3.thirdparty.HungarianAlgorithm;

/**
 *
 * @author lucky7user
 */
public class HelperImpl implements Helper
{
    private final String MIN = "min";
    private final String MAX = "max";
    
    public int GetVowelsCount(String word) 
    {
        int vowelCount = 0;
        
        word = word.toLowerCase();
        for(char c : word.toCharArray())
        {
            if(IsVowel(c))
                vowelCount ++;
        }
        
        return vowelCount;
    }

    public int GetConsonantsCount(String word) 
    {
        int consonantCount = 0;
        
        word = word.toLowerCase();
        for(char c : word.toCharArray())
        {
            if(IsConsonant(c))
                consonantCount ++;
        }
        
        return consonantCount;
    }

    public boolean HasCommonFactor(int a, int b) 
    {         
        //assumption if a and b both are 1, then no divisor as 1 is not considered
        //as a divisor as per the problem statement
        
        int small;
        int big;
        
        if(a > b)
        {
            big = a;
            small = b;
        }
        else
        {
            big = b;
            small = a;
        }
        
        for(int i = 2; i <= small; i ++)
        {
            if((big%i == 0) && (small%i == 0))
                return true;
        }
        
        return false;
    }

    public boolean IsVowel(char c) 
    {
        return "aeiou".indexOf(c) != -1;
    }

    public boolean IsConsonant(char c) 
    {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }

    public double[][] RunMaximizationAlgorithm(double[][] scores, Enums.SUMTYPE sumType) 
    {
        String strSumType = MIN;
        
        if(Enums.SUMTYPE.MAX == sumType)
            strSumType = MAX;
        
        return HungarianAlgorithm.hgAlgorithm(scores, strSumType);
    }

    
}
