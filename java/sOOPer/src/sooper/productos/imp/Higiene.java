package sooper.productos.imp;

import sooper.enums.Categoria;
import sooper.productos.IProducto;

public class Higiene extends Producto {
    public Higiene(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.HIGIENE;
    }

    @Override
    public boolean esCompatible(IProducto producto) {
        return !Categoria.ALIMENTACION.equals(producto.getCategoria());
    }
}
