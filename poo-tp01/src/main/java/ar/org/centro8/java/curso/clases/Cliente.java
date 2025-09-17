package ar.org.centro8.java.curso.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Cliente {
    private int numeroCliente;

    public void informarTipoDeClase() {
        System.out.println("Hola, soy la clase cliente!");
    }

}
