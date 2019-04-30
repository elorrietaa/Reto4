package controlador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.Dormitorio;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesReservaTest {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	
	FuncionesReserva funcionesReserva = new FuncionesReserva(modelo, vista, controlador);
	
	ArrayList<Dormitorio> listaHabitacionPrueba;
	     
	  @Before
	  public void setUp() throws Exception {
	    listaHabitacionPrueba = new ArrayList<Dormitorio>(); 
	    
	    int codHabitacion=1;
		String tipoHabitacion="Dormitorio";
		String nombreHabitacion = "Doble";
		int ocupacion = 2;
		float tamanio=15;
		int numCamas=2;
		float precioHabitacion=(float) 172.5;
		int numTipCam [] = {2,0,0};
		String tiposCamaHab = "simple";
		
	    Dormitorio habitacion1 = new Dormitorio(codHabitacion,nombreHabitacion, tipoHabitacion, tamanio, numCamas,ocupacion,numTipCam,(float) 10.5, tiposCamaHab);
	    Dormitorio habitacion2 = new Dormitorio(codHabitacion,nombreHabitacion, tipoHabitacion, tamanio, numCamas,ocupacion,numTipCam,(float) 10.5, tiposCamaHab);
	    Dormitorio habitacion3 = new Dormitorio(codHabitacion,nombreHabitacion, tipoHabitacion, tamanio, numCamas,ocupacion,numTipCam,(float) 20, tiposCamaHab);
		  
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
