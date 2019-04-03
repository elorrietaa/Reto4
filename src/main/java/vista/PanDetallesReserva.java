package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * Clase PanDetallesReserva = contiene los elementos necesarios para formar el Panel en el que se muestran los detalles de la reserva
 * @author alba
 *
 */
public class PanDetallesReserva extends JPanel {
	public JTextField tFReserva, tFHotel, textField_2;
	public JLabel lblSuReserva, lblNewLabel, lblNewLabel_1, lblPrecio;
	public JButton btnContinuar, btnAtras;
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
		
		lblNewLabel = new JLabel("C\u00F3digo Reserva");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(159, 149, 110, 14);
		add(lblNewLabel);
		
		tFReserva = new JTextField();
		tFReserva.setBounds(305, 148, 86, 20);
		add(tFReserva);
		tFReserva.setColumns(10);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo Hotel");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(159, 242, 110, 14);
		add(lblNewLabel_1);
		
		tFHotel = new JTextField();
		tFHotel.setBounds(305, 241, 86, 20);
		add(tFHotel);
		tFHotel.setColumns(10);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(673, 651, 89, 23);
		add(btnContinuar);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(41, 651, 89, 23);
		add(btnAtras);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(159, 330, 63, 14);
		add(lblPrecio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 329, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}
}
