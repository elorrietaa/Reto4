
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
    
    public ArrayList<Hotel> buscarHotelPorCodCiudad(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String query) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		//En el futuro poner la select ordenada por precio
		
		
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
				
				System.out.println(query);
						
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				rs = ps.executeQuery();
						
				// crea objetos Linea con los resultados y los añade a un arrayList
				while (rs.next()) {
					hotel = new Hotel();
					hotel.setCodAlojamiento(rs.getInt("Cod_alojamiento"));
					hotel.setNombre(rs.getString("Nombre_alojamiento"));
					hotel.setDireccion(rs.getString("Direccion"));
					hotel.setTelefono(rs.getString("Telefono"));
					hotel.setUbicacion(rs.getString("Nombre_ubicacion"));
					hotel.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					//se rellena la popularidad del alojamiento
					hotel.setPopularidad(mostrarNumReservasDeUnAlojamiento(hotel.codAlojamiento));
					
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
    
    public ArrayList<Casa> buscarCasaPorCodCiudad(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String query) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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
					casa.setDireccion(rs.getString("Direccion"));
					casa.setTelefono(rs.getString("Telefono"));
					casa.setUbicacion(rs.getString("Nombre_ubicacion"));
					casa.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					//se rellena la popularidad del alojamiento
					casa.setPopularidad(mostrarNumReservasDeUnAlojamiento(casa.codAlojamiento));
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
    public ArrayList<Apartamento> buscarApartamentoPorCodCiudad(int codCiudadSeleccionada, int codTipoAlojSeleccionado, String query) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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
					apartamento.setDireccion(rs.getString("Direccion"));
					apartamento.setTelefono(rs.getString("Telefono"));
					apartamento.setUbicacion(rs.getString("Nombre_ubicacion"));
					apartamento.setPrecioAlojamiento(rs.getFloat("Precio_alojamiento"));
					apartamento.setPiso(rs.getInt("Piso"));
					//se rellena la popularidad del alojamiento
					apartamento.setPopularidad(mostrarNumReservasDeUnAlojamiento(apartamento.codAlojamiento));
					
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
     * Método buscarHabitacionPorCodigoAlojamiento = busca las habitaciones del hotel seleccionado por el usuario.
     * @param hotel = contiene los datos del hotel seleccionado por el usuario.
     * @param codHotelSeleccionado = es el código del hotel que el usuario ha seleccionado.
     * @return
     */
    public ArrayList<Habitacion> buscarHabitacionPorCodigoAlojamiento(Alojamiento alojamiento, int codHotelSeleccionado) {
    	ArrayList<Habitacion> listaHabitacion = new ArrayList<Habitacion>(); 
    	Habitacion habitacion;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT Cod_habitacion, Tipo_habitacion, Tamanio FROM `habitaciones`, `alojamiento` where habitaciones.Cod_alojamiento=alojamiento.Cod_alojamiento and alojamiento.Cod_alojamiento=?";
    	
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
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			
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
     * Método buscarHabitacionDormitorioPorCodigoAlojamiento = busca los dormitorios de un alojamiento por e código de alojamiento seleccionado. Devuelve un arrayList con la lista de dormitorios.
     * @param alojamiento
     * @param codHotelSeleccionado
     * @return
     */
    public ArrayList<Habitacion> buscarHabitacionDormitorioPorCodigoAlojamiento(Alojamiento alojamiento, int codHotelSeleccionado) {
    	ArrayList<Habitacion> listaHabitacion = new ArrayList<Habitacion>(); 
    	Habitacion habitacion;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT Cod_habitacion, Tipo_habitacion, Tamanio FROM `habitaciones`, `alojamiento` where habitaciones.Cod_alojamiento=alojamiento.Cod_alojamiento and alojamiento.Cod_alojamiento=? AND habitaciones.Tipo_habitacion = 'DORMITORIO'";
    	
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
    			habitacion.setTipoHabitacion(rs.getString("Tipo_Habitacion"));
    			habitacion.setTamanio(rs.getFloat("Tamanio"));
    			
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
     * Método buscarNumHabDeCadaTipo = busca el número de habitaciones de cada tipo que tiene el alojamiento en función del tipo que se le pase por parámetro
     * @param codHabitacion
     * @return
     */
    public int buscarNumHabDeCadaTipo(int codAloj, String tipoHabitacion) {
    	int numCamas = -1;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	String query = "SELECT count(*) FROM `habitaciones`, `alojamiento` where habitaciones.Cod_alojamiento=alojamiento.Cod_alojamiento and alojamiento.Cod_alojamiento=? and habitaciones.Tipo_habitacion=?;";
    	
    	try { 
    		// Abrimos una conexion
    		connection = conexion.conectar();
    				
    		// preparamos la consulta SQL a la base de datos
    		ps = connection.prepareStatement(query);
    		ps.setInt(1, codAloj);
    		ps.setString(2, tipoHabitacion);
    		
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
    
    /**
     * Método buscarCamaPorCodigoHabitacion = devuelve un arrayList que contiene las camas en función del codigo de habitacion que se le pasa por parámetro.
     * @param codHabitacionSeleccionada
     * @return
     */
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
   	/**
   	 * Método buscarClientePorDNI = devuelve los datos del Cliente en función del DNI que se le pasa por parámetro.
   	 * @param dni
   	 * @return
   	 */
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
   	/**
   	 * Método mostrarNumReservas = devuelve un int que contiene el número de reservas registradas en la BBDD
   	 * @return
   	 */
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
    
    /**
     * Método mostrarNumReservasConProcedimiento = devuelve un int que contiene el número de reservas registradas en la BBDD mediante un procedimiento
     * @return
     */
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
    
    /**
     * Método mostrarNumReservasDeUnAlojamiento = devuelve un int que contiene el número de reservas registradas en la BBDD para un alojamiento determinado
     * @param codAloj
     * @return
     */
    public int mostrarNumReservasDeUnAlojamiento(int codAloj ) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int ocupacion=0;
		
		String query = "SELECT count(*) FROM `reservas`,`alojamiento`  WHERE reservas.Cod_alojamiento=alojamiento.Cod_alojamiento and alojamiento.Cod_alojamiento=?";

		try {
			
		    // abrimos una conexion
		 	connection = conexion.conectar();
		 			
		 	// preparamos la consulta SQL a la base de datos
		 	stmt = connection.prepareStatement(query);
		 	stmt.setInt(1, codAloj);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
			    ocupacion = result.getInt(1);
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
		
		return ocupacion;
	}

    
    /****************************************************************************************************************
	 * 
	 * Metodos consultas fecha y hora actual
	 * 
	 ****************************************************************************************************************/
    /**
     * Método mostrarFechaActual = devuelve la fecha actual (tipo Date)
     * @return
     */
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
    /**
     * Método mostrarHoraActual = devuelve la hora actual
     * @return
     */
    public Date mostrarHoraActual() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		Date horaActual = null;
		
		String query = "SELECT DATE_FORMAT(NOW( ), \"%H:%i:%S\" );";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				horaActual = result.getDate(1);
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
		
		return horaActual;
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
    /*
	public void insertarReserva(ArrayList<Reserva> listaReservas, int pos, String dni, Date fechaIda, Date fechaVuelta) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codReserva = 0; 
		
		String query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento,Cod_habitacion, Precio_reserva, Dni, Fecha_entrada, Fecha_salida ,FechasBases, HoraBases) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
			
	//	} catch (SQLException e) {
		//	e.printStackTrace();
		//} finally {
		 //   try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		//}
		
	//} 
	 
	 /**
		 * Inserta los atributos de un objeto reserva en la base de datos
		 * 
		 * @param reserva Objeto reserva que se quiere introducir en la base de datos
		 * 
		 * @return Retorna el codigo de la reserva, generado de manera aleatoria
		 */
		public void insertar1Reserva(Reserva reserva, Dormitorio habitacion, ServiciosAdicionales servicios, String dni, Date fechaIda, Date fechaVuelta,Date fechaActual, String horaActual, float precioTotal) {
			
			PreparedStatement stmt = null;
			ResultSet result = null;
			int codReserva = 0; 
			String query;
			
			if(servicios != null)
				query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento, Cod_habitacion, Cod_serviciosCon , Precio_reserva, Dni, Fecha_entrada, Fecha_salida, Fecha_aceptabases, Hora_aceptabases) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			else
				query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento, Cod_habitacion, Precio_reserva, Dni, Fecha_entrada, Fecha_salida, Fecha_aceptabases, Hora_aceptabases) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				
				// abrimos una conexion
				connection = conexion.conectar();
				
				// preparamos la consulta INSERT
				stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				
				// añadimos los valores a insertar
				stmt.setInt(1, reserva.getCodReserva());
				stmt.setInt(2, reserva.getAlojamiento().getCodAlojamiento());
				//puede haber varias habitaciones, se le pasará por parámetro a insertarReserva un pos i. 
				//insertarReserva estará dentro de un for (int i; listaHabSeleccionadas.size(); i++), así se insertatrán las reservas de todas lashabitaciones seleecionadas.
				stmt.setInt(3, habitacion.getCodHabitacion());
				if(servicios != null) {
					stmt.setInt(4, servicios.getCodServiciosContratados());
					stmt.setFloat(5, precioTotal);
					stmt.setString(6, dni);
					stmt.setDate(7, fechaIda);
					stmt.setDate(8, fechaVuelta);
					stmt.setDate(9, fechaActual);
					stmt.setString(10, horaActual);
				}
				else {
					stmt.setFloat(4, precioTotal);
					stmt.setString(5, dni);
					stmt.setDate(6, fechaIda);
					stmt.setDate(7, fechaVuelta);
					stmt.setDate(8, fechaActual);
					stmt.setString(9, horaActual);
				}
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

		/**
		 * Método insertarReservaCasaApart = inserta los atributos del objeto reserva en la BBDD
		 * @param reserva
		 * @param dni
		 * @param fechaIda
		 * @param fechaVuelta
		 * @param fechaActual
		 * @param horaActual
		 * @param precioTotal
		 */
		public void insertarReservaCasaApart(Reserva reserva, ServiciosAdicionales servicios, String dni, Date fechaIda, Date fechaVuelta, Date fechaActual,String horaActual, float precioTotal) {
		
			PreparedStatement stmt = null;
			ResultSet result = null;
			int codReserva = 0;
			String query;
			
			if(servicios != null)
				query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento, Cod_serviciosCon Precio_reserva, Dni, Fecha_entrada, Fecha_salida, Fecha_aceptabases, Hora_aceptabases) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			else
				query = "INSERT INTO reservas (Cod_reserva, Cod_alojamiento, Precio_reserva, Dni, Fecha_entrada, Fecha_salida, Fecha_aceptabases, Hora_aceptabases) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
			try {
				
				// abrimos una conexion
				connection = conexion.conectar();
				
				// preparamos la consulta INSERT
				stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				
				// añadimos los valores a insertar
				stmt.setInt(1, reserva.getCodReserva());
				stmt.setInt(2,reserva.getAlojamiento().getCodAlojamiento());
				if(servicios != null) {
					stmt.setInt(3, servicios.getCodServiciosContratados());
					stmt.setFloat(4, precioTotal);
					stmt.setString(5, dni);
					stmt.setDate(6, fechaIda);
					stmt.setDate(7, fechaVuelta);
					stmt.setDate(8, fechaActual);
					stmt.setString(9, horaActual);
				}
				else {
					stmt.setFloat(3, precioTotal);
					stmt.setString(4, dni);
					stmt.setDate(5, fechaIda);
					stmt.setDate(6, fechaVuelta);
					stmt.setDate(7, fechaActual);
					stmt.setString(8, horaActual);
				}
				
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
		
		/**
		 * Método insertarPersonasAlojadas = inserta la lista de persnas alojadas ( con los datos encriptados) en la BBDD
		 * @param lista = el método recive la lista de personas Alojadas
		 * @param reserva = el método recive el objeto reserva
		 */
		public void insertarPersonasAlojadas(ArrayList<Cliente> lista, Reserva reserva) {
			
			PreparedStatement stmt = null;
			ResultSet result = null;
			int codPersona = 0; 
			
			String query = "INSERT INTO personasAlojadas (Cod_personaAlojada, Dni, Nombre, Apellidos, Cod_reserva) VALUES (?, ?, ?, ?, ?)";

			try {
				
				// abrimos una conexion
				connection = conexion.conectar();
				
				// preparamos la consulta INSERT
				stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				for(int i = 0; i < lista.size(); i++) {
					// añadimos los valores a insertar
					codPersona = mostrarNumPersonasAlojadas() + 1;
					stmt.setInt(1, codPersona);
					stmt.setString(2, lista.get(i).getDni());
					//puede haber varias habitaciones, se le pasará por parámetro a insertarReserva un pos i. 
					//insertarReserva estará dentro de un for (int i; listaHabSeleccionadas.size(); i++), así se insertatrán las reservas de todas lashabitaciones seleecionadas.
					stmt.setString(3, lista.get(i).getNombre());
					stmt.setString(4, lista.get(i).getApellidos());
					stmt.setInt(5, reserva.getCodReserva());
					
					// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
					stmt.executeUpdate();
				}
				
				/*result = stmt.getGeneratedKeys();
				result.next();
				codReserva = result.getInt(1);*/
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
			}
		}
		
		/**
		 * Método mostrarNumPersonasAlojadas = devuelve el número de personas alojadas
		 * @return
		 */
		public int mostrarNumPersonasAlojadas() {
			
			PreparedStatement stmt = null;
			ResultSet result = null;
			int personasAlojadas =0;
			
			String query = "SELECT count(*) FROM `personasalojadas`";

			try {
				
				// abrimos una conexion
				connection = conexion.conectar();
				
				// preparamos la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				result = stmt.executeQuery();
				
				// mete en la variable el resultado obtenido en la select
				while (result.next()) {
					personasAlojadas = result.getInt(1);
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
			
			return personasAlojadas;
		}
		
		/**
		 * Método buscarPrecioMinimoDeLaHabitacionDelHotel = devuelve el menor precio que tiene una habitación en un hotel
		 * @param codAlojSeleccionado = se pasa por parámetro el código del alojamiento seleccionado por el usuario
		 * @return precioMinimo = se devuelve el precio mínimo (más bajo) que tiene una habitacion de ese alojamiento.
		 */
		public float buscarPrecioMinimoDeLaHabitacionDelHotel(int codAlojSeleccionado) {
			PreparedStatement stmt = null;
			ResultSet result = null;
			float precioMinimoDeLaHabitacionDelHotel = 0;
			
			String query = "select ROUND(Min(Precio_hab),2) from `habitaciones`,`alojamiento` where habitaciones.Cod_alojamiento = alojamiento.Cod_alojamiento AND alojamiento.cod_alojamiento = ? ";

			try {
				
				// abrimos una conexion
				connection = conexion.conectar();
				
				// preparamos la consulta SQL a la base de datos
				stmt = connection.prepareStatement(query);
				stmt.setInt(1, codAlojSeleccionado);
				// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
				result = stmt.executeQuery();
				
				// crea objetos con los resultados y los añade a un arrayList
				while (result.next()) {
					precioMinimoDeLaHabitacionDelHotel = result.getFloat(1);
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
			
			return precioMinimoDeLaHabitacionDelHotel;
			
		}
		
		/**
		 * Método buscarCodigosPromocionalesPorDni = se buscan los códigos promocionales que posee un cliente determinado para un alojamiento determinado
		 * @param codAlojamiento = Se le pasa por parámetro el código del alojamiento, para que compruebe los códigos que tiene ese alojamiento
		 * @param dni = se le pasa por parámetro el DNI del cliente, para que compruebe si el cliente tiene códigos promocionales.
		 * @return listacodigosPromocionales = se devuelve una lista de códigos promocionales de ese cliente para ese alojamiento
		 */
		 public ArrayList<CodigoPromocional> buscarCodigosPromocionalesPorDni(int codAlojamiento, String dni) {
		    	ArrayList<CodigoPromocional> listacodigosPromocionales = new ArrayList<CodigoPromocional>(); 
		    	CodigoPromocional codigoProm;
		    	PreparedStatement ps = null;
		    	ResultSet rs = null;
		    	
		    	String query = "select * FROM `codigospromocionales` WHERE dni=? AND codigospromocionales.Cod_alojamiento=?";

		    	//String query = "select Cod_promocional, DescuentoPorcentaje FROM `codigospromocionales` ";
		    			
		    	
		    	try {
		    		// Abrimos una conexion
		    		connection = conexion.conectar();
		    				
		    		// preparamos la consulta SQL a la base de datos
		    		ps = connection.prepareStatement(query);
		    		ps.setString(1, dni);
		    		ps.setInt(2, codAlojamiento);
		    		
		    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		    		rs = ps.executeQuery();
		    
		    		// crea objetos Linea con los resultados y los añade a un arrayList
		    		while (rs.next()) {
		    			codigoProm = new CodigoPromocional(); 
		    			codigoProm.setCod_promocional(rs.getString("Cod_promocional"));
		    			codigoProm.setCod_alojamiento(rs.getInt("Cod_alojamiento"));
		    			codigoProm.setDni(rs.getString("Dni"));
		    			codigoProm.setDescuento(rs.getFloat("DescuentoPorcentaje"));
		    			
		    			listacodigosPromocionales.add(codigoProm);
		    		} 
		    				
		    		} 
		    	catch (SQLException e) {
		    			e.printStackTrace();
		    		} 
		    		finally {
		    			// cerramos la conexion
		    			conexion.desconectar();
		    		}
		    	System.out.println("SALE LA LISTA DE CODIGOS PROMOCIONALES");
		    	return listacodigosPromocionales;
		 }

		 /**
		 * Método buscarCodigosPromocionalesSoloPorDni = se buscan todos los códigos promocionales que posee un cliente determinado 
		 * @param dni = se le pasa por parámetro el DNI del cliente, para que compruebe si el cliente tiene códigos promocionales.
		 * @return listacodigosPromocionales = se devuelve una lista de todos códigos promocionales de ese cliente
		 */
		 public ArrayList<CodigoPromocional> buscarCodigosPromocionalesSoloPorDni( String dni) {
		    	ArrayList<CodigoPromocional> listacodigosPromocionales = new ArrayList<CodigoPromocional>(); 
		    	CodigoPromocional codigoProm;
		    	PreparedStatement ps = null;
		    	ResultSet rs = null;
		    	
		    	String query = "select * FROM `codigospromocionales` WHERE dni=?";

		    	//String query = "select Cod_promocional, DescuentoPorcentaje FROM `codigospromocionales` ";
		    			
		    	
		    	try {
		    		// Abrimos una conexion
		    		connection = conexion.conectar();
		    				
		    		// preparamos la consulta SQL a la base de datos
		    		ps = connection.prepareStatement(query);
		    		ps.setString(1, dni);
		    		
		    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		    		rs = ps.executeQuery();
		    
		    		// crea objetos Linea con los resultados y los añade a un arrayList
		    		while (rs.next()) {
		    			codigoProm = new CodigoPromocional(); 
		    			codigoProm.setCod_promocional(rs.getString("Cod_promocional"));
		    			codigoProm.setCod_alojamiento(rs.getInt("Cod_alojamiento"));
		    			codigoProm.setDni(rs.getString("Dni"));
		    			codigoProm.setDescuento(rs.getFloat("DescuentoPorcentaje"));
		    			
		    			listacodigosPromocionales.add(codigoProm);
		    		} 
		    				
		    		} 
		    	catch (SQLException e) {
		    			e.printStackTrace();
		    		} 
		    		finally {
		    			// cerramos la conexion
		    			conexion.desconectar();
		    		}
		    	System.out.println("SALE LA LISTA DE CODIGOS PROMOCIONALES");
		    	return listacodigosPromocionales;
		 }
		 
		 /**
		  * Método eliminarCodigoPromocionalAplicado = se elimina el código promocional que se ha aplicado de la BBDD
		  * @param codPromocionalSeleccionado = se pasa por parámetro el código pormocional seleccionado por el usuario
		  */
		 public void eliminarCodigoPromocionalAplicado( String codPromocionalSeleccionado) {
		    
		    	PreparedStatement ps = null;
		    	
		    	
		    	String query = "DELETE FROM `codigospromocionales` WHERE `Cod_promocional`=?";

		
		    	try {
		    		// Abrimos una conexion
		    		connection = conexion.conectar();
		    				
		    		// preparamos la consulta SQL a la base de datos
		    		ps = connection.prepareStatement(query);
		    		ps.setString(1, codPromocionalSeleccionado);
		    		
		    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		    		ps.execute();
		    
		    				
		    		} 
		    	catch (SQLException e) {
		    			e.printStackTrace();
		    		} 
		    		finally {
		    			// cerramos la conexion
		    			conexion.desconectar();
		    		}
		    	
		 }
		 
		 /**
		  * Método buscarServiciosAdicionales = se muestran los servicios adicionales de un alojamiento
		  * @param codAlojamiento = Se le pasa por parámetro el código del alojamiento
		  * @return sA= devuelve un objeto sA del tipo ServiciosAdicionales.
		  */
		 public ServiciosAdicionales buscarServiciosAdicionales(int codAlojamiento) {
			 
			 	PreparedStatement ps = null;
		    	ResultSet rs = null;
		    	ServiciosAdicionales sA = null;
		    	String query = "select Cod_servicio,Wifi,Precio_Wifi,Aire,Precio_aire,"
		    			+ " Piscina, Precio_piscina, Spa, Precio_spa,"
		    			+ " Gimnasio, Precio_gimnasio, Parking, Precio_parking,"
		    			+ " Restaurante, Bar FROM `servicios` WHERE cod_alojamiento=?";
		    	
		    	try {
		    		// Abrimos una conexion
		    		connection = conexion.conectar();
		    				
		    		// preparamos la consulta SQL a la base de datos
		    		ps = connection.prepareStatement(query);
		    		ps.setInt(1, codAlojamiento);
		    		
		    		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
		    		rs = ps.executeQuery();
		    
		    		// crea objetos Linea con los resultados y los añade a un arrayList
		    		while (rs.next()) {
		    			sA = new ServiciosAdicionales(rs.getInt("Cod_servicio"), codAlojamiento, rs.getInt("Wifi"),rs.getFloat("Precio_Wifi"),rs.getInt("Aire"),rs.getFloat("Precio_aire"),rs.getInt("Piscina"),rs.getFloat("Precio_piscina"),rs.getInt("Spa"),rs.getFloat("Precio_spa"),rs.getInt("Gimnasio"),rs.getFloat("Precio_gimnasio"),rs.getInt("Parking"),rs.getFloat("Precio_parking"),rs.getInt("Restaurante"),rs.getInt("Bar")); 
		    		}
		    	} 
		    	catch (SQLException e) {
		    			e.printStackTrace();
		    		} 
		    		finally {
		    			// cerramos la conexion
		    			conexion.desconectar();
		    		}
		    	
			 return sA;
			 
		 }
		 
		 public int conseguirCodServicios() {
				
				PreparedStatement stmt = null;
				ResultSet result = null;
				int codServicios=0;
				
				String query = "SELECT count(*) FROM `serviciosseleccionados`";

				try {
					
					// abrimos una conexion
					connection = conexion.conectar();
					
					// preparamos la consulta SQL a la base de datos
					stmt = connection.prepareStatement(query);
					
					// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
					result = stmt.executeQuery();
					
					// mete en la variable el resultado obtenido en la select
					while (result.next()) {
						codServicios = result.getInt(1);
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
				
				return codServicios;
			}
		 public void insertarServiciosContratados(ServiciosAdicionales servicios) {
				
				PreparedStatement stmt = null;
				ResultSet result = null;
				int codReserva = 0;
				String query;
				
				query = "INSERT INTO servicioscontratados (Cod_serviciosCon, Cod_servicio, Wifi, Aire, Piscina, Spa, Gimnasio, Parking) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				
				try {
					
					// abrimos una conexion
					connection = conexion.conectar();
					
					// preparamos la consulta INSERT
					stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
					
					// añadimos los valores a insertar
					stmt.setInt(1, servicios.getCodServiciosContratados());
					stmt.setInt(2, servicios.getCodServicios());
					stmt.setBoolean(3, servicios.isWifiSeleccionado());
					stmt.setBoolean(4, servicios.isAireSeleccionado());
					stmt.setBoolean(5, servicios.isPiscinaSeleccionada());
					stmt.setBoolean(6, servicios.isSpaSeleccionado());
					stmt.setBoolean(7, servicios.isGimnasioSeleccionado());
					stmt.setBoolean(8, servicios.isParkingSeleccionado());
					
					// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
					stmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
				    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
				}
			
			}
}