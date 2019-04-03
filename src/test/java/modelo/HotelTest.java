package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Hotel;

public class HotelTest {
    protected int codAlojamiento=1;
    protected String nombre="HOTEL MELIA";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected int estrellas=5;
    Hotel hotelPrueba= new Hotel(codAlojamiento, nombre, numHabitaciones, ubicacion, estrellas );
   
    @Test
   	public void testEstrellas() {
	hotelPrueba.setEstrellas(estrellas);
   		assertEquals(estrellas,hotelPrueba.getEstrellas());
   	}
}
