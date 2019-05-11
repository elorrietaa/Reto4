package modelo;

import java.sql.Date;
import java.util.ArrayList;

import bbdd.Conexion;
import controlador.FuncionesPago;

/**
 * Clase PrincipalModelo:
 * Contiene las instancias de todas las clases del paquete modelo. 
 * @author alba
 *
 */
public class PrincipalModelo {

	public Conexion conexion;
	public Consultas consultas;
	
	public Ciudad ciudad;
	public TipoAlojamiento tiposAloj;
	public Alojamiento alojamiento;
	public Hotel hotel;
	public Casa casa;
	public Apartamento apartamento;
	public Dormitorio habitacion;
	public Cama cama;
	public Reserva reserva;
	public Cliente cliente;
	public FechasTarifas fechasTarifas;
	public CodigoPromocional cuponSeleccionado;

	//public PersonaAlojada personaAlojada;
	
	public FuncionesPago funcionesPago;
	public FuncionesFicheroReserva funcionesFichero;
	
	//public FuncionesBillete funcionesBillete;
  
	public float precioTotal;
	public Date fechaIda;
	public Date fechaVuelta;
	public int numNoches;
	public ArrayList<Reserva> listaReservas;
	public ArrayList<Cliente> listaPersonasEncriptada;
	public boolean basesAceptadas;
	
	/**
	 * Constructor de la clase PrincipalModelo
	 */
	public PrincipalModelo() {
		
		// creamos un objeto BBDD que se encargara de conectarse a la BBDD
		conexion = new Conexion();
				
		// Creamos un objeto Consultas que se encargara de hacer consultas a la BBDD
		consultas = new Consultas(conexion);
		
		//inicializamos nuestros objetos a null
		ciudad = null;
		alojamiento = null;
		hotel = null;
		habitacion = null;
		cama = null;
		reserva = null;
		cliente = null;
		
		// Creamos objetos con las funciones generales del programa
		
		funcionesPago = new FuncionesPago(this); 
		funcionesFichero = new FuncionesFicheroReserva(this);
		fechasTarifas = new FechasTarifas(this, null, null);
	
		// guardamos el precio total de la reserva
		precioTotal = 0;
		
		// Hacemos que de manera inicial las bases legales no hayan sido aceptadas
		basesAceptadas = false;
		
	}

}
