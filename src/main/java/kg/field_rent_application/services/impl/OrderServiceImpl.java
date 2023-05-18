package kg.field_rent_application.services.impl;

import kg.field_rent_application.dao.OrderRepo;
import kg.field_rent_application.models.entities.Order;
import kg.field_rent_application.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public Order getById(Long id) {
        Optional<Order> optional = orderRepo.findById(id);
        Order order;
        if (optional.isPresent())
            order = optional.get();
        else
            throw new RuntimeException(
                    "Order not found for id : " + id);
        return order;
    }

    @Override
    public void deleteViaId(Long id) {
        orderRepo.deleteById(id);
    }
}
