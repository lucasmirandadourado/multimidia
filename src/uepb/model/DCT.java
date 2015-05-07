package uepb.model;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class DCT {

	double dct = 0.0;
	int x, y;
	final double PI = Math.PI;
	Mat imagem;
	
	public DCT(Mat img) {
		imagem = new Mat(8, 8, CvType.CV_8UC3);
		this.imagem = img;
	}
	
	// largura e altura vão variar de 0 a 7
	public void calcularDCT(int largura, int altura) {
		for (int u = 0; u < largura; u++) {
			for (int v = 0; v < altura; v++) {
				
				for (int x = 0; x < 7; x++) {
					for (int y = 0; y < 7; y++) {
						dct += imagem.get(x, y)[0]
								* Math.cos(((2 * x + 1) * x * PI) / 16)
								* Math.cos(((2 * v + 1) * y * PI) / 16);
					}
				}
				dct = 0.25 * verificar(u) * verificar(v) * dct;

			}
		}
	}

	private double verificar(int x) {
		if (x == 0) {
			return Math.sqrt(2) / 2;
		}
		return 1;
	}

}
