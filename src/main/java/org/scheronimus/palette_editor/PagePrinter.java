package org.scheronimus.palette_editor;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PagePrinter implements Printable {

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		int pal = 2;
		int col = 2;

		if (page > pal + col - 1) {
			return NO_SUCH_PAGE;
		}

		g.drawString("Banane!", 100, 100);
		if (page < pal) {
			g.drawString((page + 1) + " Pal von " + pal + " Pal", 100, 200);
		} else {
			g.drawString((page - pal + 1) + " Colis von " + col + " Colis", 100, 200);
		}

		return PAGE_EXISTS;
	}

	public static void requestPrint() {

		PrinterJob job = PrinterJob.getPrinterJob();
		PageFormat pageFormat = job.defaultPage();
		pageFormat.setOrientation(PageFormat.LANDSCAPE);

		job.setPrintable(new PagePrinter(), pageFormat);

		boolean ok = job.printDialog();
		if (ok) {
			try {
				job.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}
}