package com.techlab.articulo.menu;

import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Validaciones;

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
                this.IngresarCategoria();
                break;
            }
            case 2: {
                this.ListarCategorias();
                break;
            }
            case 3: {
                this.ConsultarCategoriaPorCodigo();
                break;
            }
            case 4: {
                this.ModificarUnaCategoria();
                break;
            }
            case 5: {
                this.EliminarUnacategoria();
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
    
    private void IngresarCategoria() {
        Categoria categoria = crearCategoria();
        repositorioCategoria.AgregarElemento(categoria);
    }

    private Categoria crearCategoria() {
        String nombre = CrearNombreParaCategoria();
        String descripcion = CrearDescripcionParaCategoria();
        return new Categoria(nombre, descripcion);
    }

    private String CrearNombreParaCategoria() {
        String nombre;
        while (true) {
            nombre = Validaciones.ingresarNombreNoVacio(this.Scanner(), "Por favor, ingrese el nombre de la categoría");
            if(! ExisteCategoriaConNombre(nombre)) {
                return nombre;
            }
            System.out.println("La categoría con el nombre " + nombre + "ya existe en el listado. Por favor seleccione otro nombre.");
        }
    }

    private String CrearDescripcionParaCategoria() {
        return Validaciones.ingresarNombreNoVacio(this.Scanner(), "Por favor, ingrese la descripción de la categoría");
    }

    private boolean ExisteCategoriaConNombre(String nombre) {
        boolean existeCategoriaConNombre = false;
        for (Categoria categoria : this.repositorioCategoria.Lista()) {
            existeCategoriaConNombre = existeCategoriaConNombre || categoria.Nombre() == nombre;
            if (existeCategoriaConNombre) {break;}
        }
        return existeCategoriaConNombre;
    }

    private void ListarCategorias() {
        this.repositorioCategoria.listarElementosEnConsola();
    }

    private void ConsultarCategoriaPorCodigo() {
        int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código de la categoría a consultar: ");
        this.ImprimirCategoriaPorCodigo(codigo);
    }

    private void ImprimirCategoriaPorCodigo(int codigo) {
        if(this.repositorioCategoria.ExisteElElementoConCodigo_(codigo)) {
            System.out.println(this.BuscarCategoriaConCodigo(codigo));
            return;
        }
        System.out.println("No existe una categoría con el código " + codigo + " en el listado!");
    }

    private Categoria BuscarCategoriaConCodigo(int codigo) {
        return this.repositorioCategoria.BuscarElementoPorCodigo_(codigo);
    }

    private void ModificarUnaCategoria() {
        int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código de la categoría a modificar: ");
        if(! this.repositorioCategoria.ExisteElElementoConCodigo_(codigo)) {
            System.out.println("No existe una categoría con el código " + codigo + " en el listado!");
            return;
        }
        this.ModificarAtributoDeCategoria(this.BuscarCategoriaConCodigo(codigo));
    }

    private void ModificarAtributoDeCategoria(Categoria categoriaParaCambiarAtributo) {
        int opcionParaCambiar;
        while (true) {
            System.out.println("¿Qué elemento de la categoría desea modificar?");
            System.out.println("1) Nombre");
            System.out.println("2) Descripcion");
            System.out.println("0) Salir");
            opcionParaCambiar = this.SolicitarCodigoConMensaje("Por favor, ingrese un número y presione enter: ");
            switch (opcionParaCambiar) {
                case 1: {
                    String nuevoNombre = this.CrearNombreParaCategoria();
                    categoriaParaCambiarAtributo.Nombre(nuevoNombre);
                    break;
                }
                case 2: {
                    String nuevaDescripcion = this.CrearNombreParaCategoria();
                    categoriaParaCambiarAtributo.Descripcion(nuevaDescripcion);
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("La opción seleccionada no es correcta, por favor, seleccione una de las opciones listadas arriba.");
                }
            }
        }
    }

    private void EliminarUnacategoria() {
        int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código de la categoría a eliminar: ");
        if(! this.repositorioCategoria.ExisteElElementoConCodigo_(codigo)) {
            System.out.println("La categoría con el codigo " + codigo + " no se encuentra en la lista!");
        }
        if(Categoria_TieneArticulosAsociados(BuscarCategoriaConCodigo(codigo))) {
            System.out.println("La categoría con el codigo " + codigo + " no se puede eliminar ya que esta tiene articulos asociados. Cambie la categoria de los productos antes de eliminar esta categora.");
        }
        this.repositorioCategoria.EliminarElementoConCodigo_(codigo);
    }

    private boolean Categoria_TieneArticulosAsociados(Categoria categoria) {
        boolean tieneArticulosAsociados = false;
        for (Articulo articulo : this.repositorioArticulos.Lista()) {
            tieneArticulosAsociados = tieneArticulosAsociados || Articulo_TieneComoCategoria_(articulo, categoria);
            if(tieneArticulosAsociados) break;
        }
        return tieneArticulosAsociados;
    }

    private boolean Articulo_TieneComoCategoria_(Articulo articulo, Categoria categoria) {
        return articulo.Categoria().getCodigo() == categoria.getCodigo();
    }
}