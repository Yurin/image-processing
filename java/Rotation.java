import java.awt.Color;

public class Rotation{// rotate90,180,270,180scale2,45Right,45Left

    static MyImage rotate90(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;
        int width2 = height1; 
        int height2 = width1; 
        MyImage output = new MyImage(width2, height2);

        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                double x1 = height1 - 1 - i; 
                double y1 = j; 

                calcRGB(input, output, x1, y1, j, i);
            }
        }
        return output;
    }

    static MyImage rotate270(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;
        int width2 = height1; 
        int height2 = width1; 
        MyImage output = new MyImage(width2, height2);
    
        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                double x1 = i; 
                double y1 = width1 - 1 - j; 
    
                calcRGB(input, output, x1, y1, j, i);
            }
        }
        return output;
    }

    static MyImage rotate180(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;
        MyImage output = new MyImage(width1, height1);

        for (int i = 0;i<height1; i++) {
            for (int j = 0; j < width1; j++) {
                double x1 = width1 - 1 - j; 
                double y1 = height1 - 1 - i; 

                calcRGB(input, output, x1, y1, j, i);
            }
        }
        return output;
    }

    static MyImage rotate180Scale2(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;
        int width2 = width1*2; 
        int height2 = height1*2; 
        MyImage output = new MyImage(width2, height2);

        for (int i = 0;i<height2; i++) {
            for (int j = 0;j<width2; j++) {
                double x1 = (width1 - 1 - (j / 2.0)); 
                double y1 = (height1 - 1 - (i / 2.0)); 

                calcRGB(input, output, x1, y1, j, i);
            }
        }
        return output;
    }

    static MyImage rotate45Right(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;
        int width2 = (int)(Math.sqrt(width1 * width1 + height1 * height1));
        int height2 = width2; 

        MyImage output = new MyImage(width2, height2);

        double centerX1 = width1 / 2.0;
        double centerY1 = height1 / 2.0;
        double centerX2 = width2 / 2.0;
        double centerY2 = height2 / 2.0;

        double angleRad = Math.toRadians(45);

        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                double x = j - centerX2;
                double y = i - centerY2;

                double x1 = x * Math.cos(-angleRad) - y * Math.sin(-angleRad);
                double y1 = x * Math.sin(-angleRad) + y * Math.cos(-angleRad);

                x1 += centerX1;
                y1 += centerY1;

                calcRGB(input, output, x1, y1, j, i);
            }
        }
        
        return output;
    }


    static MyImage rotate45Left(MyImage input) {
        int width1 = input.width;
        int height1 = input.height;

        int width2 = (int)(Math.sqrt(width1 * width1 + height1 * height1));
        int height2 = width2;

        MyImage output = new MyImage(width2, height2);

        double centerX1 = width1 / 2.0;
        double centerY1 = height1 / 2.0;
        double centerX2 = width2 / 2.0;
        double centerY2 = height2 / 2.0;

        double angleRad = Math.toRadians(45);

        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                double x = j - centerX2;
                double y = i - centerY2;

                double x1 = x * Math.cos(angleRad) - y * Math.sin(angleRad);
                double y1 = x * Math.sin(angleRad) + y * Math.cos(angleRad);

                x1 += centerX1;
                y1 += centerY1;

                calcRGB(input, output, x1, y1, j, i);
            }
        }
        
        return output;
    }


    static void calcRGB(MyImage var0, MyImage var1, double var2, double var3, int var4, int var5) {
        int var6 = (int)(var2 + 0.5);
        if (var6 < 0) {
            var6 = 0;
        }
        if (var6 >= var0.width) {
            var6 = var0.width - 1;
        }
    
        int var7 = (int)(var3 + 0.5);
        if (var7 < 0) {
            var7 = 0;
        }
        if (var7 >= var0.height) {
            var7 = var0.height - 1;
        }
    
        Color var8 = var0.getColor(var6, var7);
        var1.setColor(var4, var5, var8);
    }
}
