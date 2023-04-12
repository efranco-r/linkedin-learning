package main.java.com.efranco.banco;

public class CuentaAhorro extends CuentaBancaria {
    private final double COMISION = 0.12;

    public CuentaAhorro() {
        super();
    }

    public CuentaAhorro(String titular, double saldo) {
        super(titular, saldo);
    }

    public CuentaAhorro(String titular, TipoCuenta tipoCuenta, double saldo) {
        super(titular, tipoCuenta, saldo);
    }

    @Override
    public void obtenerCondicionesLegales() {
        System.out.println("Estas son mis condiciones legales.");
        System.out.println("Por favor hacer uso de las mismas....");
        System.out.println("Si no, tendrá problemas jurídicos");
    }

    @Override
    public void sacarDinero(double cantidad) {
        if (cantidad < 0) {
            return;
        }

        saldo -= cantidad;
        saldo -= COMISION;
    }
    
    /*
    public double calcularComision(TipoCuenta tipoCuenta) {
        double comision;
        switch(tipoCuenta) {
            case AHORRO:
                comision = 0.1;
                break;
            case NOMINA:
                comision = 0.2;
                break;
            case HIPOTECA:
                comision = 0.3;
                break;
            case INFANTIL:
                comision = 0.1;
                break;
            default:
                comision = 0.0; 
        }

        return comision;
    }
    */
}
