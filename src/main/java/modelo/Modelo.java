package modelo;
/**
 * Clase PrincipalModelo:
 * Contiene las instancias de todas las clases del paquete modelo. 
 * @author alba
 *
 */
public class Modelo {
	public Conexion conexion;
	public Consultas consultas;
	
	public FuncionesReserva funcionesReserva;
	public FuncionesPago funcionesPago;
	//public FuncionesRegistro funcionesRegistro;
	public Ciudad ciudad;
	public Alojamiento alojamiento;
	public Hotel hotel;
	public Reserva reserva;
	//public Habitacion habitacion;
	//public Cama cama;
	//public Cliente cliente;
	//public Persona persona;
	// public float precioTotal;
	/**
	 * Constructor de la clase modelo
	 */
	public Modelo() {
		
		// creamos un objeto BBDD que se encargara de conectarse a la BBDD
		conexion = new Conexion();
				
		// Creamos un objeto Consultas que se encargara de hacer consultas a la BBDD
		consultas = new Consultas(conexion);
		
		// Creamos objetos con las funciones generales del programa
		funcionesReserva = new FuncionesReserva(this);
		funcionesPago = new FuncionesPago(this);
		//funcionesRegistro = new FuncionesRegistro(this);
		
		
		ciudad = null;
		alojamiento = null;
		hotel = null;
		reserva = null;
		// habitacion = null;
		//cama = null;
		//cliente = null;
		
		// guardamos el precio total de la reserva
		//precioTotal = 0;
		
	}
}
