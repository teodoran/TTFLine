
public class LineDetector {

	public int getStraightLineValue(int[] edgePointFrom, int[] edgePointTo, int[][] intArray) {
		int lineSum = 0;
		int[] diffPoint = getDiffPoint(edgePointFrom, edgePointTo);
		
		if (diffPoint[0] == 0) {
			return sumArray(intArray[edgePointFrom[0]]);
		}
		
		if (diffPoint[1] == 0) {
			for (int[] line:intArray) {
				lineSum += line[edgePointFrom[1]];
			}
			return lineSum;
		}
		
		double fraction = getSlope(diffPoint[0], diffPoint[1]);
		
		int[] iteratorBounds = getIteratorBounds(edgePointFrom, edgePointTo);
		
		int i0 = iteratorBounds[0];
		int i1 = iteratorBounds[1];
		int j0 = iteratorBounds[2];
		int j1 = iteratorBounds[3];
		
		for (int i=i0; i<i1; i++) {
			for (int j=j0; j<j1; j++) {
				if (isOnLine(i, j, fraction, edgePointFrom[1])){
					lineSum += intArray[i][j];
				}
			}
		}
		return lineSum;
	}
	
	private double getSlope(int x, int y) {
		return (double)y/(double)x;
	}
	
	private int[] getDiffPoint(int[] pointFrom, int[] pointTo) {
		int diffX = pointTo[0]-pointFrom[0];
		int diffY = pointTo[1]-pointFrom[1];
		int[] point = {diffX, diffY};
		return point;
	}
	
	public int[] getIteratorBounds(int[] pointFrom, int[] pointTo) {
		int i0 = Math.min(pointFrom[0], pointTo[0]) ;
		int i1 = Math.max(pointFrom[0], pointTo[0])+1;
		int j0 = Math.min(pointFrom[1], pointTo[1]);
		int j1 = Math.max(pointFrom[1], pointTo[1])+1;
		int[] points = {i0, i1, j0, j1};
		return points;
	}
	
	private int sumArray(int[] array) {
		int sum = 0;
		for (int i:array) {
			sum += i;
		}
		return sum;
	}

	public boolean isOnLine(int i, int j, double fraction, int constant) {
		return (j == (int)(Math.round(fraction*i)+constant));
	}

}
