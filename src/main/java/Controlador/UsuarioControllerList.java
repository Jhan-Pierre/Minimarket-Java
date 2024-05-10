package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioModelo;
import Utilidades.ButtonColumn;
import Utilidades.IButtonClickListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import vista.PanelUsuario;

public class UsuarioControllerList implements IButtonClickListener {
    private final UsuarioModelo usuarioModelo;
    private final PanelUsuario vistaUsuario;

    public UsuarioControllerList(PanelUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        this.usuarioModelo = new UsuarioModelo();
    }

    public void actualizarVista() {
        // Lógica para actualizar la vista con la información más reciente
        cargarUsuariosEnTabla();
    }
    
    public void cargarUsuariosEnTabla() {
        List<Usuario> listaUsuarios = usuarioModelo.listarUsuarios();

        // Crear modelo de tabla y establecerlo en la tabla
        DefaultTableModel model = new DefaultTableModel();
        vistaUsuario.tbUsuario.setModel(model);

        // Añadir columnas al modelo de la tabla
        model.addColumn("ID");
        model.addColumn("Correo");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Fecha Alta");
        model.addColumn("Rol");
        model.addColumn("Estado");

        // Añadir columnas de botones
        model.addColumn("Ver detalles");
        model.addColumn("Editar");
        model.addColumn("Eliminar");

        // Añadir filas al modelo de la tabla
        for (Usuario usuario : listaUsuarios) {
            model.addRow(new Object[]{
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getFechaAlta(),
                usuario.getRol(),
                usuario.getEstado(),
                "Ver detalles", "Editar", "Eliminar"
            });
        }

        // Crear los botones en las columnas correspondientes
        new ButtonColumn(vistaUsuario.tbUsuario, 7, this); // Ver detalles
        new ButtonColumn(vistaUsuario.tbUsuario, 8, this); // Editar
        new ButtonColumn(vistaUsuario.tbUsuario, 9, this); // Eliminar
    }
    
    @Override
    public void buttonClicked(int row, int column, String buttonText) {
        Long id = (Long) vistaUsuario.tbUsuario.getModel().getValueAt(row, 0);
        switch (buttonText) {
            case "Ver detalles" -> abrirDetallesUsuario(id);
            case "Editar" -> abrirEditarUsuario(id);
            case "Eliminar" -> eliminarUsuario(id);
        }
    }
    
    private void abrirDetallesUsuario(Long id) {
        System.out.println("detalle: " + id);
    }

    private void abrirEditarUsuario(Long id) {
        System.out.println("editar: " + id);
    }

    private void eliminarUsuario(Long id) {
        System.out.println("eliminar: " + id);
    }
}
