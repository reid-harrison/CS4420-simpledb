package gt.cs4420.relationaldb.database.storage.index;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTreeIndex {

	TreeIndex ti = new TreeIndex();
	@Test
	public void test() {
		assertTrue("tree is empty", ti.isEmpty());
		
		ti.put(26, 175, 2);
		ti.put(43, 9, 3);
		ti.put(2, 8, 1);
		ti.put(14, 20, 4);
		ti.put(20, 44, 2);
		ti.put(0, 12, 3);
		ti.put(0, 162, 1);
		ti.put(22, 48, 0);
		ti.put(50,76, 3);
		ti.put(27, 44, 2);
		ti.put(0, 88, 1);
		
		assertEquals("blockid for indexid 0 is 162", (Integer)88,ti.get(0));
		
		ti.put(0, 887, 2);
		
		assertFalse("tree is empty", ti.isEmpty());
		assertEquals("size should be 9", 9, ti.getSize());
		assertEquals("blockid for indexid 0 is 162", (Integer)887,ti.get(0));
		assertEquals("blockid for indexid 14 is 20", (Integer)20, ti.get(14));
		assertTrue("contains 14", ti.contains(14));
		assertFalse("doesn't contain 9", ti.contains(9));
		assertTrue("contains 0", ti.contains(0));
		assertEquals("root should be index 26", (Integer)26, ti.getRoot().getIndexId());
		
		ti.delete(2);
		ti.delete(26);
		ti.delete(0);
		
		assertEquals("size should be 6", 6, ti.getSize());
		assertFalse("doesn't contain 26", ti.contains(26));
		assertFalse("doesn't contain 4", ti.contains(2));
		assertFalse("doesn't contain 0", ti.contains(0));
		assertEquals("root should be index 27", (Integer)27, ti.getRoot().getIndexId());
		
		ti.put(14, 20, 2);
		ti.put(20, 44, 3);
		ti.put(0, 12, 1);
		ti.put(0, 162, 0);
		ti.put(22, 48, 3);	
		
		
		assertEquals("size should be 7", 7, ti.getSize());
		assertFalse("doesn't contain 0", ti.contains(6));
		
		ti.put(0, null, null);
		
		assertEquals("size should be 6", 6, ti.getSize());
		
		ti.put(22, null, 2);
		
		assertEquals("size should be 5", 5, ti.getSize());
		
	}

}
