
package main;

public class Profesor {
    private String nombre;
    private EquipoComputo equipo;

    public Profesor(String nombre, EquipoComputo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public EquipoComputo getEquipo() {
        return equipo;
    }
}
