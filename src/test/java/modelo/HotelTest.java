package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Hotel;

public class HotelTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected String direccion = "Calle mayor";
    protected String telefono = "666 666 666";
    protected int numHabitaciones=10;
    protected int numHabDisponibles=3;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int popularidad = 10;
    protected int estrellas=5;
    protected String [] arrayNombreHabitaciones = {"DORMITORIO","BAÑO", "SALA","COMEDOR", "COCINA", "BALCON", "GARAJE"  };
    protected int [] arrayNumHabitaciones = {2, 2, 1, 1, 1, 1, 1};
    
    Hotel hotelPrueba= new Hotel(codAlojamiento, nombre,direccion, telefono, numHabitaciones, numHabDisponibles, ubicacion, estrellas, precioAlojamiento, popularidad, arrayNombreHabitaciones, arrayNumHabitaciones);
    Hotel hotel= new Hotel();
    
    @Test
	public void testConstuctorHotel() {
		assertEquals(codAlojamiento, hotelPrueba.getCodAlojamiento());
		assertEquals(nombre, hotelPrueba.getNombre());
		assertEquals(direccion, hotelPrueba.getDireccion());
		assertEquals(telefono, hotelPrueba.getTelefono());
		assertEquals(numHabitaciones, hotelPrueba.getNumHabitaciones());
		assertEquals(numHabDisponibles, hotelPrueba.getNumHabDisponibles());
		assertEquals(ubicacion, hotelPrueba.getUbicacion());
		assertEquals(popularidad, hotelPrueba.getPopularidad());
		assertArrayEquals(arrayNombreHabitaciones, hotelPrueba.getArrayNombreHabitaciones());
		assertArrayEquals(arrayNumHabitaciones, hotelPrueba.getArrayNumHabitaciones());
	}
    
    @Test
	public void testCodAlojamiento() {
	hotelPrueba.setCodAlojamiento(codAlojamiento); 
		assertEquals(codAlojamiento,hotelPrueba.getCodAlojamiento());
	}
    @Test
   	public void testNombre() {
	hotelPrueba.setNombre(nombre);
   		assertEquals(nombre,hotelPrueba.getNombre());
   	} 
    @Test
   	public void testDireccion() {
	hotelPrueba.setDireccion(direccion);
   		assertEquals(direccion, hotelPrueba.getDireccion());
   	} 
    @Test
   	public void testTelefono() {
	hotelPrueba.setTelefono(telefono);
   		assertEquals(telefono, hotelPrueba.getTelefono());
   	} 
    @Test
	public void testNumHabitaciones() {
	hotelPrueba.setNumHabitaciones(numHabitaciones);
		assertEquals(numHabitaciones,hotelPrueba.getNumHabitaciones());
	}
    @Test
  	public void testNumHabitacionesDisp() {
	hotelPrueba.setNumHabDisponibles(numHabDisponibles);
  		assertEquals(numHabDisponibles,hotelPrueba.getNumHabDisponibles());
  	}
    @Test
   	public void testUbicacion() {
	hotelPrueba.setUbicacion(ubicacion);
   		assertEquals(ubicacion,hotelPrueba.getUbicacion());
   	}
    @Test
	public void testPrecioAlojamiento() {
	hotelPrueba.setPrecioAlojamiento(precioAlojamiento);
		assertEquals(precioAlojamiento,hotelPrueba.getPrecioAlojamiento(),0.2);
	}
    
    @Test
	public void testConstuctorMal() {
		assertNotEquals(4, hotelPrueba.getCodAlojamiento());
		assertNotEquals("k", hotelPrueba.getNombre());
		assertNotEquals(9, hotelPrueba.getNumHabitaciones());
		assertNotEquals("k", hotelPrueba.getUbicacion());
	}
    @Test
	public void testCodAlojamientoMal() {
	hotelPrueba.setCodAlojamiento(codAlojamiento); 
		assertNotEquals(5,hotelPrueba.getCodAlojamiento());
	}
    @Test
   	public void testNombreMal() {
	hotelPrueba.setNombre(nombre);
   		assertNotEquals("k",hotelPrueba.getNombre());
   	} 
    @Test
	public void testNumHabitacionesMal() {
	hotelPrueba.setNumHabitaciones(numHabitaciones);
		assertNotEquals(8,hotelPrueba.getNumHabitaciones());
	}
    @Test
   	public void testUbicacionMal() {
	hotelPrueba.setUbicacion(ubicacion);
   		assertNotEquals("k",hotelPrueba.getUbicacion());
   	}
    @Test
	public void testPrecioAlojamientoMal() {
	hotelPrueba.setPrecioAlojamiento(precioAlojamiento);
		assertNotEquals(0,hotelPrueba.getPrecioAlojamiento(),0.2);
	}
    
    @Test
   	public void testEstrellas() {
	hotelPrueba.setEstrellas(estrellas);
   		assertEquals(estrellas,hotelPrueba.getEstrellas());
   	}
    @Test
   	public void testToString() {
   		 assertEquals(nombre, hotelPrueba.toString());
   	}
    @Test
	public void testToStringDatosHotel() {
		 assertEquals("Código hotel: " + this.codAlojamiento + "Nombre: " + this.nombre, hotelPrueba.toStringDatosHotel());
	}
    
    @Test
   	public void testEstrellasMal() {
	hotelPrueba.setEstrellas(estrellas);
   		assertNotEquals(0,hotelPrueba.getEstrellas());
   	}
    @Test
   	public void testToStringMal() {
    	assertNotEquals("k", hotelPrueba.toString());
   	}
    @Test
	public void testToStringDatosHotelMal() {
    	assertNotEquals("Código hotesrgtl: " + this.codAlojamiento + "Nombre: " + this.nombre, hotelPrueba.toStringDatosHotel());
	}
}
