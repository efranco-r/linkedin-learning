package main.java.com.efranco.mock;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorAleatorioDeMovimientos {
    private static final String TRANSFERENCIA = "Tranferencia de ";
    private static final String INGRESO = "Ingreso de ";
    private static final String RETIRADA = "Retirada de ";
    private static final String PAGO_CON_TARJETA = "Pago con tarjeta de ";
    private static final String NOMINA = "Ingreso nómina de ";
    private static final String PAGO_RECIBO = "Pago de recibo de ";

    public ArrayList<String> obtenerMovimientos(int numeroDeMovimientos, String moneda) {
        ArrayList<String> movimientos = new ArrayList<>();

        for (int indice = 0; indice < numeroDeMovimientos; indice++) {
            int numeroDeMovimiento = obtenerIntAleatorio(1, 6);

            String tipoDeMovimiento;

            switch(numeroDeMovimiento) {
                case 1:
                    tipoDeMovimiento = TRANSFERENCIA;
                    break;
                case 2:
                    tipoDeMovimiento = INGRESO;
                    break;
                case 3:
                    tipoDeMovimiento = RETIRADA;
                    break;
                case 4:
                    tipoDeMovimiento = PAGO_CON_TARJETA;
                    break;
                case 5:
                    tipoDeMovimiento = NOMINA;
                    break;
                default:
                    tipoDeMovimiento = PAGO_RECIBO;
            }

            double cantidadAleatoria = obtenerDoubleAleatorio(1, 3000.0);
            String movimiento = tipoDeMovimiento + String.format("%.2f", cantidadAleatoria) + " " + moneda;

            movimientos.add(movimiento);
        }

        return movimientos;
    }

    private int obtenerIntAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }

    private double obtenerDoubleAleatorio(double minimo, double maximo) {
        return ThreadLocalRandom.current().nextDouble(minimo, maximo);
    }
}
