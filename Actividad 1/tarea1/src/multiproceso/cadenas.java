 /*
 * Primera parte. Implementa una aplicación, llamada ´cadenas´, que genere cadenas formadas por 
 * caracteres del alfabeto (a-z). La cantidad de cadenas será indicada por el usuario al ejecutar 
 * la aplicación y su longitud será aleatoria (máximo 10 caracteres). Las cadenas se deben escribir 
 * mediante tubería establecida con la aplicación 'frecuencia'.
 */
package multiproceso;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class cadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Como el número de cadenas se va a dar como argumento, el programa verificará que se da. En caso contrario, el programa terminará.
        if (args.length < 1) { // En caso que los argumentos sean menores a 1 el programa termina.
            System.out.println("Por favor, proporciona la cantidad de cadenas a generar.");
            // Fin de programa.
            System.exit(1);
        }
        int cantidadCadenas; // Creamos una variable entera de la cantidad de cadenas.

        try {
            // Parseamos el String de número de cadenas pasado por argumento, para igualarlo al entero creado y poder hacer la comparación. Y ver que el requisito sea cumplido. 
            cantidadCadenas = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            // En caso contrario advertimos al usuario que el argumento debe ser un número entero (int).
            System.out.println("El argumento debe ser un número entero.");
            // Inicializamos la cantidadCadenas.
            return;
        }
        // Creamos un número aleatorio.
        Random random = new Random();
        try (OutputStream os = System.out; PrintWriter writer = new PrintWriter(os)) {
            // Bucle for que genera cadenas. De manera aleatoria y como máximo de 10 caracteres.
            for (int i = 0; i < cantidadCadenas; i++) {
                int longitud = random.nextInt(10) + 1;  
                StringBuilder cadena = new StringBuilder(longitud);
            // Bucle en el que solo usaremos los 26 caracteres del abecedario en minúscula. 
                for (int j = 0; j < longitud; j++) {
                    char c = (char) ('a' + random.nextInt(26));
                    cadena.append(c);
                }
                // Imprimimos la/las cadenas generadas.
                writer.println(cadena);
            }

        }
    }
}
