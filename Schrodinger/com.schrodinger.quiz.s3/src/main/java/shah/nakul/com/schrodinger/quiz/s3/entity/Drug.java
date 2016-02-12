/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3.entity;

import shah.nakul.com.schrodinger.quiz.s3.helper.Helper;
import shah.nakul.com.schrodinger.quiz.s3.helperimpl.HelperImpl;

/**
 *
 * @author lucky7user
 */
public class Drug extends Item
{
    private final int consonantsCount;
    private final int vowelsCount;
    

    public Drug(String name) 
    {
        super(name);
        vowelsCount = helper.GetVowelsCount(name);
        consonantsCount = helper.GetConsonantsCount(name);
    }

    public int GetConsonantsCount() 
    {
        return consonantsCount;
    }

    public int GetVowelsCount() 
    {
        return vowelsCount;
    }
    
    
}
