package com.techlab.articulo.model;

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
        return this.Precio() * this.DescuentoPorVencimiento();
    }

    @Override
    public String getTipoArticulo() {
        return "Articulo Alimenticio";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Articulo que vence en " + this.diasParaVencimiento + " días";
    }

    @Override
    public String toString() {
        return super.toString() + " {Dias faltantes para vencimiento: " + this.diasParaVencimiento + "}";
    }

    public double DescuentoPorVencimiento() {
        if (this.diasParaVencimiento <= 7) { 
            return 0.90; 
        }
        else {
            return 1;
        } 
    }
}
