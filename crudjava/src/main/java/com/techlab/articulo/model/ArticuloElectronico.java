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
        return this.Precio() * this.SobrecargoPorGarantia();
    }

    @Override
    public String getTipoArticulo() {
        return "Articulo Electronico";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Articulo con " + this.garantiaMeses + " meses de garantía";
    }

    @Override
    public String toString() {
        return super.toString() + " {Meses de garantía restantes: " + this.garantiaMeses + "}";
    }

    public double SobrecargoPorGarantia() {
        if (this.garantiaMeses > 12) { 
            return 1.10; 
        }
        else {
            return 1;
        } 
    }
}
