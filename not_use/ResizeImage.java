import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ResizeImage {
    public static void main(String[] args) {
        // 入力ファイルパスを指定
        String inputImagePath = "input.jpg";
        // 出力ファイルパスを指定
        String outputImagePath = "output.jpg";
        // 新しい画像の幅と高さを指定
        int scaledWidth = 800;
        int scaledHeight = 600;

        try {
            // 画像を読み込む
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // 出力用BufferedImageを作成
            BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

            // グラフィックス2Dオブジェクトを取得
            Graphics2D graphics2D = outputImage.createGraphics();
            // 新しいサイズに画像を描画（スケール）
            graphics2D.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
            // リソースを解放
            graphics2D.dispose();

            // 出力画像をファイルに書き込む
            ImageIO.write(outputImage, "jpg", new File(outputImagePath));

            System.out.println("画像のサイズを変更しました: " + outputImagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}