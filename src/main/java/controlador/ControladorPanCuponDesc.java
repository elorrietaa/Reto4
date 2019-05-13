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
				 
				 //Si ha seleccionado algún código promocional
				 if(cuponAlojSeleccionado != null) {
					 //el precioTotalSinCupon será el que hasta ahora estaba calculado (modelo.precioTotal)
					 if(modelo.precioTotalSinCupon == 0)
					 	modelo.precioTotalSinCupon = this.modelo.precioTotal;
					 
					 //Y el precio total ahora será el precio aplicando el descuento del cupón:
					 modelo.precioTotal = controlador.funcionesCodigosPromo.calcularPrecioDescuentoaplicado();
					 System.out.println("PRECIOOO CON EL DESCUENTO APLICADOOO ES" + modelo.precioTotal );
				
					 vista.pago.total.setText(Float.toString(modelo.precioTotal) + " €");
					 vista.pago.aPagar.setText(Float.toString(modelo.precioTotal) + " €");
				 
				 }
				 if(modelo.basesAceptadas == true){//si ha aceptado las bases va a PanPersonasAlojadas
					
					
					vista.panPersonasAlojadas.setVisible(true);
					vista.cupon.setVisible(false);
				}
				else {// y sino a panBases
					vista.bases.setVisible(true);
					vista.cupon.setVisible(false);
				}
				
				 
				 //Se aplica el descuento al precio final
				
				break;
				
			case "No aplicar ningún descuento":
				//no habrá ningún cupón de descuento seleccionado:
				modelo.cuponSeleccionado =null;
				
				if(modelo.basesAceptadas == true){
					vista.panPersonasAlojadas.setVisible(true);
					vista.cupon.setVisible(false);
					modelo.precioTotal = modelo.precioTotalSinCupon;
				}
				else {
					vista.bases.setVisible(true);
					vista.cupon.setVisible(false);
					modelo.precioTotal = modelo.precioTotalSinCupon;
				}
				break;
				
			case "Atras":
					vista.detallesReservaCasaApart.setVisible(true);
					vista.cupon.setVisible(false);
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
					
						//se calcula el precio aplicando el descuento 
						float precioConDesc = controlador.funcionesCodigosPromo.calcularPrecioDescuentoaplicado();
						
					//IMPORTANTE!!! PARA EVITAR ERRORES!! se vuelve a calcular el precio total de la reserva  si el usuario retrocede hacia atrás
						//muestra el PRECIO TOTAL DE LA RESERVA: 
						controlador.funcionesReserva.calcularPrecioTotalFinalReserva(controlador.controladorPanBuscarHotel.tiposAloj);
						//se actualiza el precioFinal con descuento aplicado:
						vista.cupon.tFPrecioSinDesc.setText(Float.toString(modelo.precioTotal) + " €"); // Muesta el precio total sin aplicar el descuento
						vista.cupon.tFPrecioConDesc.setText(Float.toString(precioConDesc) + " €");
				}	
	}
	
	
}

	
	

