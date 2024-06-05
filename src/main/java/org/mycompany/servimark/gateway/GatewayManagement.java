package org.mycompany.servimark.gateway;

import java.util.Map;

import org.mycompany.servimark.core.CoreExternalAPI;
import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.mycompany.servimark.facturacion.facturacionExternalApi;
import org.mycompany.servimark.facturacion.model.FacturaElectronica;
import org.mycompany.servimark.facturacion.model.RespuestaEnvioFactura;
import org.mycompany.servimark.order.OrderDTO;
import org.mycompany.servimark.order.OrderExternalAPI;
import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.service.ServiceExternalAPI;
import org.mycompany.servimark.service.dto.CategoryDTO;
import org.mycompany.servimark.user.UserExternalAPI;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class GatewayManagement {
    private CoreExternalAPI coreExternalAPI;
    private OrderExternalAPI orderExternalAPI;
    private UserExternalAPI userExternalAPI;
    private ServiceExternalAPI serviceExternalAPI;
    private facturacionExternalApi facturacionExternal;

    public GatewayManagement(OrderExternalAPI orderExternalAPI,
                             CoreExternalAPI coreExternalAPI,
                             UserExternalAPI userExternalAPI,
                             ServiceExternalAPI serviceExternalAPI,
                             facturacionExternalApi facturacionExternal) {
        this.orderExternalAPI = orderExternalAPI;
        this.coreExternalAPI = coreExternalAPI;
        this.userExternalAPI = userExternalAPI;
        this.serviceExternalAPI = serviceExternalAPI;
        this.facturacionExternal= facturacionExternal;
    }

    @PostMapping("/departament")
    public ResponseEntity<?> saveDepartament(@Valid @RequestBody DepartamentDTO departamentDTO) {
        return coreExternalAPI.saveDepartament(departamentDTO);
    }

    @PostMapping("/service")
    public ResponseEntity<Map<String, Object>> saveService(@Valid @RequestBody ServiceDTO serviceDTO) {
        return serviceExternalAPI.saveService(serviceDTO);
    }

    @GetMapping("/history-service")
    public ResponseEntity<Map<String, Object>> getHistoryServiceByUser(@RequestBody UserDTO userDTO) {
        return serviceExternalAPI.getHistoryServiceByUser(userDTO);
    }

    @GetMapping("/service-category")
    public ResponseEntity<Map<String, Object>> getServicesByCategoryId(@RequestBody CategoryDTO categoryDTO) {
        return serviceExternalAPI.getServicesByCategoryId(categoryDTO);
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserDTO userDTO) {
        return userExternalAPI.saveUser(userDTO);
    }

    @PostMapping("/order")
    public ResponseEntity<Map<String, Object>> saveOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderExternalAPI.saveOrder(orderDTO);
    }

    @PostMapping("/enviar-Factura")
    public RespuestaEnvioFactura enviarFactura(@RequestBody FacturaElectronica factura) {
        return facturacionExternal.enviarFactura(factura);
    }

}
