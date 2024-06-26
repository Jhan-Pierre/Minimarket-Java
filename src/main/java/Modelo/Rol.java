package Modelo;

import Utilidades.Identificable;

public class Rol implements Identificable {
    private int id;
    private String nombre;

    public Rol() {
    }

    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
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
