package com.desafioprofessional.desafio1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioprofessional.desafio1.entities.Order;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double shipment = shippingService.shipment(order);
        double discount = order.getBasic() * order.getDiscount() / 100.0;
        return order.getBasic() - discount + shipment;
    }     
}
