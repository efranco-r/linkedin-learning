package sooper.contenedores.imp;

import com.sun.org.apache.bcel.internal.Repository;
import sooper.contenedores.IContenedor;
import sooper.productos.IProducto;

import java.util.HashSet;
import java.util.Set;

public abstract class Contenedor implements IContenedor {
    private String referencia;
    private int alto;
    private int resistencia;
    private Set<IProducto> productos;

    public Contenedor(String referencia, int alto, int resistencia) {
        this.referencia = referencia;
        this.alto = alto;
        this.resistencia = resistencia;
        this.productos = new HashSet<IProducto>();
    }

    @Override
    public String getReferencia() {
        return this.referencia;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public int volumenDisponible() {
        return getVolumen() - volumenOcupado();
    }

    private int volumenOcupado() {
        int resultado = 0;

        for (IProducto producto : this.productos) {
            resultado += producto.getVolumen();
        }

        return resultado;
    }

    @Override
    public int getResistencia() {
        return this.resistencia;
    }

    @Override
    public Set<IProducto> getProducto() {
        return this.productos;
    }

    @Override
    public boolean meter(IProducto producto) {
        boolean resistenciaOk = resiste(producto);
        boolean volumenOk = producto.tengoEspacio(this);
        boolean compatibilidadOk = Boolean.TRUE;

        for (IProducto productoRow : this.productos) {
            boolean compatibleOk = producto.esCompatible(productoRow);
            compatibilidadOk &= compatibleOk;
        }

        boolean acepta = resistenciaOk && volumenOk && compatibilidadOk;

        if (acepta) {
            this.productos.add(producto);
            producto.meter(this);
        }

        return false;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return this.resistencia > producto.getPeso();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Contenedor " + this.referencia + " [" + getTipo() +
                "] (sup " + getSuperficie() + "cm2 - vol " + getVolumen() + "cm3 - resistencia " + getResistencia() + " g).\n");

        if (this.productos.isEmpty()) {
            stringBuilder.append("\t\tvacío\n");
        }

        for (IProducto producto : this.productos) {
            stringBuilder.append("\t\t" + producto + "\n");
        }
        stringBuilder.append("\t\t>> Disponible vol " + volumenDisponible() + "cm3");

        return stringBuilder.toString();
    }
}
