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
public class BAOutput 
{
    double totalBA;
    BAPair[] baPairs;
    private int baPairCount = 0;
    
    public BAOutput(int maxCount) 
    {
        baPairs = new BAPair[maxCount];
        totalBA = 0;
    }
    
    public BAPair GetDrug(int index)
    {
        return baPairs[index];
    }
    
    public void AddBAPair(BAPair baPair)
    {
        baPairs[baPairCount] = baPair;
        baPairCount ++;
        totalBA = totalBA + baPair.baScore;
    }

    public BAPair[] GetBaPairs() 
    {
        return baPairs;
    }

    public double GetTotalBA() 
    {
        return totalBA;
    }
    
    
}
