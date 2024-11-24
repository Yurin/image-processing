import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SepiaConverter {

    public static void main(String[] args) {
        try {
            File input = new File("night_and_heart2.jpg");
            BufferedImage image = ImageIO.read(input);
            BufferedImage sepiaImage = convertToSepia(image);

            File output = new File("night_and_heart3.jpg");
            ImageIO.write(sepiaImage, "jpg", output);

            System.out.println("Image successfully converted to sepia tone.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static BufferedImage convertToSepia(BufferedImage original) {
        int width = original.getWidth();
        int height = original.getHeight();
        BufferedImage sepia = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = original.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                int tr = (int)(0.393 * r + 0.769 * g + 0.189 * b);
                int tg = (int)(0.349 * r + 0.686 * g + 0.168 * b);
                int tb = (int)(0.272 * r + 0.534 * g + 0.131 * b);

                if(tr > 255) {
                    tr = 255;
                }
                if(tg > 255) {
                    tg = 255;
                }
                if(tb > 255) {
                    tb = 255;
                }

                int newPixel = (a << 24) | (tr << 16) | (tg << 8) | tb;
                sepia.setRGB(x, y, newPixel);
            }
        }
        return sepia;
    }
}