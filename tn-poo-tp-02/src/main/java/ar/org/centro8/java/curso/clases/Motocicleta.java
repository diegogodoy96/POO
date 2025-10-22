package ar.org.centro8.java.curso.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Motocicleta extends Vehiculo{
    private String cilindrada;

    public Motocicleta(String marca, String modelo, String cilindrada, double precio) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }
  
    @Override
    public String toString() {
        return "Marca: " + getMarca() + " // Modelo: " + getModelo() + " // Cilindrada: " + cilindrada + " // Precio: $" + getPrecio();
    }
}

