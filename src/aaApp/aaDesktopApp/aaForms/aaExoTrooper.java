package aaApp.aaDesktopApp.aaForms;

import aaBusinessLogic.aaEntities.aaExobotBL;
import aaDataAccess.aaDTOs.aaExobotDTO;
import aaInfrastructure.aaAppException;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class aaExoTrooper extends JFrame {
    private aaExobotBL aaEBL;
    private JTable aaTabla;
    private DefaultTableModel aaModelo;
    private JComboBox<String> aaCmbTipo;

    public aaExoTrooper() {
        try {
            aaEBL = new aaExobotBL(); // Instancia la lógica de negocio
            aaInitComponents();       // Requisito: aaShowComponents()
            aaCargarDatos();          // Carga inicial de la grilla
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void aaInitComponents() {
        setTitle("ExoTrooper - Anthony Almeida");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Grilla (Requisito: Grilla de exobots)
        aaModelo = new DefaultTableModel(new String[]{"ID", "Tipo", "Arma", "Entreno", "No. Accion"}, 0);
        aaTabla = new JTable(aaModelo);
        add(new JScrollPane(aaTabla), BorderLayout.CENTER);

        // Panel de Control (ComboBox y Botón Buscar para punto extra)
        JPanel aaPnlControl = new JPanel();
        aaCmbTipo = new JComboBox<>(new String[]{"ExoInfanteria", "ExoAsalto", "ExoComando"});
        JButton aaBtnBuscar = new JButton("Buscar");
        JButton aaBtnEntrenar = new JButton("Entrenar");

        aaBtnBuscar.addActionListener(e -> aaBtnBuscarClick()); // Lógica punto extra
        aaBtnEntrenar.addActionListener(e -> aaBtnEntrenarClick());

        aaPnlControl.add(aaCmbTipo);
        aaPnlControl.add(aaBtnBuscar);
        aaPnlControl.add(aaBtnEntrenar);
        add(aaPnlControl, BorderLayout.NORTH);
    }

    // Método para el PUNTO EXTRA
    private void aaBtnBuscarClick() {
        try {
            String aaTipo = aaCmbTipo.getSelectedItem().toString();
            List<aaExobotDTO> aaLista = aaEBL.aaBuscarPorTipo(aaTipo); // Filtro especializado
            aaRefrescarTabla(aaLista);
        } catch (aaAppException e) {
            System.out.println("ERROR: Falló la búsqueda filtrada");
        }
    }

    private void aaBtnEntrenarClick() {
        int aaFila = aaTabla.getSelectedRow();
        if (aaFila >= 0) {
            try {
                // Obtener el DTO de la fila seleccionada
                aaExobotDTO aaSeleccionado = aaEBL.aaLeerTodo().get(aaFila);
                aaEBL.aaEntrenar(aaSeleccionado); // Requisito 46: Cambia entreno a "SI"
                aaCargarDatos(); // Refrescar grilla
            } catch (aaAppException e) {
                System.out.println("ERROR: No se pudo completar el entrenamiento");
            }
        }
    }    

    // --- Dentro de la clase aaExoTrooper ---

/**
 * Carga los datos desde la base de datos a la JTable (Grilla)
 * Requisito 47: Actualizar la grilla
 */
    private void aaCargarDatos() {
        try {
            // Obtenemos la lista actualizada desde la capa de Negocio
            List<aaExobotDTO> aaLista = aaEBL.aaLeerTodo();
            
            // Limpiamos la tabla antes de cargar
            aaModelo.setRowCount(0);
            
            // Llenamos la grilla fila por fila
            for (aaExobotDTO aaDto : aaLista) {
                aaModelo.addRow(new Object[]{
                    aaDto.getAaIdExobot(),
                    aaDto.getAaTipoExobot(),
                    aaDto.getAaTipoArma(),
                    aaDto.getAaEntreno(),
                    aaDto.getAaNoAccion()
                });
            }
        } catch (aaAppException e) {
            // Requisito 38: Usar la Clase CMD para imprimir en consola cada acción-evento
            System.out.println("ERROR: No se pudo cargar la grilla: " + e.getMessage());
        }
    }

/**
 * Ejecuta la acción del arma para el exobot seleccionado
 * Requisito 50 y 51: Buscar munición e incrementar No. Accion
 */
    private void aaBtnAccionArmaClick() {
        int aaFilaSeleccionada = aaTabla.getSelectedRow();

        if (aaFilaSeleccionada != -1) {
            try {
                // 1. Obtenemos el DTO de la fila seleccionada
                aaExobotDTO aaSeleccionado = aaEBL.aaLeerTodo().get(aaFilaSeleccionada);

                // 2. Ejecutamos la lógica (Disparar Laser/Bayoneta por cédula 9)
                String aaResultado = aaEBL.aaEjecutarDisparo(aaSeleccionado);

                // 3. Requisito 52: Mostrar en consola y tracer el resultado GOOD
                System.out.println(aaResultado);

                // 4. Actualizamos la tabla visualmente
                aaCargarDatos();

                JOptionPane.showMessageDialog(this, aaResultado);
            } catch (aaAppException e) {
                System.out.println("ERROR: Acción de arma fallida");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Exobot de la tabla.");
        }
    }

    /**
 * Limpia la grilla y la vuelve a llenar con la lista proporcionada.
 * Este método resuelve el error de símbolo no encontrado.
 */
    private void aaRefrescarTabla(List<aaExobotDTO> aaLista) {
        // 1. Limpiar todas las filas existentes en el modelo de la tabla
        aaModelo.setRowCount(0);
    
        // 2. Recorrer la lista recibida (sea la completa o la filtrada por el botón buscar)
        for (aaExobotDTO aaDto : aaLista) {
            Object[] aaFila = {
                aaDto.getAaIdExobot(),   // ID del exobot
                aaDto.getAaTipoExobot(), // Tipo (Ej: ExoComando)
                aaDto.getAaTipoArma(),   // Arma (Ej: Laser/Bayoneta)
                aaDto.getAaEntreno(),    // Estado de entrenamiento (SI/NO)
                aaDto.getAaNoAccion()    // Contador de disparos
            };
            // 3. Agregar la fila al modelo visual
            aaModelo.addRow(aaFila);
        }
    }

    

}
