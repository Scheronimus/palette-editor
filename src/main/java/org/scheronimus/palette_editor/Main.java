package org.scheronimus.palette_editor;

import org.scheronimus.palette_editor.ui.PaletteEditor;

public class Main {
	public static void main(String[] args) {
		// the jar needs to know the actual Main class that does not extend Application
		PaletteEditor.launchUI();
	}
}