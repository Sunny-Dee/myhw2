package myhw2.data;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

// TODO: complete the tests
public class InventoryTEST {
	InventorySet s = new InventorySet();
	final VideoObj v1 = new VideoObj( "A", 2000, "B" );
	final VideoObj v2 = new VideoObj( "B", 2000, "B" );
	final VideoObj v1copy = new VideoObj( "A", 2000, "B" );

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
		try { s.checkOut(null);     fail(); } catch ( IllegalArgumentException e ) {}
		try { s.checkIn(null);      fail(); } catch ( IllegalArgumentException e ) {}
		s.addNumOwned(v1, 2); assertTrue( s.get(v1).numOut() == 0 && s.get(v1).numRentals() == 0 );
		s.checkOut(v1);       assertTrue( s.get(v1).numOut() == 1 && s.get(v1).numRentals() == 1 );
		try { s.addNumOwned(v1,-3); fail(); } catch ( IllegalArgumentException e ) {}
		try { s.addNumOwned(v1,-2); fail(); } catch ( IllegalArgumentException e ) {}
		s.addNumOwned(v1,-1); assertTrue( s.get(v1).numOut() == 1 && s.get(v1).numRentals() == 1 );
		s.addNumOwned(v1, 1); assertTrue( s.get(v1).numOut() == 1 && s.get(v1).numRentals() == 1 );
		s.checkOut(v1);       assertTrue( s.get(v1).numOut() == 2 && s.get(v1).numRentals() == 2 );
		try { s.checkOut(v1);       fail(); } catch ( IllegalArgumentException e ) {}
		s.checkIn(v1);        assertTrue( s.get(v1).numOut() == 1 && s.get(v1).numRentals() == 2 );
		s.checkIn(v1copy);    assertTrue( s.get(v1).numOut() == 0 && s.get(v1).numRentals() == 2 );
		try { s.checkIn(v1);        fail(); } catch ( IllegalArgumentException e ) {}
		try { s.checkOut(v2);       fail(); } catch ( IllegalArgumentException e ) {}
		s.checkOut(v1);       assertTrue( s.get(v1).numOut() == 1 && s.get(v1).numRentals() == 3 );
	}

	@Test
	public void testClear() {
		// TODO
		s.addNumOwned(v1, 2); assertEquals( 1, s.size() );
		s.addNumOwned(v2, 2); assertEquals( 2, s.size() );
		s.clear();            assertEquals( 0, s.size() );
		try { s.checkOut(v2);       fail(); } catch ( IllegalArgumentException e ) {}
	}

	@Test
	public void testGet() {
		// TODO
//		s.addNumOwned(v1, 1);
//		Record r1 = s.get(v1);
//		Record r2 = s.get(v1);
// 		assertTrue( r1 != r2 );
	}

	@Test
	public void testIterator1() {
		// TODO
		s.addNumOwned(v1, 1);
		s.addNumOwned(v2, 1);

		Set<VideoObj> expected = new HashSet<VideoObj>();
		expected.add(v1);
		expected.add(v2);
		
		Iterator<Record> i = s.iterator();
		while(i.hasNext()) {
			Record r = i.next();
			assertTrue(expected.contains(r.video()));
			expected.remove(r.video());
		}
		assertTrue(expected.isEmpty());
	}
	@Test
	public void testIterator2() {
		// TODO
		s.addNumOwned(v1, 10);
		s.addNumOwned(v2, 10);
		s.checkOut(v2);
		s.checkOut(v2);
	

		Set<VideoObj> expected = new HashSet<VideoObj>();
		expected.add(v2);
		expected.add(v1);
		
		
		Iterator<Record> i = s.iterator(new Compar());
		Record r = i.next();

		assertEquals(r.video(), v2);
		r = i.next();
		assertEquals(r.video(), v1);
	}

}
