package bazar.condicion;

import modelo.ProdAbstracto;

public class CondicionPrecioMenor extends Condicion {
	private double precioMaximo;
	

	public CondicionPrecioMenor(double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}


	@Override
	public boolean cumple(ProdAbstracto elemento) {
		
		return elemento.getPrecio() < precioMaximo;
	}

}