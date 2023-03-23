package bazar.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bazar.condicion.Condicion;
import bazar.condicion.CondicionPrecioMenor;
import bazar.condicion.CondicionTieneCategoria;

public class ComboTest {

	private Producto p1, p2, p3;
	private Combo combo;
	private Condicion categoria;
	private String cat;

	@BeforeEach
	public void setUp() {
		p1 = new Producto("pico decorador liso", 150, 100);
		p2 = new Producto("pico decorador estrella", 170, 115);
		p3 = new Producto("sombrero", 175, 120);

		cat = "pasteleria";

		p1.agregarCategoria(cat);
		p2.agregarCategoria(cat);
		p3.agregarCategoria("indumentaria");

		categoria = new CondicionTieneCategoria(cat);
		combo = new Combo("picos de decoracion", 0.02, 50, categoria);
	}

	@Test
	public void agregarElementoTest() {
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);
		combo.agregarElemento(p3);
		int elementosEsperados = 2;

		assertEquals(elementosEsperados, combo.getElementos().size());// comprueba que solo se agreguen elementos que
																		// posean la categoria pasteleria

	}

	@Test
	public void getPesoTest() {
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		double pesoEsperado = 215;

		assertEquals(pesoEsperado, combo.getPeso(), 0.001);

	}

	@Test
	public void getPrecioSinDescuentoTest() {// comprueba que el metodo precioSinDescuento() devuelva el precio sin
												// descuento de ambos productos
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		double precioEsperado = 320;
		assertEquals(precioEsperado, combo.precioSinDescuento(), 0.001);
	}

	@Test
	public void getPrecioTest() { // comprueba que devuelve el precio con su descuento
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		double precioEsperado = 307.2;

		assertEquals(precioEsperado, combo.getPrecio(), 0.001);
	}

	@Test
	public void getCategoriasTest() {
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		Set<String> categoriasEsperadas = new HashSet<>();

		categoriasEsperadas.add("pasteleria");

		assertEquals(categoriasEsperadas, combo.getCategorias());

	}

	@Test
	public void contarProdudctosTest() {
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		int cantidadEsperada = 2;

		assertEquals(cantidadEsperada, combo.contarProductos());

	}

	@Test
	public void copiarTest() {
		// comprueba si la copia de un combo se realiza correctamente

		Condicion precioMenor = new CondicionPrecioMenor(10000);

		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		// se copia el combo
		ElementoBazar comboCopia = combo.copiar(precioMenor);
		assertNotSame(combo, comboCopia);


		// verifica que los atributos del combo copiado son iguales a los del original
		assertEquals(combo.getNombre(), comboCopia.getNombre());
		assertEquals(combo.getPeso(), comboCopia.getPeso(), 0.0001);
		assertEquals(combo.getPrecio(), comboCopia.getPrecio(), 0.001);

	}

	@Test
	public void productoMenorPesoTest() {
		combo.agregarElemento(p1);
		combo.agregarElemento(p2);

		ElementoBazar resultado = combo.productoMenorPeso();
		assertEquals(p1, resultado);
	}

}
