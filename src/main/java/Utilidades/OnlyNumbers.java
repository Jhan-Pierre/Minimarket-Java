package Utilidades;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OnlyNumbers extends KeyAdapter{
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();  // Ignora cualquier otro caracter que no sea un número
        }
    }
}
