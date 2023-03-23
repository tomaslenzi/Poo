package bazar.condicion;

import bazar.modelo.ElementoBazar;

public class CondicionTieneCategoria implements Condicion {
	private String cat;

	public CondicionTieneCategoria(String cat) {
		this.cat = cat;
	}

	@Override
	public boolean cumple(ElementoBazar elemento) {
		return elemento.tieneCategoria(cat);
	}

}
