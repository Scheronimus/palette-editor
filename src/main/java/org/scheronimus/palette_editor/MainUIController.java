package org.scheronimus.palette_editor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainUIController {

	// Event Listener on MenuItem[#aboutMenu].onAction
	@FXML
	public void printAbout(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About Palette Editor");
		alert.setHeaderText(null);
		alert.setContentText("Palette Editor\nVersion xx\nCopytight (C) 2022 Scheronimus");

		alert.showAndWait();
	}

	@FXML
	public void closeApplication(ActionEvent event) {
		Platform.exit();
	}
}
