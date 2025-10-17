package ar.org.centro8.java.curso.interfaces.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Automovil extends Vehiculo{
    public String puertas;

    public Automovil(String marca, String modelo, String puertas, float precio) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    @Override
    public void informarTipoVehiculo() {
        System.out.println("Tipo de vehículo: Automovil");
    }

   

}
