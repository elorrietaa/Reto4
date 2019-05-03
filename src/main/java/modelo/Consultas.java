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
	 /****************************************************************************************************************
   	 * 
   	 * Metodos de consultas referentes al alojamiento
   	 * 
   	 ****************************************************************************************************************/
   	
    /**
     * Método BuscarCiudad = se buscan las ciudades existentes. Se introducen en un ArrayList y se Devuelven.
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
     * Método BuscarTiposAlojamiento = se buscan las los tipos de alojamientos existentes. Se introducen en un ArrayList y se Devuelven.
     */

    public ArrayList<TipoAlojamiento> BuscarTiposAlojamiento() {
    	ArrayList<TipoAlojamiento> listaTiposAlojamiento = new ArrayList<TipoAlojamiento>(); 
    	TipoAlojamiento tipoAlojamiento;
    	
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	String query = "SELECT * FROM `tipos`";
    	
    	try {
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    				
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    		
    		// crea objetos Linea con los resultados y los añade a un arrayList
    		while (rs.next()) {
    			tipoAlojamiento = new TipoAlojamiento();
    			tipoAlojamiento.setCodTipoAlojamiento(rs.getInt("Cod_tipo"));
    			tipoAlojamiento.setTipoAlojamiento(rs.getString("Nombre_tipo"));
    			
    			
    			listaTiposAlojamiento.add(tipoAlojamiento);
    		}
    	}
    	catch (SQLException e) {
    			e.printStackTrace();
    	} 
    	finally {
    		// cerramos la conexion
    		conexion.desconectar();
    	}
    	
    	return listaTiposAlojamiento;
    }
   /** 
    * Método buscarAlojamientoPorCodigoCiudad = se buscan los alojamientos por código Ciudad y tipo de alojamiento. El código de la ciudad y el tipo de alojamiento dependerá de la selección realizada por el usuario
    * @param codCiudadSeleccionada
    * @param codTipoAlojSeleccionado
    * @return
    */
    public ArrayList<Hotel> buscarHotelPorCodCiudad(int codCiudadSeleccionada, int codTipoAlojSeleccionado) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT Cod_alojamiento, Nombre_alojamiento, Nombre_ubicacion, Precio_alojamiento, N_estrellas FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and alojamiento.Cod_ubicacion = ? and alojamiento.Cod_tipo = ?";
		
			ArrayList<Hotel> listaHoteles = new ArrayList<Hotel>(); 
			
			Hotel hotel;
			try {
				// Abrimos una conexion
				connection = conexion.conectar();
						
				// preparamos la consulta SQL a la base de datos
				ps = connection.prepareStatement(query);
				ps.setInt(1, codCiudadSeleccionada);
				//en el futuro pasar por parámetro codTipoAlojSeleccionado
				ps.setInt(2, 10);
						
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				rs = ps.executeQuery();
						
				// crea objetos Linea con los resultados y los añade a un arrayList
				while (rs.next()) {
					hotel = new Hotel();
					hotel.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
					hotel.setNombre(rs.getString("Nombre_alojamiento"));
					//hotel.setNumHabitaciones(rs.getInt("N_Habitaciones"));
					hotel.setUbicacion(rs.getString("Nombre_ubicacion"));
					hotel.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					hotel.setEstrellas(rs.getInt("N_estrellas"));
					listaHoteles.add(hotel);
				}	
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				// cerramos la conexion
				conexion.desconectar();
			}
	
		
		return listaHoteles;
		
    }
    
    /**
     * Método buscarCasaPorCodCiudad = busca la lista de casas en función de la ciudad seleccionada por el usuario.
     * @param codCiudadSeleccionada
     * @return
     */
    public ArrayList<Casa> buscarCasaPorCodCiudad(int codCiudadSeleccionada) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT Cod_alojamiento, Nombre_alojamiento, N_habitaciones, Nombre_ubicacion, Precio_alojamiento FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and alojamiento.Cod_ubicacion = ? and alojamiento.Cod_tipo = ?";
		ArrayList<Casa> listaCasas = new ArrayList<Casa>(); 
		
			Casa casa;
			try {
				// Abrimos una conexion
				connection = conexion.conectar();
						
				// preparamos la consulta SQL a la base de datos
				ps = connection.prepareStatement(query);
				ps.setInt(1, codCiudadSeleccionada);
				//en el futuro pasar por parámetro codTipoAlojSeleccionado
				ps.setInt(2, 20);
						
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				rs = ps.executeQuery();
						
				// crea objetos Linea con los resultados y los añade a un arrayList
				while (rs.next()) {
					casa = new Casa();
					casa.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
					casa.setNombre(rs.getString("Nombre_alojamiento"));
					casa.setUbicacion(rs.getString("Nombre_ubicacion"));
					casa.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					
					listaCasas.add(casa);
				}	
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				// cerramos la conexion
				conexion.desconectar();
			}
		
		
		return listaCasas;
    }
 
    /**
     * Método buscarApartamentoPorCodCiudad = busca la lista de apartamentos en función de la ciudad seleccionada por el usuario.
     * @param codCiudadSeleccionada
     * @return
     */
    public ArrayList<Apartamento> buscarApartamentoPorCodCiudad(int codCiudadSeleccionada) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT Cod_alojamiento, Nombre_alojamiento, N_habitaciones, Nombre_ubicacion, Precio_alojamiento, Piso FROM `alojamiento`, `ciudad` where ciudad.Cod_ubicacion=alojamiento.Cod_ubicacion and alojamiento.Cod_ubicacion = ? and alojamiento.Cod_tipo = ?";
		ArrayList<Apartamento> listaApartamentos = new ArrayList<Apartamento>(); 
		
		Apartamento apartamento;
			try {
				// Abrimos una conexion
				connection = conexion.conectar();
						
				// preparamos la consulta SQL a la base de datos
				ps = connection.prepareStatement(query);
				ps.setInt(1, codCiudadSeleccionada);
				//en el futuro pasar por parámetro codTipoAlojSeleccionado
				ps.setInt(2, 30);
						
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				rs = ps.executeQuery();
						
				// crea objetos Linea con los resultados y los añade a un arrayList
				while (rs.next()) {
					apartamento = new Apartamento();
					apartamento.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
					apartamento.setNombre(rs.getString("Nombre_alojamiento"));
					
					apartamento.setUbicacion(rs.getString("Nombre_ubicacion"));
					apartamento.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					apartamento.setPiso(rs.getInt("Piso"));
					
					listaApartamentos.add(apartamento);
				}	
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				// cerramos la conexion
				conexion.desconectar();
			}
		
		
		return listaApartamentos;
    }
    
    /**
     * Método buscarHabitacionPorCodigoHotel = busca las habitaciones del hotel seleccionado por el usuario.
     * @param hotel = contiene los datos del hotel seleccionado por el usuario.
     * @param codHotelSeleccionado = es el código del hotel que el usuario ha seleccionado.
     * @return
     */
    public ArrayList<Dormitorio> buscarHabitacionPorCodigoHotel(Hotel hotel, int codHotelSeleccionado) {
    	ArrayList<Dormitorio> listaHabitacion = new ArrayList<Dormitorio>(); 
    	Dormitorio habitacion;
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
    			habitacion = new Dormitorio(); 
    			habitacion.setCodHabitacion(rs.getInt("Cod_habitacion"));
    			//habitacion.setAlojamiento(hotel);
    			habitacion.setNombreHabitacion(rs.getString("Nombre_habitacion"));
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			habitacion.setPrecioHabitacion(rs.getFloat("Precio_hab"));
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
    
  /**
   * buscarHabitacionDisponiblel = busca las habitaciones disponibles para el hotel seleccionado en las fechas seleccionadas.
   * @param fechaIda
   * @param fechaVuelta
   * @param codHotelSeleccionado
   * @return
   */
    public ArrayList<Dormitorio> buscarHabitacionDisponiblel(Date fechaIda, Date fechaVuelta, int codHotelSeleccionado) {
    	ArrayList<Dormitorio> listaHabDisp = new ArrayList<Dormitorio>(); 
    	Dormitorio habitacion;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT Cod_habitacion,Nombre_habitacion, Tipo_Habitacion, Tamanio, Precio_hab FROM `habitaciones` WHERE Cod_alojamiento=? AND Cod_habitacion NOT IN(SELECT habitaciones.Cod_habitacion FROM `habitaciones`, `reservas` where habitaciones.Cod_habitacion=reservas.Cod_habitacion AND habitaciones.Cod_alojamiento=? AND ((Fecha_entrada <= ? AND Fecha_salida >= ?) OR Fecha_salida BETWEEN ? AND ? OR Fecha_entrada BETWEEN ? AND ?));";
    	
    	try { 
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codHotelSeleccionado);
    		ps.setInt(2, codHotelSeleccionado);
    		ps.setDate(3, fechaIda);
    		ps.setDate(4, fechaVuelta);
    		ps.setDate(5, fechaIda);
    		ps.setDate(6, fechaVuelta);
    		ps.setDate(7, fechaIda);  
    		ps.setDate(8, fechaVuelta);
    		
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    
    		// crea objetos Linea con los resultados y los añade a un arrayList
    		while (rs.next()) {
    			habitacion = new Dormitorio(); 
    			habitacion.setCodHabitacion(rs.getInt("Cod_habitacion"));
    			habitacion.setNombreHabitacion(rs.getString("Nombre_habitacion"));
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			habitacion.setPrecioHabitacion(rs.getFloat("Precio_hab"));
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
    
    /**
     * Método buscarNumCamasPorCodHab = busca el número de camas que tiene la habitación
     * @param codHabitacion
     * @return
     */
    public int buscarNumCamasPorCodHab(int codHabitacion) {
    	int numCamas = -1;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT count(Cod_Cama) FROM `camas` WHERE Cod_habitacion=?;";
    	
    	try { 
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codHabitacion);
    		
    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
    		rs = ps.executeQuery();
    
    		// mete en la variable el resultado obtenido en la select
    		while (rs.next()) {
    			numCamas = rs.getInt(1);
    		}
    				
    		} 
    	catch (SQLException e) {
    			e.printStackTrace();
    		} 
    		finally {
    			// cerramos la conexion
    			conexion.desconectar();
    		}
    	return numCamas;
    }
    
    /**
     * Método buscarSiAlojDisponible = verifica si el alojamiento está disponible para las fechas seleccionadas.
     * @param fechaIda
     * @param fechaVuelta
     * @param codAlojSeleccionado
     * @return
     */
    public boolean buscarSiAlojDisponible(Date fechaIda, Date fechaVuelta, int codAlojSeleccionado) {
    	PreparedStatement ps = null;
		ResultSet result = null;
    	int countCodaloj = -1;
    	boolean disponible = false;
    	
    	//probar la selec
    	String query = "SELECT count(Cod_alojamiento) FROM `reservas` where Cod_alojamiento=? AND ((Fecha_entrada <= ? AND Fecha_salida >= ?) OR Fecha_salida BETWEEN ? AND ? OR Fecha_entrada BETWEEN ? AND ?);";
    	try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codAlojSeleccionado);
    		ps.setDate(2, fechaIda);
    		ps.setDate(3, fechaVuelta);
    		ps.setDate(4, fechaIda);
    		ps.setDate(5, fechaVuelta);
    		ps.setDate(6, fechaIda);  
    		ps.setDate(7, fechaVuelta);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = ps.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				countCodaloj = result.getInt(1);
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
    	
    	if(countCodaloj == 0) {
    		disponible = true;
    	}
    	else if (countCodaloj > 0) {
    		disponible = false;
    	}
    	
    	return disponible;
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
    
    		// crea objetos Linea con los resultados y los añade a un arrayList
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
			
			// crea objetos con los resultados y los añade a un arrayList
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
			
			// mete en la variable el resultado obtenido en la select
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
			
			// crea objetos con los resultados y los añade a un arrayList
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
			
			// crea objetos con los resultados y los añade a un arrayList
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
    
    /**
	 * Inserta los atributos de un objeto reserva en la base de datos
	 * 
	 * @param reserva Objeto reserva que se quiere introducir en la base de datos
	 * 
	 * @return Retorna el codigo de la reserva, generado de manera aleatoria
	 */
	public void insertarReserva(ArrayList<Reserva> listaReservas, int pos, String dni, Date fechaIda, Date fechaVuelta) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva = 0; 
		
		String query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento,Cod_habitacion, Precio_reserva, Dni, Fecha_entrada, Fecha_salida) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// añadimos los valores a insertar
			stmt.setInt(1, listaReservas.get(pos).getCodReserva());
			stmt.setInt(2, 1);
			//puede haber varias habitaciones, se le pasará por parámetro a insertarReserva un pos i. 
			//insertarReserva estará dentro de un for (int i; listaHabSeleccionadas.size(); i++), así se insertatrán las reservas de todas lashabitaciones seleecionadas.
			stmt.setInt(3,listaReservas.get(pos).getHabitacion().getCodHabitacion());
			stmt.setFloat(4, listaReservas.get(pos).getPrecioReserva());
			stmt.setString(5, dni);
			stmt.setDate(6, fechaIda);
			stmt.setDate(7, fechaVuelta);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
			/*result = stmt.getGeneratedKeys();
			result.next();
			codReserva = result.getInt(1);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
	}

public void insertarReservaCasaApart(Reserva reserva, String dni, Date fechaIda, Date fechaVuelta) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva = 0; 
		
		String query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento, Precio_reserva, Dni, Fecha_entrada, Fecha_salida) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// añadimos los valores a insertar
			stmt.setInt(1, reserva.getCodReserva());
			stmt.setInt(2,reserva.getAlojamiento().getCodAlojamiento());
			stmt.setFloat(3, reserva.getPrecioReserva());
			stmt.setString(4, dni);
			stmt.setDate(5, fechaIda);
			stmt.setDate(6, fechaVuelta);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
			/*result = stmt.getGeneratedKeys();
			result.next();
			codReserva = result.getInt(1);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
	}

}