import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class BitmapFilter {
	public static BufferedImage img;

	public static void main(String[] args) throws IOException {
		img = ImageIO.read(new File("img/rboat5.jpg"));
		drawLines();
		drawFourFilter();
	}

	public static void drawLines() throws IOException {
		FourFilter filter = new FourFilter();

		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				pixels[i][j] = luminanceFromARGB(img.getRGB(i, j));
			}
		}

		int[][] filteredPixels = filter.filterHard(pixels);

		System.out.println("Done filtering");

		LineDetector lineDetector = new LineDetector();

		w = filteredPixels.length;
		h = filteredPixels[0].length;

		BufferedImage filteredImg = new BufferedImage(w, h, 1);

		Graphics graph = filteredImg.getGraphics();

		ArrayList<int[]> lines = lineDetector.getCandidateLines(filteredPixels,	w/4);

		System.out.println("Done getting candidates");
		System.out.println("No of candidates: " + lines.size());

		lines = lineDetector.reduceCandidates(lines);

		graph.setColor(Color.RED);
		
		System.out.println("Angle: " + lineDetector.innerAngle(lines.get(0), lines.get(1))*(180/Math.PI));

		for (int[] line : lines) {
			System.out.println(line[4]);
			graph.drawLine(line[0], line[1], line[2], line[3]);
		}

		graph.drawImage(filteredImg, 0, 0, null);

		ImageIO.write(filteredImg, "png", new File("img/savedLines.png"));
	}

	public static void drawFourFilter() throws IOException {
		FourFilter filter = new FourFilter();

		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				pixels[i][j] = luminanceFromARGB(img.getRGB(i, j));
			}
		}

		int[][] filteredPixels = filter.filterHard(pixels);

		System.out.println("Done filtering");

		w = filteredPixels.length;
		h = filteredPixels[0].length;

		BufferedImage filteredImg = new BufferedImage(w, h, 1);

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (filteredPixels[i][j] >= 1) {
					filteredImg.setRGB(i, j, Color.RED.getRGB());
				} else {
					filteredImg.setRGB(i, j, Color.WHITE.getRGB());
				}
			}
		}
		ImageIO.write(filteredImg, "png", new File("img/savedFourFilter.png"));
	}
	
	public static int luminanceFromARGB(int rgb) {
		int r =   (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b =  (rgb      ) & 0xFF;
		return luminance(r, g, b);
	}
	
	public static int luminance(float r, float g, float b) {
		return Math.round(0.299f * r + 0.587f * g + 0.114f * b);
	}

}
