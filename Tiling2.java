import java.awt.*;

public class Tiling2 {

    static MyImage execute(MyImage input1, MyImage input2) {

        int width1 = input1.width;
        int height1 = input1.height;
        int width2 = input2.width;
        int height2 = input2.height;

        int outputWidth = Math.max(width1, width2);
        int outputHeight = height1 + height2;

        MyImage output = new MyImage(outputWidth, outputHeight);

        // 上部の画像をセット
        for (int i = 0; i < height1; i++) {
            for (int j = 0; j < width1; j++) {
                Color color1 = input1.getColor(j, i);
                output.setColor(j, i, color1);
            }
        }

        // 下部の画像をセット
        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                Color color2 = input2.getColor(j, i);
                output.setColor(j, i + height1, color2);
            }
        }

        return output;
    }
}
