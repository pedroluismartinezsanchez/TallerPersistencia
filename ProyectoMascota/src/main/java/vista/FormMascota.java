/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.HuespedControlador;
import controlador.MascotaControlador;
import dto.MascotaDTO;
import model.Mascota;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormMascota extends JFrame {
    private JTextField txtNombre, txtEspecie, txtEdad;
    private JTextArea txtListado;
    private MascotaControlador controller;
   

    public FormMascota() {
        controller = new MascotaControlador();
       

        setTitle("Gestión de Mascotas");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Panel de entrada
        JPanel panel = new JPanel(new GridLayout(5, 2));
        txtNombre = new JTextField();
        txtEspecie = new JTextField();
        txtEdad = new JTextField();

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Especie:"));
        panel.add(txtEspecie);
        panel.add(new JLabel("Edad:"));
        panel.add(txtEdad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());
        

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizar());

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminar());

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> listar());

        panel.add(btnGuardar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);

        add(panel, BorderLayout.NORTH);

        // Área de listado
        txtListado = new JTextArea();
        add(new JScrollPane(txtListado), BorderLayout.CENTER);
    }

    private void guardar() {
        try {
            MascotaDTO dto = capturarDatos();
            controller.registrarMascota(dto);
            mensaje("Mascota guardada correctamente.");
            limpiar();
        } catch (Exception e) {
            mensaje("Error: " + e.getMessage());
        }
    }

    private void actualizar() {
        try {
            String nombreClave = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a actualizar:");
            MascotaDTO dto = capturarDatos();
            controller.actualizar(nombreClave, dto);
            mensaje("Mascota actualizada.");
            limpiar();
        } catch (Exception e) {
            mensaje("Error: " + e.getMessage());
        }
    }

    private void eliminar() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a eliminar:");
            controller.eliminar(nombre);
            mensaje("Mascota eliminada.");
            limpiar();
        } catch (Exception e) {
            mensaje("Error: " + e.getMessage());
        }
    }

    private void listar() {
        List<Mascota> lista = controller.obtenerMascotas();
        txtListado.setText("");
        for (Mascota m : lista) {
            txtListado.append(m.getNombre() + " | " + m.getEspecie() + " | " + m.getEdad() + "\n");
        }
    }

    private MascotaDTO capturarDatos() {
        String nombre = txtNombre.getText().trim();
        String especie = txtEspecie.getText().trim();
        //int edad = Integer.parseInt(txtEdad.getText().trim());
        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Edad debe ser un número válido.");
        }
        return new MascotaDTO(nombre, especie, edad);
    }

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtEspecie.setText("");
        txtEdad.setText("");
    }
}
