package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class ControladorPanDetallesReserva implements ActionListener {

	public JframePrincipal vista;
	public PrincipalModelo modelo;
	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 * @param conexion 
	 */
	public ControladorPanDetallesReserva(JframePrincipal vista, PrincipalModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.detallesReserva.btnAtras.addActionListener(this);
		vista.detallesReserva.btnContinuar.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
