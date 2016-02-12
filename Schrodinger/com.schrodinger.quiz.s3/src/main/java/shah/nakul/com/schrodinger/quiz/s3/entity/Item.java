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
public class Item 
{
    String name;
    int nameLength;
    final Helper helper = new HelperImpl();

    public Item(String name) 
    {
        this.name = name;
        this.nameLength = name.length();
    }

    public int GetNameLength() 
    {
        return nameLength;
    }
    
    
    public boolean HasCommonFactor(Item item)
    {
        return helper.HasCommonFactor(nameLength, item.GetNameLength());
    }
}
