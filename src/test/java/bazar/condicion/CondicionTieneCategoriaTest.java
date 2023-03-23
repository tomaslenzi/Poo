package bazar.condicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import bazar.modelo.Producto;

public class CondicionTieneCategoriaTest {
	@Test
	public void CondicionTieneCategoriaCumpleTest() {
		Producto p1 = new Producto("pico decorador liso", 150, 100);
		Producto p2 = new Producto("producto", 170, 200);

		p1.agregarCategoria("pasteleria");
		p2.agregarCategoria("utencillo");

		Condicion categoria = new CondicionTieneCategoria("pasteleria");

		assertTrue(categoria.cumple(p1));
		assertFalse(categoria.cumple(p2));
	}

}
