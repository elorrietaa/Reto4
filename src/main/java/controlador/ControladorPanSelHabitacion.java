package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bbdd.Conexion;
import modelo.Apartamento;
import modelo.Cama;
import modelo.Ciudad;
import modelo.Consultas;
import modelo.Dormitorio;
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
	Dormitorio habitacion;
	Cama cama;
	Reserva reserva;
	Date fechaIda;
	Date fechaVuelta;
	String tiposCamaHab;
	
	public int[] indHabsSel = null;
	private ArrayList<Dormitorio> listaDormitorios;
	private ArrayList<Dormitorio> listaDormSeleccionados;
	public ArrayList<Reserva> listaReservas;
	int numTipCam [] = new int [3];
	float precioReserva =-1;
	 

	/** 
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 * @param conexion Instancia de la conexion para los malditos teses
	 * @param controlador Instancia del controlador para poder utilizarlo
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
		vista.selHabitacion.btnCerrarSesion.addActionListener(this);
		vista.selHabitacion.btnCancelar.addActionListener(this);
		vista.selHabitacion.btnInicioSesion.addActionListener(this);
		vista.selHabitacion.btnRegistro.addActionListener(this);
		vista.selHabitacion.btnAtras.addActionListener(this);
		vista.selHabitacion.btnContinuar.addActionListener(this);
	}
	/**
	 * M�todo: guardar1DormSeleccionadosJTable = se gudardan en el ArrayList listaHabSeleccionadas los datos de las habitaciones seleccionadas.
	 */
	public void mostrar1DormSeleccionadosJTable() {
		//indHabsSel es un array que contiene el �ndice (la posici�n) de las habitaciones seleccionadas en el JTable
	    indHabsSel = vista.selHabitacion.tab.getSelectedRows();
	    
	    //la lista de dormitorios DISPONIBLES que semuestra al usuario para que seleccione
	    listaDormitorios = consultas.buscarHabitacionDisponiblel(modelo.fechaIda, modelo.fechaVuelta, modelo.hotel.getCodAlojamiento());
	  
	    
		//se guarda en filaDormSel la posici�n seleccionada en la tabla
		  int filaDormSel = vista.selHabitacion.tab.getSelectedRow();
			    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + filaDormSel);
			//se guarda el apartamento seleccionado en la tabla
			//Dormitorio habitacion = (Dormitorio) listaDormitorios.get(filaDormSel);
			
			//rellenamos la habitacion con los datos de la habitacion seleccionada (listaDormitorios.get(filaDormSel))
			habitacion = new Dormitorio(); 
			habitacion.setCodHabitacion(listaDormitorios.get(filaDormSel).getCodHabitacion());
			habitacion.setNombreHabitacion(listaDormitorios.get(filaDormSel).getNombreHabitacion());
			//habitacion.setAlojamiento(hotel);
			habitacion.setTipoHabitacion(listaDormitorios.get(filaDormSel).getTipoHabitacion());
			habitacion.setTamanio(listaDormitorios.get(filaDormSel).getTamanio());
			habitacion.setNumCamas(listaDormitorios.get(filaDormSel).getNumCamas());
			habitacion.setPrecioHabitacion(listaDormitorios.get(filaDormSel).getPrecioHabitacion());
			
			
			//le pasa el apartamento al modelo
			modelo.habitacion = this.habitacion;
			
			//prueba
			System.out.println("Habitacion{{{{{{{{{{{{{{{ " + habitacion.getCodHabitacion());
			System.out.println("Habitacion{{{{{{{{{{{{{{{ " + modelo.habitacion.getCodHabitacion());
		 
		//Se muestran los detalles de las habitaciones seleccionadas en el JTable del panel detallesReserva
			mostratDetallesHabHotelSel(habitacion);
			
		}
	
	
		/**
		 * M�todo mostratDetallesHabHotelSel = Se muestran los detalles de las habitaciones seleccionadas en el JTable del panel detallesReserva
		 * 
		 * @param habitacion Objeto dormitorion con la informacion de las habitaciones del hotel seleccionado
		 */
		public void mostratDetallesHabHotelSel(Dormitorio habitacion) {

		DefaultTableModel tablaDetCasApart = (DefaultTableModel) vista.detallesReservaCasaApart.tab.getModel();
		 
		Object[] datos = new Object[6];
		
		tablaDetCasApart.setRowCount(0);
			datos[0] = habitacion.getCodHabitacion();
			datos[1] = habitacion.getNombreHabitacion();
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab( habitacion.getCodHabitacion());
			//Mostrar detalles de las camas de la habitaci�n seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(habitacion.getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			datos[3] = tiposCamaHab;
			datos[4] =  (String.format("%.2f", habitacion.getPrecioHabitacion()) + "�");
			datos[5] =  (String.format("%.2f", modelo.hotel.getPrecioAlojamiento()) + "� / "+ controlador.funcionesReserva.calcularNochesReservadas() +" noches");
			tablaDetCasApart.addRow(datos);
		
		}
	
	
	/**
	  * M�todo: mostrarHoteles muestra los detalles del hotel seleccionado por el usuario en la pantalla PandetallesReserva
	  */
		public void mostrarDatosHotelesJTable() {
	    DefaultTableModel tablaHotel = (DefaultTableModel) vista.detallesReserva.tabHot.getModel();
				
		//llena la tabla con los datos del modelo.hotel (el hotel seleccionado)
		Object[] datos = new Object[4];
		
		tablaHotel.setRowCount(0);
			datos[0] = modelo.hotel.getNombre();
			datos[1] = modelo.hotel.getPrecioAlojamiento() +" � habitaci�n/noche";
			datos[2] = modelo.hotel.getEstrellas();
			datos[3] = modelo.hotel.getDireccion();
			tablaHotel.addRow(datos);
	}
    
	/**
	  * M�todo: actualizarPanDetallesReserva = se actualiza la informaci�n de la reserva en el siguiente panel: PanDetallesReserva 
	  * Aparece en PanDetallesReserva la informaic�n del hotel seleccionado, las habitaciones seleccionadas, el n�mero de noches de la reserva y el precio Total de la reserva 
	  * 
	  */
	public void actualizarPanDetallesReserva() {
			
		DefaultTableModel tablaHabs = (DefaultTableModel) vista.detallesReserva.tab.getModel();
			
		// Muestra los datos del Hotel seleccionado en un JTable
		mostrarDatosHotelesJTable();
			
		// Muestra los datos de la o las habitaciones seleccionadas en un JTable
		mostrarDetallesHabsSelec(tablaHabs);
			
	}
		
		
	/**
	 * M�todo: mostrarDetallesHabsSelec = muestra los detalles de las habitaciones seleccionadas, es decir, muestra el contenido del arrayList listaHabSeleccionadas
	 * 
	 * @param tabla Tabla que se rellena con la informacion de la reserva
	 */
	public void mostrarDetallesHabsSelec( DefaultTableModel tabla) {
		Object[] datos = new Object[6];
	
		tabla.setRowCount(0);
		
		for(int i=0; i<listaDormSeleccionados.size();i++) {
			datos[0] = listaDormSeleccionados.get(i).getCodHabitacion();
			datos[1] = listaDormSeleccionados.get(i).getNombreHabitacion();
			datos[2] = modelo.consultas.buscarNumCamasPorCodHab(listaDormSeleccionados.get(i).getCodHabitacion());
			//Mostrar detalles de las camas de la habitaci�n seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormSeleccionados.get(i).getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			datos[3] = tiposCamaHab;
			datos[4] =  (String.format("%.2f", listaDormSeleccionados.get(i).getPrecioHabitacion()) + "�");
			datos[5] =  (String.format("%.2f",modelo.listaReservas.get(i).getPrecioReserva()) + "� / "+ modelo.numNoches+" noches");
			tabla.addRow(datos);
		} 
	}
		
	/**
	 * M�todo: guardarReservasHab = Genera 1 o varias reservas y las guardar en en el ArrayList<Reserva> listaReservas
	 */
