package bazar.modelo;

import bazar.condicion.Condicion;

public class ComboPromocional extends Combo {

	public ComboPromocional(String nombre, double porcentajeDtoPorProducto, double porcentajeMaxDto,
			Condicion condicion) {
		super(nombre, porcentajeDtoPorProducto, porcentajeMaxDto, condicion);

	}

	@Override
	public double getPrecio() {
		double precioTotal = this.precioSinDescuento();
		double totalProductos = this.contarProductos();
		return precioTotal / totalProductos;

	}

}
