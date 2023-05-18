package kg.field_rent_application.controllers;

import kg.field_rent_application.models.entities.Order;
import kg.field_rent_application.services.FieldService;
import kg.field_rent_application.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor

@Controller
public class OrderController {
    private final OrderService orderService;
    private final FieldService fieldService;

    @GetMapping("/add/new_order/{id}")
    public String addNewOrder(@PathVariable(value = "id") Long id, Model model) {
        Order order = new Order();
        order.setFieldId(id);
        model.addAttribute("order", order);
        return "neworder";
    }

    @PostMapping("/save/order")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.save(order);
        return "redirect:/";
    }
}
