import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame {
    public static void main(String[] args) {
        try {
            // 画像読み込み
            BufferedImage originalImage = ImageIO.read(new File("4pictures2.jpg"));
            
            // 額縁の太さ
            int frameThickness = 20;

            // 元画像の幅と高さ
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            // 新しい画像の幅と高さ
            int newWidth = width + frameThickness * 2;
            int newHeight = height + frameThickness * 2;

            // 新しい画像を作成
            BufferedImage framedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

            Graphics2D g2d = framedImage.createGraphics();

            // 白背景
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, newWidth, newHeight);

            // 元画像の描画
            g2d.drawImage(originalImage, frameThickness, frameThickness, null);

            g2d.dispose();

            // 結果
            ImageIO.write(framedImage, "jpg", new File("4pictures3.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
