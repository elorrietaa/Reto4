package controlador;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

/**
 * Clase PrincipalControlador:
 * Contiene las instancias de todas las clases del paquete controlador. 
 * @author alba
 *
 */
public class PrincipalControlador {
    public PrincipalModelo modelo;
    public JframePrincipal vista;
    
    private ControladorPanBuscarHotel controladorPanBuscarHotel;
    //private ControladorPanDetallesReserva controladorPanDetallesReserva;
    //private ControladorPanPago controladorPanPago;
    //private ControladorPanVueltas controladorPanVueltas;
    /**
     * Constructor del PrincipalControlador
     * @param modelo
     * @param vista
     */
    public PrincipalControlador(PrincipalModelo modelo, JframePrincipal vista) {
	this.modelo = modelo;
	this.vista = vista;
    }
    /**
	 * Esta funcion se encarga de inicializar la interfaz
	 */
    public void inicializarVista() {
    	vista.setVisible(true);
    	vista.buscarHotel.setVisible(true);
    	vista.detallesReserva.setVisible(false);
    	vista.pago.setVisible(false);
    	vista.vueltas.setVisible(false);
    }
    /**
	 * Esta funcion de encarga de inicializar los botones
	 */
    public void inicializarListeners() {
    	// añadimos listeners a los botones del panel 'controladorPanBuscarHotel'
    	this.controladorPanBuscarHotel = new ControladorPanBuscarHotel(vista, modelo);
    	this.controladorPanBuscarHotel.addListeners();
    	this.controladorPanBuscarHotel.mostrarCiudad();
    	
    	// añadimos listeners a los botones del panel 'controladorPanDetallesReserva'
    	// añadimos listeners a los botones del panel 'controladorPanPago'
    	// añadimos listeners a los botones del panel 'controladorPanVueltas'
    }
}
