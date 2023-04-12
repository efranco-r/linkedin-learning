package main.java.com.efranco.cajero;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import main.java.com.efranco.banco.CuentaAhorro;
import main.java.com.efranco.banco.CuentaBancaria;
import main.java.com.efranco.mock.GeneradorAleatorioDeMovimientos;

public class CajeroAutomatico {
    private CuentaBancaria cuentaBancaria;

    public CajeroAutomatico(String usuario, String contrasena) {
        double cantidadAleatoria = ThreadLocalRandom.current().nextDouble(0, 50000);
        this.cuentaBancaria = new CuentaAhorro("Eduardo", 100_000);
    }

    public void mostrarSaldo() {
        double saldo = this.cuentaBancaria.obtenerSaldo();
        System.out.println("Su saldo es: " + saldo);
    }

    public void ingresarDinero() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa la cantidad de dinero a depositar:");
            double cantidad = scanner.nextDouble();

            this.cuentaBancaria.ingresarDinero(cantidad);
        }
    }

    public void sacarDinero() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite la cantidad de dinero a retirar:");
            double cantidad = scanner.nextDouble();

            this.cuentaBancaria.sacarDinero(cantidad);
        }
    }

    public void salir() {
        System.out.print("Gracias por utilizar nuestros servicios!");
    }

    public void consultarUltimoMovimientos() {
        GeneradorAleatorioDeMovimientos generadorAleatorioDeMovimientos = new GeneradorAleatorioDeMovimientos();
        System.out.println("Cuántos movimientos quiere consultar?");
        
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroDeMovimientos = scanner.nextInt();
            ArrayList<String> movimientos = generadorAleatorioDeMovimientos.obtenerMovimientos(numeroDeMovimientos, "USD");
            mostrarMovimientos(movimientos);
        }
    }

    public void mostrarCondicionesLegales() {
        cuentaBancaria.obtenerCondicionesLegales();
    }

    private void mostrarMovimientos(ArrayList<String> movimientos) {
        for (String movimiento: movimientos) {
            System.out.println(movimiento);
        }
    }

}
