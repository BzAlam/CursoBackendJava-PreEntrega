package com.techlab.articulo.menu;
import java.util.Scanner;
import com.techlab.articulo.utils.Validaciones;

public abstract class Menu {
    private Scanner scanner;
    private int opcion;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void Ejecutar() {
        while (true) {
            this.MostrarMenu();
            this.CambiarNumeroDeOpcion();
            this.EjecutarComandoPorNumeroDeOpcion(this.Opcion());
            if (this.TerminoElPrograma()) return;
        }
    }
    
    /*Sé que la consigna era hacer abstracto a este método, 
    pero como vi que ambos menús hacían lo mismo, 
    decidí hacerlo general.*/

    //public abstract void Ejecutar();

    protected abstract void MostrarMenu();

    protected abstract void EjecutarComandoPorNumeroDeOpcion(int NumeroDeOpcion);

    protected int Opcion() {
        return this.opcion;
    }

    protected void Opcion(int setOpcion) {
        this.opcion = setOpcion;
    }

    protected Scanner Scanner() {
        return this.scanner;
    }

    public void CambiarNumeroDeOpcion() {
        System.out.println("Por favor, seleccione una de estas opciones y luego presione enter: ");
        this.Opcion(Validaciones.ingresarNumero(this.Scanner()));
    }

    public boolean TerminoElPrograma() {
        return this.Opcion() == 0;
    }

    protected int SolicitarCodigoConMensaje(String mensaje) {
        System.out.println(mensaje);
        return Validaciones.ingresarNumero(this.Scanner());
    }
}