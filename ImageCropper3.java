//上から600ピクセルの位置から縦700ピクセル、横1000ピクセルの領域を切り出す
import java.awt.image.BufferedImage;

import java.io.File;
import javax.imageio.ImageIO;

public class ImageCropper3 {

    public static BufferedImage cropImage(BufferedImage input, int startX, int startY, int targetWidth, int targetHeight) {
        // Get the subimage based on the specified position and dimensions
        return input.getSubimage(startX, startY, targetWidth, targetHeight);
    }

    public static void main(String[] args) {
        try {
            // Load your image; change the path to your image file
            File inputFile = new File("car2.jpg");
            BufferedImage inputImage = ImageIO.read(inputFile);

            // Define the starting point (x, y) and the desired width and height
            int startX = 0; // From the left edge
            int startY = 600; // 600 pixels down from the top
            int targetWidth = 1000;
            int targetHeight = 700;

            // Ensure the cropping area fits within the image dimensions
            if (startX + targetWidth > inputImage.getWidth() || startY + targetHeight > inputImage.getHeight()) {
                throw new IllegalArgumentException("Cropping dimensions exceed the bounds of the image.");
            }

            // Crop the image
            BufferedImage croppedImage = cropImage(inputImage, startX, startY, targetWidth, targetHeight);

            // Save the cropped image to a new file
            File outputFile = new File("car3.jpg");
            ImageIO.write(croppedImage, "jpg", outputFile);
            
            System.out.println("Cropped image saved as: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}