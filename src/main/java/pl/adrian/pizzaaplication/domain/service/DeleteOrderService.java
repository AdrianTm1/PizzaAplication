package pl.adrian.pizzaaplication.domain.service;

import org.springframework.stereotype.Service;
import pl.adrian.pizzaaplication.data.repository.OrderRepository;
import pl.adrian.pizzaaplication.data.repository.OrderSizeRepository;
import pl.adrian.pizzaaplication.domain.exception.ResourceNotFoundException;

import static pl.adrian.pizzaaplication.domain.service.AuthorizationService.checkToken;

@Service
public class DeleteOrderService {

    private final OrderRepository orderRepository;
    private final OrderSizeRepository orderSizeRepository;

    public DeleteOrderService(OrderRepository orderRepository, OrderSizeRepository orderSizeRepository) {
        this.orderRepository = orderRepository;
        this.orderSizeRepository = orderSizeRepository;
    }

    public void deleteOrder(Integer orderId, String token) {
        checkToken(token);
        boolean orderExist = orderRepository.existsById(orderId);
        if(!orderExist) {
            throw new ResourceNotFoundException("Zamowienie o podanym id nie istnieje");
        }
        orderSizeRepository.deleteAllByOrderId(orderId);
        orderRepository.deleteById(orderId);


    }


}
