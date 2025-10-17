package ar.org.centro8.java.curso.Test;

import ar.org.centro8.java.curso.interfaces.clases.Automovil;
import ar.org.centro8.java.curso.interfaces.clases.Motocicleta;

public class TestConcesionaria {
    public static void main(String[] args) {
        
        Automovil Auto1 = new Automovil("Peugeot", "206", "4", 200000); 
        Motocicleta Moto1 = new Motocicleta("Honda", "Titan", 60000, "125c");
        Automovil Auto2 = new Automovil("Peugeot", "208", "5", 250000);
        Motocicleta Moto2 = new Motocicleta("Yamaha", "YBR", (float) 80500.50, "160c"); //se castea el precio a float por el decimal

        System.out.println(""Auto1);
        

    }
}
