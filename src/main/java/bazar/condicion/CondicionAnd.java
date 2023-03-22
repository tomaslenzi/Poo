package bazar.condicion;

import bazar.modelo.ProdAbstracto;

public class CondicionAnd extends Condicion{
	private Condicion c1,c2;

	@Override
	public boolean cumple(ProdAbstracto elemento) {
		// TODO Auto-generated method stub
		return c1.cumple(elemento) && c2.cumple(elemento);
	}

}