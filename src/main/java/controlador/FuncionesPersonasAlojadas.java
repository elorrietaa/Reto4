package controlador;

import java.util.ArrayList;

import modelo.Cama;
import modelo.Dormitorio;
import modelo.Habitacion;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesPersonasAlojadas {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioReserva;
	
	public FuncionesPersonasAlojadas (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	/**
	 * Método mostrarPersonasAlojadas = muestra el número de personas que pueden alojarse en el alojamiento teniendo en cuenta el número y el tipo de camas que tienen las habitaciones del alojamiento
	 */
	public void mostrarPersonasAlojadas() {
	    int ocupacion = 0;
	    ArrayList<Dormitorio> listaDormitorios = modelo.consultas.buscarHabitacionDisponiblel(modelo.fechaIda, modelo.fechaVuelta, modelo.hotel.getCodAlojamiento());
	          for(int i=0; i<listaDormitorios.size();i++) {
	               ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormitorios.get(i).getCodHabitacion());
	        
	               ocupacion = controlador.funcionesReserva.mostrarOcupacionHab(listaCamas);
	          }
	          System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!El número de personas que se pueden alojar en el alojamiento es: " + ocupacion);
	}
	

}
