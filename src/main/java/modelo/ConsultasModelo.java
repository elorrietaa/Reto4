package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

/**
 * FuncionesModelo: contiene los métodos del modelo
 * @author IN1DM3B_09
 *
 */
public class ConsultasModelo {
    private static Conexion conexion;
    private static Connection connection;
    /**
     * método BuscarCiudad, se buscan las ciudades existentes. Se introducen en un ArrayList y se Devuelven.
     */
    public static ArrayList BuscarCiudad() {
	ArrayList <Ciudad> listaCiudades = new ArrayList(); 
	Ciudad ciudad;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = " SELECT * FROM `ciudad`;";
	try {
		// Abrimos una conexion
		
		connection = conexion.conectar();
				
		// preparamos la consulta SQL a la base de datos
		ps = connection.prepareStatement(query);
				
		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		rs = ps.executeQuery();
		
		// crea objetos Linea con los resultados y los añade a un arrayList
		while (rs.next()) {
			ciudad = new Ciudad();
			ciudad.setCodCiudad(rs.getInt("Cod_ubicacion"));
			ciudad.setNombreCiudad(rs.getString("Nombre_ubicacion"));
			
			listaCiudades.add(ciudad);
		}
	}
	catch (SQLException e) {
			e.printStackTrace();
	} 
	finally {
		// cerramos la conexion
		//conexion.desconectar();
	}
	return listaCiudades;
    }
   
    public ArrayList BuscarHotelPorCodigoCiudad(int codCiudadIntroducida) {
	ArrayList <Hotel> listaAlojamientos = new ArrayList(); 
	Hotel hotel;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = " SELECT Cod_alojamiento, Nombre_alojamiento, N_habitaciones, Nombre_ubicacion, Precio_alojamiento, N_estrellas FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and Cod_Ubicacion=" + codCiudadIntroducida;
	
	try {
		// Abrimos una conexion
		connection = conexion.conectar();
				
		// preparamos la consulta SQL a la base de datos
		ps = connection.prepareStatement(query);
				
		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		rs = ps.executeQuery();
				
		// crea objetos Linea con los resultados y los añade a un arrayList
		while (rs.next()) {
			hotel = new Hotel();
			hotel.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
			hotel.setNombre(rs.getString("Nombre_alojamiento"));
			hotel.setNumHabitaciones(rs.getInt("N_Habitaciones"));
			hotel.setUbicacion(rs.getString("Nombre_ubicacion"));
			hotel.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
			hotel.setEstrellas(rs.getInt("N_estrellas"));
			listaAlojamientos.add(hotel);
		}
				
		} 
	catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// cerramos la conexion
			conexion.desconectar();
		}
	return listaAlojamientos;
    }
  
}