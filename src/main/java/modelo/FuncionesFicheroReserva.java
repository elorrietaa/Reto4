package modelo;
import java.io.*;
import java.util.ArrayList;

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
	 * Método: imprimirReservaHabitacionesHotel, escribe en el fichero la reserva de las habitaciones del hotel. 1 reserva por habitacion
	 * En el caso de que el fichero que se desea guardar no exista, mustra un mensaje por pantalla y cierra la aplicación. 
	 * @param modelo
	 * @param vista
	 */
	public void imprimirReservaHabitacionesHotel(PrincipalModelo modelo, JframePrincipal vista, int pos) {
	
		FileWriter fichero = null;
        PrintWriter writer = null;
        try  
        {
        	File archivo = new File("C:\\workspace\\RETO4/reserva.txt");
        	if (!archivo.exists()) {
        	    System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        	    JOptionPane.showMessageDialog(vista, "Alerta OJO: ¡¡No es posible guardar la reserva! ¡No existe el archivo en el que quiere guardar la reserva!! LA APLICACIÓN SE CERRARÁ", null, 0);
        	    System.exit(0);
        	}
            fichero = new FileWriter("C:\\workspace\\RETO4/reserva.txt", true); // true es para añadir al final de un fichero ya existente
            writer = new PrintWriter(fichero);
            //vista.detallesReserva.tFPrecioReserva.getX() 
			writer.println("*************************************************************************************");
			writer.println("     	 DATOS DE LA RESERVA      ");
			writer.println("*************************************************************************************");
			writer.println("Código de la reserva: " + modelo.listaReservas.get(pos).getCodReserva());
			writer.println("Fecha de entrada: " + modelo.fechaIda);
			writer.println("Fecha salida: " +modelo.fechaVuelta);
			writer.println();
			writer.println("=====DATOS DEL CLIENTE: ===== " );
			writer.println("Nombre: " + modelo.cliente.getNombre()+ " Apellidos:" + modelo.cliente.getApellidos() + " DNI: " + modelo.cliente.getDni());
			writer.println();
			writer.println("=====DATOS DEL ALOJAMIENTO: ===== " );
			writer.println("Ciudad: " + modelo.hotel.getUbicacion());
			writer.println("Código del hotel: " + modelo.hotel.getCodAlojamiento()); 
			writer.println("Nombre del hotel: " + modelo.hotel.getNombre());	
			writer.println("Dirección: " + modelo.hotel.getDireccion() + "   Teléfono: "+ modelo.hotel.getTelefono());	
			writer.println("Número de estrellas: " + modelo.hotel.getEstrellas());
			writer.println();
			writer.println("===== DATOS DE LA RESERVA: ===== " );
			writer.println("Código habitación: " + modelo.listaReservas.get(pos).getHabitacion().getCodHabitacion());
			writer.println("Nombre habitación: " + modelo.listaReservas.get(pos).getHabitacion().getNombreHabitacion());
			writer.println("Tipo de habitación: " + modelo.listaReservas.get(pos).getHabitacion().getTipoHabitacion());
			writer.println("Número de camas de la habitación: " + modelo.consultas.buscarNumCamasPorCodHab(modelo.hotel.getCodAlojamiento()));
			
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.listaReservas.get(pos).getHabitacion().getCodHabitacion());
		
			writer.println("Tipo de camas de la habitación: " + listaCamas.toString());
			writer.println();
			writer.println("Precio habitación: " + (String.format("%.2f",modelo.listaReservas.get(pos).getHabitacion().getPrecioHabitacion()) + "€/ 1 noche"));
			writer.println("Precio habitación: " + (String.format("%.2f",modelo.listaReservas.get(pos).getPrecioReserva()) + "€/ "+ modelo.numNoches+" noches"));
			writer.println();
			writer.println("*************************************************************************************");
			writer.println();
			writer.println("PRECIO FINAL TOTAL de todas sus habitaciones reservadas para "+ modelo.numNoches +" noches: " + modelo.precioTotal + " €");
			writer.println();
			writer.println("*************************************************************************************");
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
	
	/**
	 * Método: imprimirReserva1HabHotel, escribe en el fichero la reserva de las habitaciones del hotel. 1 reserva por habitacion
	 * En el caso de que el fichero que se desea guardar no exista, mustra un mensaje por pantalla y cierra la aplicación. 
	 * @param modelo
	 * @param vista
	 */
	public void imprimirReserva1HabHotel(PrincipalModelo modelo, JframePrincipal vista) {
	
		FileWriter fichero = null;
        PrintWriter writer = null;
        try  
        {
        	File archivo = new File("C:\\workspace\\RETO4/reserva.txt");
        	if (!archivo.exists()) {
        	    System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        	    JOptionPane.showMessageDialog(vista, "Alerta OJO: ¡¡No es posible guardar la reserva! ¡No existe el archivo en el que quiere guardar la reserva!! LA APLICACIÓN SE CERRARÁ", null, 0);
        	    System.exit(0);
        	}
            fichero = new FileWriter("C:\\workspace\\RETO4/reserva.txt", true); // true es para añadir al final de un fichero ya existente
            writer = new PrintWriter(fichero);
            //vista.detallesReserva.tFPrecioReserva.getX() 
			writer.println("*************************************************************************************");
			writer.println("     	 DATOS DE LA RESERVA      ");
			writer.println("*************************************************************************************");
			writer.println("Código de la reserva: " + modelo.reserva.getCodReserva());
			writer.println("Fecha de entrada: " + modelo.fechaIda);
			writer.println("Fecha salida: " +modelo.fechaVuelta);
			writer.println();
			writer.println("=====DATOS DEL CLIENTE: ===== " );
			writer.println("Nombre: " + modelo.cliente.getNombre()+ " Apellidos:" + modelo.cliente.getApellidos() + " DNI: " + modelo.cliente.getDni());
			writer.println();
			writer.println("=====DATOS DEL ALOJAMIENTO: ===== " );
			writer.println("Ciudad: " + modelo.hotel.getUbicacion());
			writer.println("Código del hotel: " + modelo.hotel.getCodAlojamiento());
			writer.println("Nombre del hotel: " + modelo.hotel.getNombre());	
			writer.println("Dirección: " + modelo.hotel.getDireccion() + "   Teléfono: "+ modelo.hotel.getTelefono());	
			writer.println("Número de estrellas: " + modelo.hotel.getEstrellas());
			writer.println();
			writer.println("===== DATOS DE LA RESERVA: ===== " );
			writer.println("Código habitación: " + modelo.habitacion.getCodHabitacion());
			writer.println("Nombre habitación: " + modelo.habitacion.getNombreHabitacion());
			writer.println("Tipo de habitación: " + modelo.habitacion.getTipoHabitacion());
			writer.println("Número de camas de la habitación: " + modelo.consultas.buscarNumCamasPorCodHab(modelo.reserva.getHabitacion().getCodHabitacion()));
			
			//Mostrar detalles de las camas de la habitación seleccionada: 
			ArrayList<Cama> listaCamas = modelo.consultas.buscarCamaPorCodigoHabitacion(modelo.reserva.getHabitacion().getCodHabitacion());
		
			writer.println("Tipo de camas de la habitación: " + listaCamas.toString());
			writer.println();
			
			writer.println("===== DATOS PRECIO: ===== " );
			writer.println("Precio sin aplicar descuento: " + modelo.precioTotalSinCupon + " €");
	//		writer.println("Descuentos aplicados:" + modelo.cuponSeleccionado.getCod_promocional() + " - Descuento:" + (String.format("%.0f", (modelo.cuponSeleccionado.getDescuento()*100))) + "%");
			writer.println("Precio aplicando descuento: " + modelo.precioTotal + " €");
	
			writer.println();
			writer.println("*************************************************************************************");
			writer.println();
			writer.println("PRECIO FINAL TOTAL de su reserva es: "+ modelo.numNoches +" noches: " + modelo.precioTotal + " €");
			writer.println();
			writer.println("*************************************************************************************");
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
	
	/**
	 * Método: imprimirReservaFicheroCasa, escribe en el fichero la reserva
	 * En el caso de que el fichero que se desea guardar no exista, mustra un mensaje por pantalla y cierra la aplicación. 
	 * @param modelo
	 * @param vista
	 */
	public void imprimirReservaFicheroCasa(PrincipalModelo modelo, JframePrincipal vista) {
	
		FileWriter fichero = null;
        PrintWriter writer = null;
        try 
        {
        	File archivo = new File("C:\\workspace\\RETO4/reserva.txt");
        	if (!archivo.exists()) {
        	    System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        	    JOptionPane.showMessageDialog(vista, "Alerta OJO: ¡¡No es posible guardar la reserva! ¡No existe el archivo en el que quiere guardar la reserva!! LA APLICACIÓN SE CERRARÁ", null, 0);
        	    System.exit(0);
        	}
            fichero = new FileWriter("C:\\workspace\\RETO4/reserva.txt", true); // true es para añadir al final de un fichero ya existente
            writer = new PrintWriter(fichero);
            //vista.detallesReserva.tFPrecioReserva.getX() 
			writer.println("*************************************************************");
			writer.println("     	 DATOS DE LA RESERVA      ");
			writer.println("*************************************************************");
			writer.println("Código de la reserva: " + modelo.reserva.getCodReserva());
			writer.println("Fecha de entrada: " + modelo.reserva.getFechaIda());
			writer.println("Fecha salida: " +modelo.reserva.getFechaVuelta());
			writer.println();
			writer.println("=====DATOS DEL CLIENTE: ===== " );
			writer.println("Nombre: " + modelo.cliente.getNombre()+ " Apellidos:" + modelo.cliente.getApellidos() + " DNI: " + modelo.cliente.getDni());
			writer.println();
			writer.println("=====DATOS DEL ALOJAMIENTO: ===== " );
			writer.println("Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion());
			writer.println("Código del alojamiento: " + modelo.reserva.getAlojamiento().getCodAlojamiento());
			writer.println("Nombre del alojamiento: " + modelo.reserva.getAlojamiento().getNombre());		
			writer.println("Dirección: " + modelo.casa.getDireccion() + "   Teléfono: "+ modelo.casa.getTelefono());	
			writer.println();
		
			writer.println("===== DATOS PRECIO: ===== " );
			writer.println("Precio sin aplicar descuento: " + modelo.precioTotalSinCupon + " €");
		//da error si no tiene codigos promocionales
		//	writer.println("Descuentos aplicados:" + modelo.cuponSeleccionado.getCod_promocional() + " - Descuento:" + (String.format("%.0f", (modelo.cuponSeleccionado.getDescuento()*100))) + "%");
			writer.println("Precio aplicando descuento: " + modelo.precioTotal + " €");
	
			writer.println();
			writer.println("*************************************************************");
			writer.println();
			writer.println("PRECIO FINAL TOTAL: " + modelo.precioTotal + "€");
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
	
	public void imprimirReservaFicheroApart(PrincipalModelo modelo, JframePrincipal vista) {
		
		FileWriter fichero = null;
        PrintWriter writer = null;
        try 
        {
        	File archivo = new File("C:\\workspace\\RETO4/reserva.txt");
        	if (!archivo.exists()) {
        	    System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        	    JOptionPane.showMessageDialog(vista, "Alerta OJO: ¡¡No es posible guardar la reserva! ¡No existe el archivo en el que quiere guardar la reserva!! LA APLICACIÓN SE CERRARÁ", null, 0);
        	    System.exit(0);
        	}
            fichero = new FileWriter("C:\\workspace\\RETO4/reserva.txt", true); // true es para añadir al final de un fichero ya existente
            writer = new PrintWriter(fichero);
            //vista.detallesReserva.tFPrecioReserva.getX() 
			writer.println("*************************************************************");
			writer.println("     	 DATOS DE LA RESERVA      ");
			writer.println("*************************************************************");
			writer.println("Código de la reserva: " + modelo.reserva.getCodReserva());
			writer.println("Fecha de entrada: " + modelo.reserva.getFechaIda());
			writer.println("Fecha salida: " +modelo.reserva.getFechaVuelta());
			writer.println();
			writer.println("=====DATOS DEL CLIENTE: ===== " );
			writer.println("Nombre1111: " + modelo.cliente.getNombre()+ " Apellidos:" + modelo.cliente.getApellidos() + " DNI: " + modelo.cliente.getDni());
			writer.println();
			writer.println("=====DATOS DEL ALOJAMIENTO: ===== " );
			writer.println("Ciudad: " + modelo.reserva.getAlojamiento().getUbicacion());
			writer.println("Código del apartamento: " + modelo.reserva.getAlojamiento().getCodAlojamiento());
			writer.println("Nombre del apartamento: " + modelo.reserva.getAlojamiento().getNombre());		
			writer.println("Dirección: " + modelo.apartamento.getDireccion() + " Piso: " +modelo.apartamento.getPiso() +"   Teléfono: "+ modelo.apartamento.getTelefono());	
			
			writer.println();
			writer.println("===== DATOS PRECIO: ===== " );
			writer.println("Precio sin aplicar descuento: " + modelo.precioTotalSinCupon + " €");
		//	writer.println("Descuentos aplicados:" + modelo.cuponSeleccionado.getCod_promocional() + " - Descuento:" + (String.format("%.0f", (modelo.cuponSeleccionado.getDescuento()*100))) + "%");
			writer.println("Precio aplicando descuento: " + modelo.precioTotal + " €");
	
			
			writer.println();
			writer.println("*************************************************************");
			writer.println();
			writer.println("PRECIO FINAL TOTAL: " + modelo.precioTotal + "€");
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