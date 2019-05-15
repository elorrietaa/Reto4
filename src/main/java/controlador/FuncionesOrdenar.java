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
	
	public ArrayList<Hotel> ordernarAlojamientosPopularidad(ArrayList<Hotel> listaHoteles) {
	   ArrayList<Hotel> listaHotelesOrdPopuDes = listaHoteles;
	  
	/*   for(int i=0; i<listaHotelesOrdPopuDes.size();i++) {
		  if(i<=listaHotelesOrdPopuDes.size()) {
			  int posicionAnterior = listaHotelesOrdPopuDes.get(i).getPopularidad();
			   int posicionPosterior = listaHotelesOrdPopuDes.get(i+1).getPopularidad();
			   
			   //si la popularidad de la posición i (posicion anterior) < i+1 (posición posterior), 
		       if(posicionAnterior<posicionPosterior) {
		    	   listaHotelesOrdPopuDes.add(i, listaHotelesOrdPopuDes.get(i+1));//se pasa el contenido de la posición posterior(i+1) a la posición anterior (i)
		    	 
		    	   //ahora la posición posterior (i+1) está en i y la anterior en i+1, y estaría en i+2 la posición posterior que no hemos eliminado, la eliminamos:
		    	  listaHotelesOrdPopuDes.remove(i+2);
		    	   
		       }
		    
		     System.out.println("LISTA ALOJAMIENTOS ORDENADOS POR POPULARIDAD " + listaHotelesOrdPopuDes.get(i).getPopularidad());
		  }
		   
	   }
	   */
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

