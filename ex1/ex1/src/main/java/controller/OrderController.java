package controller;

import entity.Order;
import repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "order-list";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id, Model model) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        model.addAttribute("order", order);
        return "order-view";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable Long id, Model model) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, @ModelAttribute Order updatedOrder) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        order.setDateTime(updatedOrder.getDateTime());
        order.setStatus(updatedOrder.getStatus());
        order.setTotalCost(updatedOrder.getTotalCost());
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id: " + id));
        orderRepository.delete(order);
        return "redirect:/orders";
    }
}