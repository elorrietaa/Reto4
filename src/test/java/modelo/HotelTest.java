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
    protected int estrellas=5;
    Hotel hotelPrueba= new Hotel(codAlojamiento, nombre, numHabitaciones, ubicacion, estrellas, precioAlojamiento);
    Hotel hotel= new Hotel();
    
    @Test
   	public void testEstrellas() {
	hotelPrueba.setEstrellas(estrellas);
   		assertEquals(estrellas,hotelPrueba.getEstrellas());
   	}
}
