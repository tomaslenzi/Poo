package bazar.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bazar.condicion.Condicion;

public class Producto extends ElementoBazar {

	private Set<String> categorias;
	private double precio;
	private double peso;

	public Producto(String nombre, double precio, double peso) {
		super(nombre);
		this.categorias = new HashSet<>();
		this.precio = precio;
		this.peso = peso;
	}

	public void agregarCategoria(String cat) {
		if (!categorias.contains(cat))
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
	public Set<String> getCategorias() {
		return new HashSet<>(categorias);
	}

	@Override
	public int contarProductos() {
		return 1;
	}

	@Override
	public ArrayList<ElementoBazar> buscar(Condicion f) {
		ArrayList<ElementoBazar> resultado = new ArrayList<>();

		if (f.cumple(this))
			resultado.add(this);
		return resultado;
	}

	@Override
	public ElementoBazar copiar(Condicion f) {
		if (f.cumple(this)) {
			Producto copia = new Producto(this.getNombre(), this.precio, this.peso);
			for (String cat : categorias)
				copia.agregarCategoria(cat);
			return copia;
		}

		return null;
	}

	@Override
	public Producto productoMenorPeso() {
		return this;
	}

	@Override
	public String toString() {
		return "Producto [categorias=" + categorias + ", precio=" + precio + ", peso=" + peso + "]";
	}
	
	

}
