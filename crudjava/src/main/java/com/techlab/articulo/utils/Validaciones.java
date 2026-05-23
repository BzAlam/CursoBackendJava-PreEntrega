package com.techlab.articulo.utils;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public final class Validaciones {
    private Validaciones() {}
    
    public static boolean EstaVacioElString_(String unNombre) {
        return unNombre == null || unNombre.trim().isEmpty();
    }

    public static String ingresarNombreNoVacio(Scanner scanner) {
        while (true) {
            String texto = scanner.nextLine();
            //scanner.nextLine();
            if (! EstaVacioElString_(texto)) {
                return texto;
            }
            System.out.println("El texto ingresado no puede estar vacío, por favor, intente nuevamente: ");
        }
    }

    public static String ingresarNombreNoVacio(Scanner scanner, String mensajeParaMostrar) {
        System.out.println(mensajeParaMostrar);
        return ingresarNombreNoVacio(scanner);
    }

    // public static int ingresarNumero(Scanner scanner) {
    //     Consumer <String> salida = mensaje -> {
    //         System.out.println(mensaje);
    //         scanner.nextLine();
    //     };
    //     while (true) {
    //         try {
    //             int numero = scanner.nextInt();
    //             scanner.nextLine();
    //             return numero;
    //         } catch (InputMismatchException errorDeInput) {
    //             salida.accept("Ese no es un número válido, por favor, seleccione un numero válido:");
    //         } catch (NoSuchElementException errorDeAgotamiento) {
    //             salida.accept("Agotado el tiempo límite, por favor, intente nuevamente");
    //         } catch (IllegalStateException errorScannerCerrado) {
    //             salida.accept("El input ya no se encuentra disponible, por favor, reinicie el programa.");
    //         } catch (Exception excepcionNoManejada) {
    //             salida.accept("Ocurrió un error, por favor, intente nuevamente: ");
    //         }
    //     }
    // }

    public static double ingresarNumeroDouble(Scanner scanner) {
        Consumer <String> salida = mensaje -> {
            System.out.println(mensaje);
            scanner.nextLine();
        };
        while (true) {
            try {
                double numero = scanner.nextDouble();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException errorDeInput) {
                salida.accept("Ese no es un número válido, por favor, seleccione un numero válido:");
            } catch (NoSuchElementException errorDeAgotamiento) {
                salida.accept("Agotado el tiempo límite, por favor, intente nuevamente");
            } catch (IllegalStateException errorScannerCerrado) {
                salida.accept("El input ya no se encuentra disponible, por favor, reinicie el programa.");
            } catch (Exception excepcionNoManejada) {
                salida.accept("Ocurrió un error, por favor, intente nuevamente: ");
            }
        }
    }

    public static int ingresarNumero(Scanner scanner) {
        return (int) ingresarNumeroDouble(scanner);
    }
}
