package sooper;

import sooper.contenedores.IContenedor;
import sooper.productos.IProducto;

import java.util.HashSet;
import java.util.Set;

public class Pedido implements IPedido {
    private String referencia;
    private Set<IContenedor> contenedores;

    public Pedido(String referencia) {
        this.referencia = referencia;
        this.contenedores = new HashSet<IContenedor>();
    }

    @Override
    public String getReferencia() {
        return this.referencia;
    }

    @Override
    public Set<IProducto> getProductos() {
        Set<IProducto> productos = null;

        for (IContenedor contenedor : this.contenedores) {
            if (productos == null) {
                productos = contenedor.getProducto();
            } else {
                productos.addAll(contenedor.getProducto());
            }
        }

        return productos;
    }

    @Override
    public Set<IContenedor> getContenedores() {
        return this.contenedores;
    }

    @Override
    public void addContenedor(IContenedor contenedor) {
        this.contenedores.add(contenedor);
    }

    @Override
    public IContenedor addProducto(IProducto producto) {
        for (IContenedor contenedor : this.contenedores) {
            if (contenedor.meter(producto)) {
                return contenedor;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pedido: " + referencia + "\n");

        for (IContenedor contenedor : this.contenedores) {
            stringBuilder.append("\t" + contenedor + "\n");
        }

        return stringBuilder.toString();
    }
}
