import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Black_background {
    public static void main(String[] args) {
        // 画像の幅と高さを設定
        int width = 4000;
        int height = 3000;

        // BufferedImageを作成
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Graphics2Dオブジェクトを取得
        Graphics2D g2d = image.createGraphics();

        Color black = new Color(0, 0, 0); 
        g2d.setColor(black);
        g2d.fillRect(0, 0, width, height);

        // 描画オブジェクトを解放
        g2d.dispose();

        // ファイルに保存
        try {
            File file = new File("background.jpg"); // 拡張子をjpgに設定
            ImageIO.write(image, "jpg", file); // フォーマットもjpgに合わせる
            System.out.println("画像を保存しました: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}