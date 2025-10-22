package ar.org.centro8.java.curso.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo>{
    private String marca;
    private String modelo;
    private Double precio;

    //Compara el objeto con un objeto específico por orden.
    //Retorna un entero negativo, cero, o un entero positivo.
    //as this object is less than, equal to, or greater than the specified object.
    public int compareTo(Vehiculo vehiculoSiguiente) {
        String vehiculoOriginal = this.marca + " " + this.modelo + " " + this.precio;
        String vehiculoAComparar = vehiculoSiguiente.marca + " " + vehiculoSiguiente.modelo + " " + vehiculoSiguiente.precio;
        return vehiculoOriginal.compareTo(vehiculoAComparar);
    }
}
