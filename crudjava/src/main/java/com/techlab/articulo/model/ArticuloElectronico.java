package com.techlab.articulo.model;

public class ArticuloElectronico extends Articulo {
    private int garantiaMeses;

    public ArticuloElectronico(String nombre, double precio, String descripcion, Categoria categoria, int garantiaMeses) {
        super(nombre, precio, descripcion, categoria);
        this.GarantiaMeses(garantiaMeses);
    } 

    public int GarantiaMeses() {
        return this.garantiaMeses;
    }

    public void GarantiaMeses(int setGarantiaMeses) {
        if(setGarantiaMeses >= 1) return;
        this.garantiaMeses = setGarantiaMeses;
    }

    @Override
    public double calcularPrecioFinal(){

    }

    @Override
    public Categoria getTipoArticulo() {

    } 

    @Override
    public int getCodigo() {

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
