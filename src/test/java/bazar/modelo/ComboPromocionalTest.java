package bazar.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import bazar.condicion.Condicion;
import bazar.condicion.CondicionPesoMenor;

public class ComboPromocionalTest {

	@Test
	public void getPrecioTest() {

		Producto p1 = new Producto("pico decorador liso", 150, 100);
		Producto p2 = new Producto("producto pesado", 170, 5000);

		Condicion pesoMenor = new CondicionPesoMenor(1000);
		Combo combo = new ComboPromocional("promocional", 10, 50, pesoMenor);
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		assertEquals(150, combo.getPrecio(), 0.001);

	}
}
