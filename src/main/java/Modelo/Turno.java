package Modelo;

public class Turno {
    private int id;
    private String nombre;

    public Turno() {
    }

    public Turno(String nombre) {
        this.nombre = nombre;
    }

    public Turno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // sobrescribir la presentacion, para solo mostrar el nombre
    @Override
    public String toString() {
        return nombre;
    }
    
}
