
import java.awt.Color;


public class Binalization {

	public static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
	
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				int S = 300;
				Color color1 = input.getColor(j, i);

				int r = color1.getRed();
				int g = color1.getGreen();
				int b = color1.getBlue();
                int color_sum = r+g+b;

                Color color2;
				if(color_sum >= S) {
					// 閾値S以上なら白 (255, 255, 255)
					color2 = new Color(255, 255, 255);
				} else {
					// 閾値S未満なら黒 (0, 0, 0)
					color2 = new Color(0, 0, 0);
				}
				
				// 出力画像に色を設定
				output.setColor(j, i, color2);

			}
		}		
		return output;
	}

}