package org.scheronimus.palette_editor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

public class MainUIController {

	String VERSION = "v.0.0.1";
	@FXML
	TextArea clientTextArea;
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
		String customer = clientTextArea.getText();
		Integer palette = paletteSpinner.getValue();
		Integer colis = colisSpinner.getValue();

		System.out.println(customer + " " + palette + " " + colis);
		PagePrinter.requestPrint(new Model(customer, palette, colis));

	}
}
