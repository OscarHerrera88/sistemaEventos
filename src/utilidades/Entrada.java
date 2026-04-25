
package utilidades;

import java.util.Scanner;


public class Entrada {
    private static final Scanner teclado= new Scanner(System.in);

    public static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return teclado.nextLine().trim();
        
    }
    
    public static int leerEntero(String mensaje) {
        while(true){
        try{
          System.out.println(mensaje);
          return  Integer.parseInt(teclado.nextLine().trim());
        }catch(NumberFormatException e){
            System.out.println("Error debe ingresar un numero entero");
        }
        }
    }
public static double leerDouble(String mensaje) {
        while(true){
        try{
          System.out.println(mensaje);
          return  Double.parseDouble(teclado.nextLine().trim());
        }catch(NumberFormatException e){
            System.out.println("Error debe ingresar un numero entero");
        }
        }
    }
}
