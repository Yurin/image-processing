import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.BufferedImageOp;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Random;
public class BlurredIllumination {

public static void main(String[] args) {
    int width = 1500;
    int height = 700;
    
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = image.createGraphics();

    // 背景を黒で塗りつぶす
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, width, height);

    Random rand = new Random();

// ランダムな円を描画する
for (int i = 0; i < 1000; i++) {
    int radius = rand.nextInt(50) + 10;
    int x = rand.nextInt(width);
    int y = rand.nextInt(height);

    float[] hsb = new float[3];
    Color.RGBtoHSB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), hsb);

    // 彩度を0.4以下に設定し、色を薄くする
    hsb[1] = rand.nextFloat() * 0.7f;

    Color randomColor = Color.getHSBColor(hsb[0], hsb[1], hsb[2]);

    g2d.setColor(new Color(randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue()));

    g2d.fillOval(x, y, radius, radius);
}

    g2d.dispose();

    // ぼかし処理
    image = blurImage(image);

    try {
        ImageIO.write(image, "jpg", new File("illumi.jpg"));
        System.out.println("画像を生成しました: illumi.jpg");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static BufferedImage blurImage(BufferedImage image) {
    int radius = 10; // ぼかしの半径
    int size = radius * 2 + 1;
    float weight = 1.0f / (size * size);
    float[] data = new float[size * size];
    
    for (int i = 0; i < data.length; i++) {
        data[i] = weight;
    }
    
    BufferedImageOp op = new ConvolveOp(new Kernel(size, size, data), ConvolveOp.EDGE_NO_OP, null);
    return op.filter(image, null);
}

}