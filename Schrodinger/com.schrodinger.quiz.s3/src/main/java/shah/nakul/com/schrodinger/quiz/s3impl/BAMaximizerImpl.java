/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3impl;

import shah.nakul.com.schrodinger.quiz.s3.BAMaximizer;
import shah.nakul.com.schrodinger.quiz.s3.common.Enums;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAInput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAOutput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAPair;
import shah.nakul.com.schrodinger.quiz.s3.entity.Drug;
import shah.nakul.com.schrodinger.quiz.s3.entity.Protein;
import shah.nakul.com.schrodinger.quiz.s3.helper.Helper;
import shah.nakul.com.schrodinger.quiz.s3.helperimpl.HelperImpl;

/**
 *
 * @author lucky7user
 */
public class BAMaximizerImpl implements BAMaximizer
{
    private final double VOWELMULTIPLIER = 2;
    private final double CONSONANTMULTIPLIER = 2.5;
    private final double FACTORBONUS = 1.25;
    final Helper helper = new HelperImpl();
    

    public BAOutput GetMaxBAPairScore(BAInput baInput) throws Exception
    {
        BAOutput baOutput = null;
        
        if(baInput.GetDrugsCount() != baInput.GetProteinsCount())
        {
            throw new Exception("Number of Proteins not equal to number of Drugs"); 
        }
        else
        {
            double[][] baScoreMatrix = new double[baInput.GetProteinsCount()][baInput.GetDrugsCount()];
            for(int i = 0; i < baInput.GetProteinsCount(); i ++)
            {
                for(int j = 0; j < baInput.GetDrugsCount(); j ++)
                {
                    baScoreMatrix[i][j] = GetBAScore(baInput.GetProtein(i), baInput.GetDrug(j));
//                    System.out.print(baScoreMatrix[i][j] + "   "); 
                      //normally standard logger such as log4j should have been used, 
                      //but for the sake of this project, minimizing external dependencies 
                }
//                System.out.println();
            }
            
            double[][]maxBAScores = helper.RunMaximizationAlgorithm(baScoreMatrix, Enums.SUMTYPE.MAX);
            
//            System.out.println("<<<>>>");
            
            baOutput = new BAOutput(maxBAScores.length);
            
            for (double[] maxBAScore : maxBAScores) 
            {
                BAPair paPair = new BAPair(baInput.GetProtein((int)maxBAScore[0]), 
                        baInput.GetDrug((int)maxBAScore[1]), maxBAScore[2]);
                
                baOutput.AddBAPair(paPair);
                
//                System.out.print(maxBAScore[0] + "   ");
//                System.out.print(maxBAScore[1] + "   ");
//                System.out.print(maxBAScore[2] + "   ");
//                System.out.println();
            }
        }
        
        return baOutput;
    }
    
    private double GetBAScore(Protein protein, Drug drug)
    {
        double score = 0;
        
        if(protein.IsLengthEven())
            score = drug.GetVowelsCount() * VOWELMULTIPLIER;
        else
            score = drug.GetConsonantsCount() * CONSONANTMULTIPLIER;
        
        if(protein.HasCommonFactor(drug))
            score = score*FACTORBONUS;
            
        return score;
    }

}
