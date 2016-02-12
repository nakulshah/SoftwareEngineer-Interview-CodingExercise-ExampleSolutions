/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shah.nakul.com.schrodinger.quiz.s3.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import shah.nakul.com.schrodinger.quiz.s3.common.Enums.ITEMTYPE;

/**
 *
 * @author lucky7user
 */
public class BAInput 
{
    Drug[] drugs;
    Protein[] proteins;
    private int drugsCount = 0;
    private int proteinsCount = 0;

    public BAInput(int maxCount) 
    {
        drugs = new Drug[maxCount];
        proteins = new Protein[maxCount]; 
    }
    
    public BAInput(String proteinsFileAddress, String drugsFileAddress) throws FileNotFoundException, IOException 
    {
        //using the helper function for this will lead to creating duplicate arrays
        //although using the helper function is the cleaner way to code
        //in case of very large data it may slow down the performance
        //so a choice is made of reading the file in this class itself
        
        proteins = new Protein[GetFileItemCount(proteinsFileAddress)];
        drugs = new Drug[GetFileItemCount(drugsFileAddress)];
        
        PopulateItems(proteinsFileAddress, ITEMTYPE.PROTEIN);
        PopulateItems(drugsFileAddress, ITEMTYPE.DRUG);
    }
    
    
    public Drug GetDrug(int index)
    {
        return drugs[index];
    }
    
    public Protein GetProtein(int index)
    {
        return proteins[index];
    }
    
    public void AddDrug(Drug drug)
    {
        drugs[drugsCount] = drug;
        drugsCount ++;
    }
    
    public void AddProtein(Protein protein)
    {
        proteins[proteinsCount] = protein;
        proteinsCount ++;
    }

    public int GetDrugsCount() 
    {
        return drugsCount;
    }

    public int GetProteinsCount() 
    {
        return proteinsCount;
    }
    
    private int GetFileItemCount(String fileAddress) throws FileNotFoundException, IOException
    {
        LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(fileAddress)));
        lnr.skip(Long.MAX_VALUE);
        return (lnr.getLineNumber() + 1);
    }
    
    private void PopulateItems(String fileAddress, ITEMTYPE itemType) throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileAddress)); 
        
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        if(ITEMTYPE.PROTEIN == itemType)
        {
            while (line != null) 
            {
                Protein pro = new Protein(line);
                this.AddProtein(pro);
                
                line = br.readLine();
            }
        }
        else
        {
            while (line != null) 
            {
                Drug drg = new Drug(line);
                this.AddDrug(drg);
                
                line = br.readLine();
            }
        }
    }
}
