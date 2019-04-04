package controlador;

import modelo.PrincipalModelo;
import vista.JframePrincipal;
/**
 * Clase PrincipalReto4 = clase principal a partir de la que arranca todo el programa.
 * @author alba
 *
 */
public class PrincipalReto4 {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	PrincipalModelo modelo = new PrincipalModelo();
	JframePrincipal vista = new JframePrincipal();
	PrincipalControlador controlador = new PrincipalControlador(modelo, vista);
    } 

}
