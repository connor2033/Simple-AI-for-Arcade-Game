
public class BinaryNode {

	private Pixel nodeVal;
	private BinaryNode leftNode;
	private BinaryNode rightNode;
	private BinaryNode parentNode;
	
	//constructing new binary node
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		nodeVal = value;
		leftNode = left;
		rightNode = right;
		parentNode = parent;
	}
	
	//constructing leaf node
	public BinaryNode() {
		nodeVal = null;
		leftNode = null;
		rightNode = null;
		parentNode = null;
	}
	
	//returns parent
	public BinaryNode getParent() {
		return this.parentNode;
	}
	
	//sets parent
	public void setParent(BinaryNode parent) {
		this.parentNode = parent;
	}
	
	//sets left child
	public void setLeft(BinaryNode p) {
		this.leftNode = p;
	}
	
	//sets right child
	public void setRight(BinaryNode p) {
		this.rightNode = p;
	}
	
	//sets data of given pixel
	public void setData(Pixel value) {
		this.nodeVal = value;
	}
	
	//checks if node is leaf
	public boolean isLeaf() {
		if(leftNode == null && rightNode == null && nodeVal == null) return true;
		else return false;
	}
	
	//returns data from pixel
	public Pixel getData() {
		return this.nodeVal;
	}
	
	//returns left child
	public BinaryNode getLeft() {
		return this.leftNode;
	}
	
	//returns right child
	public BinaryNode getRight() {
		return this.rightNode;
	}
	
}
