package Modelo;

import java.util.Date;

public class Venta {
    private int id;
    private Date fecha_hora;
    private Double impuesto; 
    private Double total;
    private int tipo_comprobante_id;
    private int metodo_pago_id;
    private Long usuario_id;

    private String comprobante;
    private String metodo_pago;
    private String usuario;
    
    
    public Venta() {
    }

    //Para obtener el listado de las ventas
    public Venta(int id, Date fecha_hora, Double impuesto, Double total, String comprobante, String metodo_pago, String usuario) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.impuesto = impuesto;
        this.total = total;
        this.comprobante = comprobante;
        this.metodo_pago = metodo_pago;
        this.usuario = usuario;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getTipo_comprobante_id() {
        return tipo_comprobante_id;
    }

    public void setTipo_comprobante_id(int tipo_comprobante_id) {
        this.tipo_comprobante_id = tipo_comprobante_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getMetodo_pago_id() {
        return metodo_pago_id;
    }

    public void setMetodo_pago_id(int metodo_pago_id) {
        this.metodo_pago_id = metodo_pago_id;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
