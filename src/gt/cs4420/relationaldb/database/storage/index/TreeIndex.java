package gt.cs4420.relationaldb.database.storage.index;

import gt.cs4420.relationaldb.domain.IndexNode;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class TreeIndex extends AbstractIndex {
	
	private IndexNode root;
	private int size;
	
	public TreeIndex() {
		this.root = null;
		this.size = 0;
	}
	
	public TreeIndex(IndexNode root){
		this.root = new IndexNode(root);
		size = 1;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public IndexNode getRoot(){
		return this.root;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean contains(Integer indexID){
		return (get(indexID) != null);
	}
	
	public Integer get(Integer indexID){
		return get(root,indexID);
	}
	
	public Integer getIndex(Integer indexID){
		return getIndex(root,indexID);
	}
	
	private Integer getIndex(IndexNode in, Integer indexID){
		if(in == null)
			return null;
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp > 0)
			return get(in.getLeft(),indexID);
		else if(cmp == 0)
				return in.getBlockIndex();
		else return get(in.getRight(),indexID);		
	}
	
	private Integer get(IndexNode in, Integer indexID){
		if(in == null)
			return null;
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp > 0)
			return get(in.getLeft(),indexID);
		else if(cmp == 0)
				return in.getBlockID();
		else return get(in.getRight(),indexID);		
	}
	
	public void put(Integer indexID, Integer blockID, Integer blockIndex){
		if(blockID == null){
			delete(indexID);
			return;
		}
		root = put(root, indexID, blockID, blockIndex);		
	}

	private IndexNode put(IndexNode in, Integer indexID, Integer blockID, Integer blockIndex) {
		if(in == null){
			++size;
			return new IndexNode(indexID, blockID, blockIndex);
		}
			
		int cmp = in.getIndexId().compareTo(indexID);
		if(cmp == 0)
			in.setBlockID(blockID);
		else if(cmp < 0)
					in.setRight(put(in.getRight(),indexID,blockID,blockIndex));
			 else in.setLeft(put(in.getLeft(),indexID,blockID,blockIndex));
		return in;
	}
	
	public void delete(Integer indexID){
		if(contains(indexID) == false)
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		root = delete(root,indexID);
		--size;
		return;
	}

	private IndexNode delete(IndexNode in, Integer indexID) {
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
			IndexNode tmp = in;
			in = min(tmp.getRight());
			in.setRight(deleteMin(tmp.getRight()));
			in.setLeft(tmp.getLeft());
		}
		return in;
	}

	private IndexNode deleteMin(IndexNode in) {
		if(in.getLeft() == null)
			return in.getRight();			
		in.setLeft(deleteMin(in.getLeft()));
		return in;
	}

	private IndexNode min(IndexNode in) {
		if(isEmpty())
			return null;
		while(in.getLeft() != null){
			in = in.getLeft();
		}
		return in;
	}

    @Override
    public Set<Integer> getPrimaryKeySet() {
    	Set<Integer> s = new HashSet<Integer>();
    	preorder(root,s);    	
        return s;
    }

    private void preorder(IndexNode node, Set<Integer> s) {
		if(node == null)
			return;
		s.add(node.getIndexId());
		preorder(node.getLeft(),s);
		preorder(node.getRight(),s);
	}

	@Override
    public Integer getBlockId(Integer primaryKey) {
        return get(primaryKey);
    }

    @Override
    public void addIndexEntry(Integer primaryKey, Integer blockId, Integer blockIndex) {
    	put(primaryKey, blockId, blockIndex);
        super.addIndexEntry(primaryKey, blockId, blockIndex);
    }

    @Override
    public void removeIndexEntry(Integer primaryKey) {
        super.removeIndexEntry(primaryKey);
    	delete(primaryKey);
    }

    @Override
    public int getBlockIndex(Integer primaryKey) {
        return getIndex(primaryKey);
    }

    @Override
    public boolean primaryKeyExists(Integer primaryKey) {
        return contains(primaryKey);
    }
}
