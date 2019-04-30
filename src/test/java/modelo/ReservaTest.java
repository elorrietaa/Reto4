package modelo;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class ReservaTest {
    private int codReserva=1;
    private Cliente cliente = new Cliente("22758299X", "Alba", "Rodriguez Salvador", new Date(31-01-2019), 'M', "abracadaver");
    private Alojamiento alojamiento=new Alojamiento(1, "Hotel Melia", 5, "Bilbao", (float) 54.2);
    private int numTipCam [] = {2,0,0};
    private Dormitorio habitacion = new Dormitorio(1, "Dormitorio","Doble", 15, 2,2, numTipCam ,(float) 172.5, "simple, simple");
    private Date fechaIda = new Date(31-01-2019);
    private Date fechaVuelta;
    private float precioReserva=(float) 88.29;
    Reserva reservaPrueba = new Reserva(codReserva, cliente, alojamiento,habitacion, fechaIda, fechaVuelta, precioReserva);
    Reserva reservaPrueba1 = new Reserva(codReserva, cliente, alojamiento, fechaIda, fechaVuelta, precioReserva);
    Reserva reserva = new Reserva(); 
    Cliente clienteNuevo = new Cliente();
    @Test 
   	public void testConstuctor1() {
   		assertEquals(codReserva, reservaPrueba.getCodReserva());
   		assertEquals(alojamiento, reservaPrueba.getAlojamiento());
   		assertEquals(precioReserva, reservaPrueba.getPrecioReserva(),0.2);
 
   	}
    @Test 
   	public void testConstuctor2() {
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
    
    @Test 
   	public void testConstuctorMal() {
   		assertNotEquals(0, reservaPrueba.getCodReserva());
   		assertNotEquals(null, reservaPrueba.getAlojamiento());
   		assertNotEquals(0, reservaPrueba.getPrecioReserva(),0.2);
 
   	}
    @Test
   	public void testCodReservaMal() {
		reservaPrueba.setCodReserva(codReserva); 
		assertNotEquals(0,reservaPrueba.getCodReserva());
   	}
    @Test
	public void testAlojamientoMal() {
		reservaPrueba.setAlojamiento(alojamiento); 
		assertNotEquals(null,reservaPrueba.getAlojamiento());
	}
    @Test
	public void testHabitacionMal() {
		reservaPrueba.setHabitacion(habitacion); 
		assertNotEquals(null, reservaPrueba.getHabitacion());
	}
    @Test
   	public void testPrecioReservaMal() {
   		reservaPrueba.setPrecioReserva(precioReserva); 
   		assertNotEquals(0,reservaPrueba.getPrecioReserva(),0.2);
   	}
    @Test
    public void testToStringMal() {
    	assertNotEquals("Dattgyos de la reserva: Código de Reserva:" + this.codReserva, reservaPrueba.toString());
    }
    @Test
	public void testClienteMal() {
		reservaPrueba.setCliente(cliente);
		assertNotEquals(null, reservaPrueba.getCliente());
	}
   
    @Test
	public void testFechaMal() {
		reservaPrueba.setFechaIda(fechaIda);
		assertNotEquals(0, reservaPrueba.getFechaIda());
	}
    @Test
	public void testVueltaMal() {
		reservaPrueba.setFechaVuelta(fechaVuelta);
		assertNotEquals(0, reservaPrueba.getFechaVuelta());
	}
}
