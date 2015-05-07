package uepb.main;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import uepb.controller.ConverterBlocosParaYUV;
import uepb.model.Bloco;
import uepb.model.DCT;

public class Main {

	public static void main(String[] args) {

		System.loadLibrary("opencv_java2410");

		Mat imagemOriginal = new Mat();
		imagemOriginal = Highgui.imread("imagem/field.bmp");
		Bloco bloco = new Bloco(imagemOriginal, 8);
		Mat ceu = bloco.getImagem(107,557);
		Mat grama = bloco.getImagem(339,215);
		Mat ceu_grama = bloco.getImagem(316,83);
		/*Highgui.imwrite("imagem/ceu.png", ceu);
		Highgui.imwrite("imagem/grama.png", grama);*/
		Highgui.imwrite("imagem/ceuGrama.png", ceu_grama);
		
		ConverterBlocosParaYUV converterBlocosParaYUV = new ConverterBlocosParaYUV();
		Mat[] ceuYUV = converterBlocosParaYUV.getImagem(ceu);
		Mat[] gramaYUV = converterBlocosParaYUV.getImagem(grama);
		Mat[] ceuGramaYUV = converterBlocosParaYUV.getImagem(ceu_grama);
		/*Highgui.imwrite("imagem/ceuY.png", ceuYUV[0]);
		Highgui.imwrite("imagem/ceuU.png", ceuYUV[1]);
		Highgui.imwrite("imagem/ceuV.png", ceuYUV[2]);
		Highgui.imwrite("imagem/gramaY.png", gramaYUV[0]);
		Highgui.imwrite("imagem/gramaU.png", gramaYUV[1]);
		Highgui.imwrite("imagem/gramaV.png", gramaYUV[2]);*/
		Highgui.imwrite("imagem/ceuGramaY.png", ceuGramaYUV[0]);
		Highgui.imwrite("imagem/ceuGramaU.png", ceuGramaYUV[1]);
		Highgui.imwrite("imagem/ceuGramaV.png", ceuGramaYUV[2]);
		
		DCT dct = new DCT(ceu);
		dct.calcularDCT(8, 8, 0);
	}
}
