package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioModelo;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class UsuarioControllerList{
    private final UsuarioModelo usuarioModelo;
    
    public UsuarioControllerList() {
        this.usuarioModelo = new UsuarioModelo();
    }

    
     public DefaultTableModel obtenerModeloTabla(String textoBusqueda) {
        List<Usuario> listaUsuarios = usuarioModelo.buscarUsuarioPorNombre(textoBusqueda);
        String[] columnNames = {"ID", "Correo", "Nombre", "Telefono", "Fecha Alta", "Rol", "Estado", "Ver detalles", "Editar", "Eliminar"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Usuario usuario : listaUsuarios) {
            Object[] row = new Object[]{
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getTelefono(),
                usuario.getFechaAlta(),
                usuario.getRol(),
                usuario.getEstado(),
                "Ver detalles",
                "Editar",
                "Eliminar"
            };
            model.addRow(row);
        }
        return model;
    }
    
    public List<Usuario> buscarUsuarios(String texto) {
        List<Usuario> listaUsuarios = usuarioModelo.buscarUsuarioPorNombre(texto);
        return listaUsuarios;
    }
}
