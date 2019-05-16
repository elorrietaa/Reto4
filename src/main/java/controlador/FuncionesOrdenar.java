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
	
	/**
	 * Método ordenarListaHoteles = devuelve en el arrayList listaHotelesOrdenada, la lista de hoteles ordenada en función de los parámetros seleccionados por el usuario
	 * @param codCiudadSeleccionada
	 * @param codTipoAlojSeleccionado
	 * @return
	 */
	public ArrayList<Hotel> ordenarListaHoteles(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	   ArrayList<Hotel> listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	
	   //(1º) ordenar por POPULARIDAD DESC: ordena el arraylist de la lista de Hoteles en orden descendente
	   if(ordenarPor == "Popularidad") {
		    listaHotelesOrdenada = ordenarListaHotelesPopularidad(codCiudadSeleccionada, codTipoAlojSeleccionado,ordenarPor,  ascDesc);
	   }
	   if(ordenarPor == "Precio" || ordenarPor == "Estrellas") {
		    listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	   }
	   

	   for(int i=0; i<listaHotelesOrdenada.size();i++) {
			 
			     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR ***la opcion seleccionada por el usuario* " +listaHotelesOrdenada.get(i).getNombre() + " - "+ listaHotelesOrdenada.get(i).getPopularidad());
			  }
	 
	    return listaHotelesOrdenada;
	}
	
	/**
	 * Método ordenarListaHotelesPopularidad = ordena la lista de hoteles por popularidad ascendente o descendente en función de la seleción realizada por el usuario
	 * @param codCiudadSeleccionada
	 * @param codTipoAlojSeleccionado
	 * @param ascDesc
	 * @return
	 */
	public ArrayList<Hotel> ordenarListaHotelesPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado,String ordenarPor, String ascDesc) {
		   ArrayList<Hotel> listaHotelesOrdPopuDes = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		
		   //(1º) ordenar por POPULARIDAD DESC
		   if(ascDesc == "Descendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaHotelesOrdPopuDes.sort(Comparator.comparing(Hotel::getPopularidad).thenComparing(Hotel::getPopularidad));
			   
			   //ordena el arraylist de la lista de Hoteles en orden descendente:
			   Collections.reverse(listaHotelesOrdPopuDes);
		   }
		  
		   //(2º) ordenar por POPULARIDAD Ascendente
		   else if(ascDesc == "Ascendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaHotelesOrdPopuDes.sort(Comparator.comparing(Hotel::getPopularidad).thenComparing(Hotel::getPopularidad));
			   
		   }
		   
		   return listaHotelesOrdPopuDes;
		}
		
	/**
	 * Método resetearFiltrosServicios
	 */
	public void resetearFiltrosServicios() {
		
	}
	
	public int[] rellenarArrayFiltrosSeleccionados() {
		//se inicializa el array en 0, lo que significa que no hay ningún servicio seleccionado por el usuario
		int[]arrayFiltrosSelec = {0,0,0,0,0,0,0,0};
		
		//si el combobox está seleccionado, se cambia el 0 por 1	
		if(vista.buscarAlojamiento.chckbxWifiSel.isSelected()) {
			arrayFiltrosSelec[0]=1;
		}
		if(vista.buscarAlojamiento.chckbxAireSel.isSelected()) {
			arrayFiltrosSelec[1]=1;
		}
		if(vista.buscarAlojamiento.chckbxPiscinaSel.isSelected()) {
			arrayFiltrosSelec[2]=1;
		}
		if(vista.buscarAlojamiento.chckbxSpaSel.isSelected()) {
			arrayFiltrosSelec[3]=1;
		}
		if(vista.buscarAlojamiento.chckbxGimSel.isSelected()) {
			arrayFiltrosSelec[4]=1;
		}
		if(vista.buscarAlojamiento.chckbxParkingsel.isSelected()) {
			arrayFiltrosSelec[5]=1;
		}
		if(vista.buscarAlojamiento.chckbxRestSel.isSelected()) {
			arrayFiltrosSelec[6]=1;
		}
		if(vista.buscarAlojamiento.chckbxBarSel.isSelected()) {
			arrayFiltrosSelec[7]=1;
		}
		
		//prueba
		System.out.println("^*^*^*^*^* FILTROS SELECCIONADOS ^*^^*^*^*^*^*^*");
		for(int i=0; i<arrayFiltrosSelec.length; i++) {
			System.out.println(arrayFiltrosSelec[i]);
		}
		
		return arrayFiltrosSelec;
	}
	
}

