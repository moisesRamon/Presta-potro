
package main;

public class EquipoComputo {
    private String marca;
    private int almacenamientoGB;
    private int ramGB;
    private double precioPorHora;

    public EquipoComputo(String marca, int almacenamientoGB, int ramGB, double precioPorHora) {
        this.marca = marca;
        this.almacenamientoGB = almacenamientoGB;
        this.ramGB = ramGB;
        this.precioPorHora = precioPorHora;
    }

    public String getMarca() {
        return marca;
    }

    public int getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public int getRamGB() {
        return ramGB;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    boolean isRented() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
