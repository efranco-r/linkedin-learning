package sooper.contenedores;

import sooper.enums.TipoContenedor;
import sooper.productos.IProducto;

import java.util.Set;

public interface IContenedor {
    String getReferencia();

    int getVolumen();
    int getSuperficie();

    int volumenDisponible();

    int getResistencia();

    Set<IProducto> getProducto();

    TipoContenedor getTipo();

    boolean meter(IProducto producto);

    boolean resiste(IProducto producto);
}
