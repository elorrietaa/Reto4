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
    protected int numHabDisponibles=3;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int popularidad = 10;
    protected String [] arrayNombreHabitaciones = {"DORMITORIO","BAÑO", "SALA","COMEDOR", "COCINA", "BALCON", "GARAJE"  };
    protected int [] arrayNumHabitaciones = {2, 2, 1, 1, 1, 1, 1};
 /*   
    Alojamiento alojamiento = new Alojamiento();
    Alojamiento alojamientoPrueba= new Alojamiento(codAlojamiento, nombre,direccion, telefono, numHabitaciones, numHabDisponibles, ubicacion, precioAlojamiento, popularidad, arrayNombreHabitaciones, arrayNumHabitaciones);
    Alojamiento alojamientoPrueba2= new Alojamiento(codAlojamiento, nombre,direccion, telefono, numHabitaciones, ubicacion, precioAlojamiento, popularidad, arrayNombreHabitaciones, arrayNumHabitaciones);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, alojamientoPrueba.getCodAlojamiento());
		assertEquals(nombre, alojamientoPrueba.getNombre());
		assertEquals(direccion, alojamientoPrueba.getDireccion());
		assertEquals(telefono, alojamientoPrueba.getTelefono());
		assertEquals(numHabitaciones, alojamientoPrueba.getNumHabitaciones());
		assertEquals(numHabDisponibles, alojamientoPrueba.getNumHabDisponibles());
		assertEquals(ubicacion, alojamientoPrueba.getUbicacion());
		assertEquals(popularidad, alojamientoPrueba.getPopularidad());
		assertArrayEquals(arrayNombreHabitaciones, alojamientoPrueba.getArrayNombreHabitaciones());
		assertArrayEquals(arrayNumHabitaciones, alojamientoPrueba.getArrayNumHabitaciones());
	}
    @Test
	public void testConstuctor2() {
		assertEquals(codAlojamiento, alojamientoPrueba2.getCodAlojamiento());
		assertEquals(nombre, alojamientoPrueba2.getNombre());
		assertEquals(direccion, alojamientoPrueba2.getDireccion());
		assertEquals(telefono, alojamientoPrueba2.getTelefono());
		assertEquals(numHabitaciones, alojamientoPrueba2.getNumHabitaciones());
		assertEquals(ubicacion, alojamientoPrueba2.getUbicacion());
		assertEquals(popularidad, alojamientoPrueba2.getPopularidad());
		assertArrayEquals(arrayNombreHabitaciones, alojamientoPrueba.getArrayNombreHabitaciones());
		assertArrayEquals(arrayNumHabitaciones, alojamientoPrueba.getArrayNumHabitaciones());
	
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
  	public void testNumHabitacionesDisp() {
  		alojamientoPrueba.setNumHabDisponibles(numHabDisponibles);
  		assertEquals(numHabDisponibles,alojamientoPrueba.getNumHabDisponibles());
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
	
*/
} 
