package Utilidades;

import java.awt.CardLayout;
import java.awt.Container;

public interface IPanelListener {
    void abrirPanel(String nombrePanel);
    void abrirPanel(String panelName, Long id);
}