package ar.org.centro8.java.curso.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ClienteIndividual extends Cliente{
    private String name;
    private String apellido;
    private String dni;

    public ClienteIndividual(int numeroCliente, String name, String apellido, String dni) {
        super(numeroCliente);
        this.name = name;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public void informarTipoDeClase(){
        System.out.println("Hola, soy la clase ClienteIndividual!");
    }

}
