import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CircleCrop {

    public static void main(String[] args) {
        try {
            // 画像ファイル読み込み
            BufferedImage originalImage = ImageIO.read(new File("kage.jpg"));

            // 円形に切る
            BufferedImage circularImage = cropImageToCircle(originalImage);

            // 結果
            ImageIO.write(circularImage, "jpg", new File("kage2.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage cropImageToCircle(BufferedImage source) {
        int diameter = Math.min(source.getWidth(), source.getHeight());

        BufferedImage circularImage = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = circularImage.createGraphics();

        // 背景を白で塗りつぶす
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, diameter, diameter);

        // 抗鋸歯を適用
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 円形のクリッピング領域を設定
        g2.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));

        // 円形領域に画像を描画
        g2.drawImage(source, 0, 0, diameter, diameter, null);

        // グラフィックスオブジェクトを解放
        g2.dispose();

        return circularImage;
    }
}