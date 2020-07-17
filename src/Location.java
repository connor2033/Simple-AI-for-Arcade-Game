
public class Location {

	private int xCo;
	private int yCo;
	
	//constructor setting given coords
	public Location(int x, int y) {
		xCo = x;
		yCo = y;
	}
	
	//returns the x coordinate
	public int xCoord() {
		return this.xCo;
	}
	
	//returns the y coordinate
	public int yCoord() {
		return this.yCo;
	}
	
	//compares the values of the coordinates
	public int compareTo (Location p) {
		if(p.xCo > this.xCo) return -1;
		else if(p.xCo < this.xCo) return 1;
		else{
			if(p.yCo > this.yCo) return -1;
			else if(p.yCo < this.yCo) return 1;
			else return 0;
		}
	}
	
}
