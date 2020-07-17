public class BinarySearchTree implements BinarySearchTreeADT{
	private BinaryNode root ; //initializing a node called root
	
	//constructor making root into a leaf
	public BinarySearchTree(){
		root = new BinaryNode();
	}
	
	//returns the root
	public BinaryNode getRoot(){
		return this.root;
	}
	
	//recursive node returning a pixel containing the given key if it exists
	public Pixel get(BinaryNode r, Location key) {
		if(r.isLeaf()) return null;
		else {
			if(key.compareTo(r.getData().getLocation()) == 1) {
				return get(r.getRight(), key);
			}
			else if(key.compareTo(r.getData().getLocation()) == -1) {
				return get(r.getLeft(), key);
			}
			else{
				return r.getData();
			}
		}
	}
	
	//recursively inserts the given pixel into the BST
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		
		Pixel pixel = get(r, data.getLocation());
		
		//if the tree is empty
		if(this.root.getData() == null) {
			root.setData(data);
			BinaryNode left = new BinaryNode();
			BinaryNode right = new BinaryNode();
			root.setLeft(left);
			root.setRight(right);
			left.setParent(root);
			right.setParent(root);
			return;
		}

		//Check if the node already exists
		if (pixel!=null) {
			throw new DuplicatedKeyException();
		}
		//inserting the node
		else {
			//initializing variables
			BinaryNode parent = getNode(r, data.getLocation()).getParent();
			BinaryNode left = new BinaryNode();
			BinaryNode right = new BinaryNode();
			BinaryNode insertNode = new BinaryNode(data, left, right, parent);

			left.setParent(insertNode);
			right.setParent(insertNode);
			Location parentPosition = parent.getData().getLocation();
			int result = data.getLocation().compareTo(parentPosition);
			//setting the node to left or right child
			if (result == -1) {
				parent.setLeft(insertNode);
			}
			else {
				parent.setRight(insertNode);
			}
		}
	}

	
    //recursively removing the given node if it is in the tree
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		//creating temporary node variables
		BinaryNode currNode = getNode(r,key);
		BinaryNode parent = currNode.getParent();
		BinaryNode right = currNode.getRight();
		BinaryNode left = currNode.getLeft();
		BinaryNode smallest = new BinaryNode();
		
		//pixel not in tree
		if (currNode.isLeaf()) throw new InexistentKeyException();
		
		else{
			//at least one of child is leaf
			if (right.isLeaf() || left.isLeaf()){
				//right is leaf
				if(right.isLeaf()){
					//if node is root
					if (parent == null){
						left.setParent(null);
						this.root = left ;
					}
					else{
						//pointing parent to non leaf child
						if(parent.getLeft() == currNode){
							left.setParent(parent);
							parent.setLeft(left);
						}	
						else{
							left.setParent(parent);
							parent.setRight(left);
						}
					}
				}
				
				//left is leaf
				else{
					//node is root
					if (parent == null){
						right.setParent(null);
						this.root = right;
					}
					//pointing parent to non leaf child
					else{
						if(parent.getLeft() == currNode){
							right.setParent(parent);
							parent.setLeft(right);
						}
						else{
							right.setParent(parent);
							parent.setRight(right);
						}
					}
				}
			}
			//neither child is a leaf
			else{
				smallest = smallestNode(currNode.getRight());
				currNode.setData(smallest.getData());
				remove(smallest,smallest.getData().getLocation());

			}
		}
	}
	
	
	//returns the node coming after the given node defined by inorder traversal
	public Pixel successor(BinaryNode r, Location key) {
		BinaryNode p;
		BinaryNode parent;
		
		//if tree is empty
		if(r.isLeaf()) return null;
		else {
			p = getNode(r, key);
			if(!p.isLeaf() && !p.getRight().isLeaf()) {
				return smallest(p.getRight());
			}
			else {
				parent = p.getParent();
				while(p != r && p == parent.getRight()) {
					p = parent;
					parent = p.getParent();
				}
				if(p == r) return null;
				else return parent.getData();
			}
		}
	}

	//returns the node coming before the given node defined by inorder traversal
	public Pixel predecessor(BinaryNode r, Location key) {
		BinaryNode p;
		BinaryNode parent;
		
		//tree is empty
		if(r.isLeaf()) return null;
		else {
			p = getNode(r, key);
			if(!p.isLeaf() && !p.getLeft().isLeaf()) {
				return largest(p.getLeft());
			}
			else {
				parent = p.getParent();
				while(p != r && p == parent.getLeft()) {
					p = parent;
					parent = p.getParent();
				}
				if(p == r) return null;
				else return parent.getData();
			}
		}
	}

	//returns the smallest pixel from the tree
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if(r.getData() != null) {
			while(r.getLeft().isLeaf() == false) {
				r = r.getLeft();
			}
			return r.getData();
		}
		else throw new EmptyTreeException();
	}

	//returns the largest pixel from the tree
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if(r.getData() != null) {
			while(r.getRight().isLeaf() == false) {
				r = r.getRight();
			}
			return r.getData();
		}
		else throw new EmptyTreeException();
	}

	
	//Extra helper methods (returning nodes)
	
	
	//helper method same as get but returns node
	private BinaryNode getNode(BinaryNode r, Location key) {
		if(r.isLeaf()) return r;
		else {
			if(key.compareTo(r.getData().getLocation()) == 1) {
				return getNode(r.getRight(), key);
			}
			else if(key.compareTo(r.getData().getLocation()) == -1) {
				return getNode(r.getLeft(), key);
			}
			else{
				return r;
			}
		}
	}	
	
	//helper method same as smallest but returns node
	private BinaryNode smallestNode(BinaryNode r) throws EmptyTreeException {
		if(r.getData() != null) {
			while(r.getLeft().isLeaf() == false) {
				r = r.getLeft();
			}
			return r;
		}
		else throw new EmptyTreeException();
	}

	//helper method same as largest but returns node
	public BinaryNode largestNode(BinaryNode r) throws EmptyTreeException {
		if(r.getData() != null) {
			while(r.getRight().isLeaf() == false) {
				r = r.getRight();
			}
			return r;
		}
		else throw new EmptyTreeException();
	}
	

}
