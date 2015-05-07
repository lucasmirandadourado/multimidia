package uepb.model;


public class DCT {
	
	double dct = 0.0;
	int x,y;
	// largura e altura vão variar de 0 a 7
	public void calcularDCT(int largura, int altura) {
		for (int u = 0; u < largura; u++) {
			for (int v = 0; v < altura; v++) {
				dct = 0.25*verificar(u)*verificar(v)*valorPixel(x, y)*Math.cos(((2*x+1)*x*Math.PI)/16)*Math.sin(((2*v+1)*y*Math.PI)/16);
			}
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return o valor do pixel da cor!
	 */
	private int valorPixel(int x, int y) {
		return 0;
		
	}

	private double verificar(int x) {
		if (x == 0) {
			return Math.sqrt(2)/2;
		}
		return 1;
	}
	
}
