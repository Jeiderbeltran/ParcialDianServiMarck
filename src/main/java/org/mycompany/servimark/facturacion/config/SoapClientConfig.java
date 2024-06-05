package org.mycompany.servimark.facturacion.config;

import org.mycompany.servimark.facturacion.management.DianClientManagement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    @Value("${dian.wsdl.url}")
    private String dianWsdlUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.tuempresa.facturacion.dian");
        return marshaller;
    }

    @Bean
    public DianClientManagement dianClient(Jaxb2Marshaller marshaller) {
        DianClientManagement client = new DianClientManagement();
        client.setDefaultUri(dianWsdlUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
