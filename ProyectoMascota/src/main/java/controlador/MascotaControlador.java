/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.MascotaDAO;
import dto.MascotaDTO;
import java.util.List;
import model.Mascota;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
public class MascotaControlador {
     private MascotaDAO dao = new MascotaDAO();

    public void registrarMascota(MascotaDTO dto) {
        validar(dto);
        Mascota m = new Mascota(dto.getNombre(), dto.getEspecie(), dto.getEdad());
        dao.guardar(m);
    }

    public List<Mascota> obtenerMascotas() {
        return dao.listar();
    }

    public void eliminar(String nombre) {
        dao.eliminarPorNombre(nombre);
    }

    public void actualizar(String nombreClave, MascotaDTO dto) {
        validar(dto);
        Mascota nueva = new Mascota(dto.getNombre(), dto.getEspecie(), dto.getEdad());
        dao.actualizar(nombreClave, nueva);
    }

    private void validar(MascotaDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (dto.getEspecie() == null || dto.getEspecie().isBlank()) {
            throw new IllegalArgumentException("La especie no puede estar vacía.");
        }
        if (dto.getEdad() < 0) {
            throw new IllegalArgumentException("Edad inválida.");
        }
    }
}
