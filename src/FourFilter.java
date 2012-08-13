public class FourFilter {

	public int[][] filter(int[][] img) {

		int step = 4;

		int w = img.length / step;
		int h = img[0].length / step;

		int[][] filteredImg = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int[][] section = {
						{ img[i * step][j * step],
								img[i * step][(j * step) + 1] },
						{ img[(i * step) + 1][j * step],
								img[(i * step) + 1][(j * step) + 1] } };
				filteredImg[i][j] = compressBool(section);
			}
		}

		return filteredImg;
	}

	public int compress(int[][] section) {
		int threshold = 1000;
		int delta = max(section) - min(section);
		if (delta < threshold) {
			return Color.BLACK.getRGB();
		}
		return Color.WHITE.getRGB();
	}

	public int compressBool(int[][] section) {
		int threshold = 1000;
		int delta = max(section) - min(section);
		if (delta < threshold) {
			return 0;
		}
		return 1;
	}

	public int min(int[][] section) {
		int min = section[0][0];
		for (int i = 0; i < section.length; i++) {
			for (int j = 0; j < section[0].length; j++) {
				if (section[i][j] < min) {
					min = section[i][j];
				}
			}
		}
		return min;
	}

	public int max(int[][] section) {
		int max = section[0][0];
		for (int i = 0; i < section.length; i++) {
			for (int j = 0; j < section[0].length; j++) {
				if (section[i][j] > max) {
					max = section[i][j];
				}
			}
		}
		return max;
	}

}
