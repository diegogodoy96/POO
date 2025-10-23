package ar.org.centro8.java.curso.clases;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo>{
    private String marca;
    private String modelo;
    private double precio;


    // Método que formatea el precio
    public String getPrecioFormateado() {
        //@SuppressWarnings("deprecation") // ??? lo agregué por el quick fix: Arrojó advertencia al agregar el método 'Locale'.
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("es", "ES"));   //💡 En Java, "es", "ES" significa Español de España.
        DecimalFormat formato = new DecimalFormat("#,##0.00", simbolos);                    // El string #,##0.00 es el patrón (o “máscara”) que indica cómo mostrar el número.
        return formato.format(precio);
    }


    public int compareTo(Vehiculo vehiculoSiguiente) {
        String vehiculoOriginal = this.marca + " " + this.modelo + " " + this.precio;
        String vehiculoAComparar = vehiculoSiguiente.marca + " " + vehiculoSiguiente.modelo + " " + vehiculoSiguiente.precio;
        return vehiculoOriginal.compareTo(vehiculoAComparar);
    }
}
