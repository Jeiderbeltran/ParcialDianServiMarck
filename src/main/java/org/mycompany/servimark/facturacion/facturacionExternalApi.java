package org.mycompany.servimark.facturacion;


import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.springframework.http.ResponseEntity;

public interface facturacionExternalApi {

    ResponseEntity<RespuestaEnvioFactura> enviarFactura(FacturaElectronica factura);
}
