/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Proveedor;

import Modelo.CRUDProveedor;
import Modelo.Proveedor;



/**
 *
 * @author jean carlos
 */
public class ProveedorControllerShow {
     private final CRUDProveedor proveedorModelo;
    
    public ProveedorControllerShow() {
        this.proveedorModelo = new CRUDProveedor();
    }
    
    public Proveedor mostrarProveedorPorCodigo(Long id){
        return proveedorModelo.mostrarProveedorPorCodigo(id);
    } 
}
