package com.techlab.articulo;
import java.util.Scanner;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.menu.*;
import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;

public class App extends Menu{
    //Decidí hacer la app principal una clase que herede de menu porque
    //al fin y al cabo esta sigue siendo un menú.
    public static Scanner scanner;
    public static Repositorio<Articulo> repositorioArticulos;
    public static Repositorio<Categoria> repositorioCategoria;
    private static App aplicacion;

    public static void main(String[] args) {
        InicializarObjetos();
        aplicacion.Ejecutar();
        CerrarScanner();
    }

    public App() {
        super(scanner);
    }

    @Override
    protected void MostrarMenu() {
        System.out.println("Bienvenido al sistema de control de productos. ¿Qué desea hacer hoy?");
        System.out.println("1) Gestionar articulos");
        System.out.println("2) Gestionar categorías");
        System.out.println("0) Salir");
    }

    @Override
    protected void EjecutarComandoPorNumeroDeOpcion(int NumeroDeOpcion) {
        switch (this.Opcion()) {
            case 1: {
                this.IniciarMenuArticulos();
                break;
            }  
            case 2: {
                this.IniciarMenuCategorias();
                break;
            }
            case 0: {
                break;
            }
            default: {
                System.out.println("La opción seleccionada no es correcta, por favor, ingrese uno de los números listados y presione enter.");
                break;
            }    
        }
    }

    private void IniciarMenuArticulos() {
        MenuArticulos menuArticulos = new MenuArticulos(scanner, repositorioArticulos, repositorioCategoria);
        menuArticulos.Ejecutar();
    }

    private void IniciarMenuCategorias() {
        MenuCategoria menuCategoria = new MenuCategoria(scanner, repositorioArticulos, repositorioCategoria);
        menuCategoria.Ejecutar();
    }

    private static void InicializarObjetos() {
        scanner = new Scanner(System.in);
        repositorioArticulos = new Repositorio<>();
        repositorioCategoria = new Repositorio<>();
        aplicacion = new App();
    }

    private static void CerrarScanner() {
        scanner.close();
    }
}