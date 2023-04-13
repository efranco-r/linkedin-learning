package sooper.productos.imp;

import sooper.enums.Categoria;
import sooper.productos.IProducto;

public class Mascota extends Producto {
    public Mascota(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.MASCOTAS;
    }

    @Override
    public boolean esCompatible(IProducto producto) {
        return !Categoria.DROGUERIA.equals(producto.getCategoria());
    }
}
