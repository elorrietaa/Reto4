package controlador;

import java.util.ArrayList;

/**
 * Clase: ControladorPanBuscarHotel: contiene los métodos utilizados en el Panel PanBuscarHotel.
 * @author IN1DM3B_09
 *
 */
public class ControladorPanBuscarHotel {
    /**
     * Método mostrarCiudad, muestra las ciudades que se han b
     * @param listaCiudades
     */
   
    public void mostrarCiudad() {
	ArrayList listaCiudades=modelo.FuncionesModelo.buscarCiudad();
	vista.PanBuscarHotel.setDefaultLocale(labelCiudad);
    }
}
