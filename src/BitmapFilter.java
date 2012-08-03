import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapFilter {

	// Bitmap bitmap = BitmapFactory.decodeFile(filename)

	public static void main(String[] args) throws IOException {

		BufferedImage img = ImageIO.read(new File("img/stones.jpg"));

		int w = img.getWidth();
		int h = img.getHeight();

		int[][] pixels = new int[w][h];

		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				pixels[i][j] = img.getRGB(i, j);

		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				pixels[i][j] = Color.BLACK.getRGB();

		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				img.setRGB(i, j, pixels[i][j]);

		// bufferedImage.setRGB(x, y, rgb);
		ImageIO.write(img, "png", new File("img/saved.png"));

	}

}
