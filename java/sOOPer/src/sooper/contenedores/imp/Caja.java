package sooper.contenedores.imp;

import sooper.enums.TipoContenedor;
import sooper.productos.IProducto;

public class Caja extends Contenedor {
    private int ancho;
    private int largo;

    public Caja(String referencia, int alto, int ancho, int largo) {
        super(referencia, alto, 0);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public int getSuperficie() {
        return this.ancho * this.largo;
    }

    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.CAJA;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return Boolean.TRUE;
    }
}
