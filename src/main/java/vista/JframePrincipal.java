package vista;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JframePrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//atributos
	public JFrame frame;
	public PanBienvenida bienvenida;
	public PanBuscarAlojamiento buscarAlojamiento;
	public PanSelHabitacion selHabitacion;
	public PanDetallesReserva detallesReserva;
	public PanDetallesReservaCasaApart detallesReservaCasaApart;
	public PanPago pago;
	public PanVueltas vueltas;
	public PanLogin login;
	public PanRegistro registro;
	public PanBasesLegales bases;

	//constructor
	public JframePrincipal() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		
		inicializarPaneles();
		anadirPaneles();
	}

	private void inicializarPaneles() {
		bienvenida = new PanBienvenida();
		buscarAlojamiento = new PanBuscarAlojamiento();
		selHabitacion = new PanSelHabitacion();
		detallesReserva = new PanDetallesReserva();
		detallesReservaCasaApart = new PanDetallesReservaCasaApart();
		pago = new PanPago();
		vueltas = new PanVueltas();
		login = new PanLogin();
		registro = new PanRegistro();
		bases = new PanBasesLegales();
	}
	
	private void anadirPaneles() {
		getContentPane().add(bienvenida);
		getContentPane().add(buscarAlojamiento);
		getContentPane().add(selHabitacion);
		getContentPane().add(detallesReserva);
		getContentPane().add(detallesReservaCasaApart);
		getContentPane().add(pago); 
		getContentPane().add(vueltas);
		getContentPane().add(login);
		getContentPane().add(registro);
		getContentPane().add(bases);
	}
}