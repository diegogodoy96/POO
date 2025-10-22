package ar.org.centro8.java.curso.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo>{
    private String marca;
    private String modelo;
    private double precio;

    //Compara el objeto con un objeto específico por orden.
    //Retorna un entero negativo, cero, o un entero positivo.
    //En caso de que el objeto sea menor, igual a, o mayor que el objeto específico
    public int compareTo(Vehiculo vehiculoSiguiente) {
        String vehiculoOriginal = this.marca + " " + this.modelo + " " + this.precio;
        String vehiculoAComparar = vehiculoSiguiente.marca + " " + vehiculoSiguiente.modelo + " " + vehiculoSiguiente.precio;
        return vehiculoOriginal.compareTo(vehiculoAComparar);
    }
}


