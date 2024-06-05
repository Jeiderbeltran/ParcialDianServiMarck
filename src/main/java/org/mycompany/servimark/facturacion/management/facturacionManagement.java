package org.mycompany.servimark.facturacion.management;

import org.mycompany.servimark.facturacion.facturacionExternalApi;
import org.mycompany.servimark.facturacion.facturacionInternalApi;
import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class facturacionManagement implements facturacionExternalApi,facturacionInternalApi {


    private final DianClient dianClient;

    public facturacionManagement(DianClient dianClient) {
        this.dianClient = dianClient;
    }

    public ResponseEntity<RespuestaEnvioFactura> enviarFactura(FacturaElectronica factura) {
        return dianClient.enviarFactura(factura);
    }
}
