package gt.cs4420.relationaldb.domain;

public class IndexNode <T extends Comparable<T>,E extends Comparable<E>> {
	
	private T indexID;
	private E blockID;
	
	private IndexNode<T,E> left;
	private IndexNode<T,E> right;
	
	public IndexNode(T indexID, E blockID){
		this.indexID = indexID;
		this.blockID = blockID;
		this.left = null;
		this.right = null;
	}
	
	public IndexNode() {
		this.indexID = null;
		this.blockID = null;
		this.left = null;
		this.right = null;
	}
	
	public void setIndexID(T indexID){
		this.indexID = indexID;
	}
	
	public T getIndexId(){
		return this.indexID;
	}
	
	public void setBlockID(E blockID){
		this.blockID = blockID;
	}
	
	public E getBlockID(){
		return this.blockID;
	}
	
	public void setLeft(IndexNode<T,E> in){
		this.left = in;
	}
	
	public IndexNode<T,E> getLeft(){
		return this.left;
	}
	
	public void setRight(IndexNode<T,E> in){
		this.right = in;
	}
	
	public IndexNode<T,E> getRight(){
		return this.right;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof IndexNode))
				return false;
		@SuppressWarnings("unchecked")
		IndexNode<T, E> in = (IndexNode<T,E>) o;
		return in.getIndexId().equals(this.getIndexId()) && in.getBlockID().equals(this.getBlockID()) && 
				in.getLeft().equals(this.getLeft()) && in.getRight().equals(this.getRight());
		
	}
}
