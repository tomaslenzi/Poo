package bazar;

import java.util.ArrayList;

public class Combo extends ProdAbstracto {
	private double porcentajeDtoPorProducto;
	private double porcentajeMaxDto;
	private ArrayList<ProdAbstracto> elementos;
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


	public void agregarElemento(ProdAbstracto elemnto) {
		if(condicion.cumple(elemnto))
			elementos.add(elemnto);
	}
	


	public ArrayList<ProdAbstracto> getElementos() {
		ArrayList<ProdAbstracto> copia = new ArrayList<>();
		for(ProdAbstracto e: elementos) {
			copia.add(e);
		}
		
		return copia;
	}


	@Override
	public double getPeso() {
		double suma = 0;
		for (ProdAbstracto elemento: elementos)
			suma+=elemento.getPeso();
		return suma;
	}
	
	protected double precioSinDescuento() {
		double precioTotal = 0.0;
		for (ProdAbstracto elemento: elementos)
			precioTotal+=elemento.getPrecio();
		return precioTotal;
	}

	@Override
	public double getPrecio() {

		double precioTotal = precioSinDescuento();
		double descuento = porcentajeDtoPorProducto * contarProductos();
		if(descuento > this.porcentajeMaxDto)
			descuento = porcentajeMaxDto;
		
		return precioTotal - descuento*precioTotal;
	}


	@Override
	public ArrayList<String> getCategorias() {
		ArrayList<String> categorias = new ArrayList<>();
		for (ProdAbstracto elemento: elementos) {
			ArrayList<String> catElem = elemento.getCategorias();
			for(String cat: catElem)
				if(!categorias.contains(cat))
					categorias.add(cat);
		}
		return categorias;
	}


	@Override
	public int contarProductos() {
		int total = 0;
		for (ProdAbstracto elemento: elementos)
			total= total + elemento.contarProductos();
			
		return total;
	}


	@Override
	public ArrayList<ProdAbstracto> buscar(Condicion f) {
		ArrayList <ProdAbstracto> resultado = new ArrayList<>();
		if(f.cumple(this)) {
			resultado.add(this);
		}
		else {
			for (ProdAbstracto elemento: elementos)
				resultado.addAll(elemento.buscar(f));
		}
		return resultado;
	}


	@Override
	public ProdAbstracto copiar(Condicion f) {
		if(f.cumple(this)) {
			ArrayList<ProdAbstracto> hijosQueCumplen = new ArrayList<>();
			for (ProdAbstracto elemento: elementos) {
				ProdAbstracto copia = elemento.copiar(f);
				if(copia != null) {
					hijosQueCumplen.add(copia);
					
				}
				if(hijosQueCumplen.isEmpty())
					return null;
				else {
					Combo copiaCombo = new Combo(this.getNombre(), this.porcentajeDtoPorProducto, this.porcentajeMaxDto, condicion);
					for(ProdAbstracto elem: hijosQueCumplen)
						copiaCombo.agregarElemento(elem);
					return copiaCombo;
				}
			}
		}
		return null;
	}


	@Override
	public Producto productoMenorPeso() {
		double menorPeso = Double.MAX_VALUE;
		Producto produtoMenorPeso = null;
		for (ProdAbstracto elemento: elementos) {
			Producto produtoMenorPesoAux = elemento.productoMenorPeso();
			double temp =produtoMenorPesoAux.getPeso();
			if(produtoMenorPeso == null || temp < menorPeso) {
				menorPeso = temp;
				produtoMenorPeso = produtoMenorPesoAux;
			}
		}
		return produtoMenorPeso;
	}
	
	
	
	
}
