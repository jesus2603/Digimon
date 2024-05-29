package digimon;

import java.util.Random;
import java.util.Scanner;

/**
 * La clase Batalla representa una batalla entre un domador y un Digimon enemigo.
 * Un Digimon enemigo es seleccionado aleatoriamente al inicio de la batalla.
 */
public class Batalla {

    private Digimon enemigo;

    /**
     * Constructor de la clase Batalla.
     * Inicializa un Digimon enemigo seleccionado aleatoriamente de una lista de nombres.
     */
    public Batalla() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String digimonEnemigo = nombres[new Random().nextInt(nombres.length)];
        enemigo = new Digimon(digimonEnemigo, digimonEnemigo);
    }

    /**
     * Obtiene el Digimon enemigo.
     * @return el Digimon enemigo.
     */
    public Digimon getEnemigo() {
        return enemigo;
    }

    /**
     * Permite al domador elegir un Digimon de su equipo para la batalla.
     * @param domador el domador que elige el Digimon.
     */
    public void elige(Domador domador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un Digimon de tu equipo:");
        for (int i = 0; i < domador.getEquipo().size(); i++) {
            System.out.println((i + 1) + ". " + domador.getEquipo().get(i));
        }
        int eleccion = validarEntrada(domador.getEquipo().size());
        Digimon elegido = domador.getEquipo().get(eleccion - 1);
        pelea(domador, elegido);
    }

    /**
     * Inicia la pelea entre el Digimon elegido por el domador y el Digimon enemigo.
     * @param domador el domador que participa en la batalla.
     * @param digimon el Digimon elegido por el domador.
     */
    public void pelea(Domador domador, Digimon digimon) {
        Scanner scanner = new Scanner(System.in);
        while (enemigo.getSalud() > 0 && digimon.getSalud() > 0) {
            System.out.println("Tu Digimon: " + digimon);
            System.out.println("Digimon Enemigo: " + enemigo);
            System.out.println("Elige una opción:");
            System.out.println("1. Ataque1");
            System.out.println("2. Ataque2");
            System.out.println("3. Capturar");

            int opcion = validarEntrada(3);
            int dano = 0;
            switch (opcion) {
                case 1:
                    dano = digimon.ataque1();
                    enemigo.setSalud(enemigo.getSalud() - dano);
                    System.out.println(digimon.getNombre() + " ha usado Ataque1 causando " + dano + " de daño.");
                    break;
                case 2:
                    dano = digimon.ataque2();
                    enemigo.setSalud(enemigo.getSalud() - dano);
                    System.out.println(digimon.getNombre() + " ha usado Ataque2 causando " + dano + " de daño.");
                    break;
                case 3:
                    domador.captura(enemigo);
                    if (domador.getEquipo().size() >= Domador.CAPACIDAD_EQUIPO) {
                        System.out.println("¡Felicidades! Has capturado los 3 Digimon y has terminado el juego, eres un maquina!!!.");
                        System.exit(0);
                    }
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (enemigo.getSalud() > 0) {
                int danoEnemigo = enemigo.ataque1();
                digimon.setSalud(digimon.getSalud() - danoEnemigo);
                System.out.println(enemigo.getNombre() + " ha usado causando " + danoEnemigo + " de daño.");
            }
        }

        if (digimon.getSalud() <= 0) {
            System.out.println(digimon.getNombre() + " ha sido derrotado.");
        } else if (enemigo.getSalud() <= 0) {
            System.out.println(enemigo.getNombre() + " ha sido derrotado.");
        }
    }

    /**
     * Valida la entrada del usuario para asegurarse de que está dentro del rango permitido.
     * @param max el valor máximo permitido.
     * @return la opción seleccionada por el usuario.
     */
    private int validarEntrada(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion < 1 || opcion > max) {
            System.out.print("Elige una opción válida (1-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada errónea. Elige una opción válida (1-" + max + "): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
        }
        return opcion;
    }
}
