package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Ciudad;
import modelo.CodigoPromocional;
import modelo.PrincipalModelo;
import modelo.TipoAlojamiento;
import vista.JframePrincipal;

public class ControladorPanCuponDesc implements ActionListener{
	
	private JframePrincipal vista;
	private PrincipalModelo modelo;
	private PrincipalControlador controlador;
	
	private CodigoPromocional cuponAloj;
	
	public ControladorPanCuponDesc(JframePrincipal vista, PrincipalModelo modelo, PrincipalControlador controlador) {
		this.vista = vista;
		this.modelo = modelo;
		this.controlador = controlador;
	}
	
	public void addListeners() {
		this.vista.cupon.btnAplicar.addActionListener(this);
		this.vista.cupon.btnAtras.addActionListener(this);
		this.vista.cupon.btnNOAplicar.addActionListener(this);
		
		this.vista.cupon.cBListaCupones.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object sourceObject = e.getSource();
		
    	if (sourceObject instanceof JButton) {
    		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand(); // Almacena el texto del boton para poder identificarlo posteriormente
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Aplicar y continuar":
				// (1º) guarda el cógido promocional seleccionado
				 CodigoPromocional cuponAlojSeleccionado = (CodigoPromocional) vista.cupon.cBListaCupones.getSelectedItem();
				 
				 //Si ha seleccionado algún código promocional, se guarda el descuento que se va a aplicar
				 if(cuponAlojSeleccionado != null) {
					 float descuentoAAplicar = cuponAlojSeleccionado.getDescuento();
					 System.out.println("El descuento que se va a aplicar es: " + descuentoAAplicar);
				 }
				 else {
					 JOptionPane.showMessageDialog(vista, "Por favor, seleccione el descuento que desee aplicar. Gracias. ", null, 0);
				 }
				 
				 //Se aplica el descuento al precio final
				
				break;
				
			case "No deseo aplicar nungún descuento":
				if(modelo.basesAceptadas == true){
					vista.panPersonasAlojadas.setVisible(true);
					vista.cupon.setVisible(false);
				}
				else {
					vista.bases.setVisible(true);
					vista.cupon.setVisible(false);
				}
				break;
				
			case "Atras":
					vista.detallesReservaCasaApart.setVisible(true);
					vista.cupon.setVisible(false);
					//reset??
				
				break;
			}
			//JCOMBOBOX DE CIUDAD Y TIPO ALOJAMIENTO
		} else if (sourceObject instanceof JComboBox) {
			
			actualizarJComboBox(); //se actualiza el JTable del PanBuscarHotel con los datos seleccionados por el usuario
			
		}
	}


	/**
	* Método actualizarFiltradoJComboBox = 
	*/
	private void actualizarJComboBox() {
		// (1º) guarda la ciudad seleccionada
			this.cuponAloj = (CodigoPromocional) vista.cupon.cBListaCupones.getSelectedItem();
					if (cuponAloj != null) {
						float descuentoSelec = cuponAloj.getDescuento();
						System.out.println("EL descuento seleccionado es: " + descuentoSelec);
						//se pasa el descuentoSeleccionado  al modelo
						modelo.cuponSeleccionado = this.cuponAloj;		
						System.out.println("EL descuento seleccionado es: " + modelo.cuponSeleccionado.getCod_promocional() + " del alojamiento " + modelo.cuponSeleccionado.getCod_alojamiento());
					
						//se actualiza el precioFinal con descuento aplicado:
					
					}
			
					
	}
}
