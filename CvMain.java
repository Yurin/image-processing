
public class CvMain {



	static void imageProcessing1() {

		String filename1 = "sun.jpg";

		String filename2 = "sun.jpg";

		MyImage image1, image2;
	
		image1 = JpegFileReader.read(filename1);

		{
			//image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			//image2 = GammaCorrection.execute(image1);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Rotation.rotate90(image1);
			image2 = Scale.execute(image1);
			//image2 = Rotation.rotate45Right(image1);
			//image2 = Rotation.rotate45Left(image1);
			//image2 = Rotation.rotate180(image1);
			//image2 = Rotation.rotate180Scale2(image1);
		}

		JpegFileWriter.write(filename2, image2);

	}


	static void imageProcessing2() {

		String filename1 = "sun.jpg";
		String filename2 = "album9.jpg";
		String filename3 = "album10.jpg";

		MyImage image1, image2, image3, image0;
	
		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);

		// KMeans kmeans = new KMeans();
		// kmeans.clustering(image1, 4);
		// image0 = Chromakey_white_original.execute(image1, kmeans, 3);

		//image3 = VirtualStudio.execute(image1, image2, image0); 
		//image3 = VirtualStudio2.execute(image1, image2, image0);
		//image3 = AlphaBlending.execute(image1, image2, image0); 	
		//image3 = AlphaBlending2.execute(image1, image2, image0); 
		image3 = Blending1.execute(image1, image2); 
		//image3 = Blending2.execute(image1, image2); 
		//image3 = Tiling.execute(image1, image2); 	
		//image3 = Tiling2.execute(image1, image2); 

		JpegFileWriter.write(filename3, image3);

	}


	public static void main(String args[]) {

		//imageProcessing1();
		imageProcessing2();

	}
}
