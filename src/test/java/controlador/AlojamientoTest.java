package controlador;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlojamientoTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    Alojamiento alojamientoPrueba= new Alojamiento(codAlojamiento, nombre, numHabitaciones, ubicacion);
    
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
} 
