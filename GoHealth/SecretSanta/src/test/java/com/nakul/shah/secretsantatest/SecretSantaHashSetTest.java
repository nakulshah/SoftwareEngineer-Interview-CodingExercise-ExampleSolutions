package com.nakul.shah.secretsantatest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nakul.shah.secretsanta.SecretSanta;
import com.nakul.shah.secretsantaimpl.SecretSantaHashSetImpl;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author V506617
 */
public class SecretSantaHashSetTest 
{
    private String[] participants = new String[] { "Kyle", "Kenny", "Eric", "Stan",
                                        "Stewie", "Brian"};
    
    private final String[] nullParticipants = null;
    
    private final String[] nullNameParticipants = new String[] { null, "", "Eric", "Stan",
                                        "Stewie", "Brian" };
    
    private final String[] singleParticipant = new String[] { "Kyle" };
    
    private SecretSanta secretSantaHashSet;

    
    public SecretSantaHashSetTest() 
    {
        secretSantaHashSet = new SecretSantaHashSetImpl();
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
    
    @Test
    //no person must be assigned to himself/herself
    public void noPersonToHimeself() 
    {
        
        for (int stress = 0; stress <= 100000; stress++)
        {
            String[] assignmentsHashSet = secretSantaHashSet.generateAssignments(participants);
            
            System.out.println("Assignment: " + Arrays.toString(assignmentsHashSet));

            for(int i = 0; i < assignmentsHashSet.length; i++)
            {
                if(assignmentsHashSet[i].equalsIgnoreCase(participants[i]))
                    fail("Voilation of Rule: no person must be assigned to himself/herself. "
                            + "Violation by " + assignmentsHashSet[i]);
            }
        
            if(!noDuplicates(assignmentsHashSet))
            {
                fail("Assignment has duplicates " + Arrays.toString(assignmentsHashSet));
                return;
            }
            
        }
        
        assertTrue(true);
    }
    
    @Test
    //All participants must have an assigned person from the passed list of participants
    public void allPersonFromPassedList() 
    {
        final String[] assignmentsHashSet = secretSantaHashSet.generateAssignments(participants);
        
        System.out.println("Assignment: " + Arrays.toString(assignmentsHashSet));
        
        for(String assignment : assignmentsHashSet)
        {
            boolean fromPassed = false;
            for(String participant : participants)
            {
                if(assignment.equalsIgnoreCase(participant))
                {
                    fromPassed = true;
                    break;
                }
            }
            
            if(!fromPassed)
                fail("Voilation of Rule: All participants must have an assigned person from the passed list of participants. ");
            else
                assertTrue(noDuplicates(assignmentsHashSet));
        }
    }
    
    @Test
    public void testNoNullSanta() 
    {
       final String[] assignments = secretSantaHashSet.generateAssignments(participants);

       for(int i = 0; i < participants.length; i++)
       {
          if(null == assignments[i])
          {
              fail();
              return;
          }

       }

       assertTrue(noDuplicates(assignments));
    }
    
    @Test
    //if the participants set is null, then throw an exception
    public void nullParticipants() 
    {
        try
        {
            secretSantaHashSet.generateAssignments(nullParticipants);
        }
        catch(Exception ex)
        {
            if(ex.getMessage().equalsIgnoreCase("Null participants are not supported"))
            {
                assertTrue(true);
            }
            else
            {
                fail("Expected exception was not raised");
            }
        }
    }
    
    @Test
    //if the participant name is null, then throw an exception
    public void nullParticipantName() 
    {
        try
        {
            secretSantaHashSet.generateAssignments(nullNameParticipants);
        }
        catch(Exception ex)
        {
            if(ex.getMessage().equalsIgnoreCase("Null or empty participant names are not supported"))
            {
                assertTrue(true);
            }
            else
            {
                fail("Expected exception was not raised");
            }
        }
    }
    
    @Test
    public void singleParticipant() 
    {
        try
        {
            secretSantaHashSet.generateAssignments(singleParticipant);
        }
        catch(Exception ex)
        {
            if(ex.getMessage().equalsIgnoreCase("If a single participant is supplied,"
                    + " then it will lead to self assignment"))
            {
                assertTrue(true);
            }
            else
            {
                fail("Expected eception was not raised");
            }
        }
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
