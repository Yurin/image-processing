import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame {
    public static void main(String[] args) {
        try {
            // 画像を読み込みます
            BufferedImage originalImage = ImageIO.read(new File("4pictures2.jpg"));
            
            // 額縁の太さを設定
            int frameThickness = 20;

            // 元の画像の幅と高さを取得
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            // 新しい画像の幅と高さを計算
            int newWidth = width + frameThickness * 2;
            int newHeight = height + frameThickness * 2;

            // 新しい画像を作成
            BufferedImage framedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

            // 描画コンテキストを取得
            Graphics2D g2d = framedImage.createGraphics();

            // 白い背景を描画
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, newWidth, newHeight);

            // 元の画像を描画
            g2d.drawImage(originalImage, frameThickness, frameThickness, null);

            // リソースを解放
            g2d.dispose();

            // 画像をファイルに書き出します
            ImageIO.write(framedImage, "jpg", new File("4pictures3.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
