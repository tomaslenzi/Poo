package bazar.modelo;

import java.util.List;
import java.util.Set;

import bazar.condicion.Condicion;

public abstract class ElementoBazar {
	private String nombre;
	
	public ElementoBazar(String nombre) {
		this.nombre = nombre;
	}
	public abstract double getPeso();
	public abstract double getPrecio();
	public abstract Set<String> getCategorias();
	
	
	public abstract int contarProductos();
	public abstract List<ElementoBazar> buscar(Condicion f);
	public abstract ElementoBazar copiar(Condicion f);
	public abstract Producto productoMenorPeso();
	
	public boolean tieneCategoria(String categoria) {
		return this.getCategorias().contains(categoria);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
}

