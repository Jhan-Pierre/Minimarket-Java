package Modelo;

import java.sql.Date;

public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Date fechaAlta;
    private Date fecha_actualizado;
    private String password;
    private String rol;
    private String estado;
    private String turno;
    private int rol_id;
    private int estado_id;
    private int turno_id;
    
    public Usuario(int idUsuario, String correo, String password, String telefono1, String apellido, int rol_id1, int turno_id, int estado_id) {
        this.correo = correo;
        this.password = password;
    }

    public Usuario(Long id, String nombre, String correo, int rol_id) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol_id = rol_id;
    }

    public Usuario(Long id, String correo, String nombre, String telefono, Date fechaAlta, String rolNombre, String estado) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.rol = rolNombre;
        this.estado = estado;
    }

    //Constructor para el buscar usuario por id
    public Usuario(String nombre, String apellido, String correo, String telefono, int rol_id, int estado_id, int turno_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.rol_id = rol_id;
        this.estado_id = estado_id;
        this.turno_id = turno_id;
    }

    //Constructor para el mostrar usuario por id
    public Usuario(String correo,String telefono,String nombre,String apellido, Date fecha_alta, Date fecha_actualizado, String rol, String turno, String estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaAlta = fecha_alta;
        this.fecha_actualizado = fecha_actualizado;
        this.rol = rol;
        this.estado = estado;
        this.turno = turno;
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

    public Date getFecha_actualizado() {
        return fecha_actualizado;
    }

    public void setFecha_actualizado(Date fecha_actualizado) {
        this.fecha_actualizado = fecha_actualizado;
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
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
}
