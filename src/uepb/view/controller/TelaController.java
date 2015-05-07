package uepb.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import uepb.controller.ConverterBlocosParaYUV;
import uepb.model.Bloco;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TelaController implements Initializable {

	@FXML
	private ToggleButton toggleButtonCarregarCeu;
	@FXML
	private ToggleButton toggleButtonCarregarGrama;
	@FXML
	private ToggleButton toggleButtonCarregarCeuEGrama;

	@FXML
	private Pane paneY;
	@FXML
	private Pane paneU;
	@FXML
	private Pane paneV;

	@FXML
	private ImageView imageViewCarregarCeu;
	@FXML
	private ImageView imageViewCarregarGrama;
	@FXML
	private ImageView imageViewCarregarCeuEGrama;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		toggleButtonCarregarGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(true);
				toggleButtonCarregarCeu.setSelected(false);
				toggleButtonCarregarCeuEGrama.setSelected(false);

				Image y = new Image("/uepb/icones/gramaY.jpg");
				Image u = new Image("/uepb/icones/gramaU.jpg");
				Image v = new Image("/uepb/icones/gramaV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);
				
				//Iv.setOnZoom(null);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});

		toggleButtonCarregarCeu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(false);
				toggleButtonCarregarCeu.setSelected(true);
				toggleButtonCarregarCeuEGrama.setSelected(false);

				Image y = new Image("/uepb/icones/ceuY.jpg");
				Image u = new Image("/uepb/icones/ceuU.jpg");
				Image v = new Image("/uepb/icones/ceuV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});
		
		toggleButtonCarregarCeuEGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(false);
				toggleButtonCarregarCeu.setSelected(false);
				toggleButtonCarregarCeuEGrama.setSelected(true);

				Image y = new Image("/uepb/icones/ceuGramaY.jpg");
				Image u = new Image("/uepb/icones/ceuGramaU.jpg");
				Image v = new Image("/uepb/icones/ceuGramaV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});

		Image imagemCarregarGrama = new Image("/uepb/icones/grama.png");
		imageViewCarregarGrama.setImage(imagemCarregarGrama);

		Image imagemCarregarCeu = new Image("/uepb/icones/ceu.png");
		imageViewCarregarCeu.setImage(imagemCarregarCeu);

		Image imagemCarregarCeuEGrama = new Image("/uepb/icones/ceuGrama.png");
		imageViewCarregarCeuEGrama.setImage(imagemCarregarCeuEGrama);

		toggleButtonCarregarCeu.setGraphic(imageViewCarregarCeu);
		toggleButtonCarregarGrama.setGraphic(imageViewCarregarGrama);
		toggleButtonCarregarCeuEGrama.setGraphic(imageViewCarregarCeuEGrama);
	}

}
