package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReservaTest {
    private int codReserva=1;
    private Alojamiento alojamiento=new Alojamiento(1, "Hotel Melia", 5, "Bilbao", (float) 54.2);
    private float precioReserva=(float) 88.29;
    Reserva reservaPrueba = new Reserva(codReserva, alojamiento, precioReserva);
    Reserva reserva = new Reserva();
    @Test
   	public void testConstuctor() {
   		assertEquals(codReserva, reservaPrueba.getCodReserva());
   		assertEquals(alojamiento, reservaPrueba.getAlojamiento());
   		assertEquals(precioReserva, reservaPrueba.getPrecioReserva(),0.2);
   		
   	}
    @Test
   	public void testCodReserva() {
		reservaPrueba.setCodReserva(codReserva); 
   		assertEquals(codReserva,reservaPrueba.getCodReserva());
   	}
    @Test
	public void testAlojamiento() {
		reservaPrueba.setAlojamiento(alojamiento); 
		assertEquals(alojamiento,reservaPrueba.getAlojamiento());
	}
    @Test
   	public void testPrecioReserva() {
   		reservaPrueba.setPrecioReserva(precioReserva); 
   		assertEquals(precioReserva,reservaPrueba.getPrecioReserva(),0.2);
   	}
}
