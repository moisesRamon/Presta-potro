
package main;

public class Alumno {
    private String nombre;
    private EquipoComputo equipo;

    public Alumno(String nombre, EquipoComputo equipo) {
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



