package ar.org.centro8.java.curso.clases;

import ar.org.centro8.java.curso.interfaces.IConcesionaria;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class ListadoVehiculo implements IConcesionaria {
    /*
     * Interfaz List: representa una lista con índices. Es la única que tiene
     * métodos con índices.
     * Se especifica el tipo de dato de la lista, a través del Generic.
     */
    public List<Vehiculo> vehiculos;

    public ListadoVehiculo(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarObjetosAlListado(Vehiculo... v) {
        for (int i = 0; i < v.length; i++) {
            vehiculos.add(v[i]);
        }
    }

    @Override
    public void imprimirListadoVehiculo() {
        System.out.println("\n"); // salto de linea
        vehiculos.forEach(System.out::println); // recorrido de la lista e impresión de la misma
        System.out.println("\n=============================\n"); // salto de linea + separación con signo igual + salto de linea
    }

    @Override
    public void traerVehiculoPorPrecioMasCaro() {
        double precioMasCaro = vehiculos
                // Stream: secuencia de elementos para aplicar operaciones(filter, map, max,
                // min, etc.) de manera funcional (sin bucles explícitos).
                .stream()
                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                .get()
                .getPrecio();
        vehiculos
                .stream()
                .filter(v -> v.getPrecio() == precioMasCaro)
                .forEach(v -> System.out.println("Vehículo más caro: " + v.getMarca() + " " + v.getModelo()));
    }

    @Override
    public void traerVehiculoPorPrecioMasBarato() {
        double precioMasBarato = vehiculos
                .stream()
                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                .get()
                .getPrecio();
        vehiculos
                .stream()
                .filter(v -> v.getPrecio() == precioMasBarato)
                .forEach(v -> System.out.println("Vehículo más barato: " + v.getMarca() + " " + v.getModelo()));
    }

    @Override
    public void traerVehiculoPorLetra() {
        // ejemplo clase 25
        String letra = "y"; // en caso de querer filtrar por otra letra se debe modificar la variable
        vehiculos
                .stream()
                .filter(v -> v.getModelo() != null && v.getModelo().toLowerCase().contains(letra)) // parámetro
                .forEach(v -> System.out.println(
                        "Vehículo que contiene en el modelo la letra 'Y': " + v.getMarca() + " " + v.getModelo() + " $"
                                + v.getPrecioFormateado()));
        System.out.println("\n=============================\n");
    }

    @Override
    public void ordenarListadoVehiculoPorPrecioMayorAMenor() {
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio)
                        .reversed())
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo()));
        System.out.println("\n=============================\n");
    }

    @Override
    public void ordenarListadoVehiculoPorOrdenNatural() {
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
        // utilización treeSet || creación de Set(ejemplo clase21)
        Set<Vehiculo> setVehiculo;
        setVehiculo = new TreeSet<>();
        setVehiculo.addAll(vehiculos);
        setVehiculo.forEach(System.out::println);
        System.out.println("\n");
    }
}
