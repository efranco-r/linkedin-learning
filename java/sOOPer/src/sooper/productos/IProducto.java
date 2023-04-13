package sooper.productos;

import sooper.contenedores.IContenedor;
import sooper.enums.Categoria;

public interface IProducto {
    String getReferencia();

    int getPeso();

    int getVolumen();

    Categoria getCategoria();

    boolean esCompatible(IProducto producto);

    boolean tengoEspacio(IContenedor contenedor);

    void meter(IContenedor contenedor);
}
