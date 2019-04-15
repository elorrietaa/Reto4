package modelo;

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
	public Alojamiento alojamiento;
	public Hotel hotel;
	public Habitacion habitacion;
	public Cama cama;
	public Reserva reserva;
	public Cliente cliente;

	//public Cama cama;
	//public PersonaAlojada personaAlojada;
	
	public FuncionesPago funcionesPago;
	public FuncionesFicheroReserva funcionesReserva;
	
	//public FuncionesBillete funcionesBillete;
  
	public float precioTotal;
	
	
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
		funcionesReserva = new FuncionesFicheroReserva(this);
		
	
		// guardamos el precio total de la reserva
		precioTotal = 0;
		
	}

}
