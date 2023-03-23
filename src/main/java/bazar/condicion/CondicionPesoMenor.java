package bazar.condicion;

import bazar.modelo.ProdAbstracto;

public class CondicionPesoMenor implements Condicion {
	private double pesoMaximo;

	public CondicionPesoMenor(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	@Override
	public boolean cumple(ProdAbstracto elemento) {
		return elemento.getPeso() < pesoMaximo;
	}

}