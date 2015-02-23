package marsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void testgetXCoordinate0() {
		Point point = new Point(0,0);	
		assertEquals(0,point.getX());
	}

	@Test
	public void testgetYCoordinate0() {
		Point point = new Point(0,0);	
		assertEquals(0,point.getY());
	}
	
	@Test
	public void testgetXCoordinate1() {
		Point point = new Point(1,0);	
		assertEquals(1,point.getX());
	}
}