package sooper.productos.imp;

import sooper.enums.Categoria;
import sooper.productos.IProducto;

public class Drogueria extends Producto{
    public Drogueria(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.DROGUERIA;
    }

    @Override
    public boolean esCompatible(IProducto producto) {
        return !Categoria.ALIMENTACION.equals(producto.getCategoria()) && !Categoria.MASCOTAS.equals(producto.getCategoria());
    }
}
