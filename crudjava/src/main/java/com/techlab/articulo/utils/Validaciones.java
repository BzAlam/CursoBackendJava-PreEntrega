package com.techlab.articulo.utils;

public final class Validaciones {
    private Validaciones() {}
    
    public static boolean EstaVacioElString_(String unNombre) {
        return unNombre == null || unNombre.trim().isEmpty();
    }
}
