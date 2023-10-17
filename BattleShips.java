package grid01;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Random;


public class BattleShips {

	//instance variables 
	String shipType="";
	boolean sank = false;
	int points=0;
	int roundCounter=1;

	private Grid theGrid = new Grid();

	public void play() {
		//variables 
		String rowAsString;
		String squareAsString;
		String output;
		boolean test;
		int row, square;
		int debug;
		final int ROUNDS = 10;
		boolean debugMode =false;
		String endMessage;
		ArrayList <String> firedAt = new ArrayList <String>();


		//setting up the ships
		Ship s1 = new Ship("Aircraft Carrier",5,2);
		Ship s2 = new Ship("Battleship",4,4);
		Ship s3 = new Ship("Submarine",3,6);
		Ship s4 = new Ship("Destroyer",2,8);
		Ship s5 = new Ship("Patrol Boat",1,10);

		//adding the ships
		addShipToGrid(s1);
		addShipToGrid(s2);
		addShipToGrid(s3);
		addShipToGrid(s4);
		addShipToGrid(s5);



		//ask user for debug mode?
		debug = JOptionPane.showConfirmDialog(null, " Would you like to play in debug mode?", "Welcome to Battleships!",
				JOptionPane.YES_NO_OPTION);

		if(debug==0){debugMode=true;}

		//if in debug mode display details
		do{
			if (debugMode==true){
				this.theGrid.debug();}

			this.sank = false;


			// ask for coordinates?

			rowAsString = JOptionPane.showInputDialog("Round "+ this.roundCounter + " You have " + this.points + " points!"+"\nPlease enter the Row");
			row = Integer.parseInt(rowAsString);	

			squareAsString = JOptionPane.showInputDialog("Round "+ this.roundCounter + " You have " + this.points + " points!"+"\nPlease enter the Square");
			square = Integer.parseInt(squareAsString);	


			// test if there is a  ship on the square
			test = this.theGrid.isThereAShipOn(row, square);

			String tempRowAsString=Integer.toString(row);
			String tempSquareAsString=Integer.toString(square);


			// check if square is already been fired at?
			if(firedAt.contains(tempRowAsString+tempSquareAsString)){
				JOptionPane.showMessageDialog(null, "You already fired at that square!");
			}else{

				firedAt.add(tempRowAsString+tempSquareAsString);

				//if there its a hit 
				if (test==true){

					//check if the ship sank
					sunkShip(s1,tempRowAsString,tempSquareAsString);
					sunkShip(s2,tempRowAsString,tempSquareAsString);
					sunkShip(s3,tempRowAsString,tempSquareAsString);
					sunkShip(s4,tempRowAsString,tempSquareAsString);
					sunkShip(s5,tempRowAsString,tempSquareAsString);

					output="Hit! You hit the " +this.shipType+"!";

				}// end of hit function

				//if its a miss 
				else{ 
					output = "Miss";

					roundCounter=roundCounter+1;
				}//end of miss function

				//if a ship did not sink display results
				if (this.sank == false){
					JOptionPane.showMessageDialog(null, output);
				}

			}//end of else statement

		}// end of do loop 

		// do while condition
		while(roundCounter<ROUNDS && this.points < 30); 

		//winning statement
		if(this.points >= 30) {endMessage ="You win! You sank all the ships and got 30 points!!";}

		///loosing statement
		else{endMessage = "Game over! you got "+this.points+" points";}

		//display message
		JOptionPane.showMessageDialog(null, endMessage, "Game Over!",1);

	}// end of 'play' method


	public void addShipToGrid(Ship ship){
		this.theGrid.addShip(ship);
	}


	public void sunkShip(Ship ship, String tempRowAsString, String tempSquareAsString){


		//check if a ship has been sunk
		if(ship.getCoords().contains(tempRowAsString+tempSquareAsString)){
			ship.setHitPoints(ship.getHitPoints()+1);
			this.shipType=ship.getType();

			//create display message and add points 
			if(ship.getHitPoints() == ship.getLength()){
				this.sank =true;
				JOptionPane.showMessageDialog(null, "You sank the "+ship.getType()+" and got " + ship.getPoints() +" points!");
				this.points = this.points+ship.getPoints();
			}//end of if
		}//end of if

	}//end of sunkShip



}//end of class
