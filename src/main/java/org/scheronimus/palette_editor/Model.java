package org.scheronimus.palette_editor;

public class Model {
	String customer;
	Integer palette;
	Integer colis;

	public Model(String customer, Integer palette, Integer colis) {
		super();
		this.customer = customer;
		this.palette = palette;
		this.colis = colis;
	}

	public String getCustomer() {
		return customer;
	}

	public String generateLineForPageNumber(int page) throws OutOfBoundException {
		if (page > (getTotalNumberOfElements() - 1)) {
			throw new OutOfBoundException("Page index bigger that the amount of items");
		}
		String s;
		if (page < palette) {
			s = (page + 1) + " Pal";
		} else {
			s = (page - palette + 1) + " Colis";
		}
		s = s + " von [ " + palette + " Pal + " + colis + " Colis ]";
		return s;
	}

	public int getTotalNumberOfElements() {
		return palette + colis;
	}

}
