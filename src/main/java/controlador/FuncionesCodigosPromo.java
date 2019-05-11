package controlador;

import java.util.ArrayList;

import modelo.CodigoPromocional;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesCodigosPromo {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	
	private CodigoPromocional cuponAloj;
	
	public FuncionesCodigosPromo (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	/**
	 * Método mostrarCuponesDescuento = muestra los cupones descuento (en función del clienteintroducido y del alojamiento seleccionado en el ComboBox del panel pago
	 */
	public void mostrarCuponesDescuento() {
		vista.pago.cBListaCupones.removeAllItems();
	/*	//No funciona así, me dice nullPointerException
		 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.alojamiento.getCodAlojamiento() + modelo.cliente.getDni());
		    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.alojamiento.getCodAlojamiento(), modelo.cliente.getDni());	
		 
				for(int i=0; i<listaCupones.size();i++) {
				    cuponAloj=listaCupones.get(i);
				    vista.pago.cBListaCupones.addItem(cuponAloj);
				}
	*/	
		//para HOTELES
		if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI     " + modelo.hotel.getCodAlojamiento() + "-"+modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.hotel.getCodAlojamiento(), modelo.cliente.getDni());	
			    System.out.println("listaCupones.size() == " + listaCupones.size());
			    	if(listaCupones.size() == 0) {
			    		vista.pago.cBListaCupones.addItem("No tiene usted cupones");
			    	}
			 
			    	else {
			    		for(int i=0; i<listaCupones.size();i++) {
					    cuponAloj=listaCupones.get(i);
					    vista.pago.cBListaCupones.addItem(cuponAloj);
			    		}
			    	}
					
		}
		//PARA CASAS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.casa.getCodAlojamiento() + modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.casa.getCodAlojamiento(), modelo.cliente.getDni());	
			 
					for(int i=0; i<listaCupones.size();i++) {
					    cuponAloj=listaCupones.get(i);
					    vista.pago.cBListaCupones.addItem(cuponAloj);
					}
		}
		//PARA APARTAMENTOS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.apartamento.getCodAlojamiento() + modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.apartamento.getCodAlojamiento(), modelo.cliente.getDni());	
			 
					for(int i=0; i<listaCupones.size();i++) {
					    cuponAloj=listaCupones.get(i);
					    vista.pago.cBListaCupones.addItem(cuponAloj);
					}
		}
	   
	}

}
