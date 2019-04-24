package controlador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modelo.Habitacion;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesReservaTest {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	
	FuncionesReserva funcionesReserva = new FuncionesReserva(modelo, vista, controlador);
	
	ArrayList<Habitacion> listaHabitacionPrueba = new ArrayList<Habitacion>(); 
	protected int codHabitacion=1;
	protected String tipoHabitacion="Dormitorio";
	protected float tamanio=15;
	protected int numCamas=2;
	protected float precioHabitacion=(float) 172.5;
	private int numTipCam [] = {2,0,0};
	protected String tiposCamaHab = "simple";
	
	Habitacion habitacion1 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 10.5, tiposCamaHab);
	Habitacion habitacion2 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 10.5, tiposCamaHab);
	Habitacion habitacion3 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 20, tiposCamaHab);
	  
	//no me deja meterlo en el arraylist
	//listaHabitacionPrueba.add(habitacion1);
	
	@Test
	public void testCalcularPrecioReservaHotel() {
		float precioReservaEsperado = 41;
		float precioObservado = funcionesReserva.calcularPrecioReservaHotel(listaHabitacionPrueba);
		assertEquals(precioReservaEsperado, precioObservado ,0.02);
	}
	
	@Test
	public void testCalcularNochesReservadas() {
		
	}

}
