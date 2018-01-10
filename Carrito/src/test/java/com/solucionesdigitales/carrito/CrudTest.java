package com.solucionesdigitales.carrito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.solucionesdigitales.carrito.CarritoApplication;
import com.solucionesdigitales.carrito.modelo.entidad.Producto;
import com.solucionesdigitales.carrito.servicio.ProductoServicio;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = CarritoApplication.class, loader = AnnotationConfigContextLoader.class)
public class CrudTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(CrudTest.class);
	
	
	
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServicio servico;
	@Before
	public void setup() 
	{
       LOG.info("-----------------");
       LOG.info("Inicializando componentes ...");
       LOG.info("-----------------");
	}
	
	@Test
	public void agregarProducto() {
		String respuestaEsperada = "EXITO";
		Producto producto = new Producto("Rufles",15.5);
		LOG.info("PRODUCTO A INSERTAR: " + producto);
		String respuesta = servico.insertarProducto(producto);
		Assert.assertEquals(respuestaEsperada, respuesta);
		
		producto.setIdProducto(null);
		producto.setNombre("Cocacola");
		producto.setPrecio(23.9);
		LOG.info("PRODUCTO A INSERTAR: " + producto);
		String respuesta1 = servico.insertarProducto(producto);
		Assert.assertEquals(respuestaEsperada, respuesta1);
		
		   producto.setIdProducto(2L);
		   producto.setNombre("Pepsi");
			producto.setPrecio(10);
		   LOG.info("PRODUCTO ACTUALIZADO A: " + producto);
		   String respuesta2 = servico.actualizarProducto(producto);
		   Assert.assertEquals(respuestaEsperada, respuesta2);
		
		 LOG.info("PRODUCTO A ELIMINAR: ID(" + 1L+")");
		 String respuesta3 = servico.eliminarProducto(1L);
		 Assert.assertEquals(respuestaEsperada, respuesta3);
		
	}
	 
}
