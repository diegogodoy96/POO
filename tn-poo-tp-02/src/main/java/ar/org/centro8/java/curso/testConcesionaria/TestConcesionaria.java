package ar.org.centro8.java.curso.testConcesionaria;

import java.util.ArrayList;

import ar.org.centro8.java.curso.clases.Automovil;
import ar.org.centro8.java.curso.clases.ListadoVehiculo;
import ar.org.centro8.java.curso.clases.Motocicleta;
import ar.org.centro8.java.curso.clases.Vehiculo;

public class TestConcesionaria {
    public static void main(String[] args) {
        //creación de objetos, tanto de auto como de moto
        Vehiculo auto1 = new Automovil("Peugeot", "206", "4", 200000.00);
        Vehiculo moto1 = new Motocicleta("Honda", "Titan", "125c", 60000.00);
        Vehiculo auto2 = new Automovil("Peugeot", "208", "5", 250000.00);
        Vehiculo moto2 = new Motocicleta("Yamaha", "YBR", "160c", 80500.50);
        //creación de nuevo listado
        ListadoVehiculo listadoVehiculo = new ListadoVehiculo(new ArrayList<>()); 
        //uso de métodos
        listadoVehiculo.agregarObjetosAlListado(auto1,moto1,auto2,moto2);
        listadoVehiculo.imprimirListadoVehiculo();
        //separación =============================
        listadoVehiculo.traerVehiculoPorPrecioMasCaro();
        listadoVehiculo.traerVehiculoPorPrecioMasBarato();
        listadoVehiculo.traerVehiculoPorLetra();
        //separación =============================
        listadoVehiculo.ordenarListadoVehiculoPorPrecioMayorAMenor();
        //separación =============================
        listadoVehiculo.ordenarListadoVehiculoPorOrdenNatural();

    }
}
