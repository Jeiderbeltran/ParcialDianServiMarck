package org.mycompany.servimark.facturacion.management;

import org.springframework.beans.factory.annotation.Autowired;

public class facturacionManagement {

    private final DianClient dianClient;

    @Autowired
    public FacturacionService(DianClient dianClient) {
        this.dianClient = dianClient;
    }

    public RespuestaEnvioFactura enviarFacturaElectronica(FacturaElectronica factura) {
        return dianClient.enviarFactura(factura);
    }
}
