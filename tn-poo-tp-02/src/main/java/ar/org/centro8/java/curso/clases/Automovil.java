package ar.org.centro8.java.curso.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Automovil extends Vehiculo{
    private String puertas;

    public Automovil(String marca, String modelo, String puertas, double precio) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca() + " // Modelo: " + getModelo() + " // Puertas: " + puertas + " // Precio: $" + getPrecioFormateado();
    }
}
