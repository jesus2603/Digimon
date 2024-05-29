package digimon;

import java.util.ArrayList;
import java.util.Random;

public class Domador {
	private String nombre;
    private ArrayList<Digimon> equipo;
    static final int CAPACIDAD_EQUIPO = 3;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        // Agregar un Digimon aleatorio al equipo
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String digimonInicial = nombres[new Random().nextInt(nombres.length)];
        equipo.add(new Digimon(digimonInicial, digimonInicial));
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Digimon> getEquipo() {
        return equipo;
    }

    public void captura(Digimon digimon) {
        if (digimon.getSalud() <= 20 && equipo.size() < CAPACIDAD_EQUIPO) {
            equipo.add(digimon);
            System.out.println(digimon.getNombre() + " se ha unido a su equipo");
        } else {
            System.out.println("No se puede unir");
        }
    }
}
