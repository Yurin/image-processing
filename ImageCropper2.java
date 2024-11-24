import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCropper2 {

    public static void main(String[] args) {
        // 入力画像のパスを指定
        String inputImagePath = "icho_shoes2.jpg";
        // 出力画像のパスを指定
        String outputImagePath = "icho_shoes3.jpg";

        try {
            // 画像を読み込む
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            
            // オリジナル画像のサイズを取得
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();

            // 切り出すサイズ
            int cropWidth = 1000;
            int cropHeight = 700;

            // 画像の中心からの切り出し位置を計算
            int cropStartX = (originalWidth - cropWidth) / 2;
            int cropStartY = (originalHeight - cropHeight) / 2;

            // 画像を切り出す
            BufferedImage croppedImage = originalImage.getSubimage(cropStartX, cropStartY, cropWidth, cropHeight);

            // 切り出した画像をファイルに書き出す
            ImageIO.write(croppedImage, "jpg", new File(outputImagePath));

            System.out.println("画像が正常に切り出されました: " + outputImagePath);

        } catch (IOException e) {
            System.out.println("画像の処理中にエラーが発生しました: " + e.getMessage());
            e.printStackTrace();
        }
    }
}