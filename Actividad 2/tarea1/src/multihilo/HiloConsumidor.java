/*
 * Creamos un solo hilo consumidor que implementará la clase Runnable.
 */
package multihilo;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class HiloConsumidor implements Runnable {
    
    private final RecursoCompartido recurso;

    public HiloConsumidor(RecursoCompartido recurso) {
        this.recurso = recurso;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Consume valor.
                recurso.consumir();
                Thread.sleep(150); // Pausa de 150ms.
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
