package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.io.IOException;

public class JframePrincipal extends JFrame{

	public JFrame frame;
	public PanBuscarHotel buscarHotel;
	public PanDetallesReserva detallesReserva;
	public PanPago pago;
	public PanVueltas vueltas;

	public JframePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		
		inicializarPaneles();
		anadirPaneles();
	}

	private void inicializarPaneles() {
		//try {
		buscarHotel = new PanBuscarHotel();
		//}
		/*catch(IOException e) {
			e.printStackTrace();
		}*/
		detallesReserva = new PanDetallesReserva();
		pago = new PanPago();
		vueltas = new PanVueltas();
	}
	private void anadirPaneles() {
		getContentPane().add(buscarHotel);
		getContentPane().add(detallesReserva);
		getContentPane().add(pago);
		getContentPane().add(vueltas);
	}
}