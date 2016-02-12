/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAInput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAOutput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAPair;
import shah.nakul.com.schrodinger.quiz.s3.entity.Drug;
import shah.nakul.com.schrodinger.quiz.s3.entity.Protein;
import shah.nakul.com.schrodinger.quiz.s3impl.BAMaximizerImpl;

/**
 *
 * @author lucky7user
 */
public class BAMaximizerTest {
    
    BAInput baInput;
    BAOutput baOutput;
    BAMaximizer baMaximizer = new BAMaximizerImpl();
    
    public BAMaximizerTest() 
    {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestBAMaximizer() 
     {
         baInput = new BAInput(5);
         
         Protein pro1 = new Protein("TPHE39A");
         baInput.AddProtein(pro1);
         Drug drg1 = new Drug("Lipitor");
         baInput.AddDrug(drg1);
         
         Protein pro2 = new Protein("Z0-1");
         baInput.AddProtein(pro2);
         Drug drg2 = new Drug("Actos");
         baInput.AddDrug(drg2);
         
         Protein pro3 = new Protein("ACC2");
         baInput.AddProtein(pro3);
         Drug drg3 = new Drug("Zosyn");
         baInput.AddDrug(drg3);
         
         try
         {
             baOutput = baMaximizer.GetMaxBAPairScore(baInput);
             
             for(BAPair baPair : baOutput.GetBaPairs())
             {   
                System.out.println(baPair);
             }
             assertTrue((20 == baOutput.GetTotalBA()));
         }
         catch(Exception ex)
         {
             assertTrue(false);
         }
     }
}
