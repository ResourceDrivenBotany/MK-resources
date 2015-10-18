package plantResources;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Misha Kanai
 * Oct 13
 * 
 * 
 */

public class ResourcesTest {

	private Resource water0;	//these will be initialized to 0
	private Resource soil0;
	private Resource scent0;

	private Water water1;		//these will be initialized to nonzero values
	private Soil soil1;
	private Scent scent1;
	
	@Before
	public void before() {
		water0 = new Water();
		soil0 = new Soil();
		scent0 = new Scent();
		
		water1 = new Water(5);
		soil1 = new Soil(5);
		scent1 = new Scent(5);

	}
	
	@Test
	public void testWater0() {	//tests the concrete methods of the Resource class through the Water class''
		
		assertEquals(0, water0.getValue());
		
		
		water0.incValue();
		assertEquals("water0 +1 = 1", 1, water0.getValue());
		water0.incValue(5);
		assertEquals("water0 +5 = 6", 6, water0.getValue());
		
		water0.decValue(3);
		assertEquals("water0 -3 = 3", 3, water0.getValue());
		water0.incValue(-1);
		assertEquals("water0 -1 = 2", 2, water0.getValue());
	}
	
	@Test
	public void testScentConstructor() {
		Scent scent = new Scent(water1, soil1, 2);
		assertEquals(2, scent.getValue());
		assertEquals(3, water1.getValue());
		assertEquals(3, soil1.getValue());
	}
	
	@Test(expected = NegativeResourceException.class)	// Ensure setting through the constructor is nonnegative
	public void testConstructorExceptions() {
		Resource water = new Water(-5);
	}
	
	@Test
	public void testScentIncrement() {		// Scent uses an alias of water and soil to decrease each equal to its increase
		scent1.incValue(water1, soil1, 4);
		assertEquals(9, scent1.getValue());
		assertEquals(1, water1.getValue());
		assertEquals(1, soil1.getValue());
		scent1.incValue(water1, soil1, 1);
		assertEquals(10, scent1.getValue());
		assertEquals(0, water1.getValue());
		assertEquals(0, soil1.getValue());
	}
	
	@Test(expected = NegativeResourceException.class)
	public void testScentIncrementUnderflow() {
		scent1.incValue(water1, soil1, 6);
	}
	
	@Test(expected = NegativeResourceException.class)
	public void testWaterExceptions() {
		water0.incValue(-5);
	}
	
	@Test(expected = NegativeResourceException.class)
	public void testWaterConstructorException() {
		water0 = new Water(-5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testScentExceptions() {
		scent1.incValue(null, soil1, 3);
	}

}
