package ar.org.centro8.java.curso.clases;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cheque {
    //atributos
    private double monto;
    private String bancoEmisor;
    private LocalDate fechaPago;
    
    //constructor
    public Cheque(double monto, String bancoEmisor, LocalDate fechaPago) {
            this.monto = monto;
            this.bancoEmisor = bancoEmisor;
            this.fechaPago = fechaPago;
    }

    

}