/*	public void guardarReservasHab() {
		
		listaReservas = new ArrayList<Reserva>(); 
			
		//creamos un arrayList listaHabSeleccionadas que va a contener las habitaciones seleccionadas
			
		int codReserva= modelo.consultas.mostrarNumReservas();
		
			for(int i=0; listaDormSeleccionados.size()>i; i++) {
			    	
				//metemos las reservas de las habitaciones seleccionadas en un arrayList listaReservas
			    modelo.reserva = new Reserva(); 
			    codReserva = codReserva + 1;
			    modelo.reserva.setCodReserva(codReserva);
			    modelo.reserva.setCliente(modelo.cliente);
			    modelo.reserva.setAlojamiento(modelo.hotel);
			    modelo.reserva.setHabitacion(this.listaDormSeleccionados.get(i));
			    modelo.reserva.setFechaIda(modelo.fechaIda);
			    modelo.reserva.setFechaVuelta(modelo.fechaVuelta);
			    modelo.reserva.setPrecioReserva(controlador.funcionesReserva.calcularPrecioHabXNoches(listaDormSeleccionados, i));
				listaReservas.add(modelo.reserva);
			 }
			    
			 //probamos que listaHabSeleccionadas se haya creado y rellenado correctamente:
			 for(int i=0; listaReservas.size()>i; i++) {
			   	System.out.println("------->La lista de reservaaaas: " +"C�digo reserva: " +listaReservas.get(i).getCodReserva() + "cod alojamiento reservado " + listaReservas.get(i).getAlojamiento().getCodAlojamiento() + "codigo habitacion reservada: "+ listaReservas.get(i).getHabitacion().getCodHabitacion() +"precio reserva 1 hab: "+ listaReservas.get(i).getPrecioReserva());
			 }
			
			 //guardamos el ArrayList listaReservas en el modelo
			 modelo.listaReservas = this.listaReservas;	
		}
*/	
	/**
	 * Acciones de los distintos componentes del panel
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atr�s":
	
				vista.buscarAlojamiento.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			
			
			case "Continuar":
				
			    //probamos que se haya seleccionado al menos una habitaci�n
				if(vista.selHabitacion.tab.getSelectedRowCount()!=0) {
					
				//PARA MULTIPLES HABITACIONES:	
				
					/*//(1�)Se guardan los detalles de la (o las habitaciones seleecionadas)
					guardarDormSeleccionadosJTable();
					guardar1DormSeleccionadosJTable();
					
					//(2�)Genera 1 o varias reservas y las guardar en en el ArrayList<Reserva> listaReservas
					guardarReservasHab();
					
					//(3�) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
					controlador.funcionesReserva.mostrarDatosReserva(listaDormSeleccionados);
					
					//(4�) se actualiza la informaci�n del siguiente panel: PanDetallesReserva con la info del hotel seleccionado, las habitaciones seleccionadas y el precio Total de la reserva
					actualizarPanDetallesReserva();
					
					//(5�) actualiza el siguiente panel: Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
					vista.selHabitacion.setVisible(false);
					vista.detallesReserva.setVisible(true);
			*/			
			
				//PARA 1 SOLA HABITACION
					//(1�)Se guardan los detalles de la (o las habitaciones seleecionadas)
				    	//mostrar los detalles de la hab seleccionada en JTable de panDetallesReserva
				    	mostrar1DormSeleccionadosJTable();
	
					//(2�)Genera 1 reserva y la guarda en modelo.reserva
					//pasar por par�metro el tiposAloj para diferenciar entre hotel, casa y apartamento �? no se si es lo mas correcto	
					controlador.funcionesReserva.guardarReservaAlojamiento(modelo.tiposAloj);
					
					//(3�) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
					
					controlador.funcionesReserva.mostrarDatosReservaAloj(modelo.tiposAloj);
					
					
					
					//(4�) se actualiza la informaci�n del siguiente panel: PanDetallesReserva con la info del hotel seleccionado, las habitaciones seleccionadas y el precio Total de la reserva
					controlador.controladorPanBuscarAlojamiento.actualizarPanDetallesReservaCasaAloj();
					
					//(5�) actualiza el siguiente panel: Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
					vista.selHabitacion.setVisible(false);
					vista.detallesReservaCasaApart.setVisible(true);
					
				
					
				}
				else {//si no ha seleccionado al menos una habitaci�n aparecer� un aviso
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione al menos una habitaci�n para continuar. Gracias. ", null, 0);
				}
				break;
			
			case "Inicio Sesi�n":
				ControladorLogin.panelOrigen = vista.selHabitacion;
				vista.login.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			
			case "Registro":
				ControladorRegistro.panelOrigen = vista.selHabitacion;
				vista.registro.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.selHabitacion.setVisible(false);
				controlador.funcionesBotones.reset();
				break;
			case "Cerrar Sesi�n":
				controlador.funcionesBotones.cerrarSesion();
				break;
		}	
	}
}