package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * FuncionesModelo: contiene los métodos del modelo
 * @author IN1DM3B_09
 *
 */
public class ConsultasModelo {
    private Conexion conexion;
    private Connection connection;
    /**
     * método BuscarCiudad, se buscan las ciudades existentes. Se introducen en un ArrayList y se Devuelven.
     */
    public ArrayList BuscarCiudad() {
	ArrayList <Ciudad> listaCiudades = new ArrayList(); 
	Ciudad ciudad;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = " SELECT * FROM `ciudad`";
	
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
			ciudad.setNombreCiudad(rs.getString("Nombre"));
			listaCiudades.add(ciudad);
		}
				
		} 
	catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// cerramos la conexion
			conexion.desconectar();
		}
	return listaCiudades;
    }
    /**
    public ArrayList BuscarAlojamiento() {
	ArrayList <Alojamiento> listaAlojamientos = new ArrayList(); 
	Alojamiento alojamiento;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = " SELECT * FROM `ciudad`";
	
	try {
		// Abrimos una conexion
		connection = conexion.conectar();
				
		// preparamos la consulta SQL a la base de datos
		ps = connection.prepareStatement(query);
				
		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		rs = ps.executeQuery();
				
		// crea objetos Linea con los resultados y los añade a un arrayList
		while (rs.next()) {
			alojamiento = new Alojamiento();
			alojamiento.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
			alojamiento.setNombre(rs.getString("Nombre"));
			alojamiento.setNumHabitaciones(rs.getInt("N_Habitaciones"));
			alojamiento.setUbicacion(rs.getInt("N_Habitaciones"));
			listaAlojamientos.add(alojamiento);
		}
				
		} 
	catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// cerramos la conexion
			conexion.desconectar();
		}
	return listaCiudades;
    }
    */
}