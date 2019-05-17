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
	 * M�todo ordenarListaHoteles = devuelve en el arrayList listaHotelesOrdenada, la lista de hoteles ordenada en funci�n de los par�metros seleccionados por el usuario
	 * @param codCiudadSeleccionada
	 * @param codTipoAlojSeleccionado
	 * @return
	 */
	public ArrayList<Hotel> ordenarListaHoteles(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	   ArrayList<Hotel> listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	
	   //(1�) ordenar por POPULARIDAD DESC: ordena el arraylist de la lista de Hoteles en orden descendente
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
	 * M�todo ordenarListaHotelesPopularidad = ordena la lista de hoteles por popularidad ascendente o descendente en funci�n de la seleci�n realizada por el usuario
	 * @param codCiudadSeleccionada
	 * @param codTipoAlojSeleccionado
	 * @param ascDesc
	 * @return
	 */
	public ArrayList<Hotel> ordenarListaHotelesPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado,String ordenarPor, String ascDesc) {
		   ArrayList<Hotel> listaHotelesOrdPopuDes = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		
		   //(1�) ordenar por POPULARIDAD DESC
		   if(ascDesc == "Descendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaHotelesOrdPopuDes.sort(Comparator.comparing(Hotel::getPopularidad).thenComparing(Hotel::getPopularidad));
			   
			   //ordena el arraylist de la lista de Hoteles en orden descendente:
			   Collections.reverse(listaHotelesOrdPopuDes);
		   }
		  
		   //(2�) ordenar por POPULARIDAD Ascendente
		   else if(ascDesc == "Ascendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaHotelesOrdPopuDes.sort(Comparator.comparing(Hotel::getPopularidad).thenComparing(Hotel::getPopularidad));
			   
		   }
		   
		   return listaHotelesOrdPopuDes;
		}
		
	/**
	 * M�todo resetearFiltrosServicios
	 */
	public void resetearFiltrosServicios() {
		
	}
	
	/**
	 * M�todo rellenarArrayFiltrosSeleccionados = devuelve un Strin en el que aparecen los filtros seleccionados
	 * @return
	 */
	public String rellenarArrayFiltrosSeleccionados() {
		String serviciosSelec = "";
		
		//si el combobox est� seleccionado, se cambia el 0 por 1	
		if(vista.buscarAlojamiento.chckbxWifiSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Wifi = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxAireSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Aire = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxPiscinaSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Piscina = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxSpaSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Spa = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxGimSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Gimnasio = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxParkingsel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Parking = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxRestSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Restaurante = 1 ";
		}
		if(vista.buscarAlojamiento.chckbxBarSel.isSelected()) {
		    serviciosSelec = serviciosSelec + "and Bar = 1 ";
		}
		
		//prueba
		System.out.println("^*^*^*^*^* FILTROS SELECCIONADOS ^*^^*^*^*^*^*^*");
		
		return serviciosSelec;
	}
	
	/**
	 * M�todo crearQuerisAplicarFiltros = se crean las querys para las busquedas de alojamiento aplicando los filtros seleccionados por el usuario
	 * @return 
	 * @return
	 */
	public ArrayList<Hotel> crearQuerisAplicarFiltros(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	    String query = "";
	    String serviciosSelec = rellenarArrayFiltrosSeleccionados();
	    
	    if(ordenarPor == "Precio" && ascDesc == "Ascendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento asc";
		}
		else if(ordenarPor == "Precio" && ascDesc == "Descendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento desc";
		}
		else if(ordenarPor == "Estrellas" && ascDesc == "Ascendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by N_estrellas asc";
		}
		else if(ordenarPor == "Estrellas" && ascDesc == "Descendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by N_estrellas desc";
		}
		else {
			query = "SELECT * FROM `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec;

		}
	    return modelo.consultas.buscarHotelPorCodCiudad2(codCiudadSeleccionada, codTipoAlojSeleccionado, query);
	}
	
}

