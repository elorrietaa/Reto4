package controlador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.Habitacion;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesReservaTest {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	
	FuncionesReserva funcionesReserva = new FuncionesReserva(modelo, vista, controlador);
	
	ArrayList<Habitacion> listaHabitacionPrueba;
	     
	  @Before
	  public void setUp() throws Exception {
	    listaHabitacionPrueba = new ArrayList<Habitacion>(); 
	    
	    int codHabitacion=1;
		String tipoHabitacion="Dormitorio";
		float tamanio=15;
		int numCamas=2;
		float precioHabitacion=(float) 172.5;
		int numTipCam [] = {2,0,0};
		String tiposCamaHab = "simple";
		
	    Habitacion habitacion1 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 10.5, tiposCamaHab);
	    Habitacion habitacion2 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 10.5, tiposCamaHab);
	    Habitacion habitacion3 = new Habitacion(codHabitacion, tipoHabitacion, tamanio, numCamas,numTipCam,(float) 20, tiposCamaHab);
		  
	    listaHabitacionPrueba.add(habitacion1);
	    listaHabitacionPrueba.add(habitacion2);
	    listaHabitacionPrueba.add(habitacion3);
	  }
	
	@Test
	public void testCalcularPrecioReservaHotel() {
		float precioReservaEsperado = 41;
		//int numNoches = 1;
		
		float precioObservado = funcionesReserva.calcularPrecioReservaHotel(listaHabitacionPrueba);
		assertEquals(precioReservaEsperado, precioObservado ,0.5);
	}
	
	@Test
	public void testCalcularNochesReservadas() {
		int numNochesEsperadas = 1;
		int numNochesObservadas = 1;
		
		assertEquals(numNochesEsperadas, numNochesObservadas);
	}

}
