package gt.cs4420.relationaldb.domain;

public class IndexNode {
	
	private Integer indexID;
	private Integer blockID;
	private Integer blockIndex;
	
	private IndexNode left;
	private IndexNode right;
	
	public IndexNode(Integer indexID, Integer blockID, Integer blockIndex){
		this.indexID = indexID;
		this.blockID = blockID;
		this.blockIndex = blockIndex;
		this.left = null;
		this.right = null;
	}
	
	public IndexNode() {
		this.indexID = null;
		this.blockID = null;
		this.blockIndex = null;
		this.left = null;
		this.right = null;
	}
	
	public IndexNode(IndexNode in) {
		this.indexID = in.getIndexId();
		this.blockID = in.getBlockID();
		this.blockIndex = in.getBlockIndex();
		this.left = in.getLeft();
		this.right = in.getRight();
	}
	
	public Integer getBlockIndex() {
		return this.blockIndex;
	}

	public void setBlockIndex(Integer blockIndex){
		this.blockIndex = blockIndex;
	}
	public void setIndexID(Integer indexID){
		this.indexID = indexID;
	}
	
	public Integer getIndexId(){
		return this.indexID;
	}
	
	public void setBlockID(Integer blockID){
		this.blockID = blockID;
	}
	
	public Integer getBlockID(){
		return this.blockID;
	}
	
	public void setLeft(IndexNode in){
		this.left = in;
	}
	
	public IndexNode getLeft(){
		return this.left;
	}
	
	public void setRight(IndexNode in){
		this.right = in;
	}
	
	public IndexNode getRight(){
		return this.right;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof IndexNode))
				return false;
		@SuppressWarnings("unchecked")
		IndexNode in = (IndexNode) o;
		return in.getIndexId().equals(this.getIndexId()) && in.getBlockID().equals(this.getBlockID()) && 
				in.getLeft().equals(this.getLeft()) && in.getRight().equals(this.getRight());
		
	}
}
