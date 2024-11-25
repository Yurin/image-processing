import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TextToImage {
    public static void main(String[] args) {
        String text = "1st anniversary"; // 画像に描画したい文字列
        int width = 1500;
        int height = 700;

        // BufferedImageオブジェクトの作成
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // 背景を白に設定
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        // 描画する文字の設定
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Serif", Font.PLAIN, 220));

        // 文字の描画
        graphics.drawString(text, 50, 450);

        // Graphicsオブジェクトを解放
        graphics.dispose();

        // ファイルに書き込む
        try {
            File outputfile = new File("text.jpg");
            ImageIO.write(image, "jpg", outputfile);
            System.out.println("画像を保存しました: text.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}