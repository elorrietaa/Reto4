package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.Conexion;

/**
 * FuncionesModelo: contiene los métodos del modelo
 * @author IN1DM3B_09
 *
 */

public class Consultas {
    private Conexion conexion; 
    private  Connection connection;
    /**
	 * Contructor de la clase consultas
	 * 
	 * @param conexion Clase encargada de la conexion a la base de datos
	 */
	public Consultas(Conexion conexion) {
		this.conexion = conexion;
		this.connection = null;
	} 
	
    /**
     * Método BuscarCiudad = se buscan las ciudades existentes. Se introducen en un ArrayList y se Devuelven.
     */

    public ArrayList<Ciudad> BuscarCiudad() {
    	ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>(); 
    	Ciudad ciudad;
    	/* PARA PRUEBAS:
    			ciudad = new Ciudad();
    			ciudad.setCodCiudad(1);
    			ciudad.setNombreCiudad("BILBAO");
    			listaCiudades.add(ciudad);
    			System.out.println(ciudad.getCodCiudad());
    			System.out.println(ciudad.getNombreCiudad());
    			//PARA PRUEBAS FIN
    	*/
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String query = "SELECT * FROM `ciudad`";
    	
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
    		conexion.desconectar();
    	}
    	
    	return listaCiudades;
    }
   /**
    * Método BuscarHotelPorCodigoCiudad = se buscan los hoteles por código Ciudad. El código de la ciudad dependerá de la selección realizada por el usuario
    * @param codCiudadSeleccionada
    * @return
    */
    public ArrayList<Hotel> BuscarHotelPorCodigoCiudad(int codCiudadSeleccionada) {
		ArrayList<Hotel> listaAlojamientos = new ArrayList<Hotel>(); 
		Hotel hotel;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT Cod_alojamiento, Nombre_alojamiento, N_habitaciones, Nombre_ubicacion, Precio_alojamiento, N_estrellas FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and alojamiento.Cod_ubicacion = ?";
		
		try {
			// Abrimos una conexion
			connection = conexion.conectar();
					
			// preparamos la consulta SQL a la base de datos
			ps = connection.prepareStatement(query);
			ps.setInt(1, codCiudadSeleccionada);
					
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
  
    /**
     * Método buscarHabitacionPorCodigoHotel = busca las habitaciones del hotel seleccionado por el usuario.
     * @param hotel = contiene los datos del hotel seleccionado por el usuario.
     * @param codHotelSeleccionado = es el código del hotel que el usuario ha seleccionado.
     * @return
     */
    public ArrayList<Habitacion> buscarHabitacionPorCodigoHotel(Hotel hotel, int codHotelSeleccionado) {
    	ArrayList<Habitacion> listaHabitacion = new ArrayList<Habitacion>(); 
    	Habitacion habitacion;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT * FROM `habitaciones`, `alojamiento` where habitaciones.Cod_alojamiento=alojamiento.Cod_alojamiento and alojamiento.Cod_alojamiento=?";
    	
    	try {
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codHotelSeleccionado);
    		
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    
    		// crea objetos Linea con los resultados y los añade a un arrayList
    		while (rs.next()) {
    			habitacion = new Habitacion(); 
    			habitacion.setCodHabitacion(rs.getInt("Cod_habitacion"));
    			//habitacion.setAlojamiento(hotel);
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			habitacion.setNumCamas(rs.getInt("N_Camas"));
    			//habitacion.setEstadoHabitacion(rs.getString("Estado_habitacion"));
    			listaHabitacion.add(habitacion);
    		}
    				
    		} 
    	catch (SQLException e) {
    			e.printStackTrace();
    		} 
    		finally {
    			// cerramos la conexion
    			conexion.desconectar();
    		}
    	return listaHabitacion;
    }
    public Cliente buscarClientePorDNI(String dni) {
		
		Cliente cliente = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM cliente where DNI = ?";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, dni);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				cliente = new Cliente(
					result.getString("DNI"),
					result.getString("Nombre"),
					result.getString("Apellidos"), 
					result.getDate("Fecha_nac"),
					result.getString("Sexo").charAt(0),
					result.getString("Contraseña")
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				connection.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}                 
		
		return cliente;
		
	}
    
    public void insertarCliente(Cliente cliente) {
		
		PreparedStatement stmt = null;
		String query = "INSERT INTO cliente (DNI, Nombre, Apellidos, fechaNacimiento, sexo, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query);
			
			// añadimos los valores a insertar
			stmt.setString(1, cliente.getDni());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellidos());
			stmt.setDate(4, cliente.getFechaNacimiento());
			stmt.setString(5, String.valueOf(cliente.getSexo()));
			stmt.setString(6, cliente.getContrasena());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
	}
}