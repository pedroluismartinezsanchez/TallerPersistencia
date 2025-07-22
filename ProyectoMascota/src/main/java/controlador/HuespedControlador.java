/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.HuespedDAO;
import dto.HuespedDTO;
import java.util.List;
import model.Huesped;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class HuespedControlador {
    private HuespedDAO dao = new HuespedDAO();

    public void registrarHuesped(HuespedDTO dto) {
        validar(dto);
        Huesped h = new Huesped(dto.getNombre(), dto.getDocumento(), dto.getEdad());
        dao.guardar(h);
    }

    public List<Huesped> obtenerHuespedes() {
        return dao.listar();
    }

    public void eliminar(String nombre) {
        dao.eliminarPorNombre(nombre);
    }

    public void actualizar(String nombreClave, HuespedDTO dto) {
        validar(dto);
        Huesped nuevo = new Huesped(dto.getNombre(), dto.getDocumento(), dto.getEdad());
        dao.actualizar(nombreClave, nuevo);
    }

    private void validar(HuespedDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (dto.getDocumento() == null || dto.getDocumento().isBlank()) {
            throw new IllegalArgumentException("El documento no puede estar vacío.");
        }
        if (dto.getEdad() < 0) {
            throw new IllegalArgumentException("Edad inválida.");
        }
    }
}

