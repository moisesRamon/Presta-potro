/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
  public class Usuario implements UsuarioRentable {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void rentarEquipo(EquipoComputo equipo) {
        // Implementa la lógica de rentar un equipo por parte del usuario
        // Aquí podrías registrar la renta en una lista de equipos rentados por el usuario
        // Por ejemplo, si el usuario es un Profesor o Alumno, se implementará en sus clases correspondientes
        JOptionPane.showMessageDialog(null, nombre + " ha rentado el equipo: " + equipo.getMarca());
    }
}
