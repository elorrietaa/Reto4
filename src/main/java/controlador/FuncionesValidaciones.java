package controlador;

import java.sql.Date;

import javax.swing.JOptionPane;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesValidaciones {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioReserva;
	
	Date fechaActual;
	
	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FuncionesValidaciones (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	/**
	 * validarFechaEntradaNoNow = valida que las fechas introducidas sean adecuadas.
	 * Control de fechas: no se pueden hacer reservas anteriores a now() , ni reservas de 0 noches
	 * @param fechaIda = fecha de entrada en el alojamiento
	 * @param fechaVuelta = fecha salida del alojamiento
	 * @return
	 */
	public boolean validarFechaEntradaNoNow(Date fechaIda, Date fechaVuelta) {
		//mostramos fecha actual:
		fechaActual = modelo.consultas.mostrarFechaActual();
		System.out.println("*Fecha actual es:" + fechaActual);
		
		if(fechaIda.before(fechaActual)) { //fecha Entrada anterior a fecha actual
			 JOptionPane.showMessageDialog(vista, "Lo sentimos, la fecha de entrada no puede ser anterior a la fecha actual. Seleccione otra fecha de entrada. Gracias. ", null, 0);
			 fechaIda=null;
			 return false;
		}
		else if(fechaVuelta.equals(fechaIda)) { //fecha salida igual a fecha de entrada
			JOptionPane.showMessageDialog(vista, "Lo sentimos. Debe seleccionar al menos una noche para realizar una reserva. Gracias. ", null, 0);
			 return false;
		}
		else if(fechaVuelta.before(fechaActual)) {//fecha salida anterior a fecha actual
			JOptionPane.showMessageDialog(vista, "Lo sentimos. Debe introducir un rango de fechas v�lido para realizar una reserva. Gracias. ", null, 0);
			return false;
		}
		else if(fechaVuelta.before(fechaIda)) { //fecha salida anterior a la fecha de entrada
			JOptionPane.showMessageDialog(vista, "Lo sentimos. Debe introducir un rango de fechas v�lido para realizar una reserva. Gracias. ", null, 0);
			return false;
		}
		else {
			return true;
		}
	}

}