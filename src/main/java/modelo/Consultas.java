package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.Conexion;

/**
 * FuncionesModelo: contiene los m�todos del modelo
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
	 /****************************************************************************************************************
   	 * 
   	 * Metodos de consultas referentes al alojamiento
   	 * 
   	 ****************************************************************************************************************/
   	
    /**
     * M�todo BuscarCiudad = se buscan las ciudades existentes. Se introducen en un ArrayList y se Devuelven.
     */

    public ArrayList<Ciudad> BuscarCiudad() {
    	ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>(); 
    	Ciudad ciudad;
    	
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
    		
    		// crea objetos Linea con los resultados y los a�ade a un arrayList
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
    * M�todo BuscarHotelPorCodigoCiudad = se buscan los hoteles por c�digo Ciudad. El c�digo de la ciudad depender� de la selecci�n realizada por el usuario
    * @param codCiudadSeleccionada
    * @return
    */
    public ArrayList<Hotel> BuscarHotelPorCodigoCiudad(int codCiudadSeleccionada) {
		ArrayList<Hotel> listaAlojamientos = new ArrayList<Hotel>(); 
		Hotel hotel;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT Cod_alojamiento, Nombre_alojamiento, N_habitaciones, Nombre_ubicacion, Precio_alojamiento, N_estrellas FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and alojamiento.Cod_ubicacion = ? and alojamiento.Cod_tipo = ?";
		
		try {
			// Abrimos una conexion
			connection = conexion.conectar();
					
			// preparamos la consulta SQL a la base de datos
			ps = connection.prepareStatement(query);
			ps.setInt(1, codCiudadSeleccionada);
			//en el futuro pasar por par�metro codTipoAlojSeleccionado
			ps.setInt(2, 10);
					
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			rs = ps.executeQuery();
					
			// crea objetos Linea con los resultados y los a�ade a un arrayList
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
     * M�todo buscarHabitacionPorCodigoHotel = busca las habitaciones del hotel seleccionado por el usuario.
     * @param hotel = contiene los datos del hotel seleccionado por el usuario.
     * @param codHotelSeleccionado = es el c�digo del hotel que el usuario ha seleccionado.
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
    
    		// crea objetos Linea con los resultados y los a�ade a un arrayList
    		while (rs.next()) {
    			habitacion = new Habitacion(); 
    			habitacion.setCodHabitacion(rs.getInt("Cod_habitacion"));
    			//habitacion.setAlojamiento(hotel);
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			habitacion.setNumCamas(rs.getInt("N_Camas"));
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
    
    //no funciona
    public ArrayList<Habitacion> buscarHabitacionDisponiblel(Date fechaIda, Date fechaVuelta, int codHotelSeleccionado) {
    	ArrayList<Habitacion> listaHabDisp = new ArrayList<Habitacion>(); 
    	Habitacion habitacion;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT h.Cod_habitacion, h.N_camas FROM `habitaciones` H, `reservas` R where H.Cod_habitacion=R.Cod_habitacion and  h.Cod_habitacion NOT IN( SELECT h.Cod_habitacion FROM `habitaciones` H, `reservas` R where H.Cod_habitacion=R.Cod_habitacion and ((R.Fecha_entrada <= `?` AND Fecha_salida >= `?` ) OR Fecha_salida BETWEEN `?` AND `?` OR Fecha_entrada BETWEEN `?` AND `?` AND H.Cod_alojamiento=?)";
    	
    	try { 
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setDate(1, fechaIda);
    		ps.setDate(2, fechaVuelta);
    		ps.setDate(3, fechaIda);
    		ps.setDate(4, fechaVuelta);
    		ps.setDate(5, fechaIda);
    		ps.setDate(6, fechaVuelta);
    		ps.setInt(7, codHotelSeleccionado);
    		
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    
    		// crea objetos Linea con los resultados y los a�ade a un arrayList
    		while (rs.next()) {
    			habitacion = new Habitacion(); 
    			habitacion.setCodHabitacion(rs.getInt("Cod_habitacion"));
    			habitacion.setNumCamas(rs.getInt("N_Camas"));
    			listaHabDisp.add(habitacion);
    		}
    				
    		} 
    	catch (SQLException e) {
    			e.printStackTrace();
    		} 
    		finally {
    			// cerramos la conexion
    			conexion.desconectar();
    		}
    	return listaHabDisp;
    }
    
    
    public ArrayList<Cama> buscarCamaPorCodigoHabitacion(int codHabitacionSeleccionada) {
    	ArrayList<Cama> listaCamas = new ArrayList<Cama>(); 
    	Cama cama;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	 
    	String query = "SELECT * FROM `habitaciones`, `camas` where habitaciones.Cod_habitacion=camas.Cod_habitacion and habitaciones.Cod_habitacion=?";
    	try {
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codHabitacionSeleccionada);
    		
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    
    		// crea objetos Linea con los resultados y los a�ade a un arrayList
    		while (rs.next()) {
    			cama = new Cama(); 
    			cama.setCodCama(rs.getInt("Cod_cama"));
    			cama.setTipoCama(rs.getString("Tipo_cama"));
    			listaCamas.add(cama);
    		}
    				
    		} 
    	catch (SQLException e) {
    			e.printStackTrace();
    		} 
    		finally {
    			// cerramos la conexion
    			conexion.desconectar();
    		}
    	return listaCamas;
    }
    
    
    /****************************************************************************************************************
   	 * 
   	 * Metodos de consultas referentes al cliente
   	 * 
   	 ****************************************************************************************************************/
   	
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
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				cliente = new Cliente(
					result.getString("Dni"),
					result.getString("Nombre"),
					result.getString("Apellidos"), 
					result.getDate("fechaNacimiento"),
					result.getString("sexo").charAt(0),
					result.getString("contrasena")
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
    /****************************************************************************************************************
   	 * 
   	 * Metodos de consultas referentes a la reserva
   	 * 
   	 ****************************************************************************************************************/
   	
    public int mostrarNumReservas() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva=0;
		
		String query = "SELECT count(*) FROM `reservas`";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				codReserva = result.getInt(1);
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
		
		return codReserva;
	}
    
    public int mostrarNumReservasConProcedimiento() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva=0;
		
		String query = "SELECT count(*) FROM `reservas`";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				codReserva = result.getInt(1);
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
		
		return codReserva;
	}
    
    /****************************************************************************************************************
	 * 
	 * Metodos consultas fechas
	 * 
	 ****************************************************************************************************************/
    public Date mostrarFechaActual() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		Date fechaActual = null;
		
		String query = "select Date_format(now(),'%Y-%m-%d');";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				fechaActual = result.getDate(1);
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
		
		return fechaActual;
	}
    
    /****************************************************************************************************************
	 * 
	 * Metodos para insertar los datos de los objetos cliente y billete en la BBDD (Consultas Insert)
	 * 
	 ****************************************************************************************************************/
	
	/**
	 * Inserta los atributos de un objetos cliente en la base de datos
	 * 
	 * @param cliente objeto cliente que se quiere insertar en la base de datos
	 */
    public void insertarCliente(Cliente cliente) {
		
		PreparedStatement stmt = null;
		String query = "INSERT INTO cliente (DNI, Nombre, Apellidos, fechaNacimiento, sexo, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query);
			
			// a�adimos los valores a insertar
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
    
    /**
	 * Inserta los atributos de un objeto reserva en la base de datos
	 * 
	 * @param reserva Objeto reserva que se quiere introducir en la base de datos
	 * 
	 * @return Retorna el codigo de la reserva, generado de manera aleatoria
	 */
	public void insertarReserva(Reserva reserva) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva = 0;
		
		String query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento,Cod_habitacion, Precio_reserva, Dni, Fecha_entrada, Fecha_salida) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// a�adimos los valores a insertar
			stmt.setInt(1, reserva.getCodReserva());
			stmt.setInt(2, reserva.getAlojamiento().getCodAlojamiento());
			//puede haber varias habitaciones, se le pasar� por par�metro a insertarReserva un pos i. 
			//insertarReserva estar� dentro de un for (int i; listaHabSeleccionadas.size(); i++), as� se insertatr�n las reservas de todas lashabitaciones seleecionadas.
			stmt.setInt(3,reserva.getHabitacion().getCodHabitacion());
			stmt.setFloat(4, reserva.getPrecioReserva());
			stmt.setString(5, reserva.getCliente().getDni());
			stmt.setDate(6, reserva.getFechaIda());
			stmt.setDate(7, reserva.getFechaVuelta());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
			result = stmt.getGeneratedKeys();
			result.next();
			codReserva = result.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
	}

}