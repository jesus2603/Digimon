package digimon;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Digimon {
    private String nombre;
    private String especie;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;

    public Digimon(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
        this.nivel = new Random().nextInt(5) + 1;
        this.ataque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getNivel() {
        return nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int ataque1() {
        if (dp1 > 0) {
            dp1--;
            return ataque;
        } else {
            return 0;
        }
    }

    public int ataque2() {
        if (dp2 > 1) {
            dp2 -= 2;
            return 2 * ataque;
        } else {
            return 0;
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Nivel: " + nivel);
        System.out.println("Ataque: " + ataque);
        System.out.println("Salud: " + salud);
        System.out.println("DP1: " + dp1 + " (daño: " + ataque + ")");
        System.out.println("DP2: " + dp2 + " (daño: " + (2 * ataque) + ")");
    }

    @Override
    public String toString() {
        return nombre + " (" + especie + ") - Nivel: " + nivel + ", Ataque: " + ataque + ", Salud: " + salud + ", DP1: " + dp1 + ", DP2: " + dp2;
    }
}