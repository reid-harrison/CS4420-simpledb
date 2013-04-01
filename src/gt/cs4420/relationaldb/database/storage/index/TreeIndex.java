package gt.cs4420.relationaldb.database.storage.index;

import gt.cs4420.relationaldb.domain.IndexNode;

public class TreeIndex<T extends Comparable<T>, E extends Comparable<E>> {
	
	private IndexNode<T,E> root;
	private int size;
	
	public TreeIndex(){
		this.root = null;
		this.size = 0;
	}
	
	public TreeIndex(IndexNode<T,E> root){
		this.root = new IndexNode<T,E>(root);
		size = 1;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean contains(T indexID){
		return get(indexID) != null;
	}
	
	public E get(T indexID){
		return get(root,indexID);
	}
	
	private E get(IndexNode<T,E> in, T indexID){
		if(in == null)
			return null;
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp < 0)
			return get(in.getLeft(),indexID);
		else if(cmp == 0)
				return in.getBlockID();
		else return get(in.getRight(),indexID);		
	}
	
	public void put(T indexID, E blockID){
		if(blockID == null){
			delete(indexID);
			return;
		}
		root = put(root, indexID, blockID);		
	}

	private IndexNode<T, E> put(IndexNode<T, E> in, T indexID, E blockID) {
		// TODO Auto-generated method stub
		if(in == null){
			++size;
			return new IndexNode<T,E>(indexID, blockID);
		}
			
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp == 0)
			in.setBlockID(blockID);
		else if(cmp < 0)
					in.setRight(put(in.getRight(),indexID,blockID));
			 else in.setLeft(put(in.getLeft(),indexID,blockID));
		return in;
	}
	
	public void delete(T indexID){
		assert contains(indexID);
		root = delete(root,indexID);
		--size;
		return;
	}

	private IndexNode<T, E> delete(IndexNode<T, E> in, T indexID) {
		// TODO Auto-generated method stub
		if(in == null)
			return null;
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp > 0)
			in.setLeft(delete(in.getLeft(), indexID));
		else if(cmp < 0)
				in.setRight(delete(in.getRight(), indexID));
		else {
			if(in.getLeft() == null)
				return in.getRight();
			if(in.getRight() == null)
				return in.getLeft();
			IndexNode<T, E> tmp = in;
			in = min(tmp.getRight());
			in.setLeft(tmp.getLeft());
			in.setRight(deleteMin(tmp.getRight()));
		}
		return in;
	}

	private IndexNode<T, E> deleteMin(IndexNode<T, E> in) {
		// TODO Auto-generated method stub
		if(in.getLeft() == null)
			return in.getRight();			
		IndexNode<T,E> tmp = in;
		while(tmp.getLeft().getLeft() != null)
			tmp = tmp.getLeft();
		tmp.setLeft(null);
		return in;
	}

	private IndexNode<T, E> min(IndexNode<T, E> in) {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		IndexNode<T, E> tmp = in;
		while(tmp.getLeft() != null){
			tmp = tmp.getLeft();
		}
		return tmp;
	}	
}
