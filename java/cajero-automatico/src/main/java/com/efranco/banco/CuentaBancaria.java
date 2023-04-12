package main.java.com.efranco.banco;

public abstract class CuentaBancaria {
    private String titular;
    private TipoCuenta tipoCuenta;
    protected double saldo;

    //public static final String TIPO_AHORRO = "Ahorro";
    //public static final String TIPO_NOMINA = "Nómina";

    final double COMISION = 1.2;

    public CuentaBancaria() {
        this("", TipoCuenta.AHORRO, 0);
    }

    public CuentaBancaria(String titular, double saldo) {
        this(titular, TipoCuenta.AHORRO, saldo);
    }

    public CuentaBancaria(String titular, TipoCuenta tipoCuenta, double saldo) {
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public void sacarDinero(double cantidad) {
        if (cantidad < 0) {
            return;
        }

        saldo -= cantidad;
    }

    public void ingresarDinero(double cantidad) {
        saldo += cantidad;
    }

    public void cambiarTipoDeCuenta(TipoCuenta nuevoTipo) {
        tipoCuenta = nuevoTipo;
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public abstract void obtenerCondicionesLegales();
    
}
