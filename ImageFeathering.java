import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageFeathering {

    public static BufferedImage cropAndFeather(BufferedImage original, int targetWidth, int targetHeight, int featherSize) {
        int width = original.getWidth();
        int height = original.getHeight();
        
        // Determine bounds for cropping
        int cropWidth = Math.min(targetWidth, width);
        int cropHeight = Math.min(targetHeight, height);

        // Create cropped version
        BufferedImage cropped = original.getSubimage(0, 0, cropWidth, cropHeight);
        return featherEdges(cropped, featherSize);
    }

    public static BufferedImage featherEdges(BufferedImage image, int featherSize) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage output = new BufferedImage(width, height, image.getType());

        // Copy original to output
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output.setRGB(x, y, image.getRGB(x, y));
            }
        }

        // Feather along the edges
        for (int y = 0; y < height; y++) {
            // Feather on the left and right
            for (int x = 0; x < featherSize; x++) {
                blendWithNeighbors(output, image, x, y, featherSize);
                blendWithNeighbors(output, image, width - 1 - x, y, featherSize);
            }
        }
        for (int x = 0; x < width; x++) {
            // Feather on the top and bottom
            for (int y = 0; y < featherSize; y++) {
                blendWithNeighbors(output, image, x, y, featherSize);
                blendWithNeighbors(output, image, x, height - 1 - y, featherSize);
            }
        }

        return output;
    }

    private static void blendWithNeighbors(BufferedImage output, BufferedImage image, int x, int y, int featherSize) {
        int numNeighbors = 0;
        int alphaSum = 0, redSum = 0, greenSum = 0, blueSum = 0;

        // Average across neighboring pixels in range
        for (int dy = -featherSize; dy <= featherSize; dy++) {
            for (int dx = -featherSize; dx <= featherSize; dx++) {
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && nx < image.getWidth() && ny >= 0 && ny < image.getHeight()) {
                    int rgb = image.getRGB(nx, ny);
                    alphaSum += (rgb >> 24) & 0xFF;
                    redSum += (rgb >> 16) & 0xFF;
                    greenSum += (rgb >> 8) & 0xFF;
                    blueSum += rgb & 0xFF;
                    numNeighbors++;
                }
            }
        }

        // Calculate the average color
        int avgAlpha = alphaSum / numNeighbors;
        int avgRed = redSum / numNeighbors;
        int avgGreen = greenSum / numNeighbors;
        int avgBlue = blueSum / numNeighbors;

        int avgRgb = (avgAlpha << 24) | (avgRed << 16) | (avgGreen << 8) | avgBlue;
        output.setRGB(x, y, avgRgb);
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("night_and_heart2.jpg");
            BufferedImage inputImage = ImageIO.read(inputFile);
            
            int targetWidth = 3000;
            int targetHeight = 1800;
            int featherSize = 10;  // Adjust feathering strength

            BufferedImage featheredImage = cropAndFeather(inputImage, targetWidth, targetHeight, featherSize);

            File outputFile = new File("night_and_heart3.jpg");
            ImageIO.write(featheredImage, "jpg", outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}