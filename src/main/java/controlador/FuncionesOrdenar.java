package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.Hotel;
import modelo.PrincipalModelo;
import vista.JframePrincipal;

public class FuncionesOrdenar {
	PrincipalModelo modelo;
	PrincipalControlador controlador;
	JframePrincipal vista;
	public float precioReserva;
	
	public FuncionesOrdenar (PrincipalModelo modelo,JframePrincipal vista, PrincipalControlador controlador) {
		this.modelo = modelo;
		this.controlador = controlador;
		this.vista = vista;
	} 
	
	public ArrayList<Hotel> ordernarAlojamientosPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado) {
	   ArrayList<Hotel> listaHotelesOrdPopuDes = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado);
	
	   //ordena el arraylist de la lista de Hoteles en orden ascendente
	   listaHotelesOrdPopuDes.sort(Comparator.comparing(Hotel::getPopularidad).thenComparing(Hotel::getPopularidad));
	   //ordena el arraylist de la lista de Hoteles en orden descendente:
	   Collections.reverse(listaHotelesOrdPopuDes);

	   for(int i=0; i<listaHotelesOrdPopuDes.size();i++) {
			 
			     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR POPULARIDAD " +listaHotelesOrdPopuDes.get(i).getNombre() + " - "+ listaHotelesOrdPopuDes.get(i).getPopularidad());
			  }
	 
	    return listaHotelesOrdPopuDes;
	}
}

