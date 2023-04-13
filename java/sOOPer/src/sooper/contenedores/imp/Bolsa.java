package sooper.contenedores.imp;

import sooper.Caducable;
import sooper.enums.TipoContenedor;

import java.time.LocalDate;

public class Bolsa extends Contenedor implements Caducable {
    private int ancho;

    private LocalDate caducidad;

    public Bolsa(String referencia, int alto, int ancho, int resistencia, LocalDate caducidad) {
        super(referencia, alto, resistencia);
        this.ancho = ancho;
        this.caducidad = caducidad;
    }

    @Override
    public int getSuperficie() {
        int radio = getDiametro() / 2;
        return (int) (Math.PI * radio * radio);
    }

    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.BOLSA;
    }

    public int getDiametro() {
        return (int) ((2 * ancho) / Math.PI);
    }

    @Override
    public boolean estaCaducado() {
        return caducidad.isBefore(LocalDate.now());
    }
}
