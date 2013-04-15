package gt.cs4420.relationaldb.database.storage.index;

public class TreeIndexTest {
	public static void main(String[] args){
		TreeIndexTest tit = new TreeIndexTest();
		tit.run();
	}
	
	public TreeIndexTest(){
		ti = new TreeIndex<Integer, Integer>();
	}
	
	private TreeIndex<Integer, Integer> ti;

	private void run() {
		// TODO Auto-generated method stub
		ti.put(26, 15);
		ti.put(43, 9);
		ti.put(2, 8);
		ti.put(14, 20);
		ti.put(20, 44);
		ti.put(0, 12);
		ti.put(0, 88);
		
	}
	
	
}
