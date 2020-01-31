/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportantAssignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author uzairleo
 */
class counting {

    public static void main(String[] args) 
    {
        try
        {
        File file = new File("/home/uzairleo/Desktop/leo.txt"); 
        FileInputStream fileStream = new FileInputStream(file); 
        InputStreamReader input = new InputStreamReader(fileStream); 
        BufferedReader reader = new BufferedReader(new FileReader ("/home/uzairleo/Desktop/leo.txt")); 
      Scanner readFile=new Scanner(file);
      char ch;
      int count=0;
      int a=0,e=0,ii=0,o=0,u=0;
      int consonants=0;
      int sentence=0;
       String data="";
     while(readFile.hasNextLine()){
      data = readFile.nextLine();
      for(int i = 0; i<data.length(); i++)
      {
        ch = data.charAt(i);
       
//        if((ch == 'a'|| ch=='e')||(ch == 'i'|| ch=='o')|| (ch=='u') )
//            
//            
//        {          count++;
//        }//end for
            switch(ch)
            {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    ii++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
                case '.':
                case ',':
                case '!':
                    sentence++;
                break;
                default:
                    consonants++;
                
            }
          
      }
     }
      count=a+e+ii+o+u;
      System.out.println("Total number of a is "+a);
      System.out.println("Total number of e is "+e);
      System.out.println("Total number of i is "+ii);
      System.out.println("Total number of o is "+o);
      System.out.println("Total number of u is "+u);
      
      System.out.println("Total number of Vowel is "+count);
      
      System.out.println("Total number of consonant is "+consonants);
         System.out.println("Total Length "+ (data.length()));
         
      System.out.println("Total number of sentence is "+ (sentence-1));
//  scan.close();
  
//        String line;
//        // Initializing counters 
//        int countWord = 0; 
//        int sentenceCount = 0; 
//        int characterCount = 0; 
//        int paragraphCount = 1; 
//        int whitespaceCount = 0; 
//          
//        // Reading line by line from the  
//        // file until a null is returned 
//        while((line = reader.readLine()) != null) 
//        { 
//            
//            if(line.equals("")) 
//            { 
//                paragraphCount++; 
//            } 
//            if(!(line.equals(""))) 
//            { 
//                characterCount += line.length(); 
//                // \\s+ is the space delimiter in java 
//                String[] wordList = line.split("\\s+"); 
//                  
//                countWord += wordList.length; 
//                whitespaceCount += countWord -1; 
//                  
//                // [!?.:]+ is the sentence delimiter in java 
//                String[] sentenceList = line.split("[!?.:]+"); 
//                  
//                sentenceCount += sentenceList.length; 
//            } 
//        } 
//          
//        System.out.println("Total word count = " + countWord); 
//        System.out.println("Total number of sentences = " + sentenceCount); 
//        System.out.println("Total number of characters = " + characterCount); 
//        System.out.println("Number of paragraphs = " + paragraphCount); 
//        System.out.println("Total number of whitespaces = " + whitespaceCount); 
//        
//        
//        String sentence=reader.readLine();
//                   while(sentence!=null)
//        {
//            System.out.println(sentence);
//            sentence=reader.readLine();
//            
//                   
//        } 
////        
//      
        
        
        }
catch(Exception ex)
        {
            System.out.println("error occured");   
        }
    }
}
