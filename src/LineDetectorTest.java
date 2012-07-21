import static org.junit.Assert.*;

import org.junit.Test;


public class LineDetectorTest {
	
	///////////////////////
	//Iterator bounds tests
	@Test
	public void test_getIteratorBounds_right_diogonal(){
		LineDetector line = new LineDetector();
		
		int[] testFrom = {0, 0};
		int[] testTo = {2, 2};
		
		int[] expecteds = {0, 3, 0, 3};
		
		int[] actuals = line.getIteratorBounds(testFrom, testTo);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void test_getIteratorBounds_left_diogonal(){
		LineDetector line = new LineDetector();
		
		int[] testFrom = {0, 2};
		int[] testTo = {2, 0};
		
		int[] expecteds = {0, 3, 0, 3};
		
		int[] actuals = line.getIteratorBounds(testFrom, testTo);
		
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_getIteratorBounds_right_skewed(){
		LineDetector line = new LineDetector();
		
		int[] testFrom = {0, 1};
		int[] testTo = {3, 2};
		
		int[] expecteds = {0, 4, 1, 3};
		
		int[] actuals = line.getIteratorBounds(testFrom, testTo);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	//////////////////
	//Is on line tests
	@Test
	public void test_isOnLine_0(){
		LineDetector line = new LineDetector();
		
		double fraction = (double)1/(double)3;
		int constant = 1;
				
		int i0 = 0;
		int j0 = 1;
		
		assertTrue(line.isOnLine(i0, j0, fraction, constant));
	}
	
	@Test
	public void test_isOnLine_1(){
		LineDetector line = new LineDetector();
		
		double fraction = (double)1/(double)3;
		int constant = 1;
		
		int i1 = 1;
		int j1 = 1;

		assertTrue(line.isOnLine(i1, j1, fraction, constant));
	}
	
	@Test
	public void test_isOnLine_2(){
		LineDetector line = new LineDetector();
		
		double fraction = (double)1/(double)3;
		int constant = 1;
		
		int i2 = 2;
		int j2 = 2;

		assertTrue(line.isOnLine(i2, j2, fraction, constant));
	}
	
	@Test
	public void test_isOnLine_3(){
		LineDetector line = new LineDetector();
		
		double fraction = (double)1/(double)3;
		int constant = 1;
		
		int i3 = 3;
		int j3 = 2;

		assertTrue(line.isOnLine(i3, j3, fraction, constant));
	}
	
	/////////////////////////
	//Get straight line tests
	@Test
	public void test_getStraightLineValue_for_diogonal_left() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 1},
							 {0, 1, 0},
							 {1, 0, 0}};
		
		int[] testFrom = {0, 2};
		int[] testTo = {2, 0};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_flat() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{1, 1, 1},
							 {0, 0, 0},
							 {0, 0, 0}};
		
		int[] testFrom = {0, 0};
		int[] testTo = {0, 2};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_down() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{1, 0, 0},
							 {1, 0, 0},
							 {1, 0, 0}};
		
		int[] testFrom = {0, 0};
		int[] testTo = {2, 0};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_justified_flat() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 0},
							 {1, 1, 1},
							 {0, 0, 0}};
		
		int[] testFrom = {1, 0};
		int[] testTo = {1, 2};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_justified_down() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 1, 0},
							 {0, 1, 0},
							 {0, 1, 0}};
		
		int[] testFrom = {0, 1};
		int[] testTo = {2, 1};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}

	@Test
	public void test_getStraightLineValue_for_skewed_right() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 1, 0, 0},
							 {0, 1, 0, 0},
							 {0, 0, 1, 0},
							 {0, 0, 1, 0}};
		
		int[] testFrom = {0, 1};
		int[] testTo = {3, 2};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_skewed_left() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 1, 0},
							 {0, 0, 1, 0},
							 {0, 1, 0, 0},
							 {0, 1, 0, 0}};
		
		int[] testFrom = {0, 2};
		int[] testTo = {3, 1};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_skewed_down() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 0, 0},
							 {1, 1, 0, 0},
							 {0, 0, 1, 1},
							 {0, 0, 0, 0}};
		
		int[] testFrom = {0, 2};
		int[] testTo = {3, 1};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}


}
