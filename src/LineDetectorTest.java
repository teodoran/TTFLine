import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class LineDetectorTest {
	
	LineDetector line = new LineDetector();
	
	@Before 
	public void initialize() {
		line = new LineDetector();
	}
	
	/////////////////////////
	//Get straight line tests
	@Test
	public void test_getStraightLineValue_for_diogonal_left() {
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
		int[][] testArray = {{0, 0, 0, 0},
							 {1, 1, 0, 0},
							 {0, 0, 1, 1},
							 {0, 0, 0, 0}};
		
		int[] testFrom = {1, 0};
		int[] testTo = {2, 3};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_skewed_up() {
		int[][] testArray = {{0, 0, 0, 0},
							 {0, 0, 1, 1},
							 {1, 1, 0, 0},
							 {0, 0, 0, 0}};
		
		int[] testFrom = {2, 0};
		int[] testTo = {1, 3};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(4, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_skewed_down_2() {
		int[][] testArray = {{0, 0, 0, 0},
							 {0, 0, 0, 1},
							 {0, 0, 1, 0},
							 {0, 1, 0, 0}};
		
		int[] testFrom = {1, 3};
		int[] testTo = {3, 1};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void test_getStraightLineValue_cont_1() {
		int[][] testArray = {{0, 1, 0, 0},
							 {1, 0, 0, 0},
							 {1, 0, 0, 0},
							 {0, 0, 0, 0}};
		
		int[] testFrom = {0, 1};
		int[] testTo = {2, 0};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(3, actual);
	}

	@Test
	public void test_getStraightLineValue_for_big_final_value_1() {
		int[][] testArray = {{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
		
		int[] testFrom = {0, 3};
		int[] testTo = {6, 6};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(7, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_big_final_value_2() {
		int[][] testArray = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0}};
		
		int[] testFrom = {2, 0};
		int[] testTo = {6, 8};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(9, actual);
	}
	
	@Test
	public void test_getStraightLineValue_for_big_final_value_3() {
		int[][] testArray = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
							 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
							 {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		int[] testFrom = {5, 0};
		int[] testTo = {0, 10};
		
		int actual = line.getStraightLineValue(testFrom, testTo, testArray);
		
		assertEquals(11, actual);
	}
	
	///////////////////////////
	//Get candidate lines tests
	@Test
	public void test_getCandidateLines_1() {
		int[][] testArray = {{0, 1, 0},
							 {0, 1, 0},
							 {0, 1, 0}};
		
		int[] actuals = line.getCandidateLines(testArray, 3).get(0);
		int[] expecteds = {0, 1, 2, 1, 3};
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void test_getCandidateLines_2() {
		int[][] testArray = {{0, 0, 0},
							 {1, 1, 1},
							 {0, 0, 0}};
		
		int[] actuals = line.getCandidateLines(testArray, 3).get(0);
		int[] expecteds = {1, 2, 1, 0, 3};
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void test_getCandidateLines_big_final_1() {
		int[][] testArray = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
							 {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		int[] actuals = line.getCandidateLines(testArray, 9).get(0);
		int[] expecteds = {0, 9, 5, 0, 10};
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void test_getCandidateLines_big_final_2() {
		int[][] testArray = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
							 {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		int[] actuals = line.getCandidateLines(testArray, 5).get(0);
		int[] expecteds = {0, 9, 6, 3, 7};
		
		assertArrayEquals(expecteds, actuals);
	}
	
	///////////////////
	//Merge group tests
	
	@Test
	public void test_merge_groups_1() {
		int[] line1 = {0, 0, 2, 2, 2};
		int[] line2 = {0, 0, 2, 2, 1};
		int[] line3 = {10, 10, 20, 20, 10};
		
		ArrayList<int[]> lines = new ArrayList<int[]>();
		lines.add(line3);
		lines.add(line2);
		lines.add(line1);
		
		int[] expecteds = {0, 0, 2, 2, 3};
		int[] actuals = line.mergeGroup(lines).get(1);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	///////////////////////////
	//Inner Angle tests

	@Test
	public void test_innerAngle_1() {
		int[] line1 = {1, 1, 2, 2};
		int[] line2 = {1, 2, 2, 1};
		
		double expected = Math.PI/2;
		double actual = line.innerAngle(line2, line1);
		
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void test_innerAngle_2() {
		int[] line1 = {2, 2, 1, 1};
		int[] line2 = {2, 1, 1, 2};
		
		double expected = Math.PI/2;
		double actual = line.innerAngle(line2, line1);
		
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void test_innerAngle_3() {
		int[] line1 = {1, 1, 4, 1};
		int[] line2 = {1, 1, 4, 3};
		
		double expected = Math.atan(2f/3f);
		double actual = line.innerAngle(line2, line1);
		
		assertEquals(expected, actual, 0.00005);
	}
	
	@Test
	public void test_innerAngle_4() {
		int[] line1 = {4, 1, 1, 1};
		int[] line2 = {1, 1, 4, 3};
		
		double expected = Math.atan(2f/3f);
		double actual = line.innerAngle(line2, line1);
		
		assertEquals(expected, actual, 0.00005);
	}
	
	@Test
	public void test_innerAngle_5() {
		int[] line1 = {4, 1, 1, 1};
		int[] line2 = {4, 3, 1, 1};
		
		double expected = Math.atan(2f/3f);
		double actual = line.innerAngle(line2, line1);
		
		assertEquals(expected, actual, 0.00005);
	}
	
}