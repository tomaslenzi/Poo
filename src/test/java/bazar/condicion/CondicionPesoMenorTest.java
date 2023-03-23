package bazar.condicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import bazar.modelo.Producto;

public class CondicionPesoMenorTest {

	@Test
	public void CondicionPesoMenorCumpleTest() {

		Producto p1 = new Producto("pico decorador liso", 150, 100);
		Producto p2 = new Producto("producto pesado", 170, 5000);

		Condicion pesoMenor = new CondicionPesoMenor(1000);

		assertTrue(pesoMenor.cumple(p1));
		assertFalse(pesoMenor.cumple(p2));

	}

}
