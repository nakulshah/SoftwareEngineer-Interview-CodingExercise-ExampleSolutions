/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3.entity;

/**
 *
 * @author lucky7user
 */
public class Protein extends Item
{   
    private boolean isLengthEven = false;

    public Protein(String name) 
    {
        super(name);
        
        if(this.nameLength % 2 == 0)
            isLengthEven = true;
    }
    
    public boolean IsLengthEven()
    {
        return isLengthEven;
    }
}
