package ar.org.centro8.java.curso.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta{
    //atributos
    private double montoAut;
    private List<Cheque> chequesDepositados = new ArrayList<>();

    //constructor
    public CuentaCorriente(int nroCuenta, Cliente cliente, double saldo, String tipoCambio, double montoAut) {
        super(nroCuenta, cliente, saldo, tipoCambio);
        this.montoAut = montoAut;
    }

    //métodos
    @Override
    public void depositarEfectivo(double monto){
            saldo += monto;
    }

    @Override
    public void extraerEfectivo(double monto) {
        if (saldo + montoAut >= monto) {
            setSaldo(saldo - monto);
            System.out.println("Extracción realizada con éxito.");
        } else {
            System.out.println("Monto de extracción excede el monto autorizado.");
        }
    }

    @Override
    public void informarTipoCuenta() {
        System.out.println("Tipo de cuenta es: Cuenta Corriente");
    }

    /**
     * Cobra el cheque solo si ya puede cobrarse en base a la fecha. 
     * Para validar que no se deposite un cheque con fecha pago posterior a la del sistema
     * @param cheque
     */
    public void depositarCheque(Cheque cheque) {
        if (!cheque.getFechaPago().isAfter(LocalDate.now())) { //“Si la fecha de pago NO es posterior a hoy”
            saldo += cheque.getMonto();
            chequesDepositados.add(cheque); // Se guarda
        } else {
            System.out.println("El cheque aún no puede cobrarse.");
        }
    }
    
    /**
     * método para guardar los cheques depositados
     * “Uso un bucle for-each para recorrer la lista chequesDepositados.
     * Cada vez que pasa por el bucle, la variable cheque representa un elemento de esa lista.
     * De esa forma puedo acceder a los datos de cada cheque sin usar un índice manual.”
     */
    public void mostrarChequesDepositados() {
        if (chequesDepositados.isEmpty()) {
            System.out.println("No se depositaron cheques en esta cuenta.");
        } else {
            System.out.println("Cheques depositados:");
            for (Cheque cheque : chequesDepositados) { //“Para cada objeto de tipo Cheque dentro de la lista chequesDepositados, hacé lo siguiente…”
                System.out.println("- Monto: $" + cheque.getMonto() + 
                                   ", Banco: " + cheque.getBancoEmisor() + 
                                   ", Fecha de pago: " + cheque.getFechaPago());
            }
        }
    }
    


}
