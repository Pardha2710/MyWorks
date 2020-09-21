package org.basketball;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a file name: ");
		System.out.flush();
		String filename = scanner.nextLine();
		File file = new File(filename);
		String readLine;
		Game[] gameList=new Game[4];
		int counter=0;
		
		try {
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      
		      while ((readLine = br.readLine()) !=null) { 
		    	  if(!(readLine.equals("ENDXXXXX")))
		    	  {
		    		  if(readLine.equals(""))
		    		  {
		    			  counter++;
		    			  continue;
		    		  }
		    		  else
		    		  {
		    			  String team1=readLine;
		    			  String team1Points=br.readLine();
		    			  
		    			  String[] str=team1Points.split(" ");
		    			  
		    			  int[] team1Pointsarr=new int[str.length];
		    			  
		    			  for(int i=0;i<str.length;i++)
		    			  {
		    				  team1Pointsarr[i]=Integer.parseInt(str[i]);
		    			  }
		    			  
		    			 
		    			  
		    			  String team2=br.readLine();
		    			  
		    			  String team2Points=br.readLine();
		    			  String[] str1=team2Points.split(" ");
		    			  
		    			  int[] team2Pointsarr=new int[str1.length];
		    			  
		    			  for(int i=0;i<str1.length;i++)
		    			  {
		    				  team2Pointsarr[i]=Integer.parseInt(str1[i]);
		    			  }
		    			  
		    			  
		    			 String dateof=br.readLine();
		    				
		    			 System.out.println(team1+","+Arrays.toString(team1Pointsarr)+","+team2+","+Arrays.toString(team2Pointsarr)+","+
		    			 dateof);
		    			 for(int i=0;i<gameList.length;i++)
		    			 {
		    				 gameList[i]=new Game(team1,team1Pointsarr,team2,team2Pointsarr,dateof);
		    			 }   			  
		    		  }
		    	  }
		    	  else
		    	  {
		    		  break;
		    	  }
		       
		      } // end while
		      printGames(gameList,gameList.length);
		    } // end try
		    catch (Exception e) {
		      System.err.println("Error Happened: " + e);
		    }
		
	}
	public static void printGames(Game[] game ,int n)
	{
		
	}
			

}
