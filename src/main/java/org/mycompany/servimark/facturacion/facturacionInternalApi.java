package org.mycompany.servimark.facturacion;

import java.util.Map;

import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.mycompany.servimark.service.ServiceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface facturacionInternalApi {
    RespuestaEnvioFactura enviarFacturaInterno(FacturaElectronica factura);
}
