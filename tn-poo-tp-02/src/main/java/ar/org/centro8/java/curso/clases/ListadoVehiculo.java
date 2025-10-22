package ar.org.centro8.java.curso.clases;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.org.centro8.java.curso.interfaces.IConcesionaria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoVehiculo implements IConcesionaria{
    /*
     * Interfaz List: representa una lista con índices. Es la única que tiene métodos con índices.
     * Especificar el tipo de dato de la lista, a través del Generic.
     */
    public List<Vehiculo> vehiculos;

    public ListadoVehiculo(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Metodo para agregar vehiculos a la lista
     * Utilizando varargs
     * 
     * @param v
     */
     /*
      * declaración:
      * tipoDeDato[] identificador; --> declaración
      * tipoDeDato identificador[]; --> declaración
      * identificador = new tipoDeDato[n]; --> cantidad de variables que va a tener
      */

    public void agregarObjetosAlListado(Vehiculo... v) {
        for(int i = 0; i < v.length; i++) {
            vehiculos.add(v[i]);
        }
    }
  
    @Override
    public void imprimirListadoVehiculo() {
        System.out.println("\n");                                   //salto de linea
        vehiculos.forEach(System.out::println);                     //recorrido de la lista e impresión de la misma
        System.out.println("\n=============================\n");    //salto de linea + separación con signo igual + salto de linea
    }

    @Override
    public void traerVehiculoPorPrecioMasCaro() {
        double precioMasCaro = vehiculos
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
    public void traerVehiculoPorLetraY() { //averiguar como setear que la búsqueda sea genérica para cualquier letra
        //ejemplo clase 25
        vehiculos
                 .stream()
                 .filter(v->v.getMarca().toLowerCase().contains("y"))
                 .forEach(v-> System.out.println(
                        "Vehículo que contiene en el modelo la letra 'Y': " + v.getMarca() + " " + v.getModelo() + " $" + v.getPrecio()));
                 System.out.println("\n=============================\n");
    }

    @Override
    public void ordenarListadoVehiculoPorPrecioMayorAMenor() {
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        vehiculos
                 .stream()
                 .sorted(Comparator.comparing(Vehiculo::getPrecio)
                 .reversed())
                 .forEach(v-> System.out.println(v.getMarca() + " " + v.getModelo()));
                 System.out.println("\n=============================\n");
    }

    @Override
    public void ordenarListadoVehiculoPorOrdenNatural() {
        //utilización treeSet
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
        //creación de Set(ejemplo clase21)
        Set<Vehiculo> setVehiculo;
        setVehiculo = new TreeSet<>();
        setVehiculo.addAll(vehiculos);
        setVehiculo.forEach(System.out::println);
    }
}
