package App;


import controlador.PrincipalControlador;
import modelo.PrincipalModelo;
import vista.JframePrincipal;
/**
 * Clase PrincipalReto4 = clase principal a partir de la que arranca todo el programa.
 * @author alba
 *
 */
public class PrincipalReto4 {  
    public static void main(String[] args) {
    	//Declaración a inicialización de vista, modelo y controlador
    	JframePrincipal vista = new JframePrincipal();
		PrincipalModelo modelo = new PrincipalModelo();
		PrincipalControlador controlador = new PrincipalControlador(modelo, vista);
		
		controlador.inicializarVista();
		controlador.inicializarListeners(); 
    }  

}  
 