package it.polito.tdp.gestionale;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.gestionale.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DidatticaGestionaleController {

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtMatricolaStudente;

	@FXML
	private TextArea txtResult;

	@FXML
	void doCorsiFrequentati(ActionEvent event) {
		txtResult.clear();
		txtResult.setText("premuto Corsi Frequentati");
		
		/**
		 * QUIN NON C'� NULLA DA CONTROLLARE PERCHE NON CI SONO DATI INPUT
		 */
		model.createGraph();
		
		
		this.txtResult.appendText(model.getFrequenzeStudenti().toString());
		
		this.txtResult.appendText("\nSTATISTICHE:");
		this.txtResult.appendText("\n" + model.getStat());
	}
	
	@FXML
	void doVisualizzaCorsi(ActionEvent event) {
		txtResult.clear();
		txtResult.setText("premuto Visualizza Corsi");
	}

	@FXML
	void initialize() {
		assert txtMatricolaStudente != null : "fx:id=\"txtMatricolaStudente\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DidatticaGestionale.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}

}
