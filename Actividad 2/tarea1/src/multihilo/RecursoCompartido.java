/*
 * Clase que almacenará el Array para que los hilos puedan operar.
 */
package multihilo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class RecursoCompartido {

    // Creamos el array sobre el que vamos a operar.
    // Tiene 10 posicines.
    private int[] ArraySuma = new int[10];
    // Ponemos un indice para controlar la posición en el array.
    private int index = 0;
    // Variable suma sobre la que iremos sumando elementos.
    private int sumaTotal = 0;
    // Límite máximo de suma de elementos.
    private static final int MAX_SUMA = 100;

    // Metodo para guardar el número en el recurso compartido en este caso el array.
    public synchronized void producir(int valor, String nombreHilo) throws IOException {
        while (index >= ArraySuma.length) {
            try {
                // El hilo productor espera.
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (sumaTotal < MAX_SUMA) { // En caso que la suma Total sea inferior a 100 puede seguir creando productores y metiendo en el Array.
            ArraySuma[index] = valor;
            // metemos elementos en el array.
            index++;
            registrarOperacion(nombreHilo + " introduce el valor " + valor + " en la posición " + (index - 1) + ", Array = " + Arrays.toString(ArraySuma) + ", Suma=" + sumaTotal);
            // Notifica a todos los hilos que pueden producir.
            notifyAll();
        }
    }

    // Metodo para guardar el número en el recurso compartido en este caso el array.
    public synchronized void consumir() throws IOException {
        while (index <= 0) {
            try {
                // El hilo consumidor espera.
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int valor = ArraySuma[--index];
        ArraySuma[index] = 0; // Limpiamos la posición en el array.
        sumaTotal += valor;

        registrarOperacion("Hilo consumidor, saca el valor " + valor + " de la posición " + index + ", Array = " + Arrays.toString(ArraySuma) + ", Suma=" + sumaTotal);
        notifyAll();

        if (sumaTotal >= MAX_SUMA) {
            registrarOperacion("Resultado final: " + sumaTotal);
            System.exit(0);
        }
    }

    // Método para registrar la operación en un archivo.
    // El archivo es un txt llamado registro.txt.
    private void registrarOperacion(String operacion) throws IOException {
        try (FileWriter fw = new FileWriter("registro.txt", true); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(operacion);
        }
    }
}
