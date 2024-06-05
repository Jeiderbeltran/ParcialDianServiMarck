package org.mycompany.servimark.facturacion.management;

import org.mycompany.servimark.facturacion.model.EnviarFacturaRequest;
import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DianClientManagement extends WebServiceGatewaySupport {

    public RespuestaEnvioFactura enviarFactura(FacturaElectronica factura) {
        EnviarFacturaRequest request = new EnviarFacturaRequest();
        request.setFactura(factura);

        return (RespuestaEnvioFactura) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
    
}
