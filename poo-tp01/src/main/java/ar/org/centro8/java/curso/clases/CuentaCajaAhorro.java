package ar.org.centro8.java.curso.clases;


import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class CuentaCajaAhorro extends Cuenta{
    //atributos
    private double tasaInteres;

    //constructor
    public CuentaCajaAhorro(int nroCuenta, Cliente cliente, double saldo, String tipoCambio, double tasaInteres) {
        super(nroCuenta, cliente, saldo, tipoCambio);
        this.tasaInteres = tasaInteres;
    }

    //métodos
    @Override
    public void depositarEfectivo(double monto){
            saldo += monto;
    }

    @Override
    public void extraerEfectivo(double monto) {
        if(saldo-monto<0) System.out.println("Saldos insuficientes para realiza esta operación");
            else saldo -= monto;
    }

    @Override
    public void informarTipoCuenta() {
        System.out.println("Tipo de cuenta es: Caja de Ahorro");
    }

    public void cobrarInteres(double tasaInteres){
        double interes = getSaldo() * tasaInteres;
        depositarEfectivo(interes);
    }

}


