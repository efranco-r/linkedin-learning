package sooper.productos.imp;

import sooper.Caducable;

import java.time.LocalDate;

public class Fresco extends Alimentacion implements Caducable {
    private LocalDate caducidad;
    public Fresco(String referencia, int peso, int volumen, LocalDate caducidad) {
        super(referencia, peso, volumen);
        this.caducidad = caducidad;
    }

    @Override
    public boolean estaCaducado() {
        return caducidad.isBefore(LocalDate.now());
    }
}
