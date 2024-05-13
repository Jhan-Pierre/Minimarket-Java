package Modelo;

public class CategoriaProducto {
    private int id;
    private String nombre;

    // Constructor
    public CategoriaProducto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public long getId() {
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

    // Método toString para mostrar el nombre en el ComboBox
    @Override
    public String toString() {
        return nombre;
    }
}

