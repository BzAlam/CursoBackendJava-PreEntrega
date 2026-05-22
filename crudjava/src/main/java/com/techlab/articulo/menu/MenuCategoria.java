package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;

public class MenuCategoria extends Menu {
    protected Repositorio<Articulo> repositorioArticulos;
    protected Repositorio<Categoria> repositorioCategoria;

    public MenuCategoria(Scanner scanner, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategoria) {
        super(scanner);
        this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategoria = repositorioCategoria;
    }

    @Override
    protected void MostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de categorías. ¿Qué desea hacer?");
        System.out.println("1) Ingresar categoría");
        System.out.println("2) Listar categorías");
        System.out.println("3) Consultar una categoría por código");
        System.out.println("4) Modificar una categoría");
        System.out.println("5) Eliminar una categoría");
        System.out.println("0) Volver");
    }

    @Override
    protected void EjecutarComandoPorNumeroDeOpcion(int NumeroDeOpcion) {
        switch (NumeroDeOpcion) {
            case 1: {
                //this.IngresarCategoria(); //TODO
                break;
            }
            case 2: {
                //this.ListarCategorias();
                break;
            }
            case 3: {
                //this.ConsultarCategoriaPorCodigo();
                break;
            }
            case 4: {
                //this.ModificarUnaCategoria();
                break;
            }
            case 5: {
                //this.EliminarUnacategoria();
                break;
            }
            case 0: {
                return;
            }
            default: {
                System.out.println("La opción seleccionada no es correcta, por favor, ingrese uno de los número listados y presione enter.");
                break;
            }
        }
    }
    
}