/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */

public class Huesped {
    private String nombre;
    private String documento;
    private int edad;

    public Huesped(String nombre, String documento, int edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public int getEdad() { return edad; }

    public void setDocumento(String documento) { this.documento = documento; }
    public void setEdad(int edad) { this.edad = edad; }

    public String toLineaArchivo() {
        return nombre + "," + documento + "," + edad;
    }

    public static Huesped desdeLineaArchivo(String linea) {
        String[] partes = linea.split(",");
        if (partes.length != 3) return null;
        try {
            int edad = Integer.parseInt(partes[2]);
            return new Huesped(partes[0], partes[1], edad);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

