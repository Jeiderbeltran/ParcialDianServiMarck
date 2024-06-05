package org.mycompany.servimark.facturacion;


import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.springframework.http.ResponseEntity;

public interface facturacionExternalApi {

    RespuestaEnvioFactura enviarFactura(FacturaElectronica factura);
}
