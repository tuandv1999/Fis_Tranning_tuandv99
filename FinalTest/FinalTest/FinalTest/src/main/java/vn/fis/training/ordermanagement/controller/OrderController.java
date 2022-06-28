package vn.fis.training.ordermanagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.ordermanagement.dto.OrderDTO;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.model.OrderItem;
import vn.fis.training.ordermanagement.model.OrderStatus;
import vn.fis.training.ordermanagement.model.Product;
import vn.fis.training.ordermanagement.repository.OrderItemsRepository;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.util.List;


@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemsRepository  orderItemsRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{orderId}")
    public OrderDTO findById(@PathVariable(name="orderId")Long orderId) {
        return orderService.findById(orderId);
    }
    @PutMapping("/create")
    public Order Create(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    @PostMapping("/delete/{orderId}")
    public void Delete(@PathVariable Long orderId){
       Order order= orderService.getByid(orderId);
       if(order.getStatus().equals("CREATED")||order.getStatus().equals("CANCELLE")){
           orderRepository.delete(order);
       }
    }
    @PostMapping("/addOrderItem")
    public Order addOrderItem (Long orderId, OrderItem orderItem, Product product){
        Order order=orderService.getByid(orderId);
        if(order.getStatus().equals("CREATED")){
            OrderItem orderItem1=new OrderItem();
            Product product1=new Product();
            orderItem1.setId(orderItem.getId());
            orderItem1.setAmount(product.getPrice()*orderItem.getQuantity());
            orderItem1.setQuantity(orderItem.getQuantity());
            orderItem1.setOrder(order);
            orderItem1.setProduct(product);
            orderItemsRepository.save(orderItem1);
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setAvaiable(product.getAvaiable());
            productRepository.save(product1);

        }
        return order;
    }
    @PostMapping("/delete/orderitems/{OrderItemId}/OrderId")
    public List<Order> removeOrderItem(@PathVariable  Long OrderItemId, @PathVariable Long OrderId){
        orderItemsRepository.deleteById(OrderItemId);
        orderRepository.deleteById(OrderId);
        return orderRepository.findAll();
    }
    @PostMapping("/update/paid/{orderId}")
    public Order UpdateOrderStatus(@PathVariable Long orderId){
        Order order=orderService.getByid(orderId);
        Order order1=new Order();
        if(order.getStatus().equals("CREATE")){
            order1.setId(orderId);
            order1.setOrderDateTime(order.getOrderDateTime());
            order1.setStatus(OrderStatus.PAID);
            order1.setTotalAmount(order.getTotalAmount());
            order1.setCustomer(order.getCustomer());
        }
        return orderService.createOrder(order1);
    }
    @PostMapping("/update/cancel/{orderId}")
    public Order UpdateOrderByStatus(@PathVariable Long orderId){
        Order order=orderService.getByid(orderId);
        Order order1=new Order();
        if(order.getStatus().equals("CREATE")){
            order1.setId(orderId);
            order1.setOrderDateTime(order.getOrderDateTime());
            order1.setStatus(OrderStatus.CANCELLED);
            order1.setTotalAmount(order.getTotalAmount());
            order1.setCustomer(order.getCustomer());
        }
        return orderService.createOrder(order1);
    }

}




