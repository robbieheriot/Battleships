package grid01;

public class Square {

	private int number;
	private Ship theShip;


	public Square(int number) {
		setNumber(number);
	}

	public boolean isThereAShip() {
		if(theShip == null) {
			return false;
		}else{
			return true;
		}
	}

	//getters and setters
	public void setShip(Ship theShip) {
		this.theShip = theShip;
	}

	public Ship getShip(){
		return this.theShip;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public int getNumber() {
		return this.number;
	}

}//end class
