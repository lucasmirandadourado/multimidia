package uepb.controller;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class ConverterBlocosParaYUV {
	
	
	
	/*public Mat getImagem(Mat blocoOriginal) {
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
	}*/
	
	public Mat[] getImagem(Mat blocoOriginal) {
		Mat imagemY = new Mat(blocoOriginal.height(), blocoOriginal.width(), CvType.CV_8UC3);
		Mat imagemU = new Mat(blocoOriginal.height(), blocoOriginal.width(), CvType.CV_8UC3);
		Mat imagemV = new Mat(blocoOriginal.height(), blocoOriginal.width(), CvType.CV_8UC3);
		
		double rgb[] = new double[3];
		double y, u, v;
		for(int i=0;i<blocoOriginal.height();i++){
			for(int j=0; j<blocoOriginal.width();j++){
				rgb = blocoOriginal.get(i, j);
				y = 0.299*rgb[2] + 0.587*rgb[1] + 0.114*rgb[0];//o método get(i,j) retorna um vetor com os valores de B, G e R, respectivamente
				u = Math.abs(rgb[0]-y);
				v = Math.abs(rgb[2]-y);
				
				rgb[0] = y;
				rgb[1] = y;
				rgb[2] = y;				
				imagemY.put(i, j, rgb);
				
				rgb[0] = u;
				rgb[1] = u;
				rgb[2] = u;
				imagemU.put(i, j, rgb);
				
				rgb[0] = v;
				rgb[1] = v;
				rgb[2] = v;
				imagemV.put(i, j, rgb);
			}
		}
		Mat [] blocos = new Mat[3];
		blocos[0] = imagemY;
		blocos[1] = imagemU;
		blocos[2] = imagemV;
		return blocos;
	}
	

}
