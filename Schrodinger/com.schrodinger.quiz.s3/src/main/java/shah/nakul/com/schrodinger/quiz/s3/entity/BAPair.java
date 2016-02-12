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
public class BAPair 
{
    Protein protein;
    Drug drug;
    double baScore;

    public BAPair(Protein protein, Drug drug, double baScore) 
    {
        this.protein = protein;
        this.drug = drug;
        this.baScore = baScore;
    }

    @Override
    public String toString() 
    {
        return "BAPair{" + "protein=" + protein.name + ", drug=" + drug.name + ", baScore=" + baScore + '}';
    }
    
    
}
