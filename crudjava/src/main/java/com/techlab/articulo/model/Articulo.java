package com.techlab.articulo.model;
import com.techlab.articulo.interfaces.Identificable;
import com.techlab.articulo.interfaces.Calculable;
import com.techlab.articulo.utils.Validaciones;
import com.techlab.articulo.utils.Secuencias;

public abstract class Articulo implements Identificable, Calculable {
    private static int cantidadProductosCreados = 0;
    private String nombre;
    private double precio;
    private String descripcion;
    private Categoria categoria;
    private int codigo;

    public Articulo(String nombre, double precio, String descripcion, Categoria categoria) {
        this.Nombre(nombre);
        this.Precio(precio);
        this.Descripcion(descripcion);
        this.Categoria(categoria);
        this.codigo = Secuencias.generarCodigoArticulo();
        cantidadProductosCreados += 1;   
    }
        
    public void MostrarInformacion() {
        System.out.println("=========== Producto =================");
        System.out.println("Código --> " + this.codigo);
        System.out.println("Nombre --> " + this.nombre);
        System.out.println("Precio --> " + this.precio);
        System.out.println("Descripción --> " + this.descripcion);
        System.out.println("Categoria --> " + this.categoria);
        System.out.println("======================================");
    }

    public static double CalcularDescuentoDelDiezPorcientoSobre_(double precio) {
        return precio * 0.9;
    }

    public double Precio() {
        return this.precio;
    }

    public void Precio(double setPrecio) {
        if(setPrecio <= 0) return;
        this.precio = setPrecio;
    }

    public void Nombre(String setNombre){
        if(Validaciones.EstaVacioElString_(setNombre)) return;
        this.nombre = setNombre;
    }

    public String Nombre() {
        return this.nombre;
    }

    public String Descripcion() {
        return this.descripcion;
    }

    public void Descripcion(String setDescripcion){
        if(Validaciones.EstaVacioElString_(setDescripcion)) return;
        this.descripcion = setDescripcion;
    }

    public Categoria Categoria() {
        return this.categoria;
    }

    public void Categoria(Categoria setCategoria) {
        this.categoria = setCategoria;
    }

    public static int CantidadProductosCreados(){
        return cantidadProductosCreados;
    }

    @Override
    public String toString() {
        return "{codigo: " + this.codigo + "} {nombre: " + this.nombre + "} {precio: " + this.precio + "} {descripcion: " + this.descripcion + "}";
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

    public abstract double calcularPrecioFinal();

    public abstract double calcularPrecioFinalSinDescuento();

    public abstract String getTipoArticulo();

    public abstract String getDetalleEspecifico();
}
