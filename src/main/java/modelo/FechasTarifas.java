package modelo;

import controlador.PrincipalControlador;
import vista.JframePrincipal;

/**
 * Clase FechasTarifas = contiene VARIABLES Y ARRAYS que contienen DATOS relacionados con las TARIFAS
 * @author alba
 *
 */
public class FechasTarifas {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;

	/**
	 * Constructor de la clase FuncionesPago
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarlo
	 */
	public FechasTarifas (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	// CLASE FechasTarifas  VARIABLES Y ARRAYS que contienen datos relacionados con las tarifas
	
		//Declaración e inicialización de arrays y variables:
		//Declaración e inicialización de los días festivos
		final static int diaAnoNuevo = 1;
		final static int diaReyes = 6;
		//final static int diaViernesSanto = 19; // Cambia cada año
		final static int diaFiestaTrabajo = 1;
		final static int diaVigenMaria = 15;
		final static int diaHispanidad = 12;
		final static int diaTodosSantos = 1;
		final static int diaConstitucion = 6;
		final static int diaConcepcion = 8;
		final static int diaNatividad = 25;
		
		
		//Declaración e inicialización de los meses de los días festivos. NOTA: los meses se guardan de O a 11 siendo 0 enero y 11 diciembre.
		final static int mesAnoNuevo = 0;
		final static int mesReyes = 0;
		//final static int mesViernesSanto = 2; // Cambia cada año
		final static int mesFiestaTrabajo = 4;
		final static int mesVigenMaria = 7;
		final static int mesHispanidad = 9;
		final static int mesTodosSantos = 10;
		final static int mesConstitucion = 11;
		final static int mesConcepcion = 11;
		final static int mesNatividad = 11;
		
		//Declaración e inicialización de los nombres de los días festivos. 
		final static String nombreFestivoAnoNuevo = "Año Nuevo";
		final static String nombreFestivoReyes = "Día de Reyes";
		//final static String nombreFestivoVSanto = "Viernes Santo"; // Cambia cada año
		final static String nombreFestivoTrabajo = "Día del trabajador";
		final static String nombreFestivoVigenMaria = "Asunción de la Virgen Maria";
		final static String nombreFestivoHispanidad = "Día de la Hispanidad";
		final static String nombreFestivoTodosSantos = "Todos los Santos";
		final static String nombreFestivoConstitucion = "Día de la Constitución";
		final static String nombreFestivoConcepcion = "La Inmaculada Concepción";
		final static String nombreFestivoNatividad = "Navidad";
		
		//Este array contiene los dias de los festivos
		public final static int [] diasFestivos= {diaAnoNuevo, diaReyes, diaFiestaTrabajo, diaVigenMaria, diaHispanidad, diaTodosSantos, diaConstitucion, diaConcepcion, diaNatividad};
		
		//Este array contiene los meses de los festivos
		public final static int [] mesesFestivos= {mesAnoNuevo,mesReyes,mesFiestaTrabajo,mesVigenMaria,mesHispanidad,mesTodosSantos,mesConstitucion,mesConcepcion,mesNatividad};	
		
		//Este array contiene los nombres de los festivos
		public final static String [] nombreFestivos= {nombreFestivoAnoNuevo,nombreFestivoReyes,nombreFestivoTrabajo,nombreFestivoVigenMaria,nombreFestivoHispanidad,nombreFestivoTodosSantos, nombreFestivoConstitucion, nombreFestivoConcepcion, nombreFestivoNatividad};	
		
		//Este array contiene los días festivos, los meses y el nombre del festivo.
		public final static Object [] arrayDatosFestivos = {diasFestivos, mesesFestivos, nombreFestivos};
}
