package Main;

import vista.FrmLogin;

public class Main {
    public static void main(String[] args) {
        // Aqui sera el punto de acceso
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
}