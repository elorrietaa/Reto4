package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasaTest {

    protected int codAlojamiento=1;
    protected String nombre="Casa Bilbao";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    Casa casa = new Casa();
    Casa casaPrueba= new Casa(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, casaPrueba.getCodAlojamiento());
		assertEquals(nombre, casaPrueba.getNombre());
		assertEquals(numHabitaciones, casaPrueba.getNumHabitaciones());
		assertEquals(ubicacion, casaPrueba.getUbicacion());
	}

}
