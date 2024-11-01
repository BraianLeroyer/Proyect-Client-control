
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
        private static String usuario = "postgres";
        private static String contraseña = "1234";
        private static String host = "localhost";
        private static int puerto = 5432;
        private static String baseDatos = "control_cliente";
       
        public static Connection getConnection() throws SQLException {
        // Crea una cadena de conexión con los parámetros especificados
        String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;
        Properties props = new Properties();
        props.setProperty("user", usuario);
        props.setProperty("password", contraseña);

        // Establece la conexión
        return DriverManager.getConnection(url, props);
    }
        public static void close (ResultSet rs) throws SQLException{
            rs.close();
    }
      
        public static void close (PreparedStatement ps) throws SQLException{
            ps.close();
    }
        
        public static void connection(Connection cn) throws SQLException{
            cn.close();
    }
        
        
        
}
        
    
