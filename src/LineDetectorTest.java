import static org.junit.Assert.*;

import org.junit.Test;


public class LineDetectorTest {

/*	@Test
	public void test_getStraigthLineValue_for_diogonal_lefth() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 1},
							 {0, 2, 0},
							 {3, 0, 0}};
		
		int[] testFrom = {2, 0};
		int[] testTo = {2, 0};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(6, actual);
	}
*/
	
	@Test
	public void test_getStraigthLineValue_for_diogonal_right() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{1, 0, 0},
							 {0, 1, 0},
							 {0, 0, 1}};
		
		int[] testFrom = {0, 0};
		int[] testTo = {2, 2};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraigthLineValue_for_flat() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{1, 1, 1},
							 {0, 0, 0},
							 {0, 0, 0}};
		
		int[] testFrom = {0, 0};
		int[] testTo = {0, 2};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraigthLineValue_for_down() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{1, 0, 0},
							 {1, 0, 0},
							 {1, 0, 0}};
		
		int[] testFrom = {0, 0};
		int[] testTo = {2, 0};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraigthLineValue_for_justified_flat() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 0, 0},
							 {1, 1, 1},
							 {0, 0, 0}};
		
		int[] testFrom = {1, 0};
		int[] testTo = {1, 2};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraigthLineValue_for_justified_down() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 1, 0},
							 {0, 1, 0},
							 {0, 1, 0}};
		
		int[] testFrom = {0, 1};
		int[] testTo = {2, 1};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}

/*	@Test
	public void test_getStraigthLineValue_for_skewed_right() {
		LineDetector line = new LineDetector();
		
		int[][] testArray = {{0, 1, 0, 0},
							 {0, 1, 0, 0},
							 {0, 0, 1, 0},
							 {0, 0, 1, 0}};
		
		int[] testFrom = {0, 1};
		int[] testTo = {3, 2};
		
		int actual = line.getStraigthLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}
*/

}
