package controlador;

import java.util.ArrayList;

/**
 * Clase: ControladorPanBuscarHotel: contiene los m�todos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel {
    /**
     * M�todo mostrarCiudad, muestra las ciudades que se han b
     * @param listaCiudades
     */
   
    public void mostrarCiudad() {
	ArrayList listaCiudades=modelo.FuncionesModelo.buscarCiudad();
	vista.PanBuscarHotel.setDefaultLocale(labelCiudad);
    }
}
