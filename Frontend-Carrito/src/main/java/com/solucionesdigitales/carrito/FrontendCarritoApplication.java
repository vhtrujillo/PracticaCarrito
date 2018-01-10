package com.solucionesdigitales.carrito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.solucionesdigitales"})
public class FrontendCarritoApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(FrontendCarritoApplication.class, args);
	}
}
