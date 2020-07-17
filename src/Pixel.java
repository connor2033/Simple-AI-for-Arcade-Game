public class Pixel {

	private Location pixLoc;
	private int pixCol;
	
	//constructor that sets the pixel location and color
	public Pixel(Location p, int color) {
		pixLoc = p;
		pixCol = color;
	}
	
	//returns location of pixel
	public Location getLocation() {
		return this.pixLoc;
	}
	
	//returns color of pixel
	public int getColor() {
		return this.pixCol;
	}
	
}
