package org.basketball;

public class Game {
	private String team1,team2,gameDate;
	private int team1Points[]=new int[4];
	private int team2Points[]=new int[4];
	public Game(String team1, int[] team1Points,String team2, int[] team2Points ,String gameDate) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.gameDate = gameDate;
		this.team1Points = team1Points;
		this.team2Points = team2Points;
	}
	
	
	public String toString() {
			
	      return this.team1+"\n"+this.team1Points+"\n"+this.team2+"\n"+this.team2Points+"\n"+this.gameDate+"\n";
	   }

}
