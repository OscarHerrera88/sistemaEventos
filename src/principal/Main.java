
package principal;

import conexion.ConexionBD;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba de conexion");
    if(ConexionBD.probarConexion()){
        System.out.println("La conexion se realizo correctamente");
    }else{
        System.out.println("No fue posible conectarse");
    }
    ConexionBD.cerrarConexion();
    }
    
    
}
