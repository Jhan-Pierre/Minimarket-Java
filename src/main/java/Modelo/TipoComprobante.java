package Modelo;

import Utilidades.Identificable;

public class TipoComprobante implements Identificable {
    private int id;
    private String nombre;

    public TipoComprobante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
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
    
    // sobrescribir la presentacion, para solo mostrar el nombre
    @Override
    public String toString() {
        return nombre;
    }
    
}
