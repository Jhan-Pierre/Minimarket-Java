package Controlador;

import java.util.Set;

public class GlobalPermisos {
    private static Set<String> permisos;

    public static Set<String> getPermisos() {
        return permisos;
    }

    public static void setPermisos(Set<String> nuevosPermisos) {
        permisos = nuevosPermisos;
    }
}