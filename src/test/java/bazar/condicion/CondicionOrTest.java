package bazar.condicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import bazar.modelo.Producto;

public class CondicionOrTest {
	
	@Test
	public void CondicionOrCumpleTest() {
		Producto p1 = new Producto("pico decorador liso", 150, 10002);
		Producto p2 = new Producto("pico decorador estrella", 170, 115);
		
		p1.agregarCategoria("pasta");
		p2.agregarCategoria("pasteleria");

		Condicion pesoMenor = new CondicionPesoMenor(1000);
		Condicion categoria = new CondicionTieneCategoria("pasteleria");

		Condicion compuesta = new CondicionOr(pesoMenor, categoria);

		assertFalse(compuesta.cumple(p1));
		assertTrue(compuesta.cumple(p2));

	}

}
