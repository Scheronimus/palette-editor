package org.scheronimus.palette_editor.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void testGetCustomer() {

		Model m = new Model("Alpha", null, null);
		assertEquals("Alpha", m.getCustomer());

		m = new Model("", null, null);
		assertEquals("", m.getCustomer());

		m = new Model(null, null, null);
		assertEquals(null, m.getCustomer());
	}

	@Test
	void testGenerateLineForPageNumber() throws OutOfBoundException {
		Model m = new Model("Alpha", 2, 3);

		assertEquals("1 Pal von [ 2 Pal + 3 Colis ]", m.generateLineForPageNumber(0));
		assertEquals("2 Pal von [ 2 Pal + 3 Colis ]", m.generateLineForPageNumber(1));
		assertEquals("1 Colis von [ 2 Pal + 3 Colis ]", m.generateLineForPageNumber(2));
		assertEquals("2 Colis von [ 2 Pal + 3 Colis ]", m.generateLineForPageNumber(3));
		assertEquals("3 Colis von [ 2 Pal + 3 Colis ]", m.generateLineForPageNumber(4));

		m = new Model("Alpha", 2, 0);

		assertEquals("1 Pal von [ 2 Pal + 0 Colis ]", m.generateLineForPageNumber(0));
		assertEquals("2 Pal von [ 2 Pal + 0 Colis ]", m.generateLineForPageNumber(1));

		m = new Model("Alpha", 0, 3);

		assertEquals("1 Colis von [ 0 Pal + 3 Colis ]", m.generateLineForPageNumber(0));
		assertEquals("2 Colis von [ 0 Pal + 3 Colis ]", m.generateLineForPageNumber(1));
		assertEquals("3 Colis von [ 0 Pal + 3 Colis ]", m.generateLineForPageNumber(2));

	}

	@Test
	void testGenerateLineForPageNumber_OutOfBound() {

		assertThrows(OutOfBoundException.class, () -> {
			Model m = new Model("Alpha", 2, 3);
			m.generateLineForPageNumber(5);
		});

		assertThrows(OutOfBoundException.class, () -> {
			Model m = new Model("Alpha", 2, 0);
			m.generateLineForPageNumber(2);
		});

		assertThrows(OutOfBoundException.class, () -> {
			Model m = new Model("Alpha", 0, 3);
			m.generateLineForPageNumber(3);
		});

		assertThrows(OutOfBoundException.class, () -> {
			Model m = new Model("Alpha", 0, 0);
			m.generateLineForPageNumber(0);
		});

	}

	@Test
	void testGetTotalNumberOfElements() {
		Model m = new Model("Alpha", 2, 3);
		assertEquals(5, m.getTotalNumberOfElements());

		m = new Model("Alpha", 0, 3);
		assertEquals(3, m.getTotalNumberOfElements());

		m = new Model("Alpha", 2, 0);
		assertEquals(2, m.getTotalNumberOfElements());
	}

}
