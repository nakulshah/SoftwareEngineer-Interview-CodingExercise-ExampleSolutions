/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakul.shah.secretsantaimpl;

import com.nakul.shah.secretsanta.SecretSanta;
import java.util.HashSet;
import java.util.Random;
/**
 *
 * @author V506617
 */
public class SecretSantaRandomImpl implements SecretSanta
{
    Random rnd = new Random();

    @Override
    public String[] generateAssignments(String[] participants)  
    {
        if((participants == null) || (participants.length == 0))
            throw new IllegalArgumentException("Null participants are not supported");
            
        if(participants.length == 1)
        {
            throw new IllegalArgumentException("If a single participant is supplied,"
                    + " then it will lead to self assignment");
        }
        
        if(!noDuplicates(participants))
            throw new IllegalArgumentException("Duplicate participants are not supported");
        
        String[] santas = new String[participants.length];
        if(participants.length == 2)
        {
            santas[0] = participants[1];
            santas[1] = participants[0];
            
            return santas;
        }
        else
        {
            try
            {
                for (int i = 0; i < santas.length; i++) 
                {
                    if((participants[i] == null) || (participants[i].isEmpty()))
                        throw new IllegalArgumentException("Null or empty participant names are not supported");
                    
                    santas[i] = participants[i];
                }
                
                santas = randomize(santas);
                
                for (int i = 0; i < santas.length; i++) 
                {
                    //for extra protection
                    if (!santas[i].equalsIgnoreCase(participants[i]))
                        continue;
                    
                    for (int j = 0; j < participants.length; j++) 
                    {
                        if ((!participants[i].equalsIgnoreCase(santas[j])) && (!participants[j].equalsIgnoreCase(santas[i]))) 
                        {
                            String placeholder = santas[i];
                            santas[i] = santas[j];
                            santas[j] = placeholder; 
                            break;
                        }
                    }
                }

                return santas;
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
    }
    
    private String[] randomize(String[] santas)
    {
        for(int i = santas.length - 1; i > 0 ; i--)
        {
            int random = rnd.nextInt(i);
            
            String placeholder = santas[i];
            santas[i] = santas[random];
            santas[random] = placeholder;            
        }
        
        return santas;              
    }
    
    private boolean noDuplicates(String[] assignments)
    {
        HashSet<String> checkSet = new HashSet<String>();
        
        for(String assignment : assignments)
        {
            if(checkSet.contains(assignment))
            {
                return false;
            }
            else
                checkSet.add(assignment);
        }
        
        return true;
    }
    
}
