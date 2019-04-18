package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import bbdd.Conexion;
import modelo.Cama;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.PrincipalModelo;
import modelo.Reserva;
import vista.JframePrincipal;


/**
 * Esta clase controla el panel de detalles y se encarga de enlazar esa parte de la vista con el modelo
 * 
 */
public class ControladorPanSelHabitacion implements ActionListener {
	public PrincipalControlador controlador;
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	Consultas consultas;
	Ciudad ciudad;
	Hotel hotel;
	Habitacion habitacion;
	Cama cama;
	Reserva reserva;
	Date fechaIda;
	Date fechaVuelta;
	String tiposCamaHab;
	
	public int[] indHabsSel;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Habitacion> listaHabSeleccionadas;
	private ArrayList<Cama> listaCamas;
	int numTipCam [] = new int [3];
	float precioReserva =-1;
	 

	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 */
	public ControladorPanSelHabitacion(JframePrincipal vista, PrincipalModelo modelo,Conexion conexion, PrincipalControlador controlador ) {
		this.vista = vista;
		this.modelo = modelo;		
		this.consultas = new Consultas(conexion);
		this.controlador = controlador;
	}
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.selHabitacion.btnAtras.addActionListener(this);
		vista.selHabitacion.btnContinuar.addActionListener(this);
	}
	
	public void guardarDatosSeleccionadoshabitacion() {
	    //////ESTO ES DEL JLIST CUANDO VAYA JTABLE BIEN LO BORRAMOS
	    //se guarda la habitacion seleecionada en el JLIST
	    this.habitacion = (Habitacion) vista.selHabitacion.listHabitacion.getSelectedValue();
	    
	    
	    //le pasa la habitacion al modelo
	    modelo.habitacion = this.habitacion;
	    //Pruebas
	    System.out.println("***DATOS HABITACION***: C�digo HABITACION:" + habitacion.getCodHabitacion());
	    System.out.println("tipo habitacion :" + habitacion.getTipoHabitacion());
	    System.out.println("n�mero de camas:" + habitacion.getNumCamas());
	  
	}
	public void guardarDatosSeleccionadosJTable() {
		   
		  //indHabsSel es un array que contiene el �ndice (la posici�n) de las habitaciones seleccionadas en el JTable
		    indHabsSel = vista.selHabitacion.tab.getSelectedRows();
		    
		    //probar  aver si imprime lista habs
		  listaHabitaciones = consultas.buscarHabitacionPorCodigoHotel(hotel, modelo.hotel.getCodAlojamiento());
	    	
	    	//muestra en elJlist listHoteles la lista de hoteles de la ciudad seleccionada
		  	for(int i=0; i<listaHabitaciones.size();i++) {
		  	
		  		//prueba
		  		System.out.println("dddddddd:" + listaHabitaciones.get(i));
				
		  	}
		  
		  //creamos un arrayList listaHabSeleccionadas que va a contener las habitaciones seleccionadas
		  listaHabSeleccionadas = new ArrayList<Habitacion>(); 
		    //hacemos un arrayList que contenga las habitaciones de los indices seleccionados:
		    for(int i=0; indHabsSel.length>i; i++) {
		    	System.out.println("------->�ndice de las habitaciones selec en el JTable: " + indHabsSel[i]);
		    	//prueba
		    	System.out.println("C�digo de las habitaciones seleecionadas: " + listaHabitaciones.get(indHabsSel[i]).getCodHabitacion());
		    	
		    	//metemos las habitaciones seleccionadas en un arrayList listaHabSeleccionadas
		    	habitacion = new Habitacion(); 
				habitacion.setCodHabitacion(listaHabitaciones.get(indHabsSel[i]).getCodHabitacion());
				//habitacion.setAlojamiento(hotel);
				habitacion.setTipoHabitacion(listaHabitaciones.get(indHabsSel[i]).getTipoHabitacion());
				habitacion.setTamanio(listaHabitaciones.get(indHabsSel[i]).getTamanio());
				habitacion.setNumCamas(listaHabitaciones.get(indHabsSel[i]).getNumCamas());
				listaHabSeleccionadas.add(habitacion);
		    }
		    
		    //probamos que listaHabSeleccionadas se haya creado y rellenado correctamente:
		    for(int i=0; listaHabSeleccionadas.size()>i; i++) {
		    	System.out.println("------->Habitaciones seleccionadas: " +listaHabSeleccionadas.get(i).getCodHabitacion() );
		    }
		
		}
	
	   /**
		 * Funcion encargada de actualizar la informacion que se muestra en la interfaz
		 */
		public void actualizarFrame() {
			// Mostrar los datos de las habitaciones en tabla de la siguiente pantalla: PanSelHabitacion
			DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReserva.tab.getModel();
			mostrarDetallesHabsSelec(tablaHabs);
			
		}
		
		
		/**
		 * 
		 * 
		 * @param tabla Tabla que se rellena con la informacion de la reserva
		 */
		public void mostrarDetallesHabsSelec( DefaultTableModel tabla) {
			Object[] datos = new Object[5];
			tabla.setRowCount(0);
			for(int i=0; i<listaHabSeleccionadas.size();i++) {
				datos[0] = listaHabSeleccionadas.get(i).getCodHabitacion();
				datos[1] = listaHabSeleccionadas.get(i).getNumCamas();
				//Mostrar detalles de las camas de la habitaci�n seleccionada: 
				ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaHabSeleccionadas.get(i).getCodHabitacion());
				datos[2] = listaCamas;
				
				datos[3] = "falta";
				datos[4] =   "�";
				tabla.addRow(datos);
			}
		}
	/**
	 * Acciones de los distintos componentes del panel
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atr�s":
				
				vista.buscarHotel.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			
			
			case "Continuar":
				//(1�)Se guardan los detalles de la (o las habitaciones seleecionadas)
				//datos JList (borrar en el futuro)
				guardarDatosSeleccionadoshabitacion();
				guardarDatosSeleccionadosJTable();
				
				//Mostrar detalles de las camas de la habitaci�n seleccionada: array numTipCam contiene el n�mero de camas de cada tipo en 1 habitaci�n
				numTipCam = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
				
				// (2�) Calcula el precio de la reserva o reservas realizadas:
				precioReserva = controlador.funcionesReserva.calcularPrecioReserva(numTipCam);
				
				//(3�)Generar reserva (o reservas) y guardarla en el objeto reserva (o en el ArrayList<Reserva> listaReservas)
				controlador.funcionesReserva.generarReserva(numTipCam);
				
				//(4�) se muestran en la siguiente pantalla los detalles de la reserva y el precio de la reserva
				controlador.funcionesReserva.mostrarDatosReserva();
				//se actualiza la tabla con las habitaciones seleccionadas
				actualizarFrame();
				
				//(4�)actualiza el siguiente panel:
				// Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
				vista.selHabitacion.setVisible(false);
				vista.detallesReserva.setVisible(true);
				
				
				
				break;
	
				 
				
		}
		
	}
	/**
	 * Funciones del boton de clancelar
	 */
	public void reset() {
		modelo.cliente = null;
		
		/*
		modelo.billeteIda = null;
		modelo.billeteVuelta = null;
		modelo.linea = null;
		modelo.paradaOrigen = null;
		modelo.paradaDestino = null;
		modelo.autobus = null;
		vista.sel_billete.rbtnIda.setSelected(true);
		vista.sel_billete.rbtnVuelta.setSelected(false);
		*/
		
		modelo.precioTotal = 0;
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
	}
	
}
