package conexion;

//se importan las librerias que se requieren para la conexion de la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String URL = "jdbc:mysql://localhost:3306/gestioneventos";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Oscar1032404916";
    private static Connection conexion;

    public static  Connection obtenerConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
                System.out.println("Conexion exitosa a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el driver de Mysql");
            System.out.println("Detalle: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error al conectarse con la base de datos");
            System.out.println("Detalle: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion == null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion " + e.getMessage());

        }
    }
    public static boolean probarConexion(){
    Connection conn= obtenerConexion();
    return conn !=null;
    }

}
