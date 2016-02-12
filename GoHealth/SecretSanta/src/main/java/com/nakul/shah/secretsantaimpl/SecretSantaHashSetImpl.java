/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakul.shah.secretsantaimpl;

import com.nakul.shah.secretsanta.SecretSanta;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author V506617
 */
public class SecretSantaHashSetImpl implements SecretSanta
{   
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
        
        String[] santas = new String[participants.length];
        if(participants.length == 2)
        {
            if(participants[1].equalsIgnoreCase(participants[0]))
                throw new IllegalArgumentException("Duplicate participants are not supported");
                
            santas[0] = participants[1];
            santas[1] = participants[0];
            
            return santas;
        }
        else
        {
            try
            {
                HashSet<String> fromBag = populateSantaBag(participants);

                boolean lastParticipantAssigned = false;

                for(int i = 0; i < participants.length; i ++)
                {     
                    Iterator<String> fromIterator = fromBag.iterator();
                    while(fromIterator.hasNext())
                    {
                        String from = fromIterator.next();

                        if(!participants[i].equalsIgnoreCase(from))
                        {
                            if(from.equalsIgnoreCase(participants[participants.length - 1]))
                                lastParticipantAssigned = true;
                            
                            //covering a case in which last element is left in the
                            //bag and it corresponds to the last participant
                            if((i == participants.length - 2) && (lastParticipantAssigned == false))
                            {
                                santas[i+1]=from;
                                santas[i]= fromIterator.next();
                                
                                return santas;
                            }
                            else
                            {
                                santas[i] = from;
                                fromIterator.remove();
                                break;
                            }
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
    
    private HashSet<String> populateSantaBag(String[] participants)
    {
        HashSet<String> fromBag = new HashSet<String>();
        try
        {
            for(String particiant : participants)
            {
                if((particiant == null) || (particiant.isEmpty()))
                        throw new IllegalArgumentException("Null or empty participant names are not supported");
                
                if(fromBag.contains(particiant))
                {
                    throw new IllegalArgumentException("Duplicate participants are not supported");
                }
                else
                {
                    fromBag.add(particiant);
                }
            }   
        }
        catch(Exception ex)
        {
            throw ex;
        }
        //System.out.println("Bag: " + fromBag);
        return fromBag;
    }
    
}
