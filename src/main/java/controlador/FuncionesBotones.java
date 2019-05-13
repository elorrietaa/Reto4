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
	}
	
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
	}
	
	public void resetAtrasPago(ControladorPanPago pago) {
		
		pago.dinero = 0f;
		vista.pago.totalIntro.setText(Float.toString(pago.dinero) + " €");
		pago.falta = pago.total;
		vista.pago.aPagar.setText(Float.toString(pago.falta) + " €");
		
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
}
