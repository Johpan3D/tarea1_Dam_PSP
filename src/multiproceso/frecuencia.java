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
    public static void main(String[] args) throws IOException {
        // Lo primero que vamos hacer es recibir lo que el programa cadenas nos mande.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Creamos una variable String para pasarle el argumento que venga del otro programa.
        // Tendremos que añadir la excepción IOException.
        String entrada;
        // Leemos todas las líneas de entrada.
        while ((entrada = br.readLine()) != null) {
            // -----------------------------------------------------
            //System.out.println("El otro programa dice: " + entrada);
            //------------------------------------------------------
            // Dividimos el String en un array de palabras a través de la coma que configuré en el programa cadena
            String[] array = entrada.split(",");
            // Creamos un for-each y recorremos el array. es como poner String.lenth pero para el array
            for (String palabra: array) {
                // Creamos un nuevo array para la frecuencia.
                // Los números del 0 al 4 serán los indices de las vocales. 
                int[] frecuencia = new int[5];
                // Creamos un contador que recorra las palabras
                for(int i=0;i<palabra.length();i++){
                    // Vamos añadiendo a un nuevo caracter las posiciones de los indices
                    char caracter = palabra.charAt(i);
                    // Incrementamos el contador correspondiente si es una vocal.
                    // Ponemos los 5 casos en un Swith para incrementar cada uno.
                    switch (caracter) {
                        case 'a': frecuencia[0]++; break;
                        case 'e': frecuencia[1]++; break;
                        case 'i': frecuencia[2]++; break;
                        case 'o': frecuencia[3]++; break;
                        case 'u': frecuencia[4]++; break;
                    }
                }
                
                System.out.println("Cadena : " + palabra + " --> " + frecuencia[0] + "," + frecuencia[1] + "," + frecuencia[2] + "," + frecuencia[3] + "," + frecuencia[4]);
            }
        }
    }
}
