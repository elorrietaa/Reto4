package modelo;
import java.io.*;

import vista.JframePrincipal;

public class FuncionesReserva {
	PrincipalModelo modelo;
	
	/**
	 * Constructor de la clase FuncionesReserva
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarla
	 */
	public FuncionesReserva (PrincipalModelo modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * Metodo para calcular el precio del billete
	 * 
	 * @param reserva Objeto con la informacion de la reserva
	 * 
	 * @return Retorna el precio de la reserva
	 */
	public float calcularPrecioReserva(Hotel hotel, Reserva reserva) {
		//por ahora el precio de la reserva es solo el precio del alojamiento, en el futuro serán más cálculos
		float precioReserva = hotel.getPrecioAlojamiento();
		
		return precioReserva;
	}
	/**
	 * Método: escribeEnFichero, escribe en el fichero la reserva
	 * @param modelo
	 */
	public void escribeEnFichero(PrincipalModelo modelo, JframePrincipal vista) {
		
		FileWriter fichero = null;
        PrintWriter writer = null;
        try 
        {
            fichero = new FileWriter("C:\\workspace\\RETO4/prueba.txt", true); // true es para añadir al final de un fichero ya existente
            writer = new PrintWriter(fichero);

			writer.println("****************************");
			writer.println("      DATOS DEL HOTEL      ");
			writer.println("****************************");
			
			writer.println();
//creo que no coge bien los objetos	
			writer.println("DATOS DE LA RESERVA: " );
		//FALLA//writer.println("Código de la reserva: " + modelo.reserva.getCodReserva());
			writer.println("DATOS DEL ALOJAMIENTO: " );
			writer.println("Nombre del hotel: " + vista.buscarHotel.listHoteles.getSelectedValue());
			writer.println("DATOS DE LA RESERVA: " );
			writer.println("Precio Reserva: " + vista.detallesReserva.tFPrecioReserva.getX());
			writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
 
}