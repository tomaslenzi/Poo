package bazar.modelo;

import java.util.List;
import java.util.Set;

import bazar.condicion.Condicion;

public abstract class ProdAbstracto {
	private String nombre;
	
	public ProdAbstracto(String nombre) {
		this.nombre = nombre;
	}
	public abstract double getPeso();
	public abstract double getPrecio();
	public abstract Set<String> getCategorias();
	
	
	public abstract int contarProductos();
	public abstract List<ProdAbstracto> buscar(Condicion f);
	public abstract ProdAbstracto copiar(Condicion f);
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

