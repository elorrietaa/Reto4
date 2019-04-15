package modelo;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class ReservaTest {
    private int codReserva=1;
    private Cliente cliente = new Cliente("22758299X", "Alba", "Rodriguez Salvador", new Date(31-01-2019), 'M', "abracadaver");
    private Alojamiento alojamiento=new Alojamiento(1, "Hotel Melia", 5, "Bilbao", (float) 54.2);
    private Habitacion habitacion = new Habitacion(1, "Dormitorio", 15, 2,"simple, simple");
    private Date fechaIda = new Date(31-01-2019);
    private Date fechaVuelta;
    private float precioReserva=(float) 88.29;
    Reserva reservaPrueba = new Reserva(codReserva, cliente, alojamiento,habitacion, fechaIda, fechaVuelta, precioReserva);
    Reserva reserva = new Reserva(); 
    Cliente clienteNuevo = new Cliente();
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
	public void testHabitacion() {
		reservaPrueba.setHabitacion(habitacion); 
		assertEquals(habitacion, reservaPrueba.getHabitacion());
	}
    @Test
   	public void testPrecioReserva() {
   		reservaPrueba.setPrecioReserva(precioReserva); 
   		assertEquals(precioReserva,reservaPrueba.getPrecioReserva(),0.2);
   	}
    @Test
    public void testToString() {
   	assertEquals("Datos de la reserva: Código de Reserva:" + this.codReserva, reservaPrueba.toString());
    }
    @Test
	public void testCliente() {
		reservaPrueba.setCliente(cliente);
		assertEquals(cliente, reservaPrueba.getCliente());
	}
   
    @Test
	public void testFecha() {
		reservaPrueba.setFechaIda(fechaIda);
		assertEquals(fechaIda, reservaPrueba.getFechaIda());
	}
    @Test
	public void testVuelta() {
		reservaPrueba.setFechaVuelta(fechaVuelta);
		assertEquals(fechaVuelta, reservaPrueba.getFechaVuelta());
	}
}
