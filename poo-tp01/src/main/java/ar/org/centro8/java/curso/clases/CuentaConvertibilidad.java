package ar.org.centro8.java.curso.clases;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaConvertibilidad extends CuentaCorriente{
    //atributos
    private double saldoDolar;

    //constructor
    public CuentaConvertibilidad(int nroCuenta, Cliente cliente, double saldo, String tipoCambio, double montoAut, double saldoDolar) {
        super(nroCuenta, cliente, saldo, tipoCambio, montoAut);
        this.saldoDolar = saldoDolar;
    }

    //método para depositar efectivo(pesos)
    @Override
    public void depositarEfectivo(double monto){
            saldo += monto;
    }

    //método para extraer efectivo(pesos)
    @Override
    public void extraerEfectivo(double monto) {
        if(saldo-monto<0) System.out.println("Saldos insuficientes para realiza esta operación");
            else saldo -= monto;
    }

    @Override
    public void informarTipoCuenta() {
        System.out.println("Tipo de cuenta es: Cuenta Convertibilidad");
    }

    /**
     * método creado para depositar efectivo(dólares)
     * @param monto
     */
    public void depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolar += monto;
        }
    }

    /**
     * método creado para extraer efectivo(dólares)
     * @param monto
     */
    public void extraerDolares(double monto) {
        if (monto > 0 && monto <= saldoDolar) {
            saldoDolar -= monto;
        } else {
            System.out.println("Fondos insuficientes en dólares.");
        }
    }

    //el método que voy a utilizar en el test es del depositarCheque(Cheque cheque), que está en la clase CuentaCorriente.
    //public void depositarCheque(double monto){
      //  saldo += monto;
        //System.out.println("Hola, soy un cheque siendo depositado");
    //}

    /**
     * Este método convierte en dólares los pesos depositados en la cuenta.
     * @param cotizacion
     */
    public void convertirPesosADolares(double cotizacion){
        if (cotizacion > 0) {
            double dolares = getSaldo() / cotizacion;
            saldoDolar += dolares;
            extraerEfectivo(getSaldo()); // Se vacía la cuenta en pesos
        }
    }

    /**
     * Este método convierte en dólares los pesos depositados en la cuenta.
     */
    public void convertirDolaresAPesos(double cotizacion){
        if (cotizacion > 0) {
            double pesos = saldoDolar * cotizacion; // Convertimos los dólares a pesos
            depositarEfectivo(pesos); // Sumamos los pesos a la cuenta en pesos
            saldoDolar = 0.0; // Vaciamos el saldo en dólares
        }
    }

}
