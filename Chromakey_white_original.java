
import java.awt.*;


public class Chromakey_white_original{

	static MyImage execute(MyImage input, KMeans kmeans, int id) {

		int width = input.width;
		int height = input.height;
		MyImage output = new MyImage(width, height);

		for(int i = 0, ii = 0; i < height; i++) {
			for(int j = 0; j < width; j++, ii++) {
				
				if(kmeans.idarray[ii] == id)//背景
					output.setColor(j, i, Color.white);
				else {
				Color originalColor = input.getColor(j, i);
					output.setColor(j, i, originalColor);
				}
			}	
		}
	
		return output;

	}
}
