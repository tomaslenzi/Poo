package modelo;

import java.util.ArrayList;

import bazar.condicion.Condicion;

public class Producto extends ProdAbstracto{
	
	private ArrayList<String> categorias;
	private double precio;
	private double peso;
	
	
	
	public Producto(String nombre, double precio, double peso) {
		super(nombre);
		this.categorias = new ArrayList<>();
		this.precio = precio;
		this.peso = peso;
	}

	public void agregarCategoria(String cat) {
		if(!categorias.contains(cat))
			categorias.add(cat);
	}

	@Override
	public double getPeso() {
		return peso;
	}

	@Override
	public double getPrecio() {
		return precio;
	}

	@Override
	public ArrayList<String> getCategorias() {
		return new ArrayList<>(categorias);
	}

	@Override
	public int contarProductos() {
		return 1;
	}

	@Override
	public ArrayList<ProdAbstracto> buscar(Condicion f) {
		ArrayList<ProdAbstracto> resultado = new ArrayList<>();
		
		if(f.cumple(this))
			resultado.add(this);
		return resultado;
	}

	@Override
	public ProdAbstracto copiar(Condicion f) {
		if(f.cumple(this)) {
			Producto copia = new Producto(this.getNombre(), this.precio, this.peso);
			for (String cat:categorias)
				copia.agregarCategoria(cat);
			return copia;
		}
		
		return null;
	}

	@Override
	public Producto productoMenorPeso() {
		return this;
	}
	
	

}

