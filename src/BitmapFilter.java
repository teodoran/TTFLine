import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public static class BitmapFilter {

	public static void main(String[] args) throws IOException {

		BufferedImage img = ImageIO.read(new File("img/canny.png"));
		LineDetector lineDetector = new LineDetector();
		FourFilter filter = new FourFilter();

		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				pixels[i][j] = img.getRGB(i, j);

		int[][] filteredPixels = filter(pixels);

		System.out.println("Done filtering");

		w = filteredPixels.length;
		h = filteredPixels[0].length;

		BufferedImage filteredImg = new BufferedImage(w, h, 1);

		Graphics graph = filteredImg.getGraphics();

		ArrayList<int[]> lines = lineDetector.getCandidateLines(filteredPixels, -10000000);
		
		System.out.println("Done getting candidates");
		
		System.out.println("No of candidates: " + lines.size());

		lines = lineDetector.reduceCandidates(lines);

		graph.setColor(Color.RED);

		for (int[] line : lines) {
			System.out.println(line[4]);
			graph.drawLine(line[0], line[1], line[2], line[3]);
		}

		graph.drawImage(filteredImg, 0, 0, null);

		/*
		 * for (int i = 0; i < w; i++) { for (int j = 0; j < h; j++) {
		 * filteredImg.setRGB(i, j, filteredPixels[i][j]); } }
		 */

		ImageIO.write(filteredImg, "png", new File("img/saved.png"));
	}

}
