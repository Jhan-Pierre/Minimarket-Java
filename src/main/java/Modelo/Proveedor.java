package Modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private String ruc;
    private String descripcion;
    private String telefono;
    private String correo;
    private String direccion;
    private int estado_id;
    private String estado;
    
    //buscar por nombre
       public Proveedor(int id, String nombre, String ruc, String correo, String telefono, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.ruc = ruc;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    //constructor para buscar un rpoovedor por ID
    public Proveedor(int id, String nombre, String ruc, String telefono, String correo, String direccion, String descripcion, int estado_id) {
        this.id = id;
        this.nombre = nombre;
        this.ruc = ruc;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.estado_id = estado_id;
    }

       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
 
}
