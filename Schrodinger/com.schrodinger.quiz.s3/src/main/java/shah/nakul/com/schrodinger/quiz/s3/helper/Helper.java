/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3.helper;

import shah.nakul.com.schrodinger.quiz.s3.common.Enums.SUMTYPE;

/**
 *
 * @author lucky7user
 */
public interface Helper 
{
    int GetVowelsCount(String word);
    int GetConsonantsCount(String word);
    boolean IsVowel(char c);
    boolean IsConsonant(char c);
    boolean HasCommonFactor(int a, int b);
    double[][] RunMaximizationAlgorithm (double[][] scores, SUMTYPE sumType);
}
