package bazar.condicion;

import bazar.modelo.ProdAbstracto;

public class CondicionTieneCategoria extends Condicion{
	private String cat;

	public CondicionTieneCategoria(String cat) {
		this.cat = cat;
	}

	@Override
	public boolean cumple(ProdAbstracto elemento) {
		return elemento.tieneCategoria(cat);
	}

}
