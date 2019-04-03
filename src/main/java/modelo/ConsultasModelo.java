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
	Ciudad ciudad =new Ciudad();
	PreparedStatement ps = null;
	ResultSet rs=null;
	String query=" SELECT * FROM `ciudad`";
	try {
	//    connection=conexion.conectar();
	    ps=connection.prepareStatement(query);
	    rs=ps.executeQuery();
	    
	}catch(SQLException e){
	    e.printStackTrace();
	}
	return listaCiudades;
    }
}
