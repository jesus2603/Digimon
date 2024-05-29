package digimon;

import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Domador representa a un entrenador de Digimons.
 * Cada domador tiene un nombre y un equipo de Digimons.
 */
public class Domador {
    private String nombre;
    private ArrayList<Digimon> equipo;
    static final int CAPACIDAD_EQUIPO = 3;

    /**
     * Constructor que crea un nuevo Domador con un nombre dado.
     * El constructor inicializa el equipo del domador con un Digimon aleatorio.
     *
     * @param nombre El nombre del domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        // Agregar un Digimon aleatorio al equipo
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String digimonInicial = nombres[new Random().nextInt(nombres.length)];
        equipo.add(new Digimon(digimonInicial, digimonInicial));
    }

    /**
     * Obtiene el nombre del domador.
     *
     * @return El nombre del domador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el equipo de Digimons del domador.
     *
     * @return Una lista con el equipo de Digimons del domador.
     */
    public ArrayList<Digimon> getEquipo() {
        return equipo;
    }

    /**
     * Intenta capturar un Digimon y agregarlo al equipo del domador.
     * El Digimon puede ser capturado si su salud es menor o igual a 20 y si el equipo del domador
     * aún no ha alcanzado la capacidad máxima.
     *
     * @param digimon El Digimon que se intentará capturar.
     */
    public void captura(Digimon digimon) {
        if (digimon.getSalud() <= 20 && equipo.size() < CAPACIDAD_EQUIPO) {
            equipo.add(digimon);
            System.out.println(digimon.getNombre() + " se ha unido a su equipo");
        } else {
            System.out.println("No se puede unir, tiene más vida del mínimo que hay que tener para poder capturarlo");
        }
    }
}
