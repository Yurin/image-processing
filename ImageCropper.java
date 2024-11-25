import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageCropper {

    public static BufferedImage cropImage(BufferedImage input, int targetWidth, int targetHeight) {
        // Ensure the target width and height are within the bounds of the original image
        int cropWidth = Math.min(targetWidth, input.getWidth());
        int cropHeight = Math.min(targetHeight, input.getHeight());

        // Create the output image with specified dimensions
        BufferedImage output = new BufferedImage(cropWidth, cropHeight, input.getType());

        // Crop the image
        for (int y = 0; y < cropHeight; y++) {
            for (int x = 0; x < cropWidth; x++) {
                int rgb = input.getRGB(x, y);
                output.setRGB(x, y, rgb);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        try {
            // Load your image; change the path to your image file
            File inputFile = new File("illumi.jpg");
            BufferedImage inputImage = ImageIO.read(inputFile);

            // Define the desired width and height
            int targetWidth = 1500;
            int targetHeight = 700;

            // Crop the image
            BufferedImage croppedImage = cropImage(inputImage, targetWidth, targetHeight);

            // Save the cropped image to a new file
            File outputFile = new File("illumi.jpg");
            ImageIO.write(croppedImage, "jpg", outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}