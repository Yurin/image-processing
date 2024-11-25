import java.awt.Color;

public class GammaCorrection {
    public static MyImage execute(MyImage input) {

        MyImage output = new MyImage(input.width, input.height);

        // ガンマ値を設定
        double gammaR = 0.8;
        double gammaG = 0.0;
        double gammaB = 0.8;

        for (int i = 0; i < input.height; i++) {
            for (int j = 0; j < input.width; j++) {
                // 元の画素の色を取得
                Color color1 = input.getColor(j, i);

                double r = color1.getRed() / 255.0;
                double g = color1.getGreen() / 255.0;
                double b = color1.getBlue() / 255.0;

                // ガンマ補正
                int correctedR = (int) (Math.pow(r, 1/gammaR) * 255);
                int correctedG = (int) (Math.pow(g, 1/gammaG) * 255);
                int correctedB = (int) (Math.pow(b, 1/gammaB) * 255);

                // 新しい色を生成
                Color color2 = new Color(correctedR,correctedG,correctedB);

                output.setColor(j, i, color2);
            }
        }

        return output;
    }
}
