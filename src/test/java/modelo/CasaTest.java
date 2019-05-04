package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasaTest {

    protected int codAlojamiento=1;
    protected String nombre="Casa Bilbao";
    protected String direccion = "Calle mayor";
    protected String telefono = "666 666 666";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int numBanos=2;
    protected float metrosCuadrados=(float) 68.2;
    protected int popularidad = 10;
    Casa casa = new Casa();
    Casa casaPrueba= new Casa(codAlojamiento, nombre,direccion, telefono, numHabitaciones, ubicacion, precioAlojamiento, popularidad, numBanos, metrosCuadrados);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, casaPrueba.getCodAlojamiento());
		assertEquals(nombre, casaPrueba.getNombre());
		assertEquals(numHabitaciones, casaPrueba.getNumHabitaciones());
		assertEquals(ubicacion, casaPrueba.getUbicacion());
		assertEquals(numBanos, casaPrueba.getNumBanos());
		assertEquals(metrosCuadrados, casaPrueba.getMetrosCuadrados(),0.5);
	}

    @Test
   	public void testNumBanos() {
    	casaPrueba.setNumBanos(numBanos);
   		assertEquals(numBanos,casaPrueba.getNumBanos());
   	}
    
    @Test
   	public void testMetrosCuadrados() {
    	casaPrueba.setMetrosCuadrados(metrosCuadrados);
   		assertEquals(metrosCuadrados, casaPrueba.getMetrosCuadrados(),0.2);
   	}
}
