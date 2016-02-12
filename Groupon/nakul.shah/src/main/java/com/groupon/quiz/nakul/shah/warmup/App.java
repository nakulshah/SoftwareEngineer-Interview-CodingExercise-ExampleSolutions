package com.groupon.quiz.nakul.shah.warmup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Hello world!
 * 
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        //create an 1 D array of int
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //dateFormat.parse(dateFormat.format(new Date()));
        System.out.println(dateFormat1.parse(dateFormat.format(new Date())));
        
         dateFormat1.setTimeZone(TimeZone.getTimeZone("UTC"));
                System.out.println(dateFormat1.parse("07-03-2014 03:25:29"));
        System.out.println(new Date());
        
        
        
        
        int MAX = 20;
        int[] intArray = new int[MAX];
        
        //traverse a 1d array
        for(int i = 0; i < MAX; i++)
        {
            intArray[i] = i;
        }
        
        for(int i = 0; i < MAX; i++)
        {
            System.out.println( "Hello: " + intArray[i] );
        }
        
        //convert an array into list
        List<Integer> intArrayList = new ArrayList<Integer>();
        
        for(int i = 0; i < MAX; i++)
        {
            intArrayList.add(intArray[i]);
        }
        
        List<Integer> tempIntArrayList = new ArrayList<Integer>();
        
        for(Integer i : intArrayList)
        {
            Integer i1 =  i;
            
            i1 = i1 * 2;
            
            tempIntArrayList.add(i1);  
        }
        
        intArrayList = tempIntArrayList;
        
        //traverse a list
        for(Integer i : intArrayList)
        {
            System.out.println( "Hello: " + i );
        }
        
        //convert a list into array
        for(int i = 0; i < MAX; i++)
        {
           intArray[i] = (int)intArrayList.get(i);
        }
        
        for(int i = 0; i < MAX; i++)
        {
            System.out.println( "Hello: " + intArray[i] );
        }
        
        ArrayList<String> stock_list = new ArrayList<String>();
        stock_list.add("stock1");
        stock_list.add("stock2");
        String[] stockArr = new String[stock_list.size()];
        stockArr = stock_list.toArray(stockArr);
        for(String s : stockArr)
            System.out.println(s);
        
        //create a 2 d array of int and string
        
        //create a hashmap
        Map<Integer, String> mapIntStr = new HashMap<Integer, String>();
        
        for(int i = 0; i < MAX; i++)
        {
            mapIntStr.put(i, "Hello: " + String.valueOf(i));
        }
        
        
        //traverse a hashmap
        for(Map.Entry mapEntry : mapIntStr.entrySet())
        {
            System.out.println( "Key: " + mapEntry.getKey() + ", Value: " + mapEntry.getValue());
        }
        
        //fibonacci
        int find = 1;
        int follow = 0;
        int fibo = find + follow;
        
        System.out.println( "fibo: " + fibo);
        
        while(fibo < MAX)
        {
            follow = find;
            find = fibo;
            fibo = find + follow;
            
            System.out.println( "fibo: " + fibo);
        }
        
        for(int i = 1; i < MAX; i++)
            for(int j = 1; j < MAX/2; j++)
                for(int k = 1; k < MAX/3; k++)
                    for(int l = 1; l < MAX/4; l++)
                        if(i + j + k + l == MAX)
                            System.out.println(i + ", " + j + ", " + k + ", " + l);
        
        String whiteSpaces = "Hello World how are you?";
        String noWhiteSpaces = whiteSpaces.replace(" ", "");
        
        System.out.println( "whiteSpaces: " + whiteSpaces);
        System.out.println( "noWhiteSpaces: " + noWhiteSpaces);           
        
        //traverse a 2 d array
        
        String string = "ABBAPQRRQPABAA";
        
        String reducedString; // = removeFirstPair(string);
        
        int pairCount = 0;
        
        do
        {
            System.out.println( "string: " + string);
          
            reducedString = removeFirstPair(string);
            
            System.out.println( "reducedString: " + reducedString);
            
            if(reducedString.equals(string))
                break;
            else
            {
                pairCount++;
                string = reducedString;
            }
        }while(true);
        
        System.out.println( "pairCount: " + pairCount); 
        
        
        
        Printable print1 = new Printable("one");
        Printable print2 = new Printable("two");
    
        Thread thread1 = new Thread(print1);
        Thread thread2 = new Thread(print2);
        
        thread1.start();
        thread2.start();
        
        boolean yes = true;
        boolean no = false;
        
        System.out.println(yes & no); 
        System.out.println(yes && no); 
        System.out.println(yes & yes); 
        System.out.println(yes && yes); 
        System.out.println(no & no); 
        System.out.println(no && no); 
        
    }
    
    
    public static void permutation(String str) 
    { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) 
    {
        int n = str.length();
        
        if (n == 0) 
            System.out.println(prefix);
        else 
        {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
    
    static String removeFirstPair(String string)
    {
        String toReturn = string;
        char find;
        char follow;
        
        char[] chrArray = string.toCharArray();
        
        int pairLocation = 1;
        
        boolean pairFound = false;
        
        for(pairLocation = 1; pairLocation < chrArray.length; pairLocation++)
        {
            follow = chrArray[pairLocation - 1];
            find = chrArray[pairLocation];
            
            if(follow == find)
            {
                pairFound = true;
                break;
            }
        }
        
        if(true == pairFound)
        {
            toReturn = string.substring(0, pairLocation - 1) 
                    + string.substring(pairLocation + 1);
        }
        
        return toReturn;
    }
    
    
}

class Printable implements Runnable
{
    String name;

    public Printable(String name) 
    {
        this.name = name;
    }
    
    
    @Override
    public void run() 
    {
        for(int i = 0; i < 11; i++)
            System.out.println(this.name + ": " + i);
    }
    
}
