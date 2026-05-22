package com.techlab.articulo.repository;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.techlab.articulo.interfaces.Identificable;

public class Repositorio<Tipo extends Identificable> {
    private ArrayList<Tipo> lista = new ArrayList<>();

    public Repositorio() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<Tipo> Lista() {
        return new ArrayList<>(this.lista);
    } 

    public void AgregarElemento(Tipo elementoParaAgregar) {
        this.lista.add(elementoParaAgregar);
    }

    public void listarElementosEnConsola() {
        for(Tipo elemento : this.lista) {
            System.out.println(elemento);
        }
    }

    public Tipo BuscarElementoPorCodigo_(int codigo) {
        for(Tipo elemento : this.lista) {
            if (elemento.getCodigo() == codigo) {
                return elemento;
            }
        }
        throw new NoSuchElementException("El elemento con el código " + codigo + " no se encuentra registrado en el sistema.");
    }

    public boolean ExisteElElementoConCodigo_(int codigo) {
        boolean existeElElemento = false;
        for(Tipo elemento : this.lista) {
            existeElElemento = existeElElemento || elemento.getCodigo() == codigo;
            if(existeElElemento) break;
        }
        return existeElElemento;
    }

    public void EliminarElementoConCodigo_(int codigo) {
        Tipo elemento = BuscarElementoPorCodigo_(codigo);
        this.lista.remove(elemento);
    }

    public void EliminarElemento_(Tipo elemento) {
        this.lista.remove(elemento);
    }

    public boolean EstaVacio() {
        return this.lista.isEmpty();
        //return this.lista.size() >= 0;
    }
}
