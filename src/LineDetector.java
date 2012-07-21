
public class LineDetector {

	public int getStraigthLineValue(int[] edgePointFrom, int[] edgePointTo, int[][] intArray) {
		int lineSum = 0;
		int[] diffPoint = getDiffPoint(edgePointFrom, edgePointTo);
		
		if (diffPoint[0] == 0) {
			return sumArray(intArray[edgePointFrom[0]]);
		}
		
		double fraction = getSlope(diffPoint[0], diffPoint[1]);
		
		System.out.println(fraction);
		
		if (fraction == -1) {
			for (int[] line:intArray) {
				lineSum += line[edgePointFrom[1]];
			}
			return lineSum;
		}
		
		int i0 = 0;
		int i1 = intArray.length;
		int j0 = 0;
		int j1 = intArray[0].length;
		
		/*
		int i0 = edgePointFrom[0];
		int i1 = intArray.length;
		int j0 = edgePointFrom[1];
		int j1 = intArray[0].length;
		*/
		
		for (int i=i0; i<i1; i++) {
			for (int j=j0; j<j1; j++) {
				if (j == Math.round(fraction*i)){
					lineSum += intArray[i][j];
					System.out.println(intArray[i][j]);
				}
			}
		}
		return lineSum;
	}
	
	private double getSlope(int x, int y) {
		if (x == 0 && y== 0) {
			return 1;
		} else if (y == 0) {
			return -1;
		} else {
			return y/x;
		}
	}
	
	private int[] getDiffPoint(int[] pointFrom, int[] pointTo) {
		int diffX = pointTo[0]-pointFrom[0];
		int diffY = pointTo[1]-pointFrom[1];
		int[] point = {diffX, diffY};
		return point;
	}
	
	private int sumArray(int[] array) {
		int sum = 0;
		for (int i:array) {
			sum += i;
		}
		return sum;
	}

}
