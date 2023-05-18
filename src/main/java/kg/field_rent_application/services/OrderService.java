package kg.field_rent_application.services;

import kg.field_rent_application.models.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    void save(Order order);
    Order getById(Long id);
    void deleteViaId(Long id);
}
