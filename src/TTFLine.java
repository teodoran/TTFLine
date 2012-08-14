import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TTFLine {
	FourFilter filter;
	LineDetector lineDetector;
	
	public TTFLine() {
		filter = new FourFilter();
		lineDetector = new LineDetector();
	}
	
	public double calculateYaw(BufferedImage img){
		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				pixels[i][j] = luminanceFromARGB(img.getRGB(i, j));
			}
		}

		int[][] filteredPixels = filter.filterHard(pixels);

		w = filteredPixels.length;
		h = filteredPixels[0].length;

		ArrayList<int[]> lines = lineDetector.getCandidateLines(filteredPixels,	w/4);

		lines = lineDetector.reduceCandidates(lines);
		
		if (lines.size() <= 0) {
			return Math.random()*(Math.PI/2);
		} else if (lines.size() == 1) {
			int[] horizontal = {0, 0, 10, 0};
			return lineDetector.innerAngle(lines.get(0), horizontal);
		} 
		
		return lineDetector.innerAngle(lines.get(0), lines.get(1));
	}
	
	public int luminanceFromARGB(int rgb) {
		int r =   (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b =  (rgb      ) & 0xFF;
		return luminance(r, g, b);
	}
	
	public int luminance(float r, float g, float b) {
		return Math.round(0.299f * r + 0.587f * g + 0.114f * b);
	}

}
