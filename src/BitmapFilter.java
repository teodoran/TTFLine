import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapFilter {

	// Bitmap bitmap = BitmapFactory.decodeFile(filename)

	public static void main(String[] args) throws IOException {

		BufferedImage img = ImageIO.read(new File("img/line.png"));

		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				pixels[i][j] = img.getRGB(i, j);
		
		int[][] filteredPixels = filter(pixels);
		
		w = filteredPixels.length;
		h = filteredPixels[0].length;
		
		BufferedImage filteredImg = new BufferedImage(w, h, 1);

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				filteredImg.setRGB(i, j, filteredPixels[i][j]);
			}
		}
		ImageIO.write(filteredImg, "png", new File("img/saved.png"));

	}
	
	public static int[][] filter(int[][] img) {
		
		int step = 4;
		
		int w = img.length/step;
		int h = img[0].length/step;
		
		int[][] filteredImg = new int[w][h];
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int[][] section = {{img[i*step][j*step], img[i*step][(j*step)+1]}, 
									{img[(i*step)+1][j*step], img[(i*step)+1][(j*step)+1]}};
				filteredImg[i][j] = compress(section);
			}
		}
		
		return filteredImg;
	}
	
	public static int compress(int[][] section) {
		int threshold = 1000;
		int delta = max(section) - min(section);
		if (delta < threshold) {
			return Color.BLACK.getRGB();
		}
		return Color.WHITE.getRGB();
	}
	
	public static int min(int[][] section) {
		int min = section[0][0];
		for (int i = 0; i<section.length; i++) {
			for (int j = 0; j<section[0].length; j++) {
				if (section[i][j] < min) {
					min = section[i][j];
				}
			}
		}
		return min;
	}
	
	public static int max(int[][] section) {
		int max = section[0][0];
		for (int i = 0; i<section.length; i++) {
			for (int j = 0; j<section[0].length; j++) {
				if (section[i][j] > max) {
					max = section[i][j];
				}
			}
		}
		return max;
	}

}
