package ar.org.centro8.java.curso.interfaces.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Motocicleta extends Vehiculo{
    public String cilindrada;

    public Motocicleta(String marca, String modelo, float precio, String cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public void informarTipoVehiculo() {
        System.out.println("Tipo de vehículo: Motocicleta");
    }

    

}
