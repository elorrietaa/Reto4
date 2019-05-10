package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class PanPersonasAlojadas extends JPanel {

	private static final long serialVersionUID = 1L;
	public DefaultListModel<Object> modelo = new DefaultListModel<Object>();
	public JButton btnRegistro,btnContinuar,btnAtras,btnCancelar, btnInicioSesion;
	public JLabel lblIcono, lblTitulo, lblBtitulo;
	public JTable tabPersonasAloj;
	public JScrollPane scrollPaneIda;

	public PanPersonasAlojadas() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		// logo
		lblIcono = new JLabel("");
		lblIcono.setBounds(0, 0, 0, 0);
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		lblTitulo.setBounds(0, 0, 0, 0);
		FormatoDiseno.formatoIcono(lblTitulo);
		add(lblTitulo);		
		
		// label billete ida
		lblBtitulo = new JLabel("Introduzca los datos de las personas alojadas:");
		lblBtitulo.setBounds(45, 60, 505, 40);
		lblBtitulo.setFont(new Font("Dialog", Font.BOLD, 22));
		lblBtitulo.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblBtitulo);
		
		// TABLA HABITACIONES
		tabPersonasAloj = new JTable();
		Object[][] datos = {};
		String[] columnNames = {"Código","Habitación ", "Número de camas ", "Tipo de camas", "Precio 1 habitación 1 noche desde"};
		tabPersonasAloj.setModel(new DefaultTableModel(datos,columnNames) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, int.class, String.class, String.class, float.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		tabPersonasAloj.setDefaultRenderer(String.class, centerRenderer);
		tabPersonasAloj.setDefaultRenderer(int.class, centerRenderer);
		tabPersonasAloj.setDefaultRenderer(float.class, centerRenderer);
		tabPersonasAloj.setFillsViewportHeight(true);
		tabPersonasAloj.setBackground(Color.WHITE);
		tabPersonasAloj.setBounds(45, 300, 934, 100);
		tabPersonasAloj.setRowHeight(50);
		tabPersonasAloj.setFocusable(false);
		tabPersonasAloj.setRowSelectionAllowed(true);
		tabPersonasAloj.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabPersonasAloj.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabPersonasAloj.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabPersonasAloj.getColumnModel().getColumn(3).setPreferredWidth(180);
		tabPersonasAloj.getColumnModel().getColumn(4).setPreferredWidth(180);
		
		scrollPaneIda = new JScrollPane(tabPersonasAloj);
		scrollPaneIda.setBounds(45, 111, 935, 221);
		add(scrollPaneIda);
		//Object[][] datosVuelta = {};
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(0, 0, 0, 0);
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(0, 0, 0, 0);
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(0, 0, 0, 0);
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		btnInicioSesion = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesion.setBounds(869, 42, 105, 23);
		add(btnInicioSesion);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(869, 8, 105, 23);
		add(btnRegistro);
		
		JSpinner spinner2 = new JSpinner();
	}
}
