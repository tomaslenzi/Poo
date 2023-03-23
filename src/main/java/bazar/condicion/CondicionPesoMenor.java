package bazar.condicion;

import bazar.modelo.ElementoBazar;

public class CondicionPesoMenor implements Condicion {
	private double pesoMaximo;

	public CondicionPesoMenor(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	@Override
	public boolean cumple(ElementoBazar elemento) {
		return elemento.getPeso() < pesoMaximo;
	}

}