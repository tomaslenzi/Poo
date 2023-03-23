package bazar.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bazar.condicion.Condicion;

public class Combo extends ElementoBazar {
	private double porcentajeDtoPorProducto;
	private double porcentajeMaxDto;
	private List<ElementoBazar> elementos;
	private Condicion condicion;

	public Combo(String nombre, double porcentajeDtoPorProducto, double porcentajeMaxDto, Condicion condicion) {
		super(nombre);
		this.porcentajeDtoPorProducto = porcentajeDtoPorProducto;
		this.porcentajeMaxDto = porcentajeMaxDto;
		this.elementos = new ArrayList<>();
		this.condicion = condicion;
	}

	public void setPorcentajeDtoPorProducto(double porcentajeDtoPorProducto) {
		this.porcentajeDtoPorProducto = porcentajeDtoPorProducto;
	}

	public void setPorcentajeMaxDto(double porcentajeMaxDto) {
		this.porcentajeMaxDto = porcentajeMaxDto;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public void agregarElemento(ElementoBazar elemnto) {
		if (condicion.cumple(elemnto))
			elementos.add(elemnto);
	}

	public List<ElementoBazar> getElementos() {
		List<ElementoBazar> copia = new ArrayList<>();
		for (ElementoBazar e : elementos) {
			copia.add(e);
		}

		return copia;
	}

	@Override
	public double getPeso() {
		double suma = 0;
		for (ElementoBazar elemento : elementos) {
			suma += elemento.getPeso();
		}
		return suma;
	}

	public double precioSinDescuento() {
		double precioTotal = 0.0;
		for (ElementoBazar elemento : elementos) {
			precioTotal += elemento.getPrecio();
		}
		return precioTotal;
	}

	@Override
	public double getPrecio() {

		double precioTotal = precioSinDescuento();
		double descuento = porcentajeDtoPorProducto * contarProductos();
		if (descuento > this.porcentajeMaxDto) {
			descuento = this.porcentajeMaxDto;
		}
		return precioTotal - descuento * precioTotal;
	}

	@Override
	public Set<String> getCategorias() {
		Set<String> categorias = new HashSet<>();
		for (ElementoBazar elemento : elementos) {
			Set<String> catElem = elemento.getCategorias();
			categorias.addAll(catElem);
		}
		return categorias;
	}

	@Override
	public int contarProductos() {
		int total = 0;
		for (ElementoBazar elemento : elementos) {
			total += elemento.contarProductos();
		}
		return total;
	}

	@Override
	public List<ElementoBazar> buscar(Condicion f) {
		List<ElementoBazar> resultado = new ArrayList<>();
		if (f.cumple(this)) {
			resultado.add(this);
		} else {
			for (ElementoBazar elemento : elementos) {
				resultado.addAll(elemento.buscar(f));
			}
		}
		return resultado;
	}

	@Override
	public ElementoBazar copiar(Condicion f) {
		if (f.cumple(this)) {
			Combo copiaCombo = new Combo(this.getNombre(), porcentajeDtoPorProducto, porcentajeMaxDto, condicion);
			for (ElementoBazar elemento : elementos) {
				ElementoBazar copia = elemento.copiar(f);
				if (copia != null)
					copiaCombo.agregarElemento(copia);
			}
			if (copiaCombo != null)
				return copiaCombo;
		}
		return null;
	}

	@Override
	public Producto productoMenorPeso() {
		double menorPeso = Double.MAX_VALUE;
		Producto productoMenorPeso = null;
		for (ElementoBazar elemento : elementos) {
			Producto productoMenorPesoAux = elemento.productoMenorPeso();
			double temp = productoMenorPesoAux.getPeso();
			if (productoMenorPeso == null || temp < menorPeso) {
				menorPeso = temp;
				productoMenorPeso = productoMenorPesoAux;
			}
		}
		return productoMenorPeso;
	}

	@Override
	public String toString() {
		return "Combo [porcentajeDtoPorProducto=" + porcentajeDtoPorProducto + ", porcentajeMaxDto=" + porcentajeMaxDto
				+ ", elementos=" + elementos + ", condicion=" + condicion + "]";
	}
	
	

}
