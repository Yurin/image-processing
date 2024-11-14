import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Skyimage {
    public static void main(String[] args) {
        // 画像の幅と高さを設定
        int width = 3000;
        int height = 2000;

        // BufferedImageを作成
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Graphics2Dオブジェクトを取得
        Graphics2D g2d = image.createGraphics();

        // 梯度塗りを作成（上が暗い紺色、下が明るい青）
        Color darkBlue = new Color(10, 10, 40); // 上部の暗い紺色
        Color lightBlue = new Color(70, 70, 160); // 下部の明るい青

        // GradientPaintを使って垂直グラデーションを設定
        GradientPaint gradient = new GradientPaint(
            0, 0, darkBlue,     // 開始点とその色
            0, height, lightBlue // 終了点とその色
        );
        
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);

        // 描画オブジェクトを解放
        g2d.dispose();

        // ファイルに保存
        try {
            File file = new File("night_sky.jpeg"); // 拡張子をjpegに設定
            ImageIO.write(image, "jpeg", file); // フォーマットもjpegに合わせる
            System.out.println("画像を保存しました: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}