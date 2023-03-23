package bazar;


import bazar.condicion.Condicion;
import bazar.condicion.CondicionPesoMenor;
import bazar.modelo.Combo;
import bazar.modelo.Producto;
;

public class MainBazar {

	public static void main(String[] args) {
		
		Producto p1 = new Producto("pico decorador liso", 150, 100);
		Producto p2 = new Producto("pico decorador estrella", 170, 115);
		Producto p3 = new Producto("pico decorador plano", 175, 120);
		
		Producto p4 = new Producto("manga pastelera", 200, 100);
		
		
		
		p1.agregarCategoria("pasteleria");
		p2.agregarCategoria("pasteleria");
		p3.agregarCategoria("pasteleria");
		p4.agregarCategoria("pasteleria");
		
		Condicion pesoMenor = new CondicionPesoMenor(1000);
		
		Combo c1 = new Combo("picos de decoracion",0.1,50,pesoMenor);
		
		Combo c2 = new Combo("combo decoracion basico", 0.1, 50, pesoMenor);
		
		c1.agregarElemento(p1);
		c1.agregarElemento(p2);
		c1.agregarElemento(p3);
		

		c2.agregarElemento(c1);
		c2.agregarElemento(p4);
		
		
		
		
		System.out.println(c1.contarProductos());
		System.out.println(p1.getPrecio());
		System.out.println(c2.getPrecio());
		
		System.out.println(p1.getCategorias());
		System.out.println(c1.getCategorias());
		
		System.out.println(c2.contarProductos());
		
		System.out.println(c2.buscar(pesoMenor));
		
		//System.out.println(c2.copiar(pesoMenor));
		
		

	}

}
