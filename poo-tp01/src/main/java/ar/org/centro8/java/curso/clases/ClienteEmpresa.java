package ar.org.centro8.java.curso.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class ClienteEmpresa extends Cliente{
    private String nombreFantasia;
    private String cuit;

    public ClienteEmpresa(int numeroCliente, String nombreFantasia, String cuit) {
        super(numeroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    @Override
    public void informarTipoDeClase(){
        System.out.println("Hola, soy la ClaseEmpresa!");
    }

}
