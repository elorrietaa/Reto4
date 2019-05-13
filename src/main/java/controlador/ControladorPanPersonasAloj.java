package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bbdd.Conexion;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.Consultas;
import modelo.PersonasAlojadas;
import modelo.PrincipalModelo;

import vista.JframePrincipal;


/**
 * Esta clase controla el panel de personas alojadas y se encarga de enlazar esa parte de la vista con el modelo
 * 
 */
public class ControladorPanPersonasAloj implements ActionListener {
	public PrincipalControlador controlador;
	public JframePrincipal vista;
	public PrincipalModelo modelo; 
	
	Consultas consultas;
	private Cliente personaAlojada;
	private ArrayList<Cliente> listaPerAloj = new ArrayList<Cliente>(); 
	private ArrayList<Cliente> listaPerAlojActualizada;
	private int numFilas;
	private int filaPersonaSelec = -1;
	 

	/** 
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 * @param consultas Instancia de consultas para poder utilizarlo
	 */
	public ControladorPanPersonasAloj(JframePrincipal vista, PrincipalModelo modelo,Conexion conexion, PrincipalControlador controlador ) {
		this.vista = vista;
		this.modelo = modelo;		
		this.consultas = new Consultas(conexion);
		this.controlador = controlador;
	} 
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.panPersonasAlojadas.btnCancelar.addActionListener(this);
		vista.panPersonasAlojadas.btnAtras.addActionListener(this);
		vista.panPersonasAlojadas.btnContinuar.addActionListener(this);
		vista.panPersonasAlojadas.btnAnadirPersona.addActionListener(this);
		vista.panPersonasAlojadas.btnBorrar.addActionListener(this);
	}
	
	/**
	 * Método validarDatosPersonasAloj = valida los datos introducidos por el usuario esten en un formato correcto
	 */
	public boolean validarDatosPersonasAloj() {
	  //Se rellenan las variables de los datos introducidos con los datos introducidos en los JTextField
		//Se rellenan las variables de los datos introducidos con los datos introducidos en los JTextField
	    String dniIntroducido = vista.panPersonasAlojadas.textFieldDNI.getText();
	    String nombreIntroducido = vista.panPersonasAlojadas.textFieldNombre.getText();
	    String apellidosIntroducido = vista.panPersonasAlojadas.textFieldApellidos.getText();
	    
		
	    boolean dniValidado=controlador.funcionesRegistro.validarDNI(dniIntroducido);
	    
	    //comprobamos que el dni no esté vacio
	    if(dniIntroducido.equals("")) {
	    	JOptionPane.showMessageDialog(vista, "Por favor, rellene el campo 'DNI'.Gracias.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
	    }
	    //comprobamos que el dni formato valido y exista
	    else if(!dniValidado) {
	    	JOptionPane.showMessageDialog(vista, "Lo sentimos, DNI introducido no está en un formato válido o no existe. Por favor, inténtelo de nuevo. Gracias. ", "Aviso", JOptionPane.WARNING_MESSAGE);
	    	return false;
	    }
	    //comprobamos que el nombre no esté vacio
	    if(nombreIntroducido.equals("")) {
	    	JOptionPane.showMessageDialog(vista, "Por favor, rellene el campo 'Nombre'.Gracias.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	    //comprobamos que el apellido no esté vacio
	    if(apellidosIntroducido.equals("")) {
	    	JOptionPane.showMessageDialog(vista, "Por favor, rellene el campo 'Apellidos'.Gracias.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	   
	    return true;
	}
	
	/**
	 * Método guardarPersonaAlojada = guarda los datos de la persona alojada introducidos por el usuario. 
	 * @return
	 */
	public Cliente guardarPersonaAlojada() {
	    Cliente personaAlojada = new Cliente();
	    
	    //Se rellenan las variables de los datos introducidos con los datos introducidos en los JTextField
	    String dniIntroducido = vista.panPersonasAlojadas.textFieldDNI.getText();
	    String nombreIntroducido = vista.panPersonasAlojadas.textFieldNombre.getText();
	    String apellidosIntroducido = vista.panPersonasAlojadas.textFieldApellidos.getText();
	    
	    //pruebas
	    System.out.println("1Persona Alojada introducida: " + dniIntroducido + nombreIntroducido + apellidosIntroducido);
	    
	    //se introducen los datos introducidos por el usuario en el objeto personAlojada
	    personaAlojada.setDni(dniIntroducido);
	    personaAlojada.setNombre(nombreIntroducido); 
	    personaAlojada.setApellidos(apellidosIntroducido);
	   
	    //otra forma:
	    // Cliente personaAlojada = new Cliente(dniIntroducido, nombreIntroducido, apellidosIntroducido );
	    
	    //pruebas
	    System.out.println("2Persona Alojada introducida: " + personaAlojada.getDni() + personaAlojada.getNombre() + personaAlojada.getApellidos());
	    
	    return personaAlojada;

	}
	
	/**
	 * Método guardarListaPersonasAlojadas = guarda la persona añadida por el usuario en la lista listaPersonasAlojadas
	 * @param personasAlojada
	 * @return
	 */
	public void guardarListaPersonasAlojadas(Cliente personasAlojada) {
	    //metemos el objeto que llega por parámetro en el arrayList
	    listaPerAloj.add(personasAlojada);
	}
	
	
	/**
	 * Método mostrarListaPersonasAlojEnJTable = Se muestran los detalles de las las personas alojadas en el JTable del panel panPersonasAlojadas
	 */
	public void  mostrarListaPersonasAlojEnJTable() {

		DefaultTableModel tablaPersonasAlojadas = (DefaultTableModel) vista.panPersonasAlojadas.tabPersonasAloj.getModel();
		 
		Object[] datos = new Object[3];
		
		tablaPersonasAlojadas.setRowCount(0);
		
		for(int i=0; i<listaPerAloj.size();i++) {
			datos[0] = listaPerAloj.get(i).getDni();
			datos[1] = listaPerAloj.get(i).getNombre();
			datos[2] = listaPerAloj.get(i).getApellidos();
			
			tablaPersonasAlojadas.addRow(datos);
		} 
	}
	
	/**
	 * Método mostrarIndicePersonaSeleccionada = muestra el índice deleccionado por el usuario en la tablaPersonasAlojadas
	 * @return
	 */
	public int mostrarIndicePersonaSeleccionada() {
	    //se guarda en filaDormSel la posición seleccionada en la tabla
	    int filaPersonaSelec = vista.panPersonasAlojadas.tabPersonasAloj.getSelectedRow();
		
	    return filaPersonaSelec;
	}
	
	/**
	 * Método borrarPersonaSeleccionada= recive el índice de la fila seleccionada por el usuario. Borra los datos que se encuentran en esa posición y devuelve la lista sin esa posición. 
	 * @return
	 */
	public ArrayList<Cliente> borrarPersonaSeleccionada(ArrayList<Cliente> listaPerAloj, int filaPersonaSelec) {
	    
	    listaPerAloj.remove(filaPersonaSelec);
	    
	    return listaPerAloj;
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
				if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
					vista.detallesReservaCasaApart.setVisible(true);
					vista.panPersonasAlojadas.setVisible(false);
			    }
			    else {
					vista.detallesReservaCasaApart.setVisible(true);
					vista.panPersonasAlojadas.setVisible(false);
			    }
				break;
				
			case "Añadir":
			    //Se valida que los datos intorducidos por el usuario sean correctos.
			    boolean anadirDatos = validarDatosPersonasAloj();
			    
			    if(anadirDatos) {
			    //se guardan los datos de la persona introducida por el usuario en el objeto PersonasAlojadas
			    	personaAlojada = guardarPersonaAlojada();
				    
				    //guarda las personas alojadas en la listaPersonasAlojadas
				    guardarListaPersonasAlojadas(personaAlojada);
				    
				    listaPerAlojActualizada = listaPerAloj;
				    
				    // muestra en el JTAble la lista con las personas alojadas introducidas por el usuario
				    mostrarListaPersonasAlojEnJTable();
			    }
			    
			    
			    	break;
			    	
			case "Borrar":
			    //se guarda la posición seleccionada en la tabla (la posición que se desea eliminar)
			    filaPersonaSelec = mostrarIndicePersonaSeleccionada();
			    
			    //se comprueba que se haya seleccionado alguna fila
			    if(filaPersonaSelec != -1) {
				//Se actualiza la listaPerAloj a listaPerAlojActualizada eliminando la fila seleccionada por el usuario
				listaPerAlojActualizada = borrarPersonaSeleccionada(listaPerAloj, filaPersonaSelec);
				    
				// muestra en el JTAble la listaPerAlojActualizada
				mostrarListaPersonasAlojEnJTable();
			    }
			    else
				JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila. Gracias. ", null, 0);
			    
			   
			    	break;  
			    	
			case "Continuar":
			    
				//si no se ha insertado ninguna persona alojada, muestra mensaje
				 if(listaPerAloj.size() == 0) {
				    	JOptionPane.showMessageDialog(vista, "Por favor, introduzca los datos de las personas alojadas. Gracias.", "Aviso", JOptionPane.WARNING_MESSAGE);
						
				    }
			    //Encriptar los datos
			    encriptarDatos();
			    //Se oculta este panel y se muestra el siguiente
			    vista.panPersonasAlojadas.setVisible(false);
			    vista.pago.setVisible(true);
				break;

			    
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.panPersonasAlojadas.setVisible(false);
				controlador.funcionesBotones.reset();
				break;
		}	
	}
	
	public void encriptarDatos() {
	    String dniEncriptado;
	    String nombreEncriptado;
	    String apellidosEncriptados;
	    
	    Cliente clienteEncriptado = new Cliente();
	    ArrayList<Cliente> listaPersonasEncriptada = new ArrayList<Cliente>();
	    
	    for (int i=0; i<listaPerAlojActualizada.size(); i++) {
			dniEncriptado = controlador.funcionesRegistro.encriptacion(listaPerAlojActualizada.get(i).getDni());
			nombreEncriptado = controlador.funcionesRegistro.encriptacion(listaPerAlojActualizada.get(i).getNombre());
			apellidosEncriptados = controlador.funcionesRegistro.encriptacion(listaPerAlojActualizada.get(i).getApellidos());
			
			clienteEncriptado.setDni(dniEncriptado);
			clienteEncriptado.setNombre(nombreEncriptado);
			clienteEncriptado.setApellidos(apellidosEncriptados);
			
			listaPersonasEncriptada.add(clienteEncriptado);
	    }
	    modelo.listaPersonasEncriptada = listaPersonasEncriptada;
	}
}