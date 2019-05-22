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

    public FuncionesCodigosPromo(PrincipalModelo modelo, JframePrincipal vista, PrincipalControlador controlador) {
	this.modelo = modelo;
	this.controlador = controlador;
	this.vista = vista;
    }

    /**
     * Método mostrarCuponesDescuento = muestra los cupones descuento (en función
     * del clienteintroducido y del alojamiento seleccionado en el ComboBox del
     * panel pago
     */
    public void mostrarCuponesDescuento() {
	vista.cupon.cBListaCupones.removeAllItems();
	/*
	 * //No funciona así, me dice nullPointerException
	 * System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" +
	 * modelo.alojamiento.getCodAlojamiento() + modelo.cliente.getDni());
	 * ArrayList<CodigoPromocional> listaCupones =
	 * modelo.consultas.buscarCodigosPromocionalesPorDni(modelo.alojamiento.
	 * getCodAlojamiento(), modelo.cliente.getDni());
	 * 
	 * for(int i=0; i<listaCupones.size();i++) { cuponAloj=listaCupones.get(i);
	 * vista.cupon.cBListaCupones.addItem(cuponAloj); }
	 */
	// para HOTELES
	if (modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
	    System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI     " + modelo.hotel.getCodAlojamiento() + "-"
		    + modelo.cliente.getDni());
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.hotel.getCodAlojamiento(), modelo.cliente.getDni());
	    System.out.println("listaCupones.size() == " + listaCupones.size());

	    // Si no tiene cupones aparece un mensaje en el ComboBox
	    if (listaCupones.size() == 0) {
		vista.cupon.lblNoCupones.setVisible(true);
		vista.cupon.cBListaCupones.setVisible(false);
		vista.cupon.cBListaCupones.setEnabled(false);
		vista.cupon.lblPrecioConDesc.setVisible(false);
		vista.cupon.lblPrecioSinDesc.setVisible(false);
		vista.cupon.tFPrecioConDesc.setVisible(false);
		vista.cupon.tFPrecioSinDesc.setVisible(false);
		vista.cupon.btnAplicar.setEnabled(false);
	    }

	    // Si tiene cupones aplicables, aparece la lista de los cupones
	    else {
		for (int i = 0; i < listaCupones.size(); i++) {
		    cuponAloj = listaCupones.get(i);
		    vista.cupon.cBListaCupones.addItem(cuponAloj);

		    vista.cupon.lblNoCupones.setVisible(false);
		    vista.cupon.cBListaCupones.setVisible(true);
		    vista.cupon.cBListaCupones.setEnabled(true);
		    vista.cupon.lblPrecioConDesc.setVisible(true);
		    vista.cupon.lblPrecioSinDesc.setVisible(true);
		    vista.cupon.tFPrecioConDesc.setVisible(true);
		    vista.cupon.tFPrecioSinDesc.setVisible(true);
		    vista.cupon.btnAplicar.setEnabled(true);
		}
	    }

	}
	// PARA CASAS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {
	    System.out.println(
		    "PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.casa.getCodAlojamiento() + modelo.cliente.getDni());
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.casa.getCodAlojamiento(), modelo.cliente.getDni());

	    // Si no tiene cupones aparece un mensaje en el ComboBox
	    if (listaCupones.size() == 0) {
		vista.cupon.lblNoCupones.setVisible(true);
		vista.cupon.cBListaCupones.setVisible(false);
		vista.cupon.cBListaCupones.setEnabled(false);
		vista.cupon.lblPrecioConDesc.setVisible(false);
		vista.cupon.lblPrecioSinDesc.setVisible(false);
		vista.cupon.tFPrecioConDesc.setVisible(false);
		vista.cupon.tFPrecioSinDesc.setVisible(false);
		vista.cupon.btnAplicar.setEnabled(false);
	    }

	    // Si tiene cupones aplicables, aparece la lista de los cupones
	    for (int i = 0; i < listaCupones.size(); i++) {
		cuponAloj = listaCupones.get(i);
		vista.cupon.cBListaCupones.addItem(cuponAloj);

		vista.cupon.lblNoCupones.setVisible(false);
		vista.cupon.cBListaCupones.setVisible(true);
		vista.cupon.cBListaCupones.setEnabled(true);
		vista.cupon.lblPrecioConDesc.setVisible(true);
		vista.cupon.lblPrecioSinDesc.setVisible(true);
		vista.cupon.tFPrecioConDesc.setVisible(true);
		vista.cupon.tFPrecioSinDesc.setVisible(true);
		vista.cupon.btnAplicar.setEnabled(true);
	    }

	}
	// PARA APARTAMENTOS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
	    System.out.println("PROBANDO QUE PASE COD ALOJ Y DNI" + modelo.apartamento.getCodAlojamiento()
		    + modelo.cliente.getDni());
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.apartamento.getCodAlojamiento(), modelo.cliente.getDni());

	    // Si no tiene cupones aparece un mensaje en el ComboBox
	    if (listaCupones.size() == 0) {
		vista.cupon.lblNoCupones.setVisible(true);
		vista.cupon.cBListaCupones.setVisible(false);
		vista.cupon.cBListaCupones.setEnabled(false);
		vista.cupon.lblPrecioConDesc.setVisible(false);
		vista.cupon.lblPrecioSinDesc.setVisible(false);
		vista.cupon.tFPrecioConDesc.setVisible(false);
		vista.cupon.tFPrecioSinDesc.setVisible(false);
		vista.cupon.btnAplicar.setEnabled(false);
	    }

	    // Si tiene cupones aplicables, aparece la lista de los cupones
	    for (int i = 0; i < listaCupones.size(); i++) {
		cuponAloj = listaCupones.get(i);
		vista.cupon.cBListaCupones.addItem(cuponAloj);

		vista.cupon.lblNoCupones.setVisible(false);
		vista.cupon.cBListaCupones.setVisible(true);
		vista.cupon.cBListaCupones.setEnabled(true);
		vista.cupon.lblPrecioConDesc.setVisible(true);
		vista.cupon.lblPrecioSinDesc.setVisible(true);
		vista.cupon.tFPrecioConDesc.setVisible(true);
		vista.cupon.tFPrecioSinDesc.setVisible(true);
		vista.cupon.btnAplicar.setEnabled(true);
	    }
	}

    }

    /**
     * Método comprobarSiTIeneCuponesDescuento 0 comprueba si tiene códigos
     * disponibles, y devuelve un booleano
     * 
     * @return Retorna true o false si tiene codigos o no respectibamente
     */
    public boolean comprobarSiTIeneCuponesDescuento() {
	vista.cupon.cBListaCupones.removeAllItems();
	boolean tieneCodigos = true;
	// para HOTELES
	if (modelo.tiposAloj.getCodTipoAlojamiento() == 10) {
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.hotel.getCodAlojamiento(), modelo.cliente.getDni());

	    if (listaCupones.size() == 0) {
		return false;
	    }

	}
	// PARA CASAS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.casa.getCodAlojamiento(), modelo.cliente.getDni());

	    if (listaCupones.size() == 0) {
		return false;
	    }

	}
	// PARA APARTAMENTOS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {
	    ArrayList<CodigoPromocional> listaCupones = modelo.consultas
		    .buscarCodigosPromocionalesPorDni(modelo.apartamento.getCodAlojamiento(), modelo.cliente.getDni());

	    // Si no tiene cupones
	    if (listaCupones.size() == 0) {
		return false;
	    }

	}
	return tieneCodigos;
    }

    /**
     * Método mostrarTodosCuponesDescuento = muestra los cupones descuento del
     * usuario que ha iniciado sesión
     */
    public void mostrarTodosCuponesDescuento() {
	String textoTodoscupones = "";

	ArrayList<CodigoPromocional> listaTodosCupones = modelo.consultas
		.buscarCodigosPromocionalesSoloPorDni(modelo.cliente.getDni());
	System.out.println("listaCupones.size() == " + listaTodosCupones.size());
	if (listaTodosCupones.size() == 0) {
	    vista.cupon.textPTodosCupones.setText("No tiene usted cupones");
	}

	else {// se leen todos los cupones
	    for (int i = 0; i < listaTodosCupones.size(); i++) {
		textoTodoscupones = textoTodoscupones + "Cupón: " + listaTodosCupones.get(i).getCod_promocional()
			+ " - Descuento:" + (String.format("%.0f", (listaTodosCupones.get(i).getDescuento() * 100)))
			+ "%" + "\n";

	    }
	    System.out.println(textoTodoscupones);
	    // Se muestra en el panel de codigos promocionales todos los codigos que tiene
	    // el usuario
	    vista.cupon.textPTodosCupones.setText(textoTodoscupones);
	}

    }

    /**
     * Método calcularPrecioDescuentoaplicado = se calcula el precio del alojamiento
     * aplicando el descuento del cupón seleccionado por el usuario.
     * 
     * @return Retorna el precio de la reserva con el descuento aplicado
     */
    public float calcularPrecioDescuentoaplicado() {

	float precioConDesc;
	// calculamos el precio de la reserva aplicando el descuento seleccionado por el
	// usuario.
	if (modelo.precioTotalSinCupon == 0)
	    precioConDesc = (modelo.precioTotal - (modelo.precioTotal * modelo.cuponSeleccionado.getDescuento()));
	else
	    precioConDesc = (modelo.precioTotalSinCupon
		    - (modelo.precioTotalSinCupon * modelo.cuponSeleccionado.getDescuento()));
	// Redondeamos a 2 decimales
	precioConDesc = Math.round(precioConDesc * 100); // redondear a dos decimales
	precioConDesc = precioConDesc / 100;// redondear a dos decimales

	return precioConDesc;
    }

    public void eliminarCodigosPromocionales() {
	// para HOTELES
	if (modelo.tiposAloj.getCodTipoAlojamiento() == 10) {

	    // Si ha utilizado un cupón lo elimina de la bbdd
	    modelo.consultas.eliminarCodigoPromocionalAplicado(modelo.cuponSeleccionado.getCod_promocional());

	}
	// PARA CASAS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 20) {

	    // Si ha utilizado un cupón lo elimina de la bbdd
	    modelo.consultas.eliminarCodigoPromocionalAplicado(modelo.cuponSeleccionado.getCod_promocional());

	}
	// PARA APARTAMENTOS:
	else if (modelo.tiposAloj.getCodTipoAlojamiento() == 30) {

	    // Si ha utilizado un cupón lo elimina de la bbdd
	    modelo.consultas.eliminarCodigoPromocionalAplicado(modelo.cuponSeleccionado.getCod_promocional());

	}
    }
}
