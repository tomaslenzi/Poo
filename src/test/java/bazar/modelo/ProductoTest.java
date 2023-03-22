package bazar.modelo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bazar.condicion.Condicion;
import bazar.condicion.CondicionTieneCategoria;


public class ProductoTest {
	
	private Producto p1;
	
	@BeforeEach
	public void setUp() {
		p1 = new Producto("pico decorador liso", 150, 100);
	}
	
	@Test 
	public void agregarCategoriasTest() {
		p1.agregarCategoria("pasteleria");
		p1.agregarCategoria("decoracion");
		p1.agregarCategoria("decoracion");// se intenta agregar una misma categoria 2 veces
		
		ArrayList<String> categorias= p1.getCategorias();
		assertEquals(2, categorias.size());// se verifica que solo haya 2 categorias
		assertTrue(categorias.contains("pasteleria"));//se verifica que la categoria pasteleria este agregada
		assertTrue(categorias.contains("decoracion"));//se verifica que la categoria decoracion este agregada
		
	}
	
	@Test
	public void getPesoTest() {

		assertEquals(100, p1.getPeso());//se verifica que el valor del peso sea el esperado
	}
	
	@Test
	public void getPrecioTest() {
		assertEquals(150, p1.getPrecio());//se verifica que el valor del precio sea el esperado
	}
	
	@Test
	public void getCategoriasTest() {
		p1.agregarCategoria("pasteleria");
		p1.agregarCategoria("decoracion");
		
		ArrayList<String> categorias= p1.getCategorias();
		assertEquals(2, categorias.size());// se verifica que solo haya 2 categorias
		assertTrue(categorias.contains("pasteleria"));//se verifica que la categoria pasteleria este agregada
		assertTrue(categorias.contains("decoracion"));//se verifica que la categoria decoracion este agregada
	}
	
	@Test
	public void contarProductosTest() {
		assertEquals(1, p1.contarProductos());//se verifica que el conteo de un producto sea 1
	}
	@Test
	public void buscarTest() {
		p1.agregarCategoria("pasteleria");
		p1.agregarCategoria("decoracion");
	
		ArrayList<ProdAbstracto> resultado = new ArrayList<>();
		resultado.add(p1);
		
		String cat = "pasteleria";
		Condicion categoria = new CondicionTieneCategoria(cat);
		
		assertEquals(resultado, p1.buscar(categoria));

			
	}
	
	@Test
	public void copiarTest() { //se verifica que el metodo copiar devuelve una copia del producto con las mismas propiedades
								//y con la condicion de que la categoria del producto a copiar sea en este caso pasteleria

		p1.agregarCategoria("pasteleria");
		
		String cat = "pasteleria";
		Condicion categoria = new CondicionTieneCategoria(cat);
		
		ProdAbstracto resultado =p1.copiar(categoria);
		
		assertNotNull(resultado);
		
		Producto copia =(Producto) resultado;
		
	    assertEquals(p1.getNombre(), copia.getNombre());
	    assertEquals(p1.getPrecio(), copia.getPrecio(), 0.0);
	    assertEquals(p1.getPeso(), copia.getPeso(), 0.0);
	    assertEquals(p1.getCategorias(), copia.getCategorias());
	}
	

}
