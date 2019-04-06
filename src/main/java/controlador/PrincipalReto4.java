package controlador;

import modelo.Modelo;
import vista.JframePrincipal;
/**
 * Clase PrincipalReto4 = clase principal a partir de la que arranca todo el programa.
 * @author alba
 *
 */
public class PrincipalReto4 {

    public static void main(String[] args) {
    	
    	JframePrincipal vista = new JframePrincipal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarVista();
		controlador.inicializarListeners();
    } 

}
