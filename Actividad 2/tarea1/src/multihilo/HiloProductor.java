/*
 * Creamos un hilo Productor1 que implementará la clase Runnable.
 */
package multihilo;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class HiloProductor implements Runnable {

    private final RecursoCompartido recurso;
    // Podremos obtener el nombre del hilo que está operando.
    private final String nombreHilo;
    // Variable para generar los valores aleatorios.
    private final Random random = new Random();

    // Constructor de la clase Hilos Productores.
    public HiloProductor(RecursoCompartido recurso, String nombreHilo) {
        this.recurso = recurso;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() { // Método run de la clase.

        while (true) { // Mietras sea verdadero.
            int valor = random.nextInt(11); // Genera valores aleatorios entre 0 y 10
            try {
                // Produce valor.
                recurso.producir(valor, nombreHilo);
                Thread.sleep(100); // Pausa de 100ms.
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

    }

}
