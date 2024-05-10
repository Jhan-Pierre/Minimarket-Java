package Modelo;

public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private int rol_id;
    
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(Long id, String nombre, String email, int rol_id) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol_id = rol_id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRolId() {
        return rol_id;
    }

    public void setRolId(int rol_id) {
        this.rol_id = rol_id;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
