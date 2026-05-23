package com.techlab.articulo.menu;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Validaciones;
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
                this.IngresarArticulo();
                break;
            }
            case 2: {
                this.ListarArticulos();
                break;
            }
            case 3: {
                this.ConsultarArticuloPorCodigo();
                break;
            }
            case 4: {
                //this.ModificarUnArticulo();
                break;
            }
            case 5: {
                this.EliminarUnArticulo();
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

    private void IngresarArticulo() {
        if(RepositorioCategoriasNoEstaVacio()) {
            System.out.println("No es posible ingresar un artículo si no hay categorías antes! Por favor, cree o ingrese una nueva categoría.");
            return;
        }
        this.repositorioArticulos.AgregarElemento(this.CrearNuevoArticulo());
    }

    private Articulo CrearNuevoArticulo() {
        String nombre = this.PedirNombreArticulo();
        double precio = this.PedirPrecioArticulo();
        String descripcion = this.PedirDescripcionArticulo();
        Categoria categoria = this.PedirCategoriaExistentePorCodigo();
        return SeleccionarArticuloParaCrear(nombre, precio, descripcion, categoria);
    }

    private Articulo SeleccionarArticuloParaCrear(String nombre, double precio, String descripcion, Categoria categoria) {
        while (true) {
            System.out.println("Ahora hay que seleccionar el tipo, ¿Qué clase de artículo desea agregar?: ");
            System.out.println("1) Articulo Alimenticio");
            System.out.println("2) Articulo Electrónico");
            int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el número del tipo de art´ículo a crear: ");
            switch (codigo) {
                case 1: {
                    return this.CrearArticuloAlimenticio(nombre, precio, descripcion, categoria);
                }
                case 2: {
                    return CrearArticuloElectronico(nombre, precio, descripcion, categoria);
                }
                default:{
                    System.out.println("El código ingresado no corresponde a ninguna categoría.");
                    break;
                }
            }
        }
    }

    private String PedirNombreArticulo() {
        System.out.println("Por favor, ingrese el nombre del artículo: ");
        return Validaciones.ingresarNombreNoVacio(this.Scanner());
    }

    private double PedirPrecioArticulo() {
        System.out.println("Por favor, ingrese el precio del artículo: ");
        return Validaciones.ingresarNumeroDouble(this.Scanner());
    }

    private String PedirDescripcionArticulo() {
        System.out.println("Por favor, ingresela descripcion del artículo: ");
        return Validaciones.ingresarNombreNoVacio(this.Scanner());
    }

    private Categoria PedirCategoriaExistentePorCodigo() {
        while (true) {
            this.ListarCategorias();
            int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código de una de las categorias listadas arriba: ");
            if(ExisteCategoriaConCodigo_(codigo)) {
                return BuscarCategoriaConCodigo_(codigo);
            }
            System.out.println("La categoria con el codigo " + codigo + "  no se encuentra en esta lista!");
        }
        
    }

    private boolean ExisteCategoriaConCodigo_(int codigo) {
        boolean existeCategoria = false;
        for (Categoria categoria : this.repositorioCategoria.Lista()) {
            existeCategoria = existeCategoria || this.Categoria_TieneCodigo_(categoria, codigo);
            if(existeCategoria) break;
        }
        return existeCategoria;
    }

    private boolean Categoria_TieneCodigo_(Categoria categoria, int codigo) {
        return categoria.getCodigo() == codigo;
    } 

    private Categoria BuscarCategoriaConCodigo_(int codigo) {
        for (Categoria categoria : this.repositorioCategoria.Lista()) {
            if(Categoria_TieneCodigo_(categoria, codigo)) return categoria;
        }
        return null;
    }

    private void ListarCategorias() {
        this.repositorioCategoria.listarElementosEnConsola();
    }

    private ArticuloAlimenticio CrearArticuloAlimenticio(String nombre, double precio, String descripcion, Categoria categoria) {
        int fechaVencimiento = this.SolicitarCodigoConMensaje("Por favor, ingrese la cantidad de dias antes del vencimiento del producto: ");
        return new ArticuloAlimenticio(nombre, precio, descripcion, categoria, fechaVencimiento);
    }

    private ArticuloAlimenticio CrearArticuloElectronico(String nombre, double precio, String descripcion, Categoria categoria) {
        int mesesDeGarantia = this.SolicitarCodigoConMensaje("Por favor, ingrese la cantidad de meses restantes de garantía: ");
        return new ArticuloAlimenticio(nombre, precio, descripcion, categoria, mesesDeGarantia);
    }

    //TODO

    // private void ModificarUnArticulo() {
    //     this.MostrarMenuDeModificacion();
    //     int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el numero de la opción deseada: ")
    //     switch (codigo) {
    //         case 1: {
    //             break;
    //         }
    //         case 1: {
    //             break;
    //         }
    //         case 1: {
    //             break;
    //         }
    //         case 1: {
    //             break;
    //         }
    //         case 1: {
    //             break;
    //         }
    //         default: {
    //             System.out.println("El número ingresado no es válido, por favor, seleccion nuevamente la opción.");;
    //         }
    //     }
    
    // }

    // private void MostrarMenuDeModificacion() {
    //     System.out.println("¿Qué atributo desea modificar del artículo?");
    //     System.out.println("1) Nombre");
    //     System.out.println("2) ");
    //     System.out.println("1) Nombre");
    //     System.out.println("1) Nombre");
    //     System.out.println("1) Nombre");
    // }

    private void ListarArticulos() {
        this.repositorioArticulos.listarElementosEnConsola();
    }

    private void ConsultarArticuloPorCodigo() {
        int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código del artículo a consultar: ");
        this.ImprimirArticuloPorCodigo(codigo);
    }

    private void ImprimirArticuloPorCodigo(int codigo) {
        if(this.repositorioArticulos.ExisteElElementoConCodigo_(codigo)) {
            System.out.println(this.BuscarArticuloConCodigo(codigo));
            return;
        } 
        System.out.println("No existe un artículo con el código " + codigo + " en el listado!");
    }

    private void EliminarUnArticulo() {
        int codigo = this.SolicitarCodigoConMensaje("Por favor, ingrese el código del artículo a eliminar: ");
        if(! this.repositorioArticulos.ExisteElElementoConCodigo_(codigo)) {
            System.out.println("el Articulo con el codigo " + codigo + " no se encuentra en la lista!");
        }
        this.repositorioArticulos.EliminarElementoConCodigo_(codigo);
    }

    private Articulo BuscarArticuloConCodigo(int codigo) {
        return this.repositorioArticulos.BuscarElementoPorCodigo_(codigo);
    }

    private boolean RepositorioCategoriasNoEstaVacio() {
        return ! this.repositorioCategoria.EstaVacio();
    }
}
