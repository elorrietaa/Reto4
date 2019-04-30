package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApartamentoTest {

    protected int codAlojamiento=1;
    protected String nombre="Apartamento Bilbao";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    protected int popularidad = 10;
    protected int numBanos=2;
    protected float metrosCuadrados=(float) 68.2;
    protected int piso = 2;
    Apartamento apartamento = new Apartamento();
    Apartamento apartamentoPrueba= new Apartamento(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento, popularidad, numBanos, metrosCuadrados, piso);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, apartamentoPrueba.getCodAlojamiento());
		assertEquals(nombre, apartamentoPrueba.getNombre());
		assertEquals(numHabitaciones, apartamentoPrueba.getNumHabitaciones());
		assertEquals(ubicacion, apartamentoPrueba.getUbicacion());
		assertEquals(popularidad, apartamentoPrueba.getPopularidad());
		assertEquals(numBanos, apartamentoPrueba.getNumBanos());
		assertEquals(metrosCuadrados, apartamentoPrueba.getMetrosCuadrados(),0.5);
		assertEquals(piso, apartamentoPrueba.getPiso());
	}
    
    @Test
   	public void testPiso() {
    	apartamentoPrueba.setPiso(piso);
   		assertEquals(piso,apartamentoPrueba.getPiso());
   	}

}
