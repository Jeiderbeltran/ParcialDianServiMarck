package org.mycompany.servimark.facturacion.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EnviarFacturaRequest")
public class EnviarFacturaRequest {

    private FacturaElectronica factura;

    // Constructor
    public EnviarFacturaRequest() {
    }

    // Getter y Setter
    @XmlElement
    public FacturaElectronica getFactura() {
        return factura;
    }

    public void setFactura(FacturaElectronica factura) {
        this.factura = factura;
    }
}
