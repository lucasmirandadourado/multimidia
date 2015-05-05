package uepb.controller;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class ConverterBlocosParaYUV {

	private Mat imagem;
	
	
	
	public Mat getImagem(Mat blocoOriginal) {
		imagem = new Mat(blocoOriginal.height(), blocoOriginal.width(), CvType.CV_8UC3);
		double rgb[] = new double[3];
		double y, Cr, Cb;
		for(int i=0;i<blocoOriginal.height();i++){
			for(int j=0; j<blocoOriginal.width();j++){
				rgb = blocoOriginal.get(i, j);
				y = 0.299*rgb[2] + 0.587*rgb[1] + 0.114*rgb[0];//o método get(i,j) retorna um vetor com os valores de B, G e R, respectivamente
				Cr = ((rgb[2]-y)/1.6)+0.5;
				Cb = ((rgb[0]-y)/2)+0.5;
				rgb[2] = y;
				rgb[1] = Cr;
				rgb[0] = Cb;
				imagem.put(i, j, rgb);
			}
		}
		
		return imagem;
	}

	public void setImagem(Mat imagem) {
		this.imagem = imagem;
	}
	

}
