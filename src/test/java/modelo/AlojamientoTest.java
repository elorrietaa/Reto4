package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Alojamiento;

public class AlojamientoTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    
    Alojamiento alojamientoPrueba= new Alojamiento(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
    
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, alojamientoPrueba.getCodAlojamiento());
		assertEquals(nombre, alojamientoPrueba.getNombre());
		assertEquals(numHabitaciones, alojamientoPrueba.getNumHabitaciones());
		assertEquals(ubicacion, alojamientoPrueba.getUbicacion());
	}
    @Test
	public void testCodAlojamiento() {
		alojamientoPrueba.setCodAlojamiento(codAlojamiento); 
		assertEquals(codAlojamiento,alojamientoPrueba.getCodAlojamiento());
	}
    @Test
   	public void testNombre() {
   		alojamientoPrueba.setNombre(nombre);
   		assertEquals(nombre,alojamientoPrueba.getNombre());
   	} 
    @Test
	public void testNumHabitaciones() {
		alojamientoPrueba.setNumHabitaciones(numHabitaciones);
		assertEquals(numHabitaciones,alojamientoPrueba.getNumHabitaciones());
	}
    @Test
   	public void testUbicacion() {
   		alojamientoPrueba.setUbicacion(ubicacion);
   		assertEquals(ubicacion,alojamientoPrueba.getUbicacion());
   	}
    @Test
	public void testPrecioAlojamiento() {
		alojamientoPrueba.setPrecioAlojamiento(precioAlojamiento);
		assertEquals(precioAlojamiento,alojamientoPrueba.getPrecioAlojamiento(),0.2);
	}
} 