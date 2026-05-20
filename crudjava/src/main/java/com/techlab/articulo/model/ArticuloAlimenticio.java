package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;

public class ArticuloAlimenticio extends Articulo {
    private int diasParaVencimiento;

    public ArticuloAlimenticio(String nombre, double precio, String descripcion, Categoria categoria, int diasParaVencimiento) {
        super(nombre, precio, descripcion, categoria);
        this.DiasParaVencimiento(diasParaVencimiento);
    } 

    public int DiasParaVencimiento() {
        return this.diasParaVencimiento;
    }

    public void DiasParaVencimiento(int setDiasParaVencimiento) {
        if(setDiasParaVencimiento >= 1) return;
        this.diasParaVencimiento = setDiasParaVencimiento;
    }

    @Override
    public double calcularPrecioFinal(){

    }

    @Override
    public Categoria getTipoArticulo() {

    }

    @Override
    public String getDetalleEspecifico() {

    }

    @Override
    public double calcularPrecioFinalSinDescuento() {

    }

    @Override
    public String toString() {

    }
}
