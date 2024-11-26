import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCropper2 {

    public static void main(String[] args) {

        String inputImagePath = "icho_shoes2.jpg";
        String outputImagePath = "icho_shoes3.jpg";

        try {
            // 切る画像読み込み
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            
            // 切る元画像の大きさ
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();

            // 切るサイズ
            int cropWidth = 1000;
            int cropHeight = 700;

            // 画像の中心からの切り出し位置を計算
            int cropStartX = (originalWidth - cropWidth) / 2;
            int cropStartY = (originalHeight - cropHeight) / 2;

            // 切る
            BufferedImage croppedImage = originalImage.getSubimage(cropStartX, cropStartY, cropWidth, cropHeight);

            // 結果
            ImageIO.write(croppedImage, "jpg", new File(outputImagePath));

            System.out.println("画像が正常に切り出されました: " + outputImagePath);

        } catch (IOException e) {
            System.out.println("画像の処理中にエラーが発生しました: " + e.getMessage());
            e.printStackTrace();
        }
    }
}