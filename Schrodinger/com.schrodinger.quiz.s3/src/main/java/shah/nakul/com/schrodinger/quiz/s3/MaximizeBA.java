package shah.nakul.com.schrodinger.quiz.s3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAInput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAOutput;
import shah.nakul.com.schrodinger.quiz.s3.entity.BAPair;
import shah.nakul.com.schrodinger.quiz.s3impl.BAMaximizerImpl;

/**
 * Hello world!
 *
 */
public class MaximizeBA 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, Exception
    {
        System.out.println( "Hello Schrodinger World!" );
        
        int index;
        String proteinsFileAddress = null;
        String drugsFileAddress = null;

        for (index = 0; index < args.length; ++index)
        {
            
            
            if(args[index].toLowerCase().contains("-proteinsfile"))
            {
                proteinsFileAddress = args[index].split("=")[1];
                System.out.println("Proteins File Address = " + proteinsFileAddress);
            }
            else if(args[index].toLowerCase().contains("-drugsfile"))
            {
                drugsFileAddress = args[index].split("=")[1];
                System.out.println("Drugs File Address = " + drugsFileAddress);
            }
            else
            {
                System.out.println( "Invalid Input. Please use -DrugsFile & "
                        + " -ProteinsFile as input arguements. For Example"
                        + " -ProteinsFile=\"C:\\proteins.txt\" "
                        + "-DrugsFile=\"C:\\drugs.txt\"" );
                
                return;
            }
        }
        
        if((null != proteinsFileAddress) && (null != drugsFileAddress))
        {
            System.out.println( "<<<<<<<<<Result Summary - START>>>>>>>>>>" );

            java.util.Date startDate = new java.util.Date();
            System.out.println(new Timestamp(startDate.getTime()));

            BAInput baInput;
            BAOutput baOutput;
            BAMaximizer baMaximizer = new BAMaximizerImpl();

            baInput = new BAInput(proteinsFileAddress, drugsFileAddress);

            baOutput = baMaximizer.GetMaxBAPairScore(baInput);

            System.out.println("Total BA Score = " + baOutput.GetTotalBA());

            java.util.Date endDate = new java.util.Date();
            System.out.println(new Timestamp(endDate.getTime()));

            System.out.println("Computational Time Taken = " + (endDate.getTime() - startDate.getTime())
                            + " milli seconds");

            System.out.println( "<<<<<<<<<Result Summary - END>>>>>>>>>>" );

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Parings -- ");

            for(BAPair baPair : baOutput.GetBaPairs())
            {
                System.out.println(baPair);
            }
        
        }
        else
        {
            System.out.println( "Invalid Input. Please use -DrugsFile & "
                        + " -ProteinsFile as input arguements. For Example"
                        + " -ProteinsFile=\"C:\\proteins.txt\" "
                        + "-DrugsFile=\"C:\\drugs.txt\"" );
        }
        
        System.out.println( "Thank You" );
    }
}
