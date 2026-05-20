package com.techlab.articulo.utils;
public final class Secuencias {
    public static int codigoActualArticulo = 0;
    public static int codigoActualCategoria = 0;

    private Secuencias() {}

    public static int generarCodigoArticulo() {
        int numeroActual = codigoActualArticulo;
        codigoActualArticulo++;
        return numeroActual;
    }

    public static int generarCodigoCategoria() {
        int numeroActual = codigoActualCategoria;
        codigoActualCategoria++;
        return numeroActual;
    }
}
