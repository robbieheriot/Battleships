package grid01;

import java.util.ArrayList;

public class Ship {

	private int length;
	private String type;
	private int points;
	private int hitPoints=0;
	private ArrayList <String> coords = new ArrayList <String> ();

	public Ship (String type,int length,int points){

		setType(type);
		setLength(length);
		setPoints(points);
		setHitPoints(hitPoints);
	}


	//getters and setters 
	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public ArrayList<String> getCoords() {
		return coords;
	}

	public void setCoords(ArrayList<String> coords) {
		this.coords = coords;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}

