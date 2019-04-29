package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PanBienvenida extends JPanel {
	public JButton btnContinuar;
	public JLabel lblTocaPantalla;
	
	public PanBienvenida() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnContinuar = new JButton("");
		btnContinuar.setIcon(new ImageIcon("C:\\workspace\\RETO4\\Reto4\\img\\ImagenPanBienvenida.png"));
		btnContinuar.setSelectedIcon(null);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorder(null);
		btnContinuar.setForeground(new Color(255, 51, 51));
		btnContinuar.setFont(new Font("Agency FB", Font.PLAIN, 24));
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBounds(0, 0, 1024, 720);
		btnContinuar.setOpaque(false);
		btnContinuar.setBorderPainted(false);
		add(btnContinuar);
		
		lblTocaPantalla = new JLabel("Toca la pantalla");
		lblTocaPantalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTocaPantalla.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTocaPantalla.setForeground(Color.BLACK);
		lblTocaPantalla.setBounds(362, 440, 300, 30);
		add(lblTocaPantalla);
	}
}