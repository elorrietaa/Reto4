package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
/**
 * Clase PanDetallesReserva = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles de la reserva
 * @author alba
 *
 */
public class PanDetallesReserva extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tFPrecioReserva;
	public JLabel lblSuReserva, lblDatosAlojamiento, lblPrecio;
	public JButton btnContinuar, btnAtras;
	public JList<String> listDetalleReserva;
	public JTextPane textPDatosAlo, textPaneDetHot;

	/**
	 * Create the panel.
	 */
	public PanDetallesReserva() {
		setBounds(0,0,1024,720);
		setLayout(null);
		
		lblSuReserva = new JLabel("Su Reserva :");
		lblSuReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSuReserva.setBounds(288, 32, 84, 14);
		add(lblSuReserva);
		
		lblDatosAlojamiento = new JLabel("Detalles Alojamiento:");
		lblDatosAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDatosAlojamiento.setBounds(165, 185, 130, 14);
		add(lblDatosAlojamiento);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(673, 651, 89, 23);
		add(btnContinuar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(41, 651, 89, 23);
		add(btnAtras);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(232, 330, 63, 14);
		add(lblPrecio);
		
		tFPrecioReserva = new JTextField();
		tFPrecioReserva.setEditable(false);
		tFPrecioReserva.setBounds(305, 329, 86, 20);
		add(tFPrecioReserva);
		tFPrecioReserva.setColumns(10);
		
		textPDatosAlo = new JTextPane();
		textPDatosAlo.setEditable(false);
		textPDatosAlo.setBounds(305, 185, 204, 76);
		add(textPDatosAlo);
		

	}
}
