package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApartamentoTest {

    protected int codAlojamiento=1;
    protected String nombre="Apartamento Bilbao";
    protected int numHabitaciones=10;
    protected String ubicacion="BILBAO";
    protected float precioAlojamiento=(float) 12.2;
    Apartamento apartamento = new Apartamento();
    Apartamento apartamentoPrueba= new Apartamento(codAlojamiento, nombre, numHabitaciones, ubicacion, precioAlojamiento);
  
    @Test
	public void testConstuctor() {
		assertEquals(codAlojamiento, apartamentoPrueba.getCodAlojamiento());
		assertEquals(nombre, apartamentoPrueba.getNombre());
		assertEquals(numHabitaciones, apartamentoPrueba.getNumHabitaciones());
		assertEquals(ubicacion, apartamentoPrueba.getUbicacion());
	}

}
