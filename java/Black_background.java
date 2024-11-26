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
            File file = new File("background.jpg");
            ImageIO.write(image, "jpg", file); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}