package org.scheronimus.palette_editor.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaletteEditor extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/scheronimus/palette_editor/ui/MainUI.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Palette Editor");
		stage.show();
	}

	public static void launchUI() {
		launch();
	}

}