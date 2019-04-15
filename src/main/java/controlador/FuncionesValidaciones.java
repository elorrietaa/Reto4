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
	
	public boolean validarFechaEntradaNoNow(Date fechaIda, Date fechaVuelta) {
		//mostramos fecha actual:
		fechaActual = modelo.consultas.mostrarFechaActual();
		System.out.println("*Fecha actual es:" + fechaActual);
		if(fechaIda==null) {
			  vista.buscarHotel.setVisible(true);
		}
		if(fechaIda.before(fechaActual)) {
			 JOptionPane.showMessageDialog(vista, "Por favor, La fecha de entrada no puede ser anterior a la fecha actual. Seleccione otra fecha de entrada. Gracias. ", null, 0);
			 fechaIda=null;
			 return false;
		}
		else {
			return true;
		}
	}

}
