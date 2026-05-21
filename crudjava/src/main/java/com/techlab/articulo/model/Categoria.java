package com.techlab.articulo.model;
import com.techlab.articulo.interfaces.Identificable;
import com.techlab.articulo.utils.Validaciones;
import com.techlab.articulo.utils.Secuencias;

public class Categoria implements Identificable {
    private int codigo;
    private String nombre;
    private String descripcion;
    
    public Categoria(String nombre, String descripcion) {
        this.Nombre(nombre);
        this.Descripcion(descripcion);
        this.codigo = Secuencias.generarCodigoCategoria();
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

    @Override
    public String toString() {
        return "{codigo: " + this.codigo + "} {nombre: " + this.nombre + "} {descripcion: " + this.descripcion + "}";
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }
}