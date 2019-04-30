package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Hotel;

public class HotelTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int popularidad = 10;
    protected int estrellas=5;
    Hotel hotelPrueba= new Hotel(codAlojamiento, nombre, numHabitaciones, ubicacion, estrellas, precioAlojamiento, popularidad);
    Hotel hotel= new Hotel();
    
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
