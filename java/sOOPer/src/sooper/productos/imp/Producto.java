package sooper.productos.imp;

import sooper.contenedores.IContenedor;
import sooper.contenedores.imp.Contenedor;
import sooper.productos.IProducto;

public abstract class Producto implements IProducto {
    private String referencia;
    private int peso;
    private int volumen;
    private IContenedor contenedor;

    public Producto(String referencia, int peso, int volumen) {
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
    }

    @Override
    public String getReferencia() {
        return this.referencia;
    }

    @Override
    public int getPeso() {
        return this.peso;
    }

    @Override
    public int getVolumen() {
        return this.volumen;
    }

    @Override
    public boolean tengoEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > this.volumen;
    }

    @Override
    public void meter(IContenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public String toString() {
        return "Producto [categoria=" + getCategoria() + ", referencia=" + referencia + ", peso=" + peso + ", volumen="
                + volumen + ", contenedor=" + contenedor.getReferencia() + "]";
    }
}
