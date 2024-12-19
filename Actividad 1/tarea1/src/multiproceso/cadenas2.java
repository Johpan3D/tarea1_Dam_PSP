/*
 * Para generar palabras parecidas al español y que no salgan combinaciones extrañas de muchas consonantes seguidas, podéis utilizar un array de sílabas de dos o tres letras que siempre contengan una vocal:
 * String[] SILABAS = {"ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu", "da"........, "zo", "zu"}
 * Cuanto más completo creéis el array, más combinaciones posibles. Lo normal es que se generen cadenas 
 * que no tengan ningún significado pero que si tengan un parecido al español.
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
public class cadenas2 {

    // Array de sílabas que siempre contiene al menos una vocal, para que las palabras suenen naturales
    private static final String[] SILABAS = {
        "ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu",
        "da", "de", "di", "do", "du", "fa", "fe", "fi", "fo", "fu",
        "ga", "ge", "gi", "go", "gu", "ja", "je", "ji", "jo", "ju",
        "la", "le", "li", "lo", "lu", "ma", "me", "mi", "mo", "mu",
        "na", "ne", "ni", "no", "nu", "pa", "pe", "pi", "po", "pu",
        "ra", "re", "ri", "ro", "ru", "sa", "se", "si", "so", "su",
        "ta", "te", "ti", "to", "tu", "va", "ve", "vi", "vo", "vu",
        "ya", "ye", "yi", "yo", "yu", "za", "ze", "zi", "zo", "zu"};

    public static void main(String[] args) throws IOException {
        // Verificación de argumentos
        if (args.length < 1) {
            System.out.println("Por favor, proporciona la cantidad de cadenas a generar.");
            System.exit(1);
        }
        int cantidadCadenas;
        try {
            cantidadCadenas = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("El argumento debe ser un número entero.");
            return;
        }

        Random random = new Random();
        try (OutputStream os = System.out; PrintWriter writer = new PrintWriter(os)) {
            // Bucle para generar las cadenas de forma aleatoria
            for (int i = 0; i < cantidadCadenas; i++) {
                int longitud = random.nextInt(10) + 1;  // Longitud aleatoria de hasta 10 caracteres
                StringBuilder cadena = new StringBuilder();

                // Construcción de la cadena con sílabas
                while (cadena.length() < longitud) {
                    String silaba = SILABAS[random.nextInt(SILABAS.length)];
                    if (cadena.length() + silaba.length() <= longitud) {
                        cadena.append(silaba);
                    }
                }
                writer.println(cadena.toString());
            }
        }
    }
}   
