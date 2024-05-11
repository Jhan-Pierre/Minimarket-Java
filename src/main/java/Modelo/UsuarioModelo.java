package Modelo;

import java.util.List;
import java.util.Set;

public class UsuarioModelo {
    private CRUDusuario crudUsuario;

    public UsuarioModelo() {
        this.crudUsuario = new CRUDusuario();
    }

    public String validarUsuario(String email, String password) {
        return crudUsuario.validarUsuario(email, password);
    }

    public Set<String> obtenerPermisosPorUsuario(int rolId) {
        return crudUsuario.obtenerPermisosPorUsuario(rolId);
    }

    public Usuario obtenerUsuarioLogeado(String email) {
        return crudUsuario.obtenerUsuarioLogeado(email);
    }

    public List<Usuario> listarUsuarios() {
        return crudUsuario.listarUsuarios();
    }
    
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        return crudUsuario.buscarUsuarioPorNombre(nombre);
    }

    public void crearUsuario(String correo, String password, String telefono, String nombre, String apellido, int rolId, int estadoId, int turnoId) {
        crudUsuario.crearUsuario(correo, password, telefono, nombre, apellido, rolId, estadoId, turnoId);
    }
    
    public void editarUsuario(Long id, String correo, String password, String telefono, String nombre, String apellido, int rol_id, int estado_id, int turno_id){
        crudUsuario.editarUsuario(id, correo, password, telefono, nombre, apellido, rol_id, estado_id, turno_id);
    }
 
    public Usuario buscarUsuarioPorCodigo(long id){
        return crudUsuario.buscarUsuarioPorCodigo(id);
    }
    
}
