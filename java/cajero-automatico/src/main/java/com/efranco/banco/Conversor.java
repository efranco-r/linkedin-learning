package main.java.com.efranco.banco;

import java.math.BigDecimal;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final float tasaCambio = 1.09F; 

            System.out.println("Por favor introduzca la cantidad en EUROS:");
            double euros = scanner.nextDouble();

            double dollars = euros * tasaCambio;

            System.out.println(String.format("%f euros equivalen a %f dólares", euros, dollars));

            //Para representar largas sumas de dinero podríamos manejar algo como lo siguiente:
            String eurosString = Double.toString(euros);
            BigDecimal eurosBigDecimal = new BigDecimal(eurosString);

            String tasaCambioString = Float.toString(tasaCambio);
            BigDecimal tasaCambioBigDecimal = new BigDecimal(tasaCambioString);

            BigDecimal dollarsBigDecimal = eurosBigDecimal.multiply(tasaCambioBigDecimal);

            System.out.println("BigDecimal result: " + dollarsBigDecimal);

        }
    }
}