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
	public PanBuscarHotel buscarHotel;
	public PanSelHabitacion selHabitacion;
	public PanDetallesReserva detallesReserva;
	public PanDetallesReservaCasaApart detallesReservaCasaApart;
	public PanPago pago;
	public PanVueltas vueltas;
	public PanLogin login;
	public PanRegistro registro;

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
		//try {
		bienvenida = new PanBienvenida();
		buscarHotel = new PanBuscarHotel();
		selHabitacion = new PanSelHabitacion();
		//}
		/*catch(IOException e) {
			e.printStackTrace();
		}*/
		detallesReserva = new PanDetallesReserva();
		detallesReservaCasaApart = new PanDetallesReservaCasaApart();
		pago = new PanPago();
		vueltas = new PanVueltas();
		login = new PanLogin();
		registro = new PanRegistro();
	}
	
	private void anadirPaneles() {
		getContentPane().add(bienvenida);
		getContentPane().add(buscarHotel);
		getContentPane().add(selHabitacion);
		getContentPane().add(detallesReserva);
		getContentPane().add(detallesReservaCasaApart);
		getContentPane().add(pago); 
		getContentPane().add(vueltas);
		getContentPane().add(login);
		getContentPane().add(registro);
	}
}