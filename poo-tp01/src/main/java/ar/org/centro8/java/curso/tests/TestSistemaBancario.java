package ar.org.centro8.java.curso.tests;

import java.time.LocalDate;

import ar.org.centro8.java.curso.clases.Cheque;
import ar.org.centro8.java.curso.clases.ClienteEmpresa;
import ar.org.centro8.java.curso.clases.ClienteIndividual;
import ar.org.centro8.java.curso.clases.CuentaCajaAhorro;
import ar.org.centro8.java.curso.clases.CuentaConvertibilidad;
import ar.org.centro8.java.curso.clases.CuentaCorriente;

public class TestSistemaBancario {
    public static void main(String[] args) {
        System.out.println("**TestSistemaBancario**");

        System.out.println("** Creación de primer cliente individual **");

        ClienteIndividual clienteInd1 = new ClienteIndividual(1, "Ricardo", "Darin", "11222333");
        System.out.println(clienteInd1);

        System.out.println("** Creación de primer cuenta Caja Ahorro y asignación al primer cliente individual **");

        CuentaCajaAhorro cuentaCajaAhorro1 = new CuentaCajaAhorro(1, clienteInd1, 0, "Pesos", 4);
        System.out.println(clienteInd1);                        //consulta los datos del cliente
        System.out.println(clienteInd1.getNumeroCliente());     //consulta solo el número de cliente
        System.out.println(cuentaCajaAhorro1.getSaldo());       //consulta saldo de la cuenta del cliente1
        cuentaCajaAhorro1.depositarEfectivo(100000);      //depositar en la cuenta
        System.out.println(cuentaCajaAhorro1.getSaldo());       //consultar el saldo de la cuenta
        cuentaCajaAhorro1.extraerEfectivo(50000);         //extraer de la cuenta
        System.out.println(cuentaCajaAhorro1.getSaldo());       //consultar el saldo de la cuenta
        System.out.println(cuentaCajaAhorro1);                  //consultar los datos de la cuenta
        cuentaCajaAhorro1.cobrarInteres(4);         //cobrar interes
        System.out.println(cuentaCajaAhorro1.getSaldo());       //consultar el saldo

        System.out.println("** Creación de primer cliente empresa **");

        ClienteEmpresa clienteEmp1 = new ClienteEmpresa(1, "Chevallier", "20-49524789-5");
        System.out.println(clienteEmp1);

        System.out.println("** Creación de primer Cuenta Corriente y asignación al primer cliente empresa **");

        CuentaCorriente cuentaCorr1 = new CuentaCorriente(1, clienteEmp1, 0, "Dolar", 50000); //acá me confundí y tipoCambio iría Pesos
        System.out.println(cuentaCorr1);
        cuentaCorr1.depositarEfectivo(100000);
        System.out.println(cuentaCorr1.getSaldo());
        cuentaCorr1.extraerEfectivo(200000); //Monto de extracción excede el monto autorizado.
        cuentaCorr1.extraerEfectivo(100000);
        System.out.println(cuentaCorr1.getSaldo());
        cuentaCorr1.extraerEfectivo(49000);  //Extracción realzada con éxito.
        System.out.println(cuentaCorr1.getSaldo());
        cuentaCorr1.extraerEfectivo(2);      //Extracción realizada con éxito = 49002.0
        System.out.println(cuentaCorr1.getSaldo());
        cuentaCorr1.extraerEfectivo(999);    //Monto de Extracción excede el monto autorizado.
        
        Cheque cheque1 = new Cheque(50000, "Banco Coban", LocalDate.of(2025, 9, 18));
        cuentaCorr1.depositarCheque(cheque1);
        System.out.println(cuentaCorr1.getSaldo());
        Cheque cheque2 = new Cheque(100000, "Talicia", LocalDate.of(2025, 9, 16));
        cuentaCorr1.depositarCheque(cheque2);
        System.out.println(cuentaCorr1.getSaldo());

        cuentaCorr1.mostrarChequesDepositados();

        System.out.println("** Creación de segundo cliente empresa con cuenta convertibilidad**");

        ClienteEmpresa clienteEmp2 = new ClienteEmpresa(2, "Mulan", "30-13654789-7");

        CuentaConvertibilidad cuentaConv1 = new CuentaConvertibilidad(1, clienteEmp2, 0, "Dolares", 100000, 0);

        System.out.println(clienteEmp2);
        System.out.println(cuentaConv1);
        System.out.println(cuentaConv1.getSaldoDolar());

        System.out.println("Deposito Dólares");
        cuentaConv1.depositarDolares(50000);
        System.out.println(cuentaConv1.getSaldoDolar());
        System.out.println(cuentaConv1.getSaldo());

        System.out.println("Conversión Dolares a Pesos");
        cuentaConv1.convertirDolaresAPesos(1000);
        System.out.println(cuentaConv1.getSaldoDolar());
        System.out.println(cuentaConv1.getSaldo());

        System.out.println("Conversión Pesos a Dólares");
        cuentaConv1.convertirPesosADolares(1000);
        System.out.println(cuentaConv1.getSaldoDolar());
        System.out.println(cuentaConv1.getSaldo());

        System.out.println("Deposito Cheque en cuenta");
        Cheque cheque3 = new Cheque(10000, "VVBA", LocalDate.of(2025, 9, 15));
        cuentaConv1.depositarCheque(cheque3);
        System.out.println(cuentaConv1.getSaldo());
        cuentaConv1.mostrarChequesDepositados();
        //Consulta: la clase CuentaConvertibilidad tiene el método depositarCheque, sin embargo, no me queda claro si está llamando al método depositarCheque de la clase
        //CuentaCorriente, porque lo está guardando también en mostrarChequesDepositados, y este último no lo puse en CuentaConvertibilidad.
        //Creo que es porque el método que usé es el que tiene el parámetro(cheque3)...el que usé en CuentaConvertibilidad quedó con el parámetro(monto)

        


    }
}
