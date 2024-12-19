 /*
 * Primera parte. Implementa una aplicación, llamada ´cadenas´, que genere cadenas formadas por 
 * caracteres del alfabeto (a-z). La cantidad de cadenas será indicada por el usuario al ejecutar 
 * la aplicación y su longitud será aleatoria (máximo 10 caracteres). Las cadenas se deben escribir 
 * mediante tubería establecida con la aplicación 'frecuencia'.
 */
package multiproceso;

import java.util.Random;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class cadenas {

    public static void main(String[] args) {
        //---------------------------------------------------------------------
        // Con este bucle if tenemos que capturar el parámetro de args que irá cuando se ejecute en el cmd.
        if (args.length < 1) {
            System.exit(1);
        }
        //---------------------------------------------------------------------
        // Creamos esta variable booleana para seguir pidiendo el número en caso que ingresen algo que no sea un número.
        boolean estado = true;
        // hacemos que el sistema nos pida la cadena.
        //Scanner sc = new Scanner(System.in);
        // Bucle while que no acabará hasta que ingresemos un número correcto. En el que la condición sea el estado, que en principio creará un bucle, que mientras estado sea verdadero no terminará. 
        while (estado) {
            try {
                // Como el número de cadenas se va a dar como argumento, el programa verificará que se da. En caso contrario, el programa terminará.
                // Pedimos al usuario que ingrese las cadenas.
                //System.out.println("Por favor ingrese el número de cadenas a generar");
                // Leemos la cadena y la metemos en un String
                //String cadena = sc.nextLine();
                // Parseamos la cadena a entero para filtrar que sea un número y no otro caracter. 
                //int numeroCadenas = Integer.parseInt(cadena);
                int numeroCadenas = Integer.parseInt(args[0]);
                // Falseamos el estado si llegamos hasta el String para salir del bucle.
                // Solo llegará aquí en caso que se pueda parsear el String.
                // También si el número negativo o 0 volverá a activar el bucle while.
                if (numeroCadenas > 0) {
                    estado = false;
                }
                // Creamos un String[] de las letras a recorrer.
                String[] letras = {"ba", "be", "bi", "bo", "bu", "ca", "ce", "ci", "co", "cu", "da", "de", "di", "do", "du", "fa", "fe", "fi", "fo", "fu", "ga", "ge", "gi", "go", "gu", "ja", "je", "ji", "jo", "ju", "la", "le", "li", "lo", "lu", "ma", "me", "mi", "mo", "mu", "na", "ne", "ni", "no", "nu", "pa", "pe", "pi", "po", "pu", "ra", "re", "ri", "ro", "ru", "sa", "se", "si", "so", "su", "ta", "te", "ti", "to", "tu", "va", "ve", "vi", "vo", "vu", "ya", "ye", "yi", "yo", "yu", "za", "ze", "zi", "zo", "zu"};
                //String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z"};
                // Creamos un Random para el número de letras por cadena y para el número de la letra dentro del Array.
                Random r = new Random();
                // Lo convertimos a entero y lo limitamos del 1 al 10..
                int longitudMaxima = r.nextInt(10) + 1;
                //System.out.println("Longitud fija de cadenas para esta ejecución: " + longitudMaxima);
                // Creamos un for con el número de cadenas a construir y las construimos con la clase StringNuilder.
                // Este for creará tantas cadenas como el usuario haya manifestado.
                for (int i = 0; i < numeroCadenas; i++) {
                    // Y ahora construimos la cadena.
                    StringBuilder cadenaFormada = new StringBuilder();
                // While para construir las cadenas.
                    while (cadenaFormada.length() < longitudMaxima) {
                        int indiceLetra = r.nextInt(letras.length);
                        String silaba = letras[indiceLetra];
                        // Verificar si al agregar esta sílaba se excede la longitud máxima.
                        if (cadenaFormada.length() + silaba.length() <= longitudMaxima) {
                            cadenaFormada.append(silaba);
                        } else {
                            break; // Salimos del bucle si agregar más excede el límite.
                        }
                    }
                    // Imprimimos las cadenas.
                    System.out.println(cadenaFormada.toString());
                }
            } catch (NumberFormatException ex) {
                // En caso de número erroneo imprimimos.
                System.err.println("Número no válido, inténtelo de nuevo.");
            }
        }
    }
}
