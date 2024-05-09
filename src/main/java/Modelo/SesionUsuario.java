package Modelo;

public class SesionUsuario {
    private static SesionUsuario instancia = null;
    private Usuario usuarioLogeado;

    private SesionUsuario() {
        // Constructor privado para evitar instanciación directa
    }

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuario) {
        this.usuarioLogeado = usuario;
    }
}
