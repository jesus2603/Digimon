package digimon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase Digimon representa un Digimon con atributos como nombre, especie, nivel, ataque, salud, y puntos de poder (DP) para ataques.
 */
class Digimon {
    private String nombre;
    private String especie;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;

    /**
     * Constructor de la clase Digimon.
     * Inicializa un Digimon con un nombre y una especie dados. El nivel, ataque y salud se inicializan aleatoriamente.
     * @param nombre el nombre del Digimon.
     * @param especie la especie del Digimon.
     */
    public Digimon(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
        this.nivel = new Random().nextInt(5) + 1;
        this.ataque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Obtiene el nombre del Digimon.
     * @return el nombre del Digimon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la especie del Digimon.
     * @return la especie del Digimon.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Obtiene el nivel del Digimon.
     * @return el nivel del Digimon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene el ataque del Digimon.
     * @return el ataque del Digimon.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene la salud del Digimon.
     * @return la salud del Digimon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Establece la salud del Digimon.
     * @param salud la nueva salud del Digimon.
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Realiza el primer ataque del Digimon, decrementando DP1 y retornando el daño.
     * @return el daño del primer ataque, o 0 si no hay DP1 disponible.
     */
    public int ataque1() {
        if (dp1 > 0) {
            dp1--;
            return ataque;
        } else {
            return 0;
        }
    }

    /**
     * Realiza el segundo ataque del Digimon, decrementando DP2 y retornando el daño.
     * @return el daño del segundo ataque, o 0 si no hay DP2 disponible.
     */
    public int ataque2() {
        if (dp2 > 1) {
            dp2 -= 2;
            return 2 * ataque;
        } else {
            return 0;
        }
    }

    /**
     * Muestra las estadísticas del Digimon.
     * Incluye nombre, especie, nivel, ataque, salud y los puntos de poder para cada ataque.
     */
    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Nivel: " + nivel);
        System.out.println("Ataque: " + ataque);
        System.out.println("Salud: " + salud);
        System.out.println("DP1: " + dp1 + " (daño: " + ataque + ")");
        System.out.println("DP2: " + dp2 + " (daño: " + (2 * ataque) + ")");
    }

    /**
     * Devuelve una representación en cadena del Digimon.
     * @return una cadena que contiene el nombre, especie, nivel, ataque, salud y puntos de poder del Digimon.
     */
    @Override
    public String toString() {
        return nombre + " (" + especie + ") - Nivel: " + nivel + ", Ataque: " + ataque + ", Salud: " + salud + ", DP1: " + dp1 + ", DP2: " + dp2;
    }
}
