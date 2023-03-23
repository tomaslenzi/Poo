package bazar.condicion;

import bazar.modelo.ElementoBazar;

public class CondicionOr implements Condicion {
	private Condicion c1, c2;

	public CondicionOr(Condicion c1, Condicion c2) {
		super();
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public boolean cumple(ElementoBazar elemento) {
		return c1.cumple(elemento) || c2.cumple(elemento);
	}

}
