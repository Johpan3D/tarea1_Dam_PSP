/*
 * En esta segunda actividad debemos crea un programa con dos hilos productores y un hilo consumidor.
 * Los hilos productores se encargarán de almacenar valores numéricos en un array, 
 * mientras que el hilo consumidor sacará elementos del array de uno en uno para ir sumándolos 
 * en una variable a la que llamaremos 'Suma'. El array tendrá una capacidad para almacenar 10 valores. 
 * Los valores introducidos por los productores serán valores aleatorios entre 0 y 10.
 * El programa tendrá que tener en cuenta lo siguiente:
 * Se debe de impedir la superposición de operaciones sobre secciones críticas.
 * No se podrá consumir si el array está vacío o producir si está lleno.
 * Si el array está lleno, deberán detenerse los hilos productores (instrucción wait) hasta que el hilo 
 * consumidor termine de leer el array. Cuando esto suceda, será este hilo quien vuelva a activarlos.
 * Simularemos un tiempo de producción y de consumo en cada hilo. Es decir, los hilos deberán descansar 
 * después de producir (100 milisegundos) y después de consumir (150 milisegundos)
 * Se establecerá el valor máximo a 100, para la suma de los elementos sacados del array por el hilo 
 * consumidor, de forma que si se alcanza este valor máximo se finalizarían los hilos creados y se 
 * visulizará el resultado obtenido.
 * Tanto los hilos productores, como el hilo consumidor, comprobarán si se ha alcanzado el valor máximo 
 * para dar por finalizada su tarea.
 * Se debe de registrar en un fichero la siguiente información por cada acción: Hilo ejecutado, 
 * operación realizada, el actual estado del vector y el valor de la variable 'Suma' en ese momento.
 * Hilo productor 1, introduce el valor 6 en la posición 1, Array = 6, Suma=0
 * Hilo productor 2, introduce el valor 1 en la posición 2, Array = 6 - 1, Suma=0
 * Hilo productor 1, introduce el valor 4 en la posición 3, Array = 6 - 1 - 4, Suma=0
 * Hilo consumidor, saca el valor 4 de la posición 3, Array = 6 - 1, Suma=4
 * Hilo consumidor, saca el valor 1 de la posición 2, Array = 6 , Suma=5
 * ...
 * Hilo consumidor, saca el valor 8 de la posición 7, Array = 6 - 5 - 8 - 0 - 5 - 6 , Suma=107
 * Resultado final: 107
 * Al igual que en el ejercicio anterior debes realizar un pequeño manual (tipo “¿Cómo se hace?”), 
 * utilizando un procesador de textos en el que indiques, con pequeñas explicaciones y capturas, 
 * las forma en que has realizado la tarea. 
 * En alguna capturas es OBLIGATORIO tener como fondo la plataforma con el perfil del alumno/a;
 * Según la videoconferencia dos es mejor usar implements runnable.
 * Además el hilo Jardín es la mejor manera de hacerlo.
 * Todo debe quedar grabado en un archivo de texto plano o txt.
 */
package multihilo;

/**
 *
 * @author Juan Luis Gómez Ruiz.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos un objeto de la clase recurso compartido.
        RecursoCompartido recurso = new RecursoCompartido();
        
        // Creamos los 3 hilos.
        Thread hiloProductor1 = new Thread(new HiloProductor(recurso, "Hilo Productor 1"));
        Thread hiloProductor2 = new Thread(new HiloProductor(recurso, "Hilo Productor 2"));
        Thread hiloConsumidor = new Thread(new HiloConsumidor(recurso));
        
        // Iniciamos los hilos.
        hiloProductor1.start();
        hiloProductor2.start();
        hiloConsumidor.start();;
    }
    
}
