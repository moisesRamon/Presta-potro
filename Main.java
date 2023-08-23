package main;
        
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {

    private ArrayList<EquipoComputo> almacen = new ArrayList<>();
    private Usuario usuarioActual = null;

    private JTextField marcaField, almacenamientoField, ramField, precioField;
    private JTextArea equiposArea;
    private JComboBox<String> equiposComboBox;

    public Main() {
        setTitle("Sistema de Almacén de Cómputo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel marcaLabel = new JLabel("Marca:");
        marcaField = new JTextField();
        JLabel almacenamientoLabel = new JLabel("Almacenamiento (GB):");
        almacenamientoField = new JTextField();
        JLabel ramLabel = new JLabel("RAM (GB):");
        ramField = new JTextField();
        JLabel precioLabel = new JLabel("Precio por hora:");
        precioField = new JTextField();

        JButton agregarButton = new JButton("Agregar Equipo");
        JButton mostrarButton = new JButton("Mostrar Equipos");
        JButton eliminarButton = new JButton("Eliminar Equipo");
        JButton rentarButton = new JButton("Rentar Equipo");

        equiposComboBox = new JComboBox<>();
        equiposComboBox.addItem("Seleccionar equipo");
        equiposArea = new JTextArea(10, 30);
        equiposArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(equiposArea);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEquipo();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEquipos();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEquipo();
            }
        });

        rentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentarEquipo();
            }
        });

        panel.add(marcaLabel);
        panel.add(marcaField);
        panel.add(almacenamientoLabel);
        panel.add(almacenamientoField);
        panel.add(ramLabel);
        panel.add(ramField);
        panel.add(precioLabel);
        panel.add(precioField);
        panel.add(agregarButton);
        panel.add(mostrarButton);
        panel.add(rentarButton);
        panel.add(eliminarButton);
        panel.add(equiposComboBox);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarEquipo() {
        String marca = marcaField.getText();
        int almacenamiento = Integer.parseInt(almacenamientoField.getText());
        int ram = Integer.parseInt(ramField.getText());
        double precio = Double.parseDouble(precioField.getText());

        EquipoComputo equipo = new EquipoComputo(marca, almacenamiento, ram, precio);
        almacen.add(equipo);
        equiposComboBox.addItem(marca); // Agregar al ComboBox
        equiposArea.append("Equipo agregado:\n");
        equiposArea.append("Marca: " + marca + "\n");
        equiposArea.append("Almacenamiento: " + almacenamiento + " GB\n");
        equiposArea.append("RAM: " + ram + " GB\n");
        equiposArea.append("Precio por hora: $" + precio + "\n");
        equiposArea.append("--------------------------\n");

        // Limpiar campos
        marcaField.setText("");
        almacenamientoField.setText("");
        ramField.setText("");
        precioField.setText("");
    }

private void mostrarEquipos() {
    equiposArea.setText("===== Listado de Equipos =====\n");
    for (EquipoComputo equipo : almacen) {
        equiposArea.append("Marca: " + equipo.getMarca() + "\n");
        equiposArea.append("Almacenamiento: " + equipo.getAlmacenamientoGB() + " GB\n");
        equiposArea.append("RAM: " + equipo.getRamGB() + " GB\n");
        equiposArea.append("Precio por hora: $" + equipo.getPrecioPorHora() + "\n");
        if (equipo.isRented()) {
            equiposArea.append("Estado: No disponible (Rentado)\n");
        } else {
            equiposArea.append("Estado: Disponible\n");
        }
        equiposArea.append("--------------------------\n");
    }
}

    private void eliminarEquipo() {
        int selectedIdx = equiposComboBox.getSelectedIndex();
        if (selectedIdx > 0 && selectedIdx <= almacen.size()) {
            EquipoComputo equipo = almacen.remove(selectedIdx - 1);
            equiposComboBox.removeItemAt(selectedIdx);
            equiposArea.append("Equipo eliminado:\n");
            equiposArea.append("Marca: " + equipo.getMarca() + "\n");
            equiposArea.append("Almacenamiento: " + equipo.getAlmacenamientoGB() + " GB\n");
            equiposArea.append("RAM: " + equipo.getRamGB() + " GB\n");
            equiposArea.append("Precio por hora: $" + equipo.getPrecioPorHora() + "\n");
            equiposArea.append("--------------------------\n");
        }
    }

    private void rentarEquipo() {
        int selectedIdx = equiposComboBox.getSelectedIndex();
        if (selectedIdx > 0 && selectedIdx <= almacen.size()) {
            EquipoComputo equipo = almacen.get(selectedIdx - 1);
            if (usuarioActual instanceof UsuarioRentable) {
                ((UsuarioRentable) usuarioActual).rentarEquipo(equipo);
                equiposArea.append(usuarioActual.getNombre() + " rentó el equipo:\n");
                equiposArea.append("Marca: " + equipo.getMarca() + "\n");
                equiposArea.append("Almacenamiento: " + equipo.getAlmacenamientoGB() + " GB\n");
                equiposArea.append("RAM: " + equipo.getRamGB() + " GB\n");
                equiposArea.append("Precio por hora: $" + equipo.getPrecioPorHora() + "\n");
                equiposArea.append("--------------------------\n");
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ha rentado el equipo.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}



