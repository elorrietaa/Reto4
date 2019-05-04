package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Alojamiento;

public class AlojamientoTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected String direccion = "Calle mayor";
    protected String telefono = "666 666 666";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int popularidad = 10;
    Alojamiento alojamiento = new Alojamiento();
    Alojamiento alojamientoPrueba= new Alojamiento(codAlojamiento, nombre,direccion, telefono, numHabitaciones, ubicacion, precioAlojamiento, popularidad);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, alojamientoPrueba.getCodAlojamiento());
		assertEquals(nombre, alojamientoPrueba.getNombre());
		assertEquals(direccion, alojamientoPrueba.getDireccion());
		assertEquals(telefono, alojamientoPrueba.getTelefono());
		assertEquals(numHabitaciones, alojamientoPrueba.getNumHabitaciones());
		assertEquals(ubicacion, alojamientoPrueba.getUbicacion());
		assertEquals(popularidad, alojamientoPrueba.getPopularidad());
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
   	public void testDireccion() {
   		alojamientoPrueba.setDireccion(direccion);
   		assertEquals(direccion, alojamientoPrueba.getDireccion());
   	} 
    @Test
   	public void testTelefono() {
   		alojamientoPrueba.setTelefono(telefono);
   		assertEquals(telefono, alojamientoPrueba.getTelefono());
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
    
    @Test
	public void testConstuctorMal() {
		assertNotEquals(4, alojamientoPrueba.getCodAlojamiento());
		assertNotEquals("k", alojamientoPrueba.getNombre());
		assertNotEquals(9, alojamientoPrueba.getNumHabitaciones());
		assertNotEquals("k", alojamientoPrueba.getUbicacion());
	}
    @Test
	public void testCodAlojamientoMal() {
		alojamientoPrueba.setCodAlojamiento(codAlojamiento); 
		assertNotEquals(5,alojamientoPrueba.getCodAlojamiento());
	}
    @Test
   	public void testNombreMal() {
   		alojamientoPrueba.setNombre(nombre);
   		assertNotEquals("k",alojamientoPrueba.getNombre());
   	} 
    @Test
	public void testNumHabitacionesMal() {
		alojamientoPrueba.setNumHabitaciones(numHabitaciones);
		assertNotEquals(8,alojamientoPrueba.getNumHabitaciones());
	}
    @Test
   	public void testUbicacionMal() {
   		alojamientoPrueba.setUbicacion(ubicacion);
   		assertNotEquals("k",alojamientoPrueba.getUbicacion());
   	}
    @Test
	public void testPrecioAlojamientoMal() {
		alojamientoPrueba.setPrecioAlojamiento(precioAlojamiento);
		assertNotEquals(0,alojamientoPrueba.getPrecioAlojamiento(),0.2);
	}
} 
