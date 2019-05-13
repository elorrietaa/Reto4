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
		vista.cupon.cBListaCupones.removeAllItems();
	/*	//No funciona así, me dice nullPointerException
		 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.alojamiento.getCodAlojamiento() + modelo.cliente.getDni());
		    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.alojamiento.getCodAlojamiento(), modelo.cliente.getDni());	
		 
				for(int i=0; i<listaCupones.size();i++) {
				    cuponAloj=listaCupones.get(i);
				    vista.cupon.cBListaCupones.addItem(cuponAloj);
				}
	*/	
		//para HOTELES
		if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI     " + modelo.hotel.getCodAlojamiento() + "-"+modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.hotel.getCodAlojamiento(), modelo.cliente.getDni());	
			    System.out.println("listaCupones.size() == " + listaCupones.size());
			    	
			    //Si no tiene cupones aparece un mensaje en el ComboBox
			    if(listaCupones.size() == 0) {
			    	vista.cupon.cBListaCupones.addItem("No tiene usted cupones aplicables a este alojamiento");
			    }
			 
			    //Si tiene cupones aplicables, aparece la lista de los cupones
			    else {
			   		for(int i=0; i<listaCupones.size();i++) {
				    cuponAloj=listaCupones.get(i);
				    vista.cupon.cBListaCupones.addItem(cuponAloj);
			   		}
			   	}
					
		}
		//PARA CASAS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.casa.getCodAlojamiento() + modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.casa.getCodAlojamiento(), modelo.cliente.getDni());	
			  
			    //Si no tiene cupones aparece un mensaje en el ComboBox
			    if(listaCupones.size() == 0) {
		    		vista.cupon.cBListaCupones.addItem("No tiene usted cupones aplicables a este alojamiento");
		    	}
		 
			    //Si tiene cupones aplicables, aparece la lista de los cupones
				for(int i=0; i<listaCupones.size();i++) {
				    cuponAloj=listaCupones.get(i);
					vista.cupon.cBListaCupones.addItem(cuponAloj);
				}
				
		}
		//PARA APARTAMENTOS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
			 System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.apartamento.getCodAlojamiento() + modelo.cliente.getDni());
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.apartamento.getCodAlojamiento(), modelo.cliente.getDni());	
			    
			    //Si no tiene cupones aparece un mensaje en el ComboBox
			    if(listaCupones.size() == 0) {
		    		vista.cupon.cBListaCupones.addItem("No tiene usted cupones aplicables a este alojamiento");
		    	}
			    
			    //Si tiene cupones aplicables, aparece la lista de los cupones
				for(int i=0; i<listaCupones.size();i++) {
				    cuponAloj=listaCupones.get(i);
				    vista.cupon.cBListaCupones.addItem(cuponAloj);
				}
		}
	   
	}
	
	/**
	 * Método comprobarSiTIeneCuponesDescuento 0 comprueba si tiene códigos disponibles, y devuelve un booleano
	 */
	public boolean comprobarSiTIeneCuponesDescuento() {
		vista.cupon.cBListaCupones.removeAllItems();
		boolean tieneCodigos = true;
		//para HOTELES
		if(modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.hotel.getCodAlojamiento(), modelo.cliente.getDni());	
			  	
			    if(listaCupones.size() == 0) {
			    	return false;
			    }
			 		
		}
		//PARA CASAS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.casa.getCodAlojamiento(), modelo.cliente.getDni());	
			  
			    if(listaCupones.size() == 0) {
		    		return false;
		    	}
		 
		}
		//PARA APARTAMENTOS:
		else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
			    ArrayList<CodigoPromocional> listaCupones = modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.apartamento.getCodAlojamiento(), modelo.cliente.getDni());	
			 
			    //Si no tiene cupones 
			    if(listaCupones.size() == 0) {
		    		return false;
		    	}
			 
		}
	 return tieneCodigos;
	}
	
	/**
	 * Método mostrarTodosCuponesDescuento = muestra los cupones descuento del usuario que ha iniciado sesión
	 */
	public void mostrarTodosCuponesDescuento() {
		 String textoTodoscupones ="";
		 
			    ArrayList<CodigoPromocional> listaTodosCupones = modelo.consultas.buscarCodigosPromocionalesSoloPorDni(modelo.cliente.getDni());	
			    System.out.println("listaCupones.size() == " + listaTodosCupones.size());
			    	if(listaTodosCupones.size() == 0) {
			    		 vista.cupon.textPTodosCupones.setText("No tiene usted cupones");
			    	}
			 
			    	else {//se leen todos los cupones
			    		for(int i=0; i<listaTodosCupones.size();i++) {
			    			textoTodoscupones  = textoTodoscupones + "Cupón: " + listaTodosCupones.get(i).getCod_promocional() + " - Descuento:" + (String.format("%.0f", (listaTodosCupones.get(i).getDescuento()*100))) + "%" + "\n" ;
					   
			    		}
			    		System.out.println(textoTodoscupones);
			    		//Se muestra en el panel de codigos promocionales todos los codigos que tiene el usuario
			    		 vista.cupon.textPTodosCupones.setText(textoTodoscupones);
			    	}
		
	}
	
	/**
	 * Método calcularPrecioDescuentoaplicado = se calcula el precio del alojamiento aplicando el descuento del cupón seleccionado por el usuario.
	 * @return
	 */
	public float calcularPrecioDescuentoaplicado() {
		
		float precioConDesc;
		//calculamos el precio de la reserva aplicando el descuento seleccionado por el usuario.
		if(modelo.precioTotalSinCupon == 0)
			precioConDesc = (modelo.precioTotal - (modelo.precioTotal*modelo.cuponSeleccionado.getDescuento()));
		else
			precioConDesc = (modelo.precioTotalSinCupon - (modelo.precioTotalSinCupon*modelo.cuponSeleccionado.getDescuento()));
		//Redondeamos a 2 decimales
		precioConDesc = Math.round(precioConDesc*100); //redondear a dos decimales
		precioConDesc = precioConDesc/100;//redondear a dos decimales
		
		return precioConDesc;
	}

}
