package com.techlab.articulo.menu;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.model.*;
import java.util.Scanner;

public class MenuArticulos extends Menu {
    protected Repositorio<Articulo> repositorioArticulos;
    protected Repositorio<Categoria> repositorioCategoria;

    public MenuArticulos(Scanner scanner, Repositorio<Articulo> repositorioArticulos, Repositorio<Categoria> repositorioCategoria) {
        super(scanner);
        this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategoria = repositorioCategoria;
    }

    @Override
    protected void MostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de articulos. ¿Qué desea hacer?");
        System.out.println("1) Ingresar artículo");
        System.out.println("2) Listar artículos");
        System.out.println("3) Consultar un artículo por código");
        System.out.println("4) Modificar un artículo");
        System.out.println("5) Eliminar un artículo");
        System.out.println("0) Volver");
    }

    @Override
    protected void EjecutarComandoPorNumeroDeOpcion(int NumeroDeOpcion) {
        switch (NumeroDeOpcion) {
            case 1: {
                //this.IngresarArticulo(); //TODO
                break;
            }
            case 2: {
                //this.ListarArticulos();
                break;
            }
            case 3: {
                //this.ConsultarArticuloPorCodigo();
                break;
            }
            case 4: {
                //this.ModificarUnArticulo();
                break;
            }
            case 5: {
                //this.EliminarUnArticulo();
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
