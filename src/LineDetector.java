import java.util.ArrayList;
import java.util.HashSet;

public class LineDetector {

	public ArrayList<int[]> getCandidateLines(int[][] edgeArray, int threshold) {
		ArrayList<int[]> candidateLines = new ArrayList<int[]>();

		int height = edgeArray.length;
		int width = edgeArray[0].length;

		// top iteration
		for (int n = 0; n < width; n++) {
			int[] edgePointFrom = { 0, n };
			candidateLines.addAll(getCandidatesForSide(edgePointFrom,
					edgeArray, width, height, threshold, false, true, true,
					true));
		}

		// right iteration
		for (int n = 0; n < height; n++) {
			int[] edgePointFrom = { n, width - 1 };
			candidateLines.addAll(getCandidatesForSide(edgePointFrom,
					edgeArray, width, height, threshold, false, false, true,
					true));
		}

		// bottom iteration
		for (int n = 0; n < width; n++) {
			int[] edgePointFrom = { height - 1, n };
			candidateLines.addAll(getCandidatesForSide(edgePointFrom,
					edgeArray, width, height, threshold, false, false, false,
					true));
		}

		return new ArrayList<int[]>(new HashSet<int[]>(candidateLines));
	}

	public ArrayList<int[]> getCandidatesForSide(int[] edgePointFrom,
			int[][] edgeArray, int width, int height, int threshold,
			boolean doTop, boolean doRight, boolean doBottom, boolean doLeft) {
		ArrayList<int[]> candidateLinesForSide = new ArrayList<int[]>();

		if (doTop) {
			for (int n = 0; n < width; n++) {
				int[] edgePointTo = { 0, n };
				int[] line = {
						edgePointFrom[0],
						edgePointFrom[1],
						edgePointTo[0],
						edgePointTo[1],
						getStraightLineValue(edgePointFrom, edgePointTo,
								edgeArray) };

				if (line[4] >= threshold) {
					candidateLinesForSide.add(line);
				}
			}
		}
		if (doRight) {
			for (int n = 0; n < height; n++) {
				int[] edgePointTo = { n, width - 1 };
				int[] line = {
						edgePointFrom[0],
						edgePointFrom[1],
						edgePointTo[0],
						edgePointTo[1],
						getStraightLineValue(edgePointFrom, edgePointTo,
								edgeArray) };

				if (line[4] >= threshold) {
					candidateLinesForSide.add(line);
				}
			}
		}
		if (doBottom) {
			for (int n = 0; n < width; n++) {
				int[] edgePointTo = { height - 1, n };
				int[] line = {
						edgePointFrom[0],
						edgePointFrom[1],
						edgePointTo[0],
						edgePointTo[1],
						getStraightLineValue(edgePointFrom, edgePointTo,
								edgeArray) };

				if (line[4] >= threshold) {
					candidateLinesForSide.add(line);
				}
			}
		}
		if (doLeft) {
			for (int n = 0; n < height; n++) {
				int[] edgePointTo = { n, 0 };
				int[] line = {
						edgePointFrom[0],
						edgePointFrom[1],
						edgePointTo[0],
						edgePointTo[1],
						getStraightLineValue(edgePointFrom, edgePointTo,
								edgeArray) };

				if (line[4] >= threshold) {
					candidateLinesForSide.add(line);
				}
			}
		}

		return candidateLinesForSide;
	}

	public int getStraightLineValue(int[] edgePointFrom, int[] edgePointTo,
			int[][] intArray) {
		return getLineSum(intArray, edgePointFrom[0], edgePointFrom[1],
				edgePointTo[0], edgePointTo[1]);
	}

	public int getLineSum(int[][] array, int x, int y, int x2, int y2) {
		int sum = 0;

		int w = x2 - x;
		int h = y2 - y;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;

		if (w < 0)
			dx1 = -1;
		else if (w > 0)
			dx1 = 1;
		if (h < 0)
			dy1 = -1;
		else if (h > 0)
			dy1 = 1;
		if (w < 0)
			dx2 = -1;
		else if (w > 0)
			dx2 = 1;

		int longest = Math.abs(w);
		int shortest = Math.abs(h);

		if (!(longest > shortest)) {
			longest = Math.abs(h);
			shortest = Math.abs(w);
			if (h < 0)
				dy2 = -1;
			else if (h > 0)
				dy2 = 1;
			dx2 = 0;
		}

		int numerator = longest >> 1;

		for (int i = 0; i <= longest; i++) {
			sum += array[x][y];
			numerator += shortest;
			if (!(numerator < longest)) {
				numerator -= longest;
				x += dx1;
				y += dy1;
			} else {
				x += dx2;
				y += dy2;
			}
		}

		return sum;
	}

}