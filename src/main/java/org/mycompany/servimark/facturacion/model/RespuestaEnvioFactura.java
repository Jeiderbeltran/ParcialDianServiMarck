package org.mycompany.servimark.facturacion.model;

public class RespuestaEnvioFactura {
    private String estadoEnvio;
    private String mensaje;

    // Constructor
    public RespuestaEnvioFactura() {
    }

    // Getters y Setters
    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
