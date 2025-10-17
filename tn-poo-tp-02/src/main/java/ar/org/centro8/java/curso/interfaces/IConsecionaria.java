package ar.org.centro8.java.curso.interfaces;

public interface IConsecionaria {

    /**
     * Método default que describe a la interfaz
     */
    default void info() {
        System.out.println(
                "IConsecionaria: Interfaz para la gestión de archivos.");
    }

}
