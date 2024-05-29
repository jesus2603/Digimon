package digimon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal del programa donde se maneja la interacción con el usuario
 * y se controlan las batallas entre Digimons.
 */
public class Principal {

    /**
     * Método principal del programa.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);

        while (true) {
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");
            int opcion = validarEntrada(2);

            if (opcion == 1) {
                Batalla batalla = new Batalla();
                System.out.println("¡Un " + batalla.getEnemigo().getNombre() + " salvaje ha aparecido!");
                batalla.elige(domador);
            } else if (opcion == 2) {
                System.out.println("¡Hasta la próxima!");
                break;
            }
        }
    }

    /**
     * Valida la entrada del usuario para asegurar que se introduce un número dentro
     * de un rango válido.
     * 
     * @param max El número máximo permitido (inclusive).
     * @return La opción elegida por el usuario dentro del rango válido.
     */
    private static int validarEntrada(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion < 1 || opcion > max) {
            System.out.print("Elige una opción válida (1-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Elige una opción válida (1-" + max + "): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
        }
        return opcion;
    }
}
