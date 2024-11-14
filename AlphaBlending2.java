import java.awt.Color;

public class AlphaBlending2 {

    static MyImage execute(MyImage var0, MyImage var1, MyImage var2) {
        double alpha = 0.5 ;
        int offsetX = 850; // 任意のX
        int offsetY = 0; // 任意のY

        int width1 = var0.width;
        int width2 = var1.width;
        int height1 = var0.height;
        int height2 = var1.height;
        int maxWidth = Math.max(offsetX + width1, width2);
        int maxHeight = Math.max(offsetY + height1, height2);
        MyImage resultImage = new MyImage(maxWidth, maxHeight);

        for (int y = 0; y<maxHeight; ++y) {
            for (int x = 0; x<maxWidth; ++x) {
                Color color1 = new Color(0, 0, 0);

                //image1の範囲にいるか
                if (x >= offsetX && x < offsetX + width1 && y >= offsetY && y < offsetY + height1) {
                    color1 = var0.getColor(x - offsetX, y - offsetY);
                }

                Color color3;

                if (x < width2 && y < height2 && isInsideImage2(x, y, var1)) {
                    Color color2 = var1.getColor(x, y);
                    int blendedRed = (int) (alpha * color1.getRed() + (1 - alpha) * color2.getRed());
                    int blendedGreen = (int) (alpha * color1.getGreen() + (1 - alpha) * color2.getGreen());
                    int blendedBlue = (int) (alpha * color1.getBlue() + (1 - alpha) * color2.getBlue());
                    color3 = new Color(blendedRed, blendedGreen, blendedBlue);
                } else {
                    color3 = color1;
                }

                resultImage.setColor(x,y,color3);
            }
        }

        return resultImage;
    }
    static boolean isInsideImage2(int x, int y, MyImage image2) {
        return true;
    }
}