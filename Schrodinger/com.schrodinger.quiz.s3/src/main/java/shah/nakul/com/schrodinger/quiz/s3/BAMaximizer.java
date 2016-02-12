/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3;

import shah.nakul.com.schrodinger.quiz.s3.entity.BAInput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAOutput;

/**
 *
 * @author lucky7user
 */
public interface BAMaximizer 
{
    BAOutput GetMaxBAPairScore(BAInput baInput) throws Exception;
}
