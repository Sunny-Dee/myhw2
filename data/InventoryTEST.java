package myhw2.data;

import static org.junit.Assert.*;

import org.junit.Test;

// TODO: complete the tests
public class InventoryTEST {
	InventorySet s = new InventorySet();
	final VideoObj v1 = new VideoObj( "A", 2000, "B" );
	final VideoObj v2 = new VideoObj( "B", 2000, "B" );

	@Test
	public void testSize() {
		assertEquals( 0, s.size() );
		s.addNumOwned(v1,  1); assertEquals( 1, s.size() );
		s.addNumOwned(v1,  2); assertEquals( 1, s.size() );
		s.addNumOwned(v2,  1); assertEquals( 2, s.size() );
		s.addNumOwned(v2, -1); assertEquals( 1, s.size() );
		s.addNumOwned(v1, -3); assertEquals( 0, s.size() );
		try { s.addNumOwned(v1, -3); fail(); } catch ( IllegalArgumentException e ) {}
		assertEquals( 0, s.size() );
	}

	@Test
	public void testAddNumOwned() {
		// TODO
		final VideoObj v1copy = new VideoObj( "A", 2000, "B" );
		
		assertEquals( 0, s.size() );
		s.addNumOwned(v1, 1);     assertEquals( v1.director(), s.get(v1).video().director());
		assertEquals( v1, s.get(v1).video()) ;
		assertEquals( 1, s.get(v1).numOwned() );
		s.addNumOwned(v1, 2);     assertEquals( 3, s.get(v1).numOwned() );
		s.addNumOwned(v1, -1);    assertEquals( 2, s.get(v1).numOwned() );
		s.addNumOwned(v2, 1);     assertEquals( 2, s.get(v1).numOwned() );
		s.addNumOwned(v1copy, 1); assertEquals( 3, s.get(v1).numOwned() );
		assertEquals( 2, s.size() );
		s.addNumOwned(v1, -3);
		assertEquals( 1, s.size() );
		try { s.addNumOwned(null, 1);   fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testCheckOutCheckIn() {
		// TODO
	}

	@Test
	public void testClear() {
		// TODO
	}

	@Test
	public void testGet() {
		// TODO
	}

	@Test
	public void testIterator1() {
		// TODO
	}
	@Test
	public void testIterator2() {
		// TODO
	}

}
