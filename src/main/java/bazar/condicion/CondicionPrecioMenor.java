package bazar.condicion;

import bazar.modelo.ElementoBazar;

public class CondicionPrecioMenor implements Condicion {
	private double precioMaximo;

	public CondicionPrecioMenor(double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	@Override
	public boolean cumple(ElementoBazar elemento) {

		return elemento.getPrecio() < precioMaximo;
	}

}