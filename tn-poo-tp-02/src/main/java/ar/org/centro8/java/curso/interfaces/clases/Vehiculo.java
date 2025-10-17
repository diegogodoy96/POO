package ar.org.centro8.java.curso.interfaces.clases;

import ar.org.centro8.java.curso.interfaces.IConsecionaria;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehiculo implements IConsecionaria{
    private final String marca;
    private final String modelo;
    private final float precio;

    public abstract void informarTipoVehiculo();

       

}
