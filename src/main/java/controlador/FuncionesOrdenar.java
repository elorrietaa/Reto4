package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.Apartamento;
import modelo.Casa;
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
	 * Método rellenarArrayFiltrosSeleccionados = devuelve un Strin en el que aparecen los filtros seleccionados
	 * @return serviciosSelec = devuelve un String que contiene una cadena de caracteres con los servicios seleccionados
	 */
	public String rellenarArrayFiltrosSeleccionados() {
		String serviciosSelec = "";
		
		//si el combobox está seleccionado, se cambia el 0 por 1	
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
	
//HOTELES
	/**
	 * Método ordenarListaHoteles = devuelve en el arrayList listaHotelesOrdenada, la lista de hoteles ordenada en función de los parámetros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @return listaHotelesOrdenada = devuelve la lista de hoteles ordenados en función de los parámetros que se le han pasado
	 */
	public ArrayList<Hotel> ordenarListaHoteles(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	   ArrayList<Hotel> listaHotelesOrdenada = crearQuerisFiltrosHoteles(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	
	   //(1º) ordenar por POPULARIDAD DESC: ordena el arraylist de la lista de Hoteles en orden descendente
	   if(ordenarPor == "Popularidad") {
		    listaHotelesOrdenada = ordenarListaHotelesPopularidad(codCiudadSeleccionada, codTipoAlojSeleccionado,ordenarPor,  ascDesc);
	   }
	   if(ordenarPor == "Precio" || ordenarPor == "Estrellas") {
		    //listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		   listaHotelesOrdenada = crearQuerisFiltrosHoteles(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	   }
	   

	   for(int i=0; i<listaHotelesOrdenada.size();i++) {
			 
			     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR ***la opcion seleccionada por el usuario* " +listaHotelesOrdenada.get(i).getNombre() + " - "+ listaHotelesOrdenada.get(i).getPopularidad());
			  }
	 
	    return listaHotelesOrdenada;
	}
	
	/**
	 * Método ordenarListaHotelesPopularidad = ordena la lista de hoteles por popularidad ascendente o descendente en función de la seleción realizada por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Hotel> ordenarListaHotelesPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado,String ordenarPor, String ascDesc) {
		   ArrayList<Hotel> listaHotelesOrdPopuDes = crearQuerisFiltrosHoteles(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		
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
	 * Método crearQuerisAplicarFiltros = se crean las querys para las busquedas de alojamiento aplicando los filtros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public void resetearFiltrosServicios() {
		vista.buscarAlojamiento.chckbxWifiSel.setSelected(false);
		vista.buscarAlojamiento.chckbxAireSel.setSelected(false);
		vista.buscarAlojamiento.chckbxPiscinaSel.setSelected(false);
		vista.buscarAlojamiento.chckbxSpaSel.setSelected(false);
		vista.buscarAlojamiento.chckbxGimSel.setSelected(false);
		vista.buscarAlojamiento.chckbxParkingsel.setSelected(false);
		vista.buscarAlojamiento.chckbxRestSel.setSelected(false);
		vista.buscarAlojamiento.chckbxBarSel.setSelected(false);
	}

	public ArrayList<Hotel> crearQuerisFiltrosHoteles(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	    String query = "";
	    String serviciosSelec = rellenarArrayFiltrosSeleccionados();
	    ArrayList<Hotel> listaHoteles;
	    
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
	    listaHoteles = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, query);
	    
	    return listaHoteles;
	}
	
// ***CASAS***
	
	/**
	 * Método ordenarListaCasas = devuelve en el arrayList listaCasasOrdenada, la lista de casas ordenadas en función de los parámetros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Casa> ordenarListaCasas(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	   ArrayList<Casa> listaCasaesOrdenada = crearQuerisFiltrosCasas(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	
	   //(1º) ordenar por POPULARIDAD DESC: ordena el arraylist de la lista de Hoteles en orden descendente
	   if(ordenarPor == "Popularidad") {
		   listaCasaesOrdenada = ordenarListaCasasPopularidad(codCiudadSeleccionada, codTipoAlojSeleccionado,ordenarPor,  ascDesc);
	   }
	   if(ordenarPor == "Precio" ) {
		    //listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		   listaCasaesOrdenada = crearQuerisFiltrosCasas(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	   }
	   

	   for(int i=0; i<listaCasaesOrdenada.size();i++) {
			 
			     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR ***la opcion seleccionada por el usuario* " +listaCasaesOrdenada.get(i).getNombre() + " - "+ listaCasaesOrdenada.get(i).getPopularidad());
			  }
	 
	    return listaCasaesOrdenada;
	}
	
	/**
	 * Método ordenarListaCasasPopularidad = ordena la lista de c por popularidad ascendente o descendente en función de la seleción realizada por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Casa> ordenarListaCasasPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado,String ordenarPor, String ascDesc) {
		   ArrayList<Casa> listaCasasOrdPopuDes = crearQuerisFiltrosCasas(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		
		   //(1º) ordenar por POPULARIDAD DESC
		   if(ascDesc == "Descendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaCasasOrdPopuDes.sort(Comparator.comparing(Casa::getPopularidad).thenComparing(Casa::getPopularidad));
			   
			   //ordena el arraylist de la lista de Hoteles en orden descendente:
			   Collections.reverse(listaCasasOrdPopuDes);
		   }
		  
		   //(2º) ordenar por POPULARIDAD Ascendente
		   else if(ascDesc == "Ascendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaCasasOrdPopuDes.sort(Comparator.comparing(Casa::getPopularidad).thenComparing(Casa::getPopularidad));
			   
		   }
		   
		   return listaCasasOrdPopuDes;
		}
		
	
	/**
	 * Método crearQuerisFiltrosCasas = se crean las querys para las busquedas de alojamiento aplicando los filtros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Casa> crearQuerisFiltrosCasas(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	    String query = "";
	    String serviciosSelec = rellenarArrayFiltrosSeleccionados();
	    ArrayList<Casa> listaCasas;
	    
	    if(ordenarPor == "Precio" && ascDesc == "Ascendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento asc";
		}
		else if(ordenarPor == "Precio" && ascDesc == "Descendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento desc";
		}
		else if(ordenarPor == "Estrellas" ) {
			//mostrar mensaje diciendo que no se puede ordenar por estrellas
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento asc";
		
		}
		else {
			query = "SELECT * FROM `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec;

		}
	    listaCasas = modelo.consultas.buscarCasaPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, query);
	    
	    return listaCasas;
	}
	
	
	//APARTAMENTOS
	
	/**
	 * Método ordenarListaApartamentos = devuelve en el arrayList ordenarListaApartamentos, la lista de casas ordenadas en función de los parámetros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Apartamento> ordenarListaApartamentos(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	   ArrayList<Apartamento> listaApartamentosOrdenados = crearQuerisFiltrosApartamentos(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	
	   //(1º) ordenar por POPULARIDAD DESC: ordena el arraylist de la lista de Hoteles en orden descendente
	   if(ordenarPor == "Popularidad") {
		   listaApartamentosOrdenados = ordenarListaApartamentosPopularidad(codCiudadSeleccionada, codTipoAlojSeleccionado,ordenarPor,  ascDesc);
	   }
	   if(ordenarPor == "Precio" ) {
		    //listaHotelesOrdenada = modelo.consultas.buscarHotelPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		   listaApartamentosOrdenados = crearQuerisFiltrosApartamentos(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
	   }
	   

	   for(int i=0; i<listaApartamentosOrdenados.size();i++) {
			 
			     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR ***la opcion seleccionada por el usuario* " +listaApartamentosOrdenados.get(i).getNombre() + " - "+ listaApartamentosOrdenados.get(i).getPopularidad());
			  }
	 
	    return listaApartamentosOrdenados;
	}
	
	/**
	 * Método ordenarListaApartamentosPopularidad = ordena la lista de apartamentos por popularidad ascendente o descendente en función de la seleción realizada por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Apartamento> ordenarListaApartamentosPopularidad(int codCiudadSeleccionada, int codTipoAlojSeleccionado,String ordenarPor, String ascDesc) {
		   ArrayList<Apartamento> listaCasasOrdPopuDes = crearQuerisFiltrosApartamentos(codCiudadSeleccionada, codTipoAlojSeleccionado, ordenarPor, ascDesc);
		
		   //(1º) ordenar por POPULARIDAD DESC
		   if(ascDesc == "Descendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaCasasOrdPopuDes.sort(Comparator.comparing(Apartamento::getPopularidad).thenComparing(Apartamento::getPopularidad));
			   
			   //ordena el arraylist de la lista de Hoteles en orden descendente:
			   Collections.reverse(listaCasasOrdPopuDes);
		   }
		  
		   //(2º) ordenar por POPULARIDAD Ascendente
		   else if(ascDesc == "Ascendente") {
			    //ordena el arraylist de la lista de Hoteles en orden ascendente
			   listaCasasOrdPopuDes.sort(Comparator.comparing(Apartamento::getPopularidad).thenComparing(Apartamento::getPopularidad));
			   
		   }
		   
		   return listaCasasOrdPopuDes;
		}
		
	
	/**
	 * Método crearQuerisFiltrosApartamentos = se crean las querys para las busquedas de alojamiento aplicando los filtros seleccionados por el usuario
	 * @param codCiudadSeleccionada = se pasa el código de la ciudad seleccionada por el usuario por parámetro
	 * @param codTipoAlojSeleccionado = Se le pasa el código del tipo de alojamiento seleccionado por el usuario por parámetro
	 * @param ascDesc = se le pasa la selección del usuario (ascendente o descendente9 que será cómo desea ordenar la lista de alojamientos
	 * @return listaHotelesOrdPopuDes = lista de alojamientos ordenados en función de la selección realizada por el usuario
	 */
	public ArrayList<Apartamento> crearQuerisFiltrosApartamentos(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String ordenarPor, String ascDesc) {
	    String query = "";
	    String serviciosSelec = rellenarArrayFiltrosSeleccionados();
	    ArrayList<Apartamento> listaApartamentos;
	    
	    if(ordenarPor == "Precio" && ascDesc == "Ascendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento asc";
		}
		else if(ordenarPor == "Precio" && ascDesc == "Descendente") {
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento desc";
		}
		else if(ordenarPor == "Estrellas" ) {
			//mostrar mensaje diciendo que no se puede ordenar por estrellas
			query = "select * from `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec + "order by Precio_alojamiento asc";
		
		}
		else {
			query = "SELECT * FROM `vistaAlojamientos` where Cod_ubicacion = ? and Cod_tipo = ? " + serviciosSelec;

		}
	    listaApartamentos = modelo.consultas.buscarApartamentoPorCodCiudad(codCiudadSeleccionada, codTipoAlojSeleccionado, query);
	    
	    return listaApartamentos;
	}
	
}

