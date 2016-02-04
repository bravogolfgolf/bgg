package videostore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VideoStoreTest {

	public static final double DELTA = .001;
	private Statement statement;
	private Movie newRelease1;
	private Movie newRelease2;
	private Movie children;
	private Movie regular1;
	private Movie regular2;
	private Movie regular3;

	@Before
	public void setUp ()  {
		statement= new Statement ("Customer");
		newRelease1 = new Movie ("New Release 1", Movie.NEW_RELEASE);
		newRelease2 = new Movie ("New Release 2", Movie.NEW_RELEASE);
		children = new Movie ("Children", Movie.CHILDRENS);
		regular1 = new Movie ("Regular 1", Movie.REGULAR);
		regular2 = new Movie ("Regular 2", Movie.REGULAR);
		regular3 = new Movie ("Regular 3", Movie.REGULAR);
	}

	@Test
	public void testSingleNewReleaseStatementTotals() {
		statement.addRental(new Rental (newRelease1, 3)); 
		statement.generate();
		assertEquals(9.0, statement.getTotal(), DELTA);
		assertEquals(2, statement.getFrequentRenterPoints());
	}

	@Test
	public void testDualNewReleaseStatementTotals() {
		statement.addRental (new Rental (newRelease1, 3));
		statement.addRental (new Rental (newRelease2, 3));		
		statement.generate();
		assertEquals(18.0, statement.getTotal(), DELTA);
		assertEquals(4, statement.getFrequentRenterPoints());
	}

	@Test
	public void testSingleChildrensStatementTotals() {
		statement.addRental (new Rental (children, 3));
		statement.generate();
		assertEquals(1.5, statement.getTotal(), DELTA);
		assertEquals(1, statement.getFrequentRenterPoints());
	}

	@Test
	public void testMultipleRegularStatementTotals() {
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));		
		statement.generate();
		assertEquals(7.5, statement.getTotal(), DELTA);
		assertEquals(3, statement.getFrequentRenterPoints());
	}
	
	@Test
	public void testMultipleRegularStatementOutput() {
		statement.addRental (new Rental (regular1, 1));
		statement.addRental (new Rental (regular2, 2));
		statement.addRental (new Rental (regular3, 3));		
		assertEquals ("Rental Record for Customer\n"
				+ "\tRegular 1\t2.0\n"
				+ "\tRegular 2\t2.0\n"
				+ "\tRegular 3\t3.5\n"
				+ "You owed 7.5\n"
				+ "You earned 3 frequent renter points\n", 
				statement.generate ());
	}
}