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
	PersonasAlojadas personasAlojadas;
	public ArrayList<PersonasAlojadas> listaPerAloj;
	
	 

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
		vista.panPersonasAlojadas.btnInicioSesion.addActionListener(this);
		vista.panPersonasAlojadas.btnRegistro.addActionListener(this);
		vista.panPersonasAlojadas.btnAtras.addActionListener(this);
		vista.panPersonasAlojadas.btnContinuar.addActionListener(this);
		vista.panPersonasAlojadas.btnAnadirPersona.addActionListener(this);
		vista.panPersonasAlojadas.btnBorrar.addActionListener(this);
	}
	
	/**
	 * Método validarDatosPersonasAloj = valida los datos introducidos por el usuario esten en un formato correcto
	 */
	public void validarDatosPersonasAloj() {
	  //Se rellenan las variables de los datos introducidos con los datos introducidos en los JTextField
	   
	}
	
	/**
	 * Método guardarPersonaAlojada = guarda los datos de la persona alojada introducidos por el usuario. 
	 * @return
	 */
	public PersonasAlojadas guardarPersonaAlojada() {
	    PersonasAlojadas personaAlojada = new PersonasAlojadas();
	    
	    //Se rellenan las variables de los datos introducidos con los datos introducidos en los JTextField
	    String dniIntroducido = vista.panPersonasAlojadas.textFieldDNI.getText();
	    String nombreIntroducido = vista.panPersonasAlojadas.textFieldNombre.getText();
	    String apellidosIntroducido = vista.panPersonasAlojadas.textFieldApellidos.getText();
	    
	    
	    //se introducen los datos introducidos por el usuario en el objeto personAlojada
	    personaAlojada.setDni(dniIntroducido);
	    personaAlojada.setNombre(nombreIntroducido); 
	    personaAlojada.setApellidos(apellidosIntroducido);
	    
	    //pruebas
	    System.out.println("Persona Alojada introducida: " + personaAlojada.getDni() + personaAlojada.getNombre() + personaAlojada.getApellidos());
	    
	    return personaAlojada;

	}
	
	public ArrayList<PersonasAlojadas> guardarListaPersonasAlojadas(PersonasAlojadas personasAlojada) {
	    ArrayList<PersonasAlojadas> listaPerAloj = new  ArrayList<PersonasAlojadas>();
	    
	    //metemos el objeto que llega por parámetro en el arrayList
	    listaPerAloj.add(personasAlojada);
	     
	    
	    return listaPerAloj;

	}
	
	
	/**
	 * Método mostrarListaPersonasAlojEnJTable = Se muestran los detalles de las las personas alojadas en el JTable del panel panPersonasAlojadas
	 */
	public void  mostrarListaPersonasAlojEnJTable(ArrayList<PersonasAlojadas> listaPerAloj) {

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
			    //validarDatosPersonasAloj();
			    
			    //se guardan los datos de la persona introducida por el usuario en el objeto PersonasAlojadas
			    personasAlojadas = guardarPersonaAlojada();
			    
			    //guarda las personas alojadas en la listaPersonasAlojadas
			    listaPerAloj =  guardarListaPersonasAlojadas(personasAlojadas);
			    
			    // muestra en el JTAble la lista con las personas alojadas introducidas por el usuario
			    mostrarListaPersonasAlojEnJTable(listaPerAloj);
			    
			    	break;
			    	
			case "Borrar":
			    
			    	break;  
			    	
			case "Continuar":
			    
			    vista.panPersonasAlojadas.setVisible(false);
			    vista.pago.setVisible(true);
				break;
				
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.selHabitacion.setVisible(false);
				controlador.funcionesBotones.reset();
				break;
		}	
	}
}