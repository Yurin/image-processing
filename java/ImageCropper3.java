//上から600ピクセルの位置から縦700ピクセル、横1000ピクセルの領域を切り出す
import java.awt.image.BufferedImage;

import java.io.File;
import javax.imageio.ImageIO;

public class ImageCropper3 {

    public static BufferedImage cropImage(BufferedImage input, int startX, int startY, int targetWidth, int targetHeight) {
        return input.getSubimage(startX, startY, targetWidth, targetHeight);
    }

    public static void main(String[] args) {
        try {
            // 切る画像
            File inputFile = new File("car2.jpg");
            BufferedImage inputImage = ImageIO.read(inputFile);

            // どこからどの大きさ切るか
            int startX = 0; 
            int startY = 600; 
            int targetWidth = 1000;
            int targetHeight = 700;

            // 切る
            BufferedImage croppedImage = cropImage(inputImage, startX, startY, targetWidth, targetHeight);

            // 結果
            File outputFile = new File("car3.jpg");
            ImageIO.write(croppedImage, "jpg", outputFile);
            
            System.out.println("Cropped image saved as: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}