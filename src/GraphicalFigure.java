
public class GraphicalFigure implements GraphicalFigureADT{

	//creating private variables for figs
	private int ID;
	private int w;
	private int h;
	private String figType;
	private Location figPos;	
	private BinarySearchTree BST;
	
	//constructor for graphical figure creating new tree etc.
	public GraphicalFigure (int id, int width, int height, String type, Location pos) {
		BST = new BinarySearchTree();		
		ID = id;
		w = width;
		h = height;
		figType = type;
		figPos = pos;		
	}
	
	//sets the type String of the fig
	public void setType(String type) {
		this.figType = type;
	}
	
	//gets the width of the fig
	public int getWidth() {
		return this.w;
	}
	
	//gets the height of the fig
	public int getHeight() {
		return this.h;
	}
	
	//gets the type string of the fig
	public String getType() {
		return this.figType;
	}
	
	//gets the ID int of the fig
	public int getId() {
		return this.ID;
	}
	
	//gets the position of the fig
	public Location getOffset() {
		return this.figPos;
	}
	
	//sets the location of the fig
	public void setOffset(Location value) {
		this.figPos = value;
	}
	
	//puts the given pixel into the BST
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		if(BST.get(BST.getRoot(), pix.getLocation()) == null) {
			BST.put(BST.getRoot(), pix);
		}
		else throw new DuplicatedKeyException();
	}
	
	//checks if there is an intersection with the given fig
	public boolean intersects(GraphicalFigure gobj) {
		//creating local variables
		Pixel s = null;
		int x = getOffset().xCoord();
		int y = getOffset().yCoord();
		
		if(BST.getRoot().getClass() != null) s = gobj.BST.smallest(BST.getRoot()); 
		 
		int inX;
		int inY;
		 
		//looping through nodes of the tree
		while(BST.successor(BST.getRoot(), s.getLocation()) != null){			
			inX = s.getLocation().xCoord()+x-gobj.getOffset().xCoord();
			inY = s.getLocation().yCoord()+y-gobj.getOffset().yCoord();
			
			//returning true if intersection
			if(gobj.findPixel(new Location(inX,inY))) return true;
			s = BST.successor(BST.getRoot(), s.getLocation());
		}
		//returning false for no intersection
		return false;
	}
	
	
	//returns true if this fig has a pixel at location p
	private boolean findPixel(Location p) {
		if(BST.get(BST.getRoot(), p) != null) return true;
		else return false;
	}
	
}
