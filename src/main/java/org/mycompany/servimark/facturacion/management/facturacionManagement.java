package org.mycompany.servimark.facturacion.management;

import org.mycompany.servimark.facturacion.facturacionExternalApi;
import org.mycompany.servimark.facturacion.facturacionInternalApi;
import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;

public class facturacionManagement implements facturacionExternalApi,facturacionInternalApi {


    private final DianClientManagement dianClient;

    public facturacionManagement(DianClientManagement dianClient) {
        this.dianClient = dianClient;
    }

    public RespuestaEnvioFactura enviarFactura(FacturaElectronica factura) {
        return dianClient.enviarFactura(factura);
    }

    public RespuestaEnvioFactura enviarFacturaInterno(FacturaElectronica factura) {
        return dianClient.enviarFactura(factura);
    }
}
