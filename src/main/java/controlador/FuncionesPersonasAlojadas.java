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
	

}
