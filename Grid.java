package grid01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Grid {

	private ArrayList <Row> theRows = new ArrayList <Row> ();
	private ArrayList <String> takenSquares = new ArrayList <String> ();
	private final int NUMBER_OF_ROWS = 10;
	String tempRowAsString;
	String tempString;
	String tempSquareAsString;
	String output ="The ships are located at:";
	int square;
	int row;


	public Grid() {
		Row tempRow;
		for(int loop = 1; loop <= this.NUMBER_OF_ROWS; loop++) {
			tempRow = new Row(loop);
			this.theRows.add(tempRow);
		}
	}//end Grid


	//is there a ship on a particular square
	public boolean isThereAShipOn(int row, int square) {

		for(Row tempRow : this.theRows) {
			if(tempRow.getNumber() == row) {
				//found the correct row
				for(Square tempSquare : tempRow.getTheSquares()) {
					if(tempSquare.getNumber() == square) {
						//found the correct square

						return tempSquare.isThereAShip();
					}//end of if
				}//end of for
			}//end of if
		}//end of for loop
		return false;		
	}// end of method


	public void addShip(Ship ship) {

		//horizontal or vertical?
		int random = (int) (Math.random()*2)+1;

		//place vertically
		if (random == 1){

			int max = 10 - ship.getLength();

			
			if((checkSquares(row,square)==false)){
				
				row=(int)(Math.random()*max)+1;
				square = (int) (Math.random()*10)+1;	


				addTakenSquaresVert(ship, row, square);


				output=output+ "\n " + ship.getType() + ": ";

				for( int loop=0; loop< ship.getLength(); loop++){	

					row=row+1;

					placeShip(ship,row,square);

				}// end of for loop


			}else{ System.out.print("double"); }

		}// end of place vertically




		//place horizontally
		else{

			int max = 10 - ship.getLength();

			if((checkSquares(row,square)==false)){
				square=(int)(Math.random()*max)+1;
				row = (int) (Math.random()*10)+1;


				addTakenSquaresHorz(ship, row, square);


				output=output+ "\n " + ship.getType() + ": ";

				for( int loop=0; loop< ship.getLength(); loop++){	

					square=square+1;

					placeShip(ship,row,square);

				}// end of for loop
			} else{  System.out.print("single");}

			
		}// end of place horizontally

	}//end of method


	public void placeShip(Ship ship, int row, int square){

		for(Row tempRow : this.theRows) {

			if(tempRow.getNumber() == row) {

				for(Square tempSquare : tempRow.getTheSquares()) {

					if(tempSquare.getNumber() == square) {

						tempSquare.setShip(ship);

						//message for debug mode
						tempRowAsString=Integer.toString(row);
						tempSquareAsString=Integer.toString(square);

						output = output+"("+tempRowAsString+","+tempSquareAsString+") ";

						ship.getCoords().add(tempRowAsString+tempSquareAsString);

					}//end of if
				}//end of for loop
			}// end of if
		}//end of for loop	
	}//end of method


	//debug mode
	public void debug (){

		JOptionPane.showMessageDialog(null, output);

	} // end of debug method

	public boolean checkSquares(int row,int square){

		String RowAsString=Integer.toString(row);
		String SquareAsString=Integer.toString(square);

		if (this.takenSquares.contains(RowAsString+SquareAsString)){
			return true;
		}else{return false;}


	}//end of method

	public void addTakenSquaresVert(Ship ship, int row, int square){

		for(int loop=0; loop< ship.getLength(); loop++){

			String RowAsString=Integer.toString(row);
			String SquareAsString=Integer.toString(square);

			RowAsString=Integer.toString(row);
			SquareAsString=Integer.toString(square);

			this.takenSquares.add(RowAsString+SquareAsString);

			row=row+1;

		}
	}

	public void addTakenSquaresHorz(Ship ship, int row, int square){

		for(int loop=0; loop< ship.getLength(); loop++){

			String RowAsString=Integer.toString(row);
			String SquareAsString=Integer.toString(square);

			RowAsString=Integer.toString(row);
			SquareAsString=Integer.toString(square);

			this.takenSquares.add(RowAsString+SquareAsString);

			square=square+1;

		}
	}





}//end class
