package org.scheronimus.palette_editor;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PagePrinter implements Printable {

	Model information;

	public PagePrinter(Model information) {
		super();
		this.information = information;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		String customer;
		String lineForPageNumber;

		try {
			customer = information.getCustomer();
			lineForPageNumber = information.generateLineForPageNumber(page);
		} catch (OutOfBoundException e) {
			return NO_SUCH_PAGE;
		}

		g.drawString(customer, 100, 100);
		g.drawString(lineForPageNumber, 100, 200);

		return PAGE_EXISTS;
	}

	public static void requestPrint(Model information) {

		PrinterJob job = PrinterJob.getPrinterJob();
		PageFormat pageFormat = job.defaultPage();
		pageFormat.setOrientation(PageFormat.LANDSCAPE);

		job.setPrintable(new PagePrinter(information), pageFormat);

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