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
    
    private ControladorPanBuscarHotel panelBuscarHotel;
    
    public PrincipalControlador(PrincipalModelo modelo, JframePrincipal vista) {
	this.modelo = modelo;
	this.vista = vista;
    }
    
    public void inicializarVista() {
    	vista.setVisible(true);
    	vista.buscarHotel.setVisible(true);
    	vista.detallesReserva.setVisible(false);
    	vista.pago.setVisible(false);
    	vista.vueltas.setVisible(false);
    }
    
}
