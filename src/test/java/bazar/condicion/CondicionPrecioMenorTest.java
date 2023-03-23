package bazar.condicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import bazar.modelo.Producto;

public class CondicionPrecioMenorTest {

	@Test
	public void CondicionPrecioMenorCumple() {
		Producto p1 = new Producto("pico decorador liso", 150, 100);
		Producto p2 = new Producto("producto pesado", 170, 5000);

		Condicion precioMenor = new CondicionPrecioMenor(160);

		assertTrue(precioMenor.cumple(p1));
		assertFalse(precioMenor.cumple(p2));
	}

}
