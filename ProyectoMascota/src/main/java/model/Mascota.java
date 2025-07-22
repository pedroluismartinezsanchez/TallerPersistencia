/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }

    public void setEspecie(String especie) { this.especie = especie; }
    public void setEdad(int edad) { this.edad = edad; }

    public String toLineaArchivo() {
        return nombre + "," + especie + "," + edad;
    }

    public static Mascota desdeLineaArchivo(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) return null;
        try {
            int edad = Integer.parseInt(partes[2]);
            return new Mascota(partes[0], partes[1], edad);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
