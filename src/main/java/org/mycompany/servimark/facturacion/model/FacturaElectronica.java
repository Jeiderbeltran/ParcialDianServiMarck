package org.mycompany.servimark.facturacion.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "FacturaElectronica")
public class FacturaElectronica {

    private String id;
    private String emisor;
    private String receptor;
    private double total;

    // Constructor
    public FacturaElectronica() {
    }

    // Getters y Setters
    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    @XmlElement
    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    @XmlElement
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Otros campos y métodos si son necesarios
}