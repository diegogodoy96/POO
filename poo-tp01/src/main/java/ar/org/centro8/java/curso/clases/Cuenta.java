package ar.org.centro8.java.curso.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Cuenta {
    private final int nroCuenta;
    private Cliente cliente;
    protected double saldo;
    private String tipoCambio;

    /**
     * método para depositar efectivo en pesos
     * @param monto
     */
    public abstract void depositarEfectivo(double monto); 
    
    /**
     * método para extraer efectivo en pesos
     * @param monto
     */
    public abstract void extraerEfectivo(double monto);

    public abstract void informarTipoCuenta();

}


