package uepb.main;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import uepb.controller.Bloco;
import uepb.controller.ConverterBlocosParaYUV;

public class Main {

	public static void main(String[] args) {

		System.loadLibrary("opencv_java2410");

		Mat imagemOriginal = new Mat();
		imagemOriginal = Highgui.imread("imagem/field.bmp");
		Bloco bloco = new Bloco(imagemOriginal, 8);
		Mat ceu = bloco.getImagem(107,557);
		Mat grama = bloco.getImagem(399,215);
		Mat ceu_grama = bloco.getImagem(316,83);
		Highgui.imwrite("imagem/ceu.png", ceu);
		Highgui.imwrite("imagem/grama.png", grama);
		Highgui.imwrite("imagem/ceuGrama.png", ceu_grama);
		
		ConverterBlocosParaYUV converterBlocosParaYUV = new ConverterBlocosParaYUV();
		Mat ceuYUV = converterBlocosParaYUV.getImagem(ceu);
		Mat gramaYUV = converterBlocosParaYUV.getImagem(grama);
		Mat ceu_grama_YUV = converterBlocosParaYUV.getImagem(ceu_grama);
		Highgui.imwrite("imagem/ceuYUV.png", ceuYUV);
		Highgui.imwrite("imagem/gramaYUV.png", gramaYUV);
		Highgui.imwrite("imagem/ceuGramaYUV.png", ceu_grama_YUV);
		

		System.out.println(grama.get(0, 0)[0]);
		System.out.println(gramaYUV.get(0, 0)[0]);
	}
}
