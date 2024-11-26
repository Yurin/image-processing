//チェキフレーム
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Photoframe {

    public static void main(String[] args) {
        String inputImagePath = "night_and_heart3.jpg"; 
        String outputImagePath = "cheki.jpg"; 

        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));
            int frameThickness = 20; // フレームの厚さ
            double chekiRatio = 1.25; // チェキの縦横比（例: 8.5cm x 10.5cm）

            BufferedImage chekiImage = addChekiStyleFrame(originalImage, frameThickness, chekiRatio, Color.WHITE);

            // 画像を保存
            ImageIO.write(chekiImage, "jpg", new File(outputImagePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage addChekiStyleFrame(BufferedImage originalImage, int thickness, double ratio, Color frameColor) {
        // 元画像の幅と高さ
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();
        
        // 新しい高さを計算
        int newWidth = originalWidth + thickness * 2;
        int newHeight = (int) (newWidth * ratio);

        // チェキの白いところ
        BufferedImage chekiImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = chekiImage.createGraphics();
        g2d.setColor(frameColor);
        g2d.fillRect(0, 0, newWidth, newHeight);

        // 画像やや上に配置
        int x = thickness;
        int y = thickness + (newHeight - originalHeight - thickness * 2) / 4;  // 下部の余白を多めに

        // 元の画像を描画
        g2d.drawImage(originalImage, x, y, null);

        g2d.dispose();
        return chekiImage;
    }
}