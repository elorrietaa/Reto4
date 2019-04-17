package modelo;
import java.io.*;

import javax.swing.JOptionPane;

import vista.JframePrincipal;

public class FuncionesFicheroReserva {
	PrincipalModelo modelo;
	/**
	 * Constructor de la clase FuncionesReserva
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarla
	 */
	public FuncionesFicheroReserva (PrincipalModelo modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	/**
	 * M�todo: escribeEnFichero, escribe en el fichero la reserva
	 * En el caso de que el fichero que se desea guardar no exista, mustra un mensaje por pantalla y cierra la aplicaci�n. 
	 * @param modelo
	 * @param vista
	 */
	public void imprimirReservaFichero(PrincipalModelo modelo, JframePrincipal vista) {
	
		FileWriter fichero = null;
        PrintWriter writer = null;
        try 
        {
        	File archivo = new File("C:\\workspace\\RETO4/reserva.txt");
        	if (!archivo.exists()) {
        	    System.out.println("OJO: ��No existe el archivo de configuraci�n!!");
        	    JOptionPane.showMessageDialog(vista, "Alerta OJO: ��No es posible guardar la reserva! �No existe el archivo en el que quiere guardar la reserva!! LA APLICACI�N SE CERRAR�", null, 0);
        	    System.exit(0);
        	}
            fichero = new FileWriter("C:\\workspace\\RETO4/reserva.txt", true); // true es para a�adir al final de un fichero ya existente
            writer = new PrintWriter(fichero);
            //vista.detallesReserva.tFPrecioReserva.getX() 
			writer.println("*************************************************************");
			writer.println("     	 DATOS DELA RESERVA      ");
			writer.println("*************************************************************");
			writer.println("C�digo de la reserva: " + modelo.reserva.getCodReserva());
			writer.println("Fecha de entrada: " + modelo.reserva.getFechaIda());
			writer.println("Fecha salida: " +modelo.reserva.getFechaVuelta());
			writer.println();
			writer.println("=====DATOS DEL CLIENTE: ===== " );
			writer.println("Nombre: " + modelo.cliente.getNombre()+ " Apellidos:" + modelo.cliente.getApellidos() + " DNI: " + modelo.cliente.getDni());
			writer.println();
			writer.println("=====DATOS DEL ALOJAMIENTO: ===== " );
			writer.println("Ciudad: " + modelo.hotel.getUbicacion());
			writer.println("C�digo del hotel: " + modelo.hotel.getCodAlojamiento());
			writer.println("Nombre del hotel: " + modelo.hotel.getNombre());		
			writer.println("N�mero de estrellas: " + modelo.hotel.getEstrellas());
			writer.println();
			writer.println("===== DATOS DE LA RESERVA: ===== " );
			writer.println("C�digo habitaci�n: " + modelo.reserva.getHabitacion().getCodHabitacion());
			writer.println("Tipo de habitaci�n: " + modelo.reserva.getHabitacion().getTipoHabitacion());
			writer.println("N�mero de camas de la habitaci�n: " + modelo.reserva.getHabitacion().getNumCamas());
			writer.println("Tipo de camas de la habitaci�n: " + modelo.reserva.getHabitacion().getTiposCamaHab());
			writer.println();
			writer.println("Precio habitaci�n: " + modelo.reserva.getPrecioReserva() + "�");
			writer.println();
			writer.println("*************************************************************");
			writer.println();
			writer.println("PRECIO FINAL TOTAL: " + modelo.precioTotal + "�");
			writer.println();
			writer.println("*************************************************************");
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