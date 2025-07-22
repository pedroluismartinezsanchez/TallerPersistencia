/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Huesped;
import persistencia.ArchivoManager;

import java.util.ArrayList;
import java.util.List;

public class HuespedDAO {
    private final ArchivoManager archivo;

    public HuespedDAO() {
        archivo = new ArchivoManager("data/huespedes.txt");
    }

    public void guardar(Huesped huesped) {
        archivo.escribirLinea(huesped.toLineaArchivo());
    }

    public List<Huesped> listar() {
        List<Huesped> huespedes = new ArrayList<>();
        for (String linea : archivo.leerLineas()) {
            Huesped h = Huesped.desdeLineaArchivo(linea);
            if (h != null) huespedes.add(h);
        }
        return huespedes;
    }

    public void eliminarPorNombre(String nombre) {
        List<Huesped> huespedes = listar();
        huespedes.removeIf(h -> h.getNombre().equalsIgnoreCase(nombre));
        sobrescribirLista(huespedes);
    }

    public void actualizar(String nombreClave, Huesped nuevo) {
        List<Huesped> huespedes = listar();
        for (int i = 0; i < huespedes.size(); i++) {
            if (huespedes.get(i).getNombre().equalsIgnoreCase(nombreClave)) {
                huespedes.set(i, nuevo);
                break;
            }
        }
        sobrescribirLista(huespedes);
    }

    private void sobrescribirLista(List<Huesped> huespedes) {
        List<String> lineas = new ArrayList<>();
        for (Huesped h : huespedes) {
            lineas.add(h.toLineaArchivo());
        }
        archivo.sobrescribirArchivo(lineas);
    }
}
