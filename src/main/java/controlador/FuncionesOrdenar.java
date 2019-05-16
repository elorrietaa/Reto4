package controlador;

import java.util.ArrayList;

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
	   //añadimos una primera posicion vacia al arraylist
	   listaHotelesOrdPopuDes.set(0, new Hotel());    
	   int comodinPopu=0;
	  
	   for(int i=0; i<listaHotelesOrdPopuDes.size();i++) {
	       if(listaHotelesOrdPopuDes.get(i+1).getPopularidad()>=listaHotelesOrdPopuDes.get(i).getPopularidad()) {
		  
	       }
	       
	     
	   }
	    
	   
	   
	    return listaHotelesOrdPopuDes;
	}

}
