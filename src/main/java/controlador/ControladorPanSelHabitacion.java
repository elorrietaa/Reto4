package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bbdd.Conexion;
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
		vista.selHabitacion.btnCancelar.addActionListener(this);
		vista.selHabitacion.btnInicioSesion.addActionListener(this);
		vista.selHabitacion.btnRegistro.addActionListener(this);
		vista.selHabitacion.btnAtras.addActionListener(this);
		vista.selHabitacion.btnContinuar.addActionListener(this);
	}
	
	/**
	 * Método: guardarDatosSeleccionadosJTable = se gudardan en el ArrayList listaHabSeleccionadas los datos de las habitaciones seleccionadas.
	 */
	public void guardarDatosSeleccionadosJTable() {
		   
		  //indHabsSel es un array que contiene el índice (la posición) de las habitaciones seleccionadas en el JTable
		    indHabsSel = vista.selHabitacion.tab.getSelectedRows();
		    
		    //la lista de dormitorios DISPONIBLES que semuestra al usuario para que seleccione
		  listaDormitorios = consultas.buscarHabitacionDisponiblel(modelo.fechaIda, modelo.fechaVuelta, modelo.hotel.getCodAlojamiento());
		  
		  //creamos un arrayList listaHabSeleccionadas que va a contener las habitaciones seleccionadas
		  listaDormSeleccionados = new ArrayList<Dormitorio>(); 
		    //hacemos un arrayList que contenga las habitaciones de los indices seleccionados:
		    for(int i=0; indHabsSel.length>i; i++) {
		    	System.out.println("------->índice de las habitaciones selec en el JTable: " + indHabsSel[i]);
		    	//prueba
		    	System.out.println("Código de las habitaciones seleecionadas: " + listaDormitorios.get(indHabsSel[i]).getCodHabitacion());
		    	
		    	//metemos las habitaciones seleccionadas en un arrayList listaHabSeleccionadas
		    	habitacion = new Dormitorio(); 
				habitacion.setCodHabitacion(listaDormitorios.get(indHabsSel[i]).getCodHabitacion());
				habitacion.setNombreHabitacion(listaDormitorios.get(indHabsSel[i]).getNombreHabitacion());
				//habitacion.setAlojamiento(hotel);
				habitacion.setTipoHabitacion(listaDormitorios.get(indHabsSel[i]).getTipoHabitacion());
				habitacion.setTamanio(listaDormitorios.get(indHabsSel[i]).getTamanio());
				habitacion.setNumCamas(listaDormitorios.get(indHabsSel[i]).getNumCamas());
				habitacion.setPrecioHabitacion(listaDormitorios.get(indHabsSel[i]).getPrecioHabitacion());
				listaDormSeleccionados.add(habitacion);
		    }
		    
		    //probamos que listaHabSeleccionadas se haya creado y rellenado correctamente:
		    for(int i=0; listaDormSeleccionados.size()>i; i++) {
		    	System.out.println("------->Habitaciones seleccionadas: " +listaDormSeleccionados.get(i).getCodHabitacion() );
		    }
		
		}
	
	
	
	/**
	  * Método: mostrarHoteles = muestra los detalles del hotel seleccionado por el usuario en la pantalla PandetallesReserva 
	  * @param codCiudadSeleccionada
	  */
	public void mostrarDatosHotelesJTable() {
	    DefaultTableModel tablaHotel = (DefaultTableModel) vista.detallesReserva.tabHot.getModel();
				
		//llena la tabla con los datos del modelo.hotel (el hotel seleccionado)
		Object[] datos = new Object[2];
		
		tablaHotel.setRowCount(0);
			datos[0] = modelo.hotel.getNombre();
			datos[1] = modelo.hotel.getEstrellas();
			
			tablaHotel.addRow(datos);
	}
    
	/**
	  * Método: actualizarPanDetallesReserva = se actualiza la información de la reserva en el siguiente panel: PanDetallesReserva 
	  * Aparece en PanDetallesReserva la informaicón del hotel seleccionado, las habitaciones seleccionadas, el número de noches de la reserva y el precio Total de la reserva 
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
	 * Método: mostrarDetallesHabsSelec = muestra los detalles de las habitaciones seleccionadas, es decir, muestra el contenido del arrayList listaHabSeleccionadas
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
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(listaDormSeleccionados.get(i).getCodHabitacion());
			String tiposCamaHab = controlador.funcionesReserva.mostrarTiposDeCamas(listaCamas);
			datos[3] = tiposCamaHab;
			datos[4] =  (String.format("%.2f", listaDormSeleccionados.get(i).getPrecioHabitacion()) + "€");
			datos[5] =  (String.format("%.2f",modelo.listaReservas.get(i).getPrecioReserva()) + "€ / "+ modelo.numNoches+" noches");
			tabla.addRow(datos);
		}
	}
		
	/**
	 * Método: guardarReservasHab = Genera 1 o varias reservas y las guardar en en el ArrayList<Reserva> listaReservas
	 */
	public void guardarReservasHab() {
		
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
			   	System.out.println("------->La lista de reservaaaas: " +"Código reserva: " +listaReservas.get(i).getCodReserva() + "cod alojamiento reservado " + listaReservas.get(i).getAlojamiento().getCodAlojamiento() + "codigo habitacion reservada: "+ listaReservas.get(i).getHabitacion().getCodHabitacion() +"precio reserva 1 hab: "+ listaReservas.get(i).getPrecioReserva());
			 }
			
			 //guardamos el ArrayList listaReservas en el modelo
			 modelo.listaReservas = this.listaReservas;	
		}
	
	/**
	 * Acciones de los distintos componentes del panel
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
	
				vista.buscarHotel.setVisible(true);
				vista.selHabitacion.setVisible(false);
				break;
			
			
			case "Continuar":
				
			    //probamos que se haya seleccionado al menos una habitación
				if(vista.selHabitacion.tab.getSelectedRowCount()!=0) {
				
					//(1º)Se guardan los detalles de la (o las habitaciones seleecionadas)
					guardarDatosSeleccionadosJTable();
					
					//(2º)Genera 1 o varias reservas y las guardar en en el ArrayList<Reserva> listaReservas
					guardarReservasHab();
					
					//(3º) se muestran en la siguiente pantalla los detalles de la reserva y el precio TOTAL de la reserva
					controlador.funcionesReserva.mostrarDatosReserva(listaDormSeleccionados);
					
					//(4º) se actualiza la información del siguiente panel: PanDetallesReserva con la info del hotel seleccionado, las habitaciones seleccionadas y el precio Total de la reserva
					actualizarPanDetallesReserva();
					
					//(5º) actualiza el siguiente panel: Desaparece Panel de Seleccionar habitacion  y aparece panel de detalles reserva
					vista.selHabitacion.setVisible(false);
					vista.detallesReserva.setVisible(true);
				}
				else {//si no ha seleccionado al menos una habitación aparecerá un aviso
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione al menos una habitación para continuar. Gracias. ", null, 0);
				}
				break;
			
			case "Inicio Sesión":
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
				controlador.funcionesRegistro.mostrarBotones();
				reset();
				break;
	
		}
		
	}
	/**
	 * Funciones del boton de clancelar
	 */
	public void reset() {
		modelo.cliente = null;
		modelo.cliente = null;
		modelo.alojamiento = null;
		modelo.apartamento = null;
		modelo.cama = null;
		modelo.casa = null;
		modelo.ciudad = null;
		modelo.reserva = null;
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
		vista.buscarHotel.cBCiudad.removeAllItems();
		vista.buscarHotel.cBTipoAloj.removeAllItems();
	}
	
}
