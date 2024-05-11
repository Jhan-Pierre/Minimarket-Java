package Modelo;

import java.sql.Date;

public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaAlta;
    private String password;
    private String rol;
    private String estado;
    private int rol_id;
    private int estado_id;
    private int turno_id;
    
    public Usuario(int idUsuario, String email, String password, String telefono1, String apellido, int rol_id1, int turno_id, int estado_id) {
        this.email = email;
        this.password = password;
    }

    public Usuario(Long id, String nombre, String email, int rol_id) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol_id = rol_id;
    }

    public Usuario(Long id, String correo, String nombre, String telefono, Date fechaAlta, String rolNombre, String estado) {
        this.id = id;
        this.email = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.rol = rolNombre;
        this.estado = estado;
    }

    //Constructor para el buscar usuario por id
    public Usuario(String nombre, String apellido, String email, String telefono, int rol_id, int estado_id, int turno_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.rol_id = rol_id;
        this.estado_id = estado_id;
        this.turno_id = turno_id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getTurno_id() {
        return turno_id;
    }

    public void setTurno_id(int turno_id) {
        this.turno_id = turno_id;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rolNombre) {
        this.rol = rolNombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
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
