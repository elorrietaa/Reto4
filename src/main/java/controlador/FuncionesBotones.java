package controlador;

import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesBotones {
	
	PrincipalModelo modelo;
	JframePrincipal vista;
	PrincipalControlador controlador;
	
	public FuncionesBotones(PrincipalModelo modelo, JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	
	/**
	 * Método reset = en este método se resetean los valores a null o " ".
	 */
	public void reset() {
		modelo.cliente = null;
		modelo.alojamiento = null;
		modelo.apartamento = null;
		modelo.cama = null;
		modelo.casa = null;
		modelo.ciudad = null;
		modelo.reserva = null;
		modelo.precioTotal = 0;
		modelo.precioTotalSinCupon = 0;
		modelo.basesAceptadas = false;
		
		ControladorLogin.detalles = false;
		ControladorRegistro.detalles = false;
		
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
		
		vista.buscarAlojamiento.cBCiudad.removeAllItems();
		vista.buscarAlojamiento.cBTipoAloj.removeAllItems();
		
		controlador.funcionesRegistro.mostrarBotones();
		
		vista.cupon.tFPrecioSinDesc.setText(""); 
		vista.cupon.tFPrecioConDesc.setText("");
		
		vista.panPersonasAlojadas.modeloTabla.setRowCount(0);
		
		vista.panPersonasAlojadas.textFieldApellidos.setText("");
		vista.panPersonasAlojadas.textFieldDNI.setText("");
		vista.panPersonasAlojadas.textFieldNombre.setText("");
		
		controlador.funcionesOrdenar.resetearFiltrosServicios();
		
		resetServicios();
	}
	
	/**
	 * Método resetPago = en este método se resetean los valores del pago
	 * @param pago
	 */
	public void resetPago(ControladorPanPago pago) {
		modelo.cliente = null;
		modelo.alojamiento = null;
		modelo.apartamento = null;
		modelo.cama = null;
		modelo.casa = null;
		modelo.ciudad = null;
		modelo.reserva = null;
		modelo.precioTotal = 0;
		modelo.precioTotalSinCupon = 0;
		modelo.basesAceptadas = false;
		
		ControladorLogin.detalles = false;
		ControladorRegistro.detalles = false;
		
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
		
		vista.pago.totalIntro.setText("0 \u20AC");
		vista.pago.aPagar.setText("0 \u20AC");
		pago.monedas = new float[0];
		pago.dinero = 0f;
		
		vista.pago.btn1cen.setEnabled(true); // Habilita todo los botones de dinero
		vista.pago.btn2cen.setEnabled(true);
		vista.pago.btn5cen.setEnabled(true);
		vista.pago.btn10cen.setEnabled(true);
		vista.pago.btn20cen.setEnabled(true);
		vista.pago.btn50cen.setEnabled(true);
		vista.pago.btn1.setEnabled(true);
		vista.pago.btn2.setEnabled(true);
		vista.pago.btn5.setEnabled(true);
		vista.pago.btn10.setEnabled(true);
		vista.pago.btn20.setEnabled(true);
		vista.pago.btn50.setEnabled(true);
		vista.pago.btn100.setEnabled(true);
		vista.pago.btn200.setEnabled(true);
		
		vista.pago.btnContinuar.setVisible(false);
		vista.pago.btnContinuar.setEnabled(false);
		
		controlador.funcionesRegistro.mostrarBotones();
		
		vista.panPersonasAlojadas.modeloTabla.setRowCount(0);
		
		vista.panPersonasAlojadas.textFieldApellidos.setText("");
		vista.panPersonasAlojadas.textFieldDNI.setText("");
		vista.panPersonasAlojadas.textFieldNombre.setText("");
		
		controlador.funcionesOrdenar.resetearFiltrosServicios();
		
		resetServicios();
	}
	
	/**
	 * Método resetAtrasPago = se utiliza este método para resetear los valores de pago cuando el usuario pulse el boton atrás en el panel de pago.
	 * @param pago
	 */
	public void resetAtrasPago(ControladorPanPago pago) {	
		pago.dinero = 0f;
		vista.pago.totalIntro.setText(Float.toString(pago.dinero) + " €");
		pago.falta = pago.total;
		vista.pago.aPagar.setText(Float.toString(modelo.precioTotal) + " €");
		
		this.vista.pago.btn1cen.setEnabled(true); // Vuelve a habilitar los botones con el dinero
		this.vista.pago.btn2cen.setEnabled(true);
		this.vista.pago.btn5cen.setEnabled(true);
		this.vista.pago.btn10cen.setEnabled(true);
		this.vista.pago.btn20cen.setEnabled(true);
		this.vista.pago.btn50cen.setEnabled(true);
		this.vista.pago.btn1.setEnabled(true);
		this.vista.pago.btn2.setEnabled(true);
		this.vista.pago.btn5.setEnabled(true);
		this.vista.pago.btn10.setEnabled(true);
		this.vista.pago.btn20.setEnabled(true);
		this.vista.pago.btn50.setEnabled(true);
		this.vista.pago.btn100.setEnabled(true);
		this.vista.pago.btn200.setEnabled(true);
		
		this.vista.pago.btnContinuar.setVisible(false); // Desabilita el boton de continuar y lo hace invisible
		this.vista.pago.btnContinuar.setEnabled(false);
	}
	
	/**
	 * Método cerrarSesion = se resetean los valores necesarios para cuando el usuario pulsa cerrar sesión.
	 */
	public void cerrarSesion() {
		controlador.funcionesRegistro.mostrarBotones();
		modelo.cliente = null;
		ControladorLogin.detalles = false;
		ControladorRegistro.detalles = false;
		
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
	}
	
	/**
	 * Método resetServicios = se resetean los servicios en el panel d ebuscar alojamiento.
	 */
	public void resetServicios() {
		modelo.servicios = null;
		
		vista.buscarAlojamiento.panelServicios.setVisible(false);
		vista.buscarAlojamiento.btnServicios.setVisible(true);
		vista.buscarAlojamiento.btnServicios.setEnabled(true);
		vista.buscarAlojamiento.btnActualizar.setVisible(false);
		vista.buscarAlojamiento.btnActualizar.setEnabled(false);
		
		vista.buscarAlojamiento.checkWifi.setSelected(false);
		vista.buscarAlojamiento.checkAire.setSelected(false);
		vista.buscarAlojamiento.checkGimnasio.setSelected(false);
		vista.buscarAlojamiento.checkParking.setSelected(false);
		vista.buscarAlojamiento.checkPiscina.setSelected(false);
		vista.buscarAlojamiento.checkSpa.setSelected(false);
		
		vista.buscarAlojamiento.labelServicios.setVisible(false);
	}
}
