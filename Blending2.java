import java.awt.Color;
//重ね合わせたときに黒でない方の画素を選び、どちらも黒の場合のみ黒にするようにプログラム

public class Blending2 {

    static MyImage execute(MyImage var0, MyImage var1) {
        int offsetX = 0; // 任意のX
        int offsetY = -800; // 任意のY

        int width1 = var0.width;
        int width2 = var1.width;
        int height1 = var0.height;
        int height2 = var1.height;
        int maxWidth = Math.max(offsetX + width1, width2);
        int maxHeight = Math.max(offsetY + height1, height2);
        MyImage resultImage = new MyImage(maxWidth, maxHeight);

        for (int y = 0; y < maxHeight; ++y) {
            for (int x = 0; x < maxWidth; ++x) {
                Color color1 = new Color(0, 0, 0); // 初期化を黒に

                // image1の範囲にいるか
                if (x >= offsetX && x < offsetX + width1 && y >= offsetY && y < offsetY + height1) {
                    color1 = var0.getColor(x - offsetX, y - offsetY);
                }

                Color color3;

                if (x < width2 && y < height2 && isInsideImage2(x, y, var1)) {
                    Color color2 = var1.getColor(x, y);

                    if (isBlack(color1) && isBlack(color2)) {
                        color3 = new Color(0, 0, 0); // どちらも黒なら黒
                    } else if (!isBlack(color1) && isBlack(color2)) {
                        color3 = color1; // color1が黒でない
                    } else if (isBlack(color1) && !isBlack(color2)) {
                        color3 = color2; // color2が黒でない
                    } else {
                        color3 = color1; // 両方黒でないが、優先のためcolor1
                    }
                } else {
                    color3 = color1; // var1の範囲外ならそのままcolor1
                }

                resultImage.setColor(x, y, color3);
            }
        }

        return resultImage;
    }

    static boolean isInsideImage2(int x, int y, MyImage image2) {
        return true;
    }

    static boolean isBlack(Color c) {
        return c.getRed() == 0 && c.getGreen() == 0 && c.getBlue() == 0;
    }
}
