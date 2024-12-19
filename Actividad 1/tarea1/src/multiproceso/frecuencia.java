/*
 * Implementa una aplicación, llamada ´frecuencia´, que dada una cadena de texto recibida a través de la 
 * tubería obtenga la frecuencia absoluta de cada una de las vocales, es decir, la cantidad de veces que 
 * aparece cada vocal. En el caso de que una de las vocales no aparezca la frecuencia será 0. 
 * Por ejemplo: para la palabra “caramelo” el resultado debe ser 2 1 0 1 0.
 */
package multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class frecuencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos un array de enteros para las posiciones de las vocales en las cadenas.
        int[] frecuencias = new int[5]; 
        // Recibimos la cadena a través de la tubería.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // Y leemos la línea de entrada.
            String input = br.readLine();

            // Convertimos toda la cadena en minúsculas.
            input = input.toLowerCase();

            // Contamos la frecuecia de vocales con este Switch-case.
            for (char c : input.toCharArray()) {
                switch (c) {
                    case 'a':
                        frecuencias[0]++;
                        break;
                    case 'e':
                        frecuencias[1]++;
                        break;
                    case 'i':
                        frecuencias[2]++;
                        break;
                    case 'o':
                        frecuencias[3]++;
                        break;
                    case 'u':
                        frecuencias[4]++;
                        break;
                }
            }

            // Imprimimos la frecuencia de vocales.
            System.out.printf("%d %d %d %d %d\n", frecuencias[0], frecuencias[1], frecuencias[2], frecuencias[3], frecuencias[4]);

            // Capturamos las excepciones.
        } catch (IOException e) {
            System.err.println("Error al leer la entrada: " + e.getMessage());
        }
    }
}
