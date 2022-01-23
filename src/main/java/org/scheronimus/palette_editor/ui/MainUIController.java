package org.scheronimus.palette_editor.ui;

import org.scheronimus.palette_editor.model.Model;
import org.scheronimus.palette_editor.printer.PagePrinter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class MainUIController {

	static final String VERSION = "v.1.0.1";
	@FXML
	TextField clientTextField;
	@FXML
	Spinner<Integer> paletteSpinner;
	@FXML
	Spinner<Integer> colisSpinner;

	// Event Listener on MenuItem[#aboutMenu].onAction
	@FXML
	public void printAbout(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About Palette Editor");
		alert.setHeaderText(null);

		alert.setContentText("Palette Editor\nVersion " + VERSION + "\nCopyright (C) 2022 Scheronimus");

		alert.showAndWait();
	}

	@FXML
	public void closeApplication(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	public void printPage(ActionEvent event) {
		String customer = clientTextField.getText();
		Integer palette = paletteSpinner.getValue();
		Integer colis = colisSpinner.getValue();

		if (palette + colis > 0) {
			PagePrinter.requestPrint(new Model(customer, palette, colis));
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText(null);
			alert.setContentText("Nothing to print");
			alert.showAndWait();
		}
	}
}
